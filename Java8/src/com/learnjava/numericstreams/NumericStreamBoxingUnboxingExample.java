package com.learnjava.numericstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamBoxingUnboxingExample {
	
	public static List<Integer> boxing() {
		return IntStream.rangeClosed(1, 10) //int
			.boxed() //Integer
			.collect(Collectors.toList());
	}
	
	public static int unBoxing(List<Integer> integerList) {
		//wrapper to primitive
		return integerList.stream()
				.mapToInt(Integer::intValue) 
				.sum();
	}

	public static void main(String[] args) {
		
		System.out.println(" Boxing : " + boxing());
		
		System.out.println(" Unboxing : " + unBoxing(boxing()));

	}

}
