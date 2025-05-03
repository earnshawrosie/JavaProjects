package com.learnjava.functionalinterfaces;

import java.util.function.Predicate;

public class PredicateExample {
	
	static Predicate<Integer> p1 = (i) -> i%2 == 0;
	static Predicate<Integer> p2 = (i) -> i%2 == 0;
	
	public static void predicateAnd() {
		System.out.println("Predicate AND Result is : " + 
				p1.and(p2).test(10)); // predicate chaining
		
		System.out.println("Predicate AND Result is : " + 
				p1.and(p2).test(9)); 
	}
	
	public static void predicateOr() {
		System.out.println("Predicate OR Result is : " + 
				p1.or(p2).test(10)); // predicate chaining
		
		System.out.println("Predicate OR Result is : " + 
				p1.or(p2).test(8)); 
	}
	
	public static void predicateNegate() {
	
		System.out.println("Predicate NEGATE Result is : " + 
				p1.or(p2).negate().test(8)); 
	}
	
	
	public static void main(String[] args) {
		Predicate<Integer> p = (i) -> {
			return i%2 == 0;
		};
		
		System.out.println(p.test(4));
		
		System.out.println(p1.test(4));
		
		predicateAnd();
		predicateOr();
		predicateNegate();
	};

}
