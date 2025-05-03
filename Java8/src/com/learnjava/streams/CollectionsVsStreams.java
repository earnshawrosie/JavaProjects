package com.learnjava.streams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class CollectionsVsStreams {

	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<>();
		names.add("adam");
		names.add("jim");
		names.add("jenny");
		
		for (String name : names) {
			System.out.println(name);
		}
		
		for (String name : names) {
			System.out.println(name);
		}
		
		names.remove(0);
		
		System.out.println(names);
		
		names.stream();  //no add, remove // get etc....
		
		Stream<String> nameStream = names.stream();
		
		nameStream.forEach(System.out::println);
		
		//Cannot do this - will give IllegalStateException : stream has already been operated on or closed
		//nameStream.forEach(System.out::println); 
	}

}
