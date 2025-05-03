package com.learnjava.functionalinterfaces;

import java.util.List;
import java.util.function.Predicate;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

public class PredicateStudentExample {
	
	static Predicate<Student> p1 = (student) -> student.getGradeLevel() >= 3;
	static Predicate<Student> p2 = (student) -> student.getGpa() >= 3.9;
	
	public static void filterStudentsByGradeLevel() {
		
		System.out.println("filterStudentsByGradeLevel");
		
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		studentList.forEach(student -> {
			if (p1.test(student)) {
				System.out.println(student);
			}
		});
	}
	
	public static void filterStudentsByGpa() {
	
		System.out.println("filterStudentsByGpa");
		
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		studentList.forEach(student -> {
			if (p2.test(student)) {
				System.out.println(student);
			}
		});
	}
	
	public static void filterStudents() {
		
		System.out.println("filterStudents");
		
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		studentList.forEach(student -> {
			if (p1.or(p2).negate().test(student)) {
				System.out.println(student);
			} else {
				System.out.println(student);
			}
		});
	}

	public static void main(String[] args) {
		
		filterStudentsByGradeLevel();
		filterStudentsByGpa();
		filterStudents();
	}

}
