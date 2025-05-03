package com.learnjava.optional;

import java.util.Optional;

import com.learnjava.data.Bike;
import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

public class OptionalMapFlatMapExample {
	
	//filter
	public static void optionalFilter() {
		Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
		
		studentOptional
			.filter(student -> student.getGpa() >= 3.5)
			.ifPresent(student -> System.out.println(student));
	}
	
	//map
	public static void optionalMap() {
		Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
		
		if (studentOptional.isPresent()) {
			Optional<String> name = studentOptional
					.filter(student -> student.getGpa() >= 3.5)
					.map(Student::getName);
			System.out.println(name.get());
		}
	}
	
	//flatMap
	public static void optionalFlatMap() {
		Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
		
		Optional<String> name = studentOptional
									.filter(student -> student.getGpa() >= 3.5)  //Optional<Student <Optional<Bike>>>
									.flatMap(Student::getBike) //Optional<Bike>
									.map(Bike::getName);
		name.ifPresent(s -> System.out.println(name.get()));
	}

	public static void main(String[] args) {
		
		optionalFilter();
		optionalMap();
		optionalFlatMap();
	}

}
