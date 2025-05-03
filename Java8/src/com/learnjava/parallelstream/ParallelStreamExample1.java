package com.learnjava.parallelstream;

import java.util.List;
import java.util.stream.Collectors;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

public class ParallelStreamExample1 {

	public static List<String> printStudentActivitiesSequential() {

		long start = System.currentTimeMillis();
		
		List<String> activities = StudentDataBase.getAllStudents().stream() // Stream<Student>
				.map(Student::getActivities) // Stream<List<String>>
				.flatMap(List::stream) // Stream<String>
				.collect(Collectors.toList()); // List<String>
		
		long end = System.currentTimeMillis();
		
		System.out.println("Seq Duration : " + (end - start));
		
		return activities;
	}

	public static List<String> printStudentActivitiesParallel() {

		long start = System.currentTimeMillis();
		
		List<String> activities = StudentDataBase.getAllStudents().stream() // Stream<Student>
				.parallel()
				.map(Student::getActivities) // Stream<List<String>>
				.flatMap(List::stream) // Stream<String>
				.collect(Collectors.toList()); // List<String>
		
		long end = System.currentTimeMillis();
		
		System.out.println("Parallel Duration : " + (end - start));
		
		return activities;
	}

	public static void main(String[] args) {
		
		printStudentActivitiesSequential();
		printStudentActivitiesParallel();

	}

}
