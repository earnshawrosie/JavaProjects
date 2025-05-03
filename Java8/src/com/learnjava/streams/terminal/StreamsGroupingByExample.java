package com.learnjava.streams.terminal;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

public class StreamsGroupingByExample {
	
	public static void groupByGender() {
		
		Map<String, List<Student>> students = 
				StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.groupingBy(Student::getGender));
		
		System.out.println(students);
	}
	
	public static void groupByGpa() {
		
		Map<String, List<Student>> students = 
				StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.groupingBy(
						student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"));
		
		System.out.println(students);
	}
	
	public static void twoLevelGrouping_1() {
		
		Map<Integer, Map<String, List<Student>>> students = 
				StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.groupingBy(Student::getGradeLevel,
						Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")));
		
		System.out.println(students);
	}
	
	public static void twoLevelGrouping_2() {
		
		Map<String, Integer> students = 
				StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.groupingBy(Student::getName,
						Collectors.summingInt(Student::getNoteBooks)));
		
		System.out.println(students);
	}
	
	public static void threeArgumentGroupBy() {
		
		LinkedHashMap<String, Set<Student>> students = 
				StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.groupingBy(Student::getName, LinkedHashMap::new, Collectors.toSet()));
		
		System.out.println(students);
	}
	
	public static void calculateTopGpa() {
		
		Map<Integer, Optional<Student>> maxStudents = StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.groupingBy(Student::getGradeLevel, 
				Collectors.maxBy(Comparator.comparing(Student::getGpa))));
		
		System.out.println(maxStudents);
		
		Map<Integer, Student> maxStudents1 = StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.groupingBy(Student::getGradeLevel, 
						Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparing(Student::getGpa)), Optional::get)));
		
		System.out.println(maxStudents1);
	}
	
	public static void calculateLeastGpa() {
		
		Map<Integer, Optional<Student>> minStudents = StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.groupingBy(Student::getGradeLevel, 
				Collectors.minBy(Comparator.comparing(Student::getGpa))));
		
		System.out.println(minStudents);
		
		Map<Integer, Student> minStudents1 = StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.groupingBy(Student::getGradeLevel, 
						Collectors.collectingAndThen(
								Collectors.minBy(Comparator.comparing(Student::getGpa)), Optional::get)));
		
		System.out.println(minStudents1);
	}

	public static void main(String[] args) {
		
		//groupByGender();
		//groupByGpa();
		//twoLevelGrouping_1();
		//twoLevelGrouping_2();
		//threeArgumentGroupBy();
		//calculateTopGpa();
		calculateLeastGpa();

	}

}
