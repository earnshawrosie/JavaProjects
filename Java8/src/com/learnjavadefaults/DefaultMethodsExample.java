package com.learnjavadefaults;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultMethodsExample {

	public static void main(String[] args) {
		
		//Sort the List names in alphabetical order
		List<String> stringList = Arrays.asList("Adam", "Jenny", "Alex", "Dan", "Mike", "Eric");
		
		//Prior Java 8
		Collections.sort(stringList);

		System.out.println("Sorted list using Collections.sort() : " + stringList);
		
		//Java 8
		
		List<String> stringList1 = Arrays.asList("Adam", "Jenny", "Alex", "Dan", "Mike", "Eric");
		
		stringList1.sort(Comparator.naturalOrder());
		
		System.out.println("Sorted list using List.Sort() : " + stringList);
		
		stringList1.sort(Comparator.reverseOrder());
		
		System.out.println("Sorted list using List.Sort() reversed  : " + stringList);
	}

}
