package com.learnjava.numericstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamsExample {
	
	public static int sumOfNNumbers(List<Integer> integerList) {
		return integerList.stream()
				.reduce(0, (x,y) -> x + y); //Unboxing to convert the Integer to int
	}
	
	public static int sumOfNNumbersIntStream() {
		return IntStream.rangeClosed(1, 6) //1,2,3,4,5,6
				.sum();
	}

	public static void main(String[] args) {
		
		List<Integer> integerlist = Arrays.asList(1,2,3,4,5,6);
		
		System.out.println("Sum of n numbers : " + sumOfNNumbers(integerlist));
		
		System.out.println("Sum of n numbers intStream : " + sumOfNNumbersIntStream());

	}

}
