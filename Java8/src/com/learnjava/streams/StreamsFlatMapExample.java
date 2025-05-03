package com.learnjava.streams;

import java.util.List;
import java.util.stream.Collectors;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

public class StreamsFlatMapExample {
	
	public static List<String> printStudentActivities() {
		
		return StudentDataBase.getAllStudents().stream() //Stream<Student>
		.map(Student::getActivities) //Stream<List<String>>
		.flatMap(List::stream) //Stream<String>
		.collect(Collectors.toList()); //List<String>
	}
	
	public static List<String> printDistinctStudentActivities() {
		
		return StudentDataBase.getAllStudents().stream() //Stream<Student>
		.map(Student::getActivities) //Stream<List<String>>
		.flatMap(List::stream) //Stream<String>
		.distinct() //Stream<String> with distinct function performed
		.collect(Collectors.toList()); //List<String>
	}
	
	public static List<String> printDistinctSortedStudentActivities() {
		
		return StudentDataBase.getAllStudents().stream() //Stream<Student>
		.map(Student::getActivities) //Stream<List<String>>
		.flatMap(List::stream) //Stream<String>
		.distinct() //Stream<String> with distinct function performed
		.sorted() //Stream<String> with sorted function performed
		.collect(Collectors.toList()); //List<String>
	}
	
	public static Long printDistinctStudentActivitiesCount() {
		
		return StudentDataBase.getAllStudents().stream() //Stream<Student>
		.map(Student::getActivities) //Stream<List<String>>
		.flatMap(List::stream) //Stream<String>
		.distinct() //Stream<String> with distinct function performed
		.count();
	}


	public static void main(String[] args) {

		System.out.println(printStudentActivities());
		System.out.println(printDistinctStudentActivities());
		System.out.println(printDistinctSortedStudentActivities());
		System.out.println(printDistinctStudentActivitiesCount());
	}

}
