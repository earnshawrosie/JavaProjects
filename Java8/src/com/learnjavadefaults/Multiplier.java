package com.learnjavadefaults;

import java.util.List;

public interface Multiplier {

	int multiply(List<Integer> integerList);
	
	default int sum(List<Integer> integerList) {
		System.out.println("Inside Interface");
		return integerList.stream().reduce(1, (x,y) -> x+y);
	}
	
	default int size(List<Integer> integerList) {
		System.out.println("Inside Interface");
		return integerList.size();
	}
	
	static boolean isEmpty(List<Integer> integerList) {
		return integerList.isEmpty();
	}
}
