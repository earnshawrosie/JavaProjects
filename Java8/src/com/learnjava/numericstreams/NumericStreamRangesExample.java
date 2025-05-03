package com.learnjava.numericstreams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamRangesExample {

	public static void main(String[] args) {
		
		//Int
		IntStream intStream = IntStream.range(1, 50);
		System.out.println(" Range count : " + intStream.count());
		
		IntStream.range(1, 50).forEach(value -> System.out.print(value + ","));
		
		System.out.println();
		
		IntStream intStreamRangeClosed = IntStream.rangeClosed(1, 50);
		System.out.println(" Range closed count : " + intStreamRangeClosed.count());
		
		IntStream.rangeClosed(1, 50).forEach(value -> System.out.print(value + ","));
		
		System.out.println();
		
		
		//Long
		LongStream longStream = LongStream.range(1, 50);
		System.out.println(" Long Range count : " + longStream.count());
		
		LongStream.range(1, 50).forEach(value -> System.out.print(value + ","));
		
		System.out.println();
		
		LongStream longStreamRangeClosed = LongStream.rangeClosed(1, 50);
		System.out.println(" Long Range closed count : " + longStreamRangeClosed.count());
		
		LongStream.rangeClosed(1, 50).forEach(value -> System.out.print(value + ","));
		
		System.out.println();
		
		//Double
		IntStream.range(1, 50).asDoubleStream().forEach(value -> System.out.print(value + ","));

	}

}
