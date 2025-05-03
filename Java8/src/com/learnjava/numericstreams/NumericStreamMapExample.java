package com.learnjava.numericstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamMapExample {
	
	public static List<Integer> mapToObj() {
		
		return IntStream.rangeClosed(1, 5)
				.mapToObj(i -> { 
					return new Integer(i); })
				.collect(Collectors.toList());
	}
	
	public static long mapToLong() {
		
		return IntStream.rangeClosed(1, 5) //intstream
				// i is passed from the intstream
				.mapToLong(i -> i ) // convert intstream to longstream
				.sum();
	}
	
	public static double mapToDouble() {
		
		return IntStream.rangeClosed(1, 5) //intstream
				// i is passed from the intstream
				.mapToDouble(i -> i ) // convert intstream to doublestream
				.sum();
	}


	public static void main(String[] args) {
		
		System.out.println("mapToObj : " + mapToObj());
		System.out.println("mapToLong : " + mapToLong());
		System.out.println("mapToDouble : " + mapToDouble());
	}

}
