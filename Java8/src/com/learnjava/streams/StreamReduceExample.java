package com.learnjava.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.learnjava.data.Student;
import com.learnjava.data.StudentDataBase;

public class StreamReduceExample {
	
	public static int performMultiplication(List<Integer> integerList) {
		
		//1
		//3
		//5
		//7
		//1: a = 1 (default supplied), b = 1(from stream) => result 1 is returned
		//2: a = 1  (result from 1), b = 3(from stream) => result 3 is returned
		//3: a = 3, (result from 2), b = 5(from stream) => result 15 is returned
		//4: a = 15, b = 7(from stream) => result 105 is returned
		return integerList.stream()
				.reduce(1, (a,b) -> a*b);
	}
	
	public static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> integerList) {
	
		//1
		//3
		//5
		//7
		//1: a = 1 (default supplied), b = 1(from stream) => result 1 is returned
		//2: a = 1  (result from 1), b = 3(from stream) => result 3 is returned
		//3: a = 3, (result from 2), b = 5(from stream) => result 15 is returned
		//4: a = 15, b = 7(from stream) => result 105 is returned
		return integerList.stream()
				.reduce((a,b) -> a*b);
	}
	
	public static Optional<Student> getHighestGpaStudent() {
		
		return StudentDataBase.getAllStudents().stream()
				//students one by one
				.reduce((s1, s2) -> (s1.getGpa() > s2.getGpa()) ? s1 : s2);		
	}

	public static void main(String[] args) {
		
		List<Integer> integers = Arrays.asList(1, 3, 5, 7);
		List<Integer> integers1 = new ArrayList<>();
		
		System.out.println(performMultiplication(integers));
		
		Optional<Integer> result = performMultiplicationWithoutIdentity(integers);
		
		System.out.println(result.isPresent());
		System.out.println(result.get());
		
		Optional<Integer> result1 = performMultiplicationWithoutIdentity(integers1);
		
		if (result1.isPresent()) {
			System.out.println(result1.get());
		}
		
		Optional<Student> studentResult = getHighestGpaStudent();
		
		if (studentResult.isPresent()) {
			System.out.println(studentResult.get());
		}
		
	}

}
