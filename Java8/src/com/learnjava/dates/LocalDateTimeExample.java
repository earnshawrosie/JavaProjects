package com.learnjava.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalDateTimeExample {

	public static void main(String[] args) {

		// LocalDateTime
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("local date time : " + localDateTime);

		LocalDateTime localDateTimeFields = LocalDateTime.of(2027, 11, 14, 20, 14, 22, 978);
		System.out.println("local date time using fields : " + localDateTimeFields);

		LocalDateTime localDateTimeUsingDateAndTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println("local date time using date and time : " + localDateTimeUsingDateAndTime);

		/**
		 * Getting date and time
		 */
		System.out.println("local date time getting hour : " + localDateTime.getHour());
		System.out.println("local date time getting minute : " + localDateTime.getMinute());
		System.out.println("local date time getting day : " + localDateTime.getDayOfMonth());
		System.out.println("local date time getting with chrono : " + localDateTime.get(ChronoField.DAY_OF_MONTH));

		// etc..... many more options

		/**
		 * Modifying local date time
		 */
		System.out.println("local date time add hours: " + localDateTime.plusHours(4));
		System.out.println("local date time minus days: " + localDateTime.minusDays(7));
		System.out.println("local date time with  : " + localDateTime.withMonth(8));

		// etc..... many more options

		// NOTE - creates a new instance does not modify original... original is same
		System.out.println("original local date time: " + localDateTime);
		
		/**
		 * Converting
		 */
		
		LocalDate localDate = LocalDate.of(2019, 1, 1);
		System.out.println("local date at time : " + localDate.atTime(23, 33));
		
		LocalTime localTime = LocalTime.of(23, 33);
		System.out.println("local time at date : " + localTime.atDate(localDate));
		
		LocalDateTime toConvert = localTime.atDate(localDate);
		System.out.println("toLocalDate : " + toConvert.toLocalDate());
		System.out.println("toLocalTime : " + toConvert.toLocalTime());
		
	}

}
