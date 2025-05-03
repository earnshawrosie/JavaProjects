package com.learnjava.functionalinterfaces;

import java.util.List;
import java.util.function.Consumer;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

public class ConsumerExample {
	
	static Consumer<Student> c2 = (student) -> System.out.println(student);
	static Consumer<Student> c3 = (student) -> System.out.print(student.getName());
	static Consumer<Student> c4 = (student) -> System.out.println(student.getActivities());
	
	
	static void printAllStudents() {
		
		List<Student> studentList = StudentDataBase.getAllStudents();
		studentList.forEach(c2);
	}
	
	static void printNameAndActivities() {
		System.out.println("printNameAndActivities");
	
		List<Student> studentList = StudentDataBase.getAllStudents();
		studentList.forEach(c3.andThen(c4));  //consumer chaining
	}
	
	static void printNameAndActivitiesUsingCondition() {
		System.out.println("printNameAndActivitiesUsingCondition");
		
		List<Student> studentList = StudentDataBase.getAllStudents();
		studentList.forEach(student -> {
			if (student.getGradeLevel() >= 3 && student.getGpa() >= 3.9) {
				c3.andThen(c4).andThen(c2).accept(student);
			}
		});
	}
	
	public static void main(String[] args) {
		
		Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());
		
		c1.accept("java8");
		
		printAllStudents();
		
		printNameAndActivities();
		
		printNameAndActivitiesUsingCondition();
	}

}
