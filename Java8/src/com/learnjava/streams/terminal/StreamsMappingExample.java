package com.learnjava.streams.terminal;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

public class StreamsMappingExample {

	public static void main(String[] args) {
		
		List<String> namesList = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.mapping(Student::getName, Collectors.toList()));
		
		System.out.println(" Names List : " + namesList);
		
		Set<String> namesSet = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.mapping(Student::getName, Collectors.toSet()));
		
		System.out.println(" Names Set : " + namesSet);

	}

}
