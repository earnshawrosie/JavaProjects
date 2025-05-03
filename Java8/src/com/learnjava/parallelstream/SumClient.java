package com.learnjava.parallelstream;

import java.util.stream.IntStream;

public class SumClient {

	public static void main(String[] args) {
		
		Sum sum = new Sum();
		
		IntStream.rangeClosed(1, 1000).forEach(sum::performSum);
		
		System.out.println(sum.getTotal());  //500500
		
		Sum sum1 = new Sum();
		
		IntStream.rangeClosed(1, 1000).parallel().forEach(sum1::performSum);
		
		System.out.println(sum1.getTotal());  // Gives different results on each run

	}

}
