package com.learnjava.numericstreams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamAggregateExample {

	public static void main(String[] args) {
		
		int sum = IntStream.rangeClosed(1,50).sum();
		System.out.println("Sum is : " + sum);
		
		OptionalInt max = IntStream.rangeClosed(1,50).max();
		System.out.println(max.isPresent() ? max.getAsInt() : 0);
		
		OptionalInt min = IntStream.rangeClosed(1,50).min();
		System.out.println(min.isPresent() ? min.getAsInt() : 0);
		
		long sumLong = LongStream.rangeClosed(50,100).sum();
		System.out.println("Sum long  is : " + sumLong);
		
		OptionalLong maxLong = LongStream.rangeClosed(50,100).max();
		System.out.println(maxLong.isPresent() ? maxLong.getAsLong() : 0);
		
		OptionalLong minLong = LongStream.rangeClosed(50,100).min();
		System.out.println(minLong.isPresent() ? minLong.getAsLong() : 0);
		
		
		OptionalDouble avg = IntStream.rangeClosed(1, 50).average();
		System.out.println(avg.isPresent() ? avg.getAsDouble() : 0);
	}

}
