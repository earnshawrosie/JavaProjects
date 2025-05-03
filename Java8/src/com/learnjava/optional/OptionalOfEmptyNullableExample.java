package com.learnjava.optional;

import java.util.Optional;

public class OptionalOfEmptyNullableExample {
	
	public static Optional<String> ofNullable() {
		
		return Optional.ofNullable("Hello");
	}
	
	public static Optional<String> of() {
		
		return Optional.of("Hello");  // always expects value to be present
	}
	
	public static Optional<String> empty() {
		
		return Optional.empty();
	}
	

	public static void main(String[] args) {
		
		Optional<String> str = ofNullable();
		if (str.isPresent())
		System.out.println(str);
		
		Optional<String> str1 = of();
		if (str1.isPresent())
		System.out.println(str1);

		System.out.println(empty());
	}

}
