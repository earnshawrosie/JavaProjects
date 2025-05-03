package com.learnjava.methodreference;

import java.util.function.Predicate;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

public class RefactorMethodReferenceExample {
	
	static Predicate<Student> p1 = (student) -> student.getGradeLevel() >= 3;
	
	static Predicate<Student> p2 = RefactorMethodReferenceExample::greaterThanGradelevel;
	
	public static boolean greaterThanGradelevel(Student s) {
		return s.getGradeLevel() >= 3;
	}

	public static void main(String[] args) {
		
		System.out.println(p1.test(StudentDataBase.studentSupplier.get()));
		
		System.out.println(p2.test(StudentDataBase.studentSupplier.get()));

	}

}
