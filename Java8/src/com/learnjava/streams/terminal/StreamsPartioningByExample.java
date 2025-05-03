package com.learnjava.streams.terminal;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

public class StreamsPartioningByExample {
	
	public static void partioningBy_1() {
		
		Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.8;
		
		Map<Boolean, List<Student>> resultMap = StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.partitioningBy(gpaPredicate));
		
		System.out.println(resultMap);
	}
	
	public static void partioningBy_2() {
		
		Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.8;
		
		Map<Boolean, Set<Student>> resultMap = StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.partitioningBy(gpaPredicate, Collectors.toSet()));
		
		System.out.println(resultMap);
	}

	public static void main(String[] args) {
		
		//partioningBy_1();
		partioningBy_2();
	}

}
