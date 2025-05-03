package com.learnjava.methodreference;

import java.util.function.Consumer;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

public class ConsumerMethodReferenceExample {
	
	static Consumer<Student> c1 = (student) -> System.out.println(student);
	
	static Consumer<Student> c2 = System.out::println;
	
	static Consumer<Student> c3 = Student::printListOfActivities;

	public static void main(String[] args) {
		
		StudentDataBase.getAllStudents().forEach(c1);
		
		StudentDataBase.getAllStudents().forEach(c2);
		
		StudentDataBase.getAllStudents().forEach(c3);

	}

}
