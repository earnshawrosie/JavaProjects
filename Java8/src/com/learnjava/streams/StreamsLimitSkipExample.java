package com.learnjava.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample {
	
	public static Optional<Integer> limit(List<Integer> integers) {
		//6  *
		//7  *
		//8
		//9
		//10
		return integers.stream().limit(2).reduce((x,y) -> x + y);
	}
	
	public static Optional<Integer> skip(List<Integer> integers) {
		//6  
		//7  
		//8
		//9 *
		//10 *
		return integers.stream().skip(3).reduce((x,y) -> x + y);
	}

	public static void main(String[] args) {
		
		List<Integer> integers = Arrays.asList(6,7,8,9,10);
		
		Optional<Integer> limitResult = limit(integers);
		
		if (limitResult.isPresent()) {
			System.out.println("Limit result with limit 2 is : " + limitResult.get());
		} 

		Optional<Integer> skipResult = skip(integers);
		
		if (skipResult.isPresent()) {
			System.out.println("Skip result with skip 3 is : " + skipResult.get());
		} 
	}

}
