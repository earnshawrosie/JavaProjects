package com.learnjavadefaults;

public interface Interface3 extends Interface2 {

	default void methodC() {
		System.out.println("In Interface 3 Method C");
	}
}
