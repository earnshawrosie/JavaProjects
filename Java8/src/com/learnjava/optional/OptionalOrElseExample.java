package com.learnjava.optional;

import java.util.Optional;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

public class OptionalOrElseExample {

	//orElse
	public static String optionalOrElse() {
		Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
		
		return studentOptional.map(Student::getName).orElse("default");
	}
	
	public static String optionalOrElse1() {
		Optional<Student> studentOptional = Optional.ofNullable(null);
		
		return studentOptional.map(Student::getName).orElse("default");
	}
	
	//OrElseGet
	public static String optionalOrElseGet() {
		Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
		
		return studentOptional.map(Student::getName).orElseGet(() -> "default");
	}
	
	public static String optionalOrElseGet1() {
		Optional<Student> studentOptional = Optional.ofNullable(null);
		
		return studentOptional.map(Student::getName).orElseGet(() -> "default");
	}
	
	//orElseThrow
	public static String optionalOrElseThrow() {
		Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
		
		return studentOptional.map(Student::getName).orElseThrow(() ->  new RuntimeException("No data available"));
	}
	
	public static String optionalOrElseThrow1() {
		Optional<Student> studentOptional = Optional.ofNullable(null);
		
		return studentOptional.map(Student::getName).orElseThrow(() ->  new RuntimeException("No data available"));
	}
	
	public static void main(String[] args) {
		
		System.out.println(optionalOrElse());
		System.out.println(optionalOrElse1());
		
		System.out.println(optionalOrElseGet());
		System.out.println(optionalOrElseGet1());
		
		System.out.println(optionalOrElseThrow());
		System.out.println(optionalOrElseThrow1());
	}

}
