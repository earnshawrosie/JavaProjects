package com.learnjava.lambdas;

import java.util.Comparator;

public class ComparatorLamdaExample {

public static void main(String[] args) {
		
		/**
		 * prior Java 8
		 */
		
		Comparator<Integer> comparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(02); // 0 => 01 == 02 1 => 01 > 02  -1 => 01 < 02
			}	
		
		};
		
		System.out.println("result of the comparator is : "  + comparator.compare(3, 2));
		
		//Java 8 lamda
		//()->{}
		
		Comparator<Integer> comparatorLamda =
				(Integer a, Integer b) -> a.compareTo(b);
				
		System.out.println("result of the comparator using lamda is : " 
				+ comparatorLamda.compare(3, 2));
		
		Comparator<Integer> comparatorLamda1 =
				(a, b) -> a.compareTo(b);
				
		System.out.println("result of the comparator using lamda is : " 
				+ comparatorLamda1.compare(3, 2));
	}
}
						
