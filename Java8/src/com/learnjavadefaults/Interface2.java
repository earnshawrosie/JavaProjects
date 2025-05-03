package com.learnjavadefaults;

public interface Interface2 extends Interface1 {
	
	default void methodB() {
		System.out.println("In Interface 2 Method B");
	}
	
	default void methodA() {
		System.out.println("In Interface 2 Method A");
	}

}
