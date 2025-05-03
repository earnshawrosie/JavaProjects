package com.learnjavadefaults;

import java.util.Arrays;
import java.util.List;

public class MultiplierClient {

	public static void main(String[] args) {
		
		Multiplier multiplier = new MultiplierImpl();
		List<Integer> integerList = Arrays.asList(1,3,5);
		
		System.out.println("Result is : " + multiplier.multiply(integerList));
		
		//In IMPL - overridden
		System.out.println("default method size is : " + multiplier.size(integerList));
		
		//In INTERFACE - not overridden
		System.out.println("default method sum is : " + multiplier.sum(integerList));
		
		System.out.println("static is empty : " + Multiplier.isEmpty(integerList));
		
		List<Integer> integerList1 = Arrays.asList();
		
		System.out.println("static is empty : " + Multiplier.isEmpty(integerList1));

	}

}
