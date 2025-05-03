package com.learnjava.dates;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FormattingLocalTimeExample {
	
public static void parseTime() {
		
		/**
		 * String to LocalDate
		 */
		String time = "13:00";
		LocalTime localTime = LocalTime.parse(time);
		System.out.println(" local time : " + localTime);
		
		LocalTime localTime1 = LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME);
		System.out.println(" local time with formatter : " + localTime1);
		
		/**
		 * Custom format
		 */
		String time2  = "13*00";
		DateTimeFormatter myformat = DateTimeFormatter.ofPattern("HH*mm");
		LocalTime localTime2 = LocalTime.parse(time2, myformat);
		System.out.println(" local time with formatter custom pattern  : " + localTime2);
		
		String time3  = "13*00*02";
		DateTimeFormatter myformat2 = DateTimeFormatter.ofPattern("HH*mm*ss");
		LocalTime localTime3 = LocalTime.parse(time3, myformat2);
		System.out.println(" local time with formatter custom pattern  : " + localTime3);
	}
	
	public static void formatTime() {
		DateTimeFormatter myformat = DateTimeFormatter.ofPattern("HH*mm");
		
		LocalTime localTime = LocalTime.now();
		String format = localTime.format(myformat);
		System.out.println(" format time to string : " + format);
	}


	public static void main(String[] args) {
		parseTime();
		formatTime();
	}

}
