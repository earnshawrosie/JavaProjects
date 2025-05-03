package com.learnjava.functionalinterfaces;

public class FunctionExample1 {
	
	public static String performConcat(String str) {
		return FunctionExample.addSomeString.apply(str);
	}

	public static void main(String[] args) {
		System.out.println("Result : " + performConcat("Hello"));

	}

}
