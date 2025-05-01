package com.payara.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.payara.entity.BaggageClass;
import com.payara.model.BaggageFees;
import com.payara.model.BaggageItem;
import com.payara.model.BaggageType;

@ExtendWith(SpringExtension.class)
public class BaggageFeeLogicTest {

	private BaggageFeeLogic feeLogic = new BaggageFeeLogic();

	@Test
	public void shouldReturnZeroWhenBagClassesAreNotDefined() throws Exception {
		// GIVEN - no baggage classes are provided but weights are defined
		List<Double> weights = Arrays.asList(6.4, 7.8, 15.0);

		// WHEN
		BaggageFees fees = feeLogic.calculateFees(null, weights);

		// THEN fees should be returned
		assertNotNull(fees);

		// AND Fee should be ZERO
		assertEquals(BigDecimal.ZERO.setScale(2), fees.getTotal());

		// AND No bags will be processed
		assertEquals(0, fees.getBags().size());
	}

	@Test
	public void shouldReturnZeroWhenWeightsAreNotDefined() throws Exception {
		// GIVEN - no weights are provided
		List<Double> weights = Arrays.asList();

		// AND Baggage Classes are defined
		BaggageClass baggageClass1 = new BaggageClass(0.00, 7.00, new BigDecimal(10).setScale(2), BaggageType.LIGHT);
		BaggageClass baggageClass2 = new BaggageClass(7.00, 25.00, new BigDecimal(25).setScale(2), BaggageType.HEAVY);
		List<BaggageClass> baggageClassList = Arrays.asList(baggageClass1, baggageClass2);

		// WHEN
		BaggageFees fees = feeLogic.calculateFees(baggageClassList, weights);

		// THEN fees should be returned
		assertNotNull(fees);

		// AND Fee should be ZERO
		assertEquals(BigDecimal.ZERO.setScale(2), fees.getTotal());

		// AND No bags will be processed
		assertEquals(0, fees.getBags().size());
	}

	@Test
	public void shouldAllowOneFreeInEachBaggageClass() throws Exception {

		// GIVEN
		List<Double> weights = Arrays.asList(6.9, 15.0, 22.1, 5.4);

		BaggageClass baggageClass1 = new BaggageClass(0.00, 7.00, new BigDecimal(10).setScale(2), BaggageType.LIGHT);
		BaggageClass baggageClass2 = new BaggageClass(7.00, 25.00, new BigDecimal(25).setScale(2), BaggageType.HEAVY);

		List<BaggageClass> baggageClassList = Arrays.asList(baggageClass1, baggageClass2);

		// WHEN
		BaggageFees fees = feeLogic.calculateFees(baggageClassList, weights);

		// THEN fees should be returned
		assertNotNull(fees);

		// AND Fee should be 35 Heavy & 1 Light
		assertEquals(new BigDecimal(35).setScale(2), fees.getTotal());
		assertEquals(4, fees.getBags().size());

		// AND there should be 2 FREE bags
		List<BaggageItem> freeBags = fees.getBags().stream().filter(isFree).collect(Collectors.toList());
		assertEquals(2, freeBags.size());

		// AND there should be 1 LIGHT bags
		List<BaggageItem> lightBags = fees.getBags().stream().filter(isLight).collect(Collectors.toList());
		assertEquals(1, lightBags.size());

		// AND there should be 1 HEAVY bags
		List<BaggageItem> heavyBags = fees.getBags().stream().filter(isLight).collect(Collectors.toList());
		assertEquals(1, heavyBags.size());
	}

	@Test
	public void shouldAllocateFreeAndOverweight() throws Exception {

		// GIVEN
		List<Double> weights = Arrays.asList(9.1, 15.0, 21.0);

		BaggageClass baggageClass1 = new BaggageClass(0.00, 7.00, new BigDecimal(10).setScale(2), BaggageType.LIGHT);
		BaggageClass baggageClass2 = new BaggageClass(7.00, 25.00, new BigDecimal(25).setScale(2), BaggageType.HEAVY);

		List<BaggageClass> baggageClassList = Arrays.asList(baggageClass1, baggageClass2);

		// WHEN
		BaggageFees fees = feeLogic.calculateFees(baggageClassList, weights);

		// THEN fees should be returned
		assertNotNull(fees);

		// AND Fee should be 35 - 1 Heavy & 1 FREE + OVERWEIGHT
		assertEquals(new BigDecimal(35).setScale(2), fees.getTotal());

		// AND 3 Bags should have been processed
		assertEquals(3, fees.getBags().size());

		// AND there should be 1 FREE bag
		List<BaggageItem> freeBags = fees.getBags().stream().filter(isFree).collect(Collectors.toList());
		assertEquals(1, freeBags.size());

		// AND there should be 1 HEAVY bags
		List<BaggageItem> heavyBags = fees.getBags().stream().filter(isHeavy).collect(Collectors.toList());
		assertEquals(1, heavyBags.size());

		// AND there should be 1 FREE + OVERWEIGHT bag
		List<BaggageItem> overweightBags = fees.getBags().stream().filter(isFreeOverweight)
				.collect(Collectors.toList());
		assertEquals(1, overweightBags.size());
	}
	
	@Test  //Just experimenting
	public void shouldAllocateFreeAndOverweightForThreeClasses() throws Exception {

		// GIVEN
		List<Double> weights = Arrays.asList(4.2, 6.5, 28.2, 26.2);

		BaggageClass baggageClass1 = new BaggageClass(0.00, 7.00, new BigDecimal(10).setScale(2), BaggageType.LIGHT);
		BaggageClass baggageClass2 = new BaggageClass(7.00, 25.00, new BigDecimal(25).setScale(2), BaggageType.HEAVY);
		BaggageClass baggageClass3 = new BaggageClass(25.00, 50.00, new BigDecimal(35).setScale(2), BaggageType.EXCESS);
	
		List<BaggageClass> baggageClassList = Arrays.asList(baggageClass1, baggageClass2, baggageClass3);

		// WHEN
		BaggageFees fees = feeLogic.calculateFees(baggageClassList, weights);

		// THEN fees should be returned
		assertNotNull(fees);

		// AND Fee should be for 1 LIGHT, 1 FREE OVERWEIGHT (EXCESS -> HEAVY)
		//10 + 25
		assertEquals(new BigDecimal(35).setScale(2), fees.getTotal());

		// AND 4 Bags should have been processed
		assertEquals(4, fees.getBags().size());

		// AND there should be 2 FREE bag
		List<BaggageItem> freeBags = fees.getBags().stream().filter(isFree).collect(Collectors.toList());
		assertEquals(2, freeBags.size());
		
		// AND there should be 1 LIGHT bags
		List<BaggageItem> lightBags = fees.getBags().stream().filter(isLight).collect(Collectors.toList());
		assertEquals(1, lightBags.size());

		// AND there should be 1 FREE + OVERWEIGHT bag
		List<BaggageItem> overweightBags = fees.getBags().stream().filter(isFreeOverweight)
				.collect(Collectors.toList());
		assertEquals(1, overweightBags.size());
	}

	private Predicate<BaggageItem> isFree = b -> BaggageType.FREE.equals(b.getBaggageType());
	private Predicate<BaggageItem> isLight = b -> BaggageType.LIGHT.equals(b.getBaggageType());
	private Predicate<BaggageItem> isHeavy = b -> BaggageType.HEAVY.equals(b.getBaggageType());
	private Predicate<BaggageItem> isFreeOverweight = b -> BaggageType.FREE_OVERWEIGHT.equals(b.getBaggageType());

}
