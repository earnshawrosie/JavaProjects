package com.learnjava.dates;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormattingLocalDateTimeExample {
	
	public static void parseLocalDateTime() {
		
		String dateTime = "2025-03-19T11:14:27";
		System.out.println("local date time parse default : " + LocalDateTime.parse(dateTime));
		
		System.out.println("local date time parse default format : " + 
				LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		
		/**
		 * Custom format
		 */
		String datetime1 = "2025-03-19T11|14|27";
		DateTimeFormatter myformat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH|mm|ss");
		System.out.println("local date time custom : " + 
				LocalDateTime.parse(datetime1, myformat));
		
		String datetime2 = "2025-03-19abc11|14|27";
		DateTimeFormatter myformat2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'abc'HH|mm|ss");
		System.out.println("local date time custom : " + 
				LocalDateTime.parse(datetime2, myformat2));
		
	}
	
	public static void formatLocalDateTime() {
		DateTimeFormatter myformat = DateTimeFormatter.ofPattern("yyyy-MM-dd'abc'HH|mm|ss");
		LocalDateTime dateTime1 = LocalDateTime.now();
		System.out.println("local date time format : " + 
				dateTime1.format(myformat));
		
	}

	public static void main(String[] args) {
		parseLocalDateTime();
		formatLocalDateTime();

	}

}
