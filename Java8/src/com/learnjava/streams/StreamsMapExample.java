package com.learnjava.streams;

import java.util.List;
import java.util.Set;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class StreamsMapExample {
	
	public static List<String> namesList() {
		return StudentDataBase.getAllStudents()
		.stream()
		//Student as an input -> Student Name
		.map(Student::getName) // Stream<String>
		.map(String::toUpperCase) //Stream<String> -> upper case operation
		.collect(toList()); //List<String>
	}
	
	public static Set<String> namesSet() {
		return StudentDataBase.getAllStudents()
		.stream()
		//Student as an input -> Student Name
		.map(Student::getName) // Stream<String>
		.map(String::toUpperCase) //Stream<String> -> upper case operation
		.collect(toSet()); //Set<String>
	}

	public static void main(String[] args) {
		
		System.out.println(namesList());
		System.out.println(namesSet());

	}

}
