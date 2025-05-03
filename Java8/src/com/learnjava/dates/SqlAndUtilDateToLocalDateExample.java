package com.learnjava.dates;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class SqlAndUtilDateToLocalDateExample {

	public static void main(String[] args) {
		
		/**
		 * java.util.Date to LocalDate and vice versa
		 */
		Date date = new Date();
		System.out.println(" java.util.date : " + date);
		
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		System.out.println(" java.util.date converted to LocalDate : " + localDate);
		
		Date date1 = new Date().from(
				localDate.atTime(LocalTime.now()).atZone(ZoneId.systemDefault()).toInstant());
		
		System.out.println(" vice versa : " + date1);
		
		/**
		 * java.sql.Date to LocalDate and vice versa
		 */
		
		java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
		LocalDate localFromSql = sqlDate.toLocalDate();

	}

}
