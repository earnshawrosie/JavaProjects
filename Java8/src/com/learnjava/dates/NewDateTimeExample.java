package com.learnjava.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class NewDateTimeExample {

	public static void main(String[] args) {

		// LocalDate
		LocalDate localDate = LocalDate.now();
		System.out.println("local date : " + localDate);

		// LocalTime
		LocalTime localTime = LocalTime.now();
		System.out.println("local time : " + localTime);

		// LocalDateTime
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("local date time : " + localDateTime);

	}

}
