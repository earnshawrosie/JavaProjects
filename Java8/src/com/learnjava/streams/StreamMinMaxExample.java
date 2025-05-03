package com.learnjava.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamMinMaxExample {
	
	public static int findMaxValue(List<Integer> integerList) {
		//6 -> y
		//7 -> y
		//8 -> y
		//9 -> y
		//10 -> y
		//x variable holds the max value for each element in the iteration
		return integerList.stream().reduce(0, (x,y) ->  x > y ? x : y);
	}
	
	public static Optional<Integer>findMaxValueWithoutIdentity(List<Integer> integerList) {
		//6 -> y
		//7 -> y
		//8 -> y
		//9 -> y
		//10 -> y
		//x variable holds the max value for each element in the iteration
		return integerList.stream().reduce((x,y) ->  x > y ? x : y);
	}
	
	public static int findMinValue(List<Integer> integerList) {
		//6 -> y
		//7 -> y
		//8 -> y
		//9 -> y
		//10 -> y
		//x variable holds the max value for each element in the iteration
		return integerList.stream().reduce(0, (x,y) ->  x < y ? x : y);
	}
	
	public static Optional<Integer>findMinValueWithoutIdentity(List<Integer> integerList) {
		//6 -> y
		//7 -> y
		//8 -> y
		//9 -> y
		//10 -> y
		//x variable holds the max value for each element in the iteration
		return integerList.stream().reduce((x,y) ->  x < y ? x : y);
	}

	public static void main(String[] args) {
		
		List<Integer> integerList = Arrays.asList(6,7,8,9,10);
		List<Integer> integerList1 = new ArrayList<>();
		
		System.out.println(" max value : " + findMaxValue(integerList));
		
		Optional<Integer> max = findMaxValueWithoutIdentity(integerList);
		if (max.isPresent()) {
			System.out.println(" max value without identity : " + max.get());
		}
		
		Optional<Integer> max1 = findMaxValueWithoutIdentity(integerList1);
		if (max1.isPresent()) {
			System.out.println(" max value without identity - empty list : " + max1.get());
		} else {
			System.out.println(" Input list empty");
		}
		
		System.out.println(" min value : " + findMinValue(integerList));
		
		Optional<Integer> min = findMinValueWithoutIdentity(integerList);
		if (min.isPresent()) {
			System.out.println(" min value without identity : " + min.get());
		}
		
		Optional<Integer> min1 = findMinValueWithoutIdentity(integerList1);
		if (min1.isPresent()) {
			System.out.println(" min value without identity - empty list : " + min1.get());
		} else {
			System.out.println(" Input list empty");
		}
	}

}
