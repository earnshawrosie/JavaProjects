package com.learnjava.streams.terminal;

import java.util.stream.Collectors;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

public class StreamsSumAvgExample {
	
	public static int sum() {
		
		return StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.summingInt(Student::getNoteBooks));
	}
	
	public static double avg() {
		
		return StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.averagingInt(Student::getNoteBooks));
	}


	public static void main(String[] args) {
		
		System.out.println(" Total no of notebooks : " + sum());
		System.out.println(" Avg no of notebooks : " + avg());

	}

}
