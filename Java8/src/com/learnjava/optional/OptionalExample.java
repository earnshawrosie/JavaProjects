package com.learnjava.optional;

import java.util.Optional;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

public class OptionalExample {
	
	public static String getStudentName() {
		Student student = StudentDataBase.studentSupplier.get();
		
		return student != null ? student.getName() : null;
	}
	
	public static Optional<String> getStudentNameOptional() {
		
		Optional<Student> student = Optional.ofNullable(StudentDataBase.studentSupplier.get());
		
		return student.map(Student::getName); //Optional<String>
	}

	
	public static void main(String[] args) {
		
		String name = getStudentName();
		if ( name != null) {
		 System.out.println("Length of student name : " + name.length());
		} else {
			System.out.println("Name not found");
		}
		
		Optional<String> nameOptional = getStudentNameOptional();
		
		if (nameOptional.isPresent()) {
			System.out.println("Length of student name : " + nameOptional.get().length());
		} else {
			System.out.println("Name not found");
		}
		
		
		
	}
}
