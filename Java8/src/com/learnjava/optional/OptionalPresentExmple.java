package com.learnjava.optional;

import java.util.Optional;

public class OptionalPresentExmple {

	public static void main(String[] args) {
		
		//isPresent
		Optional<String> optional = Optional.ofNullable("hello optional");
		System.out.println(optional.isPresent());
		if (optional.isPresent()) {
			System.out.println(optional.get());
		}
		
		Optional<String> optional1 = Optional.ofNullable(null);
		System.out.println(optional1.isPresent());
		
		//ifPresent
		optional.ifPresent(s -> System.out.println(s));

	}

}
