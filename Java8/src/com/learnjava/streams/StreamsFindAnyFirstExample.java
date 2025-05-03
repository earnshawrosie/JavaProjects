package com.learnjava.streams;

import java.util.Optional;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

public class StreamsFindAnyFirstExample {
	
	public static Optional<Student> findAnyStudent() {
		
		return StudentDataBase.getAllStudents().stream()
				.filter(student -> student.getGpa() >= 3.9)
				.findAny();
	}
	
	public static Optional<Student> findFirstStudent() {
		
		return StudentDataBase.getAllStudents().stream()
				.filter(student -> student.getGpa() >= 3.9)
				.findFirst();
	}

	public static void main(String[] args) {
		
		Optional<Student> studentOptionalFindAny = findAnyStudent();
		
		if (studentOptionalFindAny.isPresent()) {
			System.out.println(" Found student : " + studentOptionalFindAny.get());
		}
		
		Optional<Student> studentOptionalFindFirst = findFirstStudent();
		
		if (studentOptionalFindFirst.isPresent()) {
			System.out.println(" Found student : " + studentOptionalFindFirst.get());
		}
		
		//Both find same - difference is when we run stream in parallel
	}

}
