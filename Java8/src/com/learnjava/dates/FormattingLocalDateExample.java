package com.learnjava.dates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormattingLocalDateExample {
	
	public static void parseLocalDate() {
		
		/**
		 * String to LocalDate
		 */
		String date = "2025-03-18";
		LocalDate localDate = LocalDate.parse(date);
		System.out.println(" local date : " + localDate);
		
		LocalDate localDate1 = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println(" local date with formatter : " + localDate1);
		
		String date1 = "20250318"; // yyyyMMdd
		LocalDate localDate2 = LocalDate.parse(date1, DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(" local date with formatter basic : " + localDate2);
		
		/**
		 * Custom date format
		 */
		String date2 = "2025|03|18";
		DateTimeFormatter myformat = DateTimeFormatter.ofPattern("yyyy|MM|dd");
		LocalDate localDate3 = LocalDate.parse(date2, myformat);
		System.out.println(" local date with formatter custom pattern  : " + localDate3);
	}
	
	public static void formatLocalDate() {
		DateTimeFormatter myformat = DateTimeFormatter.ofPattern("yyyy|MM|dd");
		
		LocalDate localDate = LocalDate.now();
		String format = localDate.format(myformat);
		System.out.println(" format date to string : " + format);
	}

	public static void main(String[] args) {
		parseLocalDate();
		formatLocalDate();

	}

}
