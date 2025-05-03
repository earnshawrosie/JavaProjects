package com.learnjava.streams;

import java.util.List;
import java.util.stream.Collectors;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

public class StreamsFilterExample {
	
	public static List<Student> filterStudents() {
		
		return StudentDataBase.getAllStudents().stream()  //Stream<Student>
		.filter(student -> student.getGender().equals("female")) //Stream<Student> - filtered ( female )
		.filter(student -> student.getGpa() >= 3.9) //Stream<Student> - filtered ( gpa )
		.collect(Collectors.toList()); //List<Student> (after filters)
	}

	public static void main(String[] args) {
		
		filterStudents().forEach(System.out::println);
	}

}
