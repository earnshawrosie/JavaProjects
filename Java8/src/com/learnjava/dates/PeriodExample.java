package com.learnjava.dates;

import java.time.LocalDate;
import java.time.Period;

public class PeriodExample {

	public static void main(String[] args) {
		
		Period periodDays = Period.ofDays(10);
		System.out.println("Period days : " + periodDays);
		System.out.println("Period days get days : " + periodDays.getDays());
		
		Period periodMonths = Period.ofMonths(2);
		System.out.println("Period months : " + periodMonths);
		System.out.println("Period months get months : " + periodMonths.getMonths());
		
		Period periodYears = Period.ofYears(10);
		System.out.println("Period years : " + periodYears);
		System.out.println("Period years get years : " + periodYears.getYears());
		System.out.println("Period to total months : " + periodYears.toTotalMonths());
		
		// etc...
		
		LocalDate date1 = LocalDate.of(2018, 1, 1);
		LocalDate date2 = LocalDate.of(2018, 12, 31);
		
		Period period = Period.between(date1, date2); //calculate difference between dates
		System.out.println("Period between : " + period);
		System.out.println("Period between days : " + period.getDays());
		System.out.println("Period between months : " + period.getMonths());
		System.out.println("Period between years : " + period.getYears());
		
		Period period1 = date1.until(date2);
		System.out.println("Period until : " + period1);
		
		System.out.println("Period days : " + period1.getDays()); //31 - 1
		System.out.println("Period months : " + period1.getMonths()); //12 - 1
		System.out.println("Period years : " + period1.getYears()); //2018 - 2018
		
		
		//Only compatible with LocalDate NOT LocalTime
	}

}
