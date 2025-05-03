package com.learnjava.parallelstream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamBoxedExample {
	
	public static int sequentialSum(List<Integer> integerList) {
		
		long start = System.currentTimeMillis();
		
		int sum = integerList.stream().reduce(0, (x,y) -> x + y);
		
		long end = System.currentTimeMillis();
		
		System.out.println("Seq Duration : " + (end - start));
		
		return sum;
	}
	
	public static int parallelSum(List<Integer> integerList) {
		
		long start = System.currentTimeMillis();
		
		int sum = integerList.parallelStream()
				.reduce(0, (x,y) -> x + y); // perform the unboxing from Integer to int
		
		long end = System.currentTimeMillis();
		
		System.out.println("Parallel Duration : " + (end - start));
		
		return sum;
	}

	public static void main(String[] args) {
		
		List<Integer> integerList = IntStream.rangeClosed(1,  100000)
				.boxed()
				.collect(Collectors.toList());
		
		sequentialSum(integerList);
		parallelSum(integerList);

	}

}
