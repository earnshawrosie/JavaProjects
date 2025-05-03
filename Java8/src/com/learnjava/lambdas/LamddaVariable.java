package com.learnjava.lambdas;

import java.util.function.Consumer;

public class LamddaVariable {
	
	static int instanceValue = 5;

	public static void main(String[] args) {
		
		int value = 4; //LocalVariable
		
		Consumer<Integer> c1 = (i1) -> {
			System.out.println("Value is " + i1);
		};
		
		c1.accept(7);
		
		Consumer<Integer> c2 = (i) -> {
			//value++;  NOT allowed
			System.out.println(value + i);
		};
		
		c2.accept(4);
		
		Consumer<Integer> c3 = (i) -> {
			instanceValue++;  // allowed
			System.out.println(instanceValue + i);
		};
		
		c3.accept(4);

	}

}
