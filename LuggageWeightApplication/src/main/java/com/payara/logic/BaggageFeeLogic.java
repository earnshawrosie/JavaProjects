package com.payara.logic;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.payara.entity.BaggageClass;
import com.payara.model.BaggageFees;
import com.payara.model.BaggageItem;
import com.payara.model.BaggageType;

@Component
public class BaggageFeeLogic {

	private BiPredicate<Double, BaggageClass> isBaggageClass = (weight, bc) -> weight >= bc.getMinWeight()
			&& weight < bc.getMaxWeight();

	private BiFunction<List<Double>, BaggageClass, List<BaggageItem>> createBaggageItems = (weights, baggageClass) -> {
		// Always assign FREE to the heaviest
		Collections.sort(weights, Collections.reverseOrder());

		return IntStream.range(0, weights.size())
				.mapToObj(i -> (i == 0 ? new BaggageItem(BaggageType.FREE, weights.get(i), BigDecimal.ZERO.setScale(2))
						: new BaggageItem(baggageClass.getBaggageType(), weights.get(i), baggageClass.getFee())))
				.collect(Collectors.toList());
	};

	private Predicate<BaggageItem> isFree = b -> BaggageType.FREE.equals(b.getBaggageType());
	
	private BiPredicate<Double, BaggageClass> eligibleOverweight = (weight, bc) -> 
		(weight - bc.getMaxWeight()) < bc.getMaxWeight();
	
	public BaggageFees calculateFees(List<BaggageClass> bagClasses, List<Double> baggageWeights) {

		List<BaggageItem> bags = Optional.ofNullable(bagClasses).map(Collection::stream).orElseGet(Stream::empty)
				.collect(Collectors.toMap(BaggageClass::getBaggageType, baggageClass -> {
					List<Double> filtered = baggageWeights.stream().filter(w -> isBaggageClass.test(w, baggageClass))
							.collect(Collectors.toList());

					return createBaggageItems.apply(filtered, baggageClass);

				})).values().stream().flatMap(Collection::stream).collect(Collectors.toList());

		// Handle the FREE + OVERWEIGHT condition
		processForFreeAndOverweight(bagClasses, bags);

		return new BaggageFees(calculateTotalFee(bags), bags);

	}

	private void processForFreeAndOverweight(List<BaggageClass> bagClasses, List<BaggageItem> bags) {
		List<BaggageClass> sortedBagClasses = Optional.ofNullable(bagClasses)
				.map(Collection::stream).orElseGet(Stream::empty)
				.sorted(Comparator.comparing(BaggageClass::getMaxWeight)).collect(Collectors.toList());

		for (int i = 0; i < sortedBagClasses.size()-1; i++) {
			int ix = i;
			List<BaggageItem> lower = bags.stream()
					.filter(bag -> isBaggageClass.test(bag.getWeight(), sortedBagClasses.get(ix)))
					.collect(Collectors.toList());
			List<BaggageItem> higher = bags.stream()
					.filter(bag -> isBaggageClass.test(bag.getWeight(), sortedBagClasses.get(ix + 1)))
					.collect(Collectors.toList());

			//If lower has NO FREE BAGS 
			//HIGHER can take potentially advantage of FREE + OVERWEIGHT
			if (lower.isEmpty() || lower.stream().noneMatch(isFree)) {
				higher.stream()
					//Filter only the charged bags
					.filter(b -> sortedBagClasses.get(ix + 1).getBaggageType().equals(b.getBaggageType())) 
					//Ignore any that are not eligible by weight
					.filter(b -> eligibleOverweight.test(b.getWeight(), sortedBagClasses.get(ix + 1)))
						.findFirst().ifPresent(b -> { //Reset as FREE OVERWEIGHT with Fee from lower baggageClass
							b.setBaggageType(BaggageType.FREE_OVERWEIGHT);
							b.setFee(sortedBagClasses.get(ix).getFee());
						});
			}
		}
	}

	private BigDecimal calculateTotalFee(List<BaggageItem> bags) {
		return bags.stream().map(BaggageItem::getFee).reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
