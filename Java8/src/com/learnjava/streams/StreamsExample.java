package com.learnjava.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

public class StreamsExample {

	public static void main(String[] args) {
		
		//student name and their activities in a map
		Predicate<Student> studentPredicate = student -> student.getGradeLevel() >= 3;
		Predicate<Student> studentGpaPredicate = student -> student.getGpa() >= 3.9;
		
		//Stream Pipeline ( 4 steps )
		
		// The 2 filter operations are intermediate operation
		// The collect is terminal operation
		
		//No intermediate operation is performed without a terminal operation
		
		Map<String, List<String>> studentMap =
				StudentDataBase.getAllStudents().stream()  // 1: Output Stream<Student>
				.filter(studentPredicate)  // 2: Output Stream<Student>
				.filter(studentGpaPredicate) // 3: Output Stream<Student>
				.collect(Collectors.toMap(Student::getName, Student::getActivities)); //4: Output Map<String, List<String>>
		
		System.out.println(studentMap);
		
		System.out.println("Using peek ");
		
		//Debugging - can use peek
		Map<String, List<String>> studentMapPeek =
				StudentDataBase.getAllStudents().stream()  
				.peek(student -> System.out.println("before filters " + student))
				.filter(studentPredicate)  
				.peek(student -> System.out.println(" after 1st filter " + student))
				.filter(studentGpaPredicate) 
				.peek(student -> System.out.println(" after 2nd filter " + student))
				.collect(Collectors.toMap(Student::getName, Student::getActivities)); //4: Output Map<String, List<String>>
		
		System.out.println(studentMapPeek);
	}

}
