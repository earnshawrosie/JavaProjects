package com.learnjava.streams;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

public class StreamMapReduceExample {

	private static int noOfNotebooks() {
		return StudentDataBase.getAllStudents().stream() // Stream<Student>
				.filter(student -> student.getGradeLevel() >= 3)
				.filter(student -> student.getGender().equals("female"))
				.map(Student::getNoteBooks) // Stream<Integer>
				.reduce(0, Integer::sum);
	}

	public static void main(String[] args) {

		System.out.println(" no of notebooks : " + noOfNotebooks());

	}

}
