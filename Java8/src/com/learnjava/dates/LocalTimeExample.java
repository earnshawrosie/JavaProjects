package com.learnjava.dates;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalTimeExample {

	public static void main(String[] args) {

		// LocalTime
		LocalTime localTime = LocalTime.now();
		System.out.println("local time : " + localTime);

		LocalTime localTimeHM = LocalTime.of(21, 14);
		System.out.println("local time HM : " + localTimeHM);
		
		LocalTime localTimeHMS = LocalTime.of(21, 14, 2);
		System.out.println("local time HMS : " + localTimeHMS);

		LocalTime localTimeHMSN = LocalTime.of(21, 14, 2, 222313214);
		System.out.println("local time HMSN : " + localTimeHMSN);

		/**
		 * Get Values from Local Time
		 */
		System.out.println("local time hour  : " + localTime.getHour());
		System.out.println("local time minute  : " + localTime.getMinute());

		System.out.println("local date get temporal  : " + localTime.get(ChronoField.CLOCK_HOUR_OF_DAY));
		
		System.out.println("local date get second of day  : " + localTime.toSecondOfDay());
		
		// etc..... many more options

		/**
		 * Modifying local date
		 */
		System.out.println("modifying plus  hours : " + localTime.plusHours(2));
		System.out.println("modifying plus  seconds : " + localTime.plusMinutes(2));
		System.out.println("modifying minus  hours : " + localTime.minusHours(5));
		System.out.println("modifying minus temporal unit : " + localTime.minus(1, ChronoUnit.HOURS));
		System.out.println("local time with midnight : " + localTime.with(LocalTime.MIDNIGHT));
		System.out.println("local time with  : " + localTime.with(ChronoField.HOUR_OF_DAY, 6));
		System.out.println("local time with hour : " + localTime.withHour(8));

		// etc..... many more options

		// NOTE - creates a new instance does not modify original... original is same
		System.out.println("original local time: " + localTime);

		/**
		 * Additional functions
		 */

		System.out.println("compare :  " + localTime.compareTo(localTimeHMS));
		System.out.println("before :  " + localTime.isBefore(localTimeHMS));
		System.out.println("after :  " + localTime.isAfter(localTimeHMS));

		// etc..... many more options

		/**
		 * Unsupported
		 */
		System.out.println("is supported hours : " + localTime.isSupported(ChronoUnit.HOURS));
		System.out.println("is supported days : " + localTime.isSupported(ChronoUnit.DAYS));
		System.out.println("minus days from time : " + localTime.minus(1, ChronoUnit.MONTHS));

	}

}
