package com.learnjavadefaults;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

public class DefaultMethodsExample2 {
	
	static Consumer<Student> studentConsumer = student -> System.out.println(student);
	
	static Comparator<Student> gpaComparator = Comparator.comparingDouble(Student::getGpa);
	static Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
	static Comparator<Student> gradeComparator = Comparator.comparing(Student::getGradeLevel);
	
	public static void sortByName(List<Student> studentList) {
		
		studentList.sort(nameComparator);
		studentList.forEach(studentConsumer);
	}
	
	public static void sortByGPA(List<Student> studentList) {
		
		Comparator<Student> nameComparator = Comparator.comparingDouble(Student::getGpa);
		
		studentList.sort(nameComparator);
		studentList.forEach(studentConsumer);
	}
	
	public static void comparatorChaining(List<Student> studentList) {
		
		studentList.sort(gradeComparator.thenComparing(nameComparator));
		studentList.forEach(studentConsumer);
	}
	
	public static void sortWithNullsFirst(List<Student> studentList) {
		
		Comparator<Student> studentComparator = Comparator.nullsFirst(nameComparator);
		studentList.sort(studentComparator);
		studentList.forEach(studentConsumer);
	}
	
	public static void sortWithNullsLast(List<Student> studentList) {
		
		Comparator<Student> studentComparator = Comparator.nullsLast(nameComparator);
		studentList.sort(studentComparator);
		studentList.forEach(studentConsumer);
	}


	public static void main(String[] args) {
		
		List<Student> studentList = StudentDataBase.getAllStudents();
		studentList.forEach(studentConsumer);
		
		System.out.println("Using Sort By Name");
		sortByName(studentList);
		
		System.out.println("Using Sort By GPA");
		sortByGPA(studentList);
		
		System.out.println("Using Comparator chaining");
		comparatorChaining(studentList);
		
		System.out.println("Using Nulls First");
		List<Student> studentListNulls = StudentDataBase.getAllStudentsWithNulls();
		sortWithNullsFirst(studentListNulls);
		
		System.out.println("Using Nulls Last");
		sortWithNullsLast(studentListNulls);
	}

}
