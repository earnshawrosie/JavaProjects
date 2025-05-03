package com.learnjava.dates;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateExample {

	public static void main(String[] args) {

		// LocalDate
		LocalDate localDate = LocalDate.now();
		System.out.println("local date : " + localDate);
		
		LocalDate localDateDMY = LocalDate.of(2027, 07, 17);
		System.out.println("local date DMY : " + localDateDMY);
		
		LocalDate localDateYD = LocalDate.ofYearDay(2027, 75);
		System.out.println("local date YD : " + localDateYD);
		
		/**
		 * Get Values from Local date
		 */
		System.out.println("local date month  : " + localDate.getMonth());
		System.out.println("local date month value  : " + localDate.getMonthValue());
		
		System.out.println("local date day of week  : " + localDate.getDayOfWeek());
		System.out.println("local date day of year : " + localDate.getDayOfYear());
		
		System.out.println("local date temporal field day of month : " + localDate.get(ChronoField.DAY_OF_MONTH));
		
		// etc.....  many more options
		
		/**
		 * Modifying local date
		 */
		System.out.println("modifying plus  days : " + localDate.plusDays(2));
		System.out.println("modifying plus  months : " + localDate.plusMonths(2));
		System.out.println("modifying minus  days : " + localDate.minusDays(5));
		System.out.println("modifying with year : " + localDate.withYear(2019));
		System.out.println("modifying with chrono field : " + localDate.with(ChronoField.YEAR, 2040));
		System.out.println("modifying with temporal : " + localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
		System.out.println("modifying minus temporal unit : " + localDate.minus(1, ChronoUnit.YEARS));
		
		// etc.....  many more options
		
		//NOTE - creates a new instance does not modify original... original is same 
		System.out.println("original local date: " + localDate);
		
		/**
		 * Additional functions 
		 */
		
		System.out.println("leap year :  " + localDate.isLeapYear());
		System.out.println("equal :  " + localDate.isEqual(localDateYD));
		System.out.println("before :  " + localDate.isBefore(localDateYD));
		System.out.println("after :  " + localDate.isAfter(localDateYD));
		
		// etc.....  many more options
		
		/**
		 * Unsupported
		 */
		System.out.println("is supported years : " + localDate.isSupported(ChronoUnit.YEARS));
		System.out.println("is supported minutes : " + localDate.isSupported(ChronoUnit.MINUTES));
		System.out.println("minus minutes from date: " + localDate.minus(1, ChronoUnit.MINUTES));
	}

}
