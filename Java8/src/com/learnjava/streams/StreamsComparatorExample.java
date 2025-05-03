package com.learnjava.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

public class StreamsComparatorExample {
	
	public static List<Student> sortStudentsByName() {
		
		return StudentDataBase.getAllStudents().stream() //Stream<Student>
		.sorted(Comparator.comparing(Student::getName)) //Stream<Student> with sorted function performed
		.collect(Collectors.toList()); //List<String>
	}
	
	public static List<Student> sortStudentsByGpa() {
		
		return StudentDataBase.getAllStudents().stream() //Stream<Student>
		.sorted(Comparator.comparing(Student::getGpa)) //Stream<Student> with sorted function performed
		.collect(Collectors.toList()); //List<String>
	}
	
	public static List<Student> sortStudentsByGpaDesc() {
		
		return StudentDataBase.getAllStudents().stream() //Stream<Student>
		.sorted(Comparator.comparing(Student::getGpa).reversed()) //Stream<Student> with sorted function performed
		.collect(Collectors.toList()); //List<String>
	}
	

	public static void main(String[] args) {
		
		System.out.println("Sorted by name :");
		sortStudentsByName().forEach(System.out::println);
		
		System.out.println("Sorted by gpa :");
		sortStudentsByGpa().forEach(System.out::println);
		
		System.out.println("Sorted by gpa desc :");
		sortStudentsByGpaDesc().forEach(System.out::println);
	}

}
