package com.learnjava.dates;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationExample {

	public static void main(String[] args) {
		
		Duration durationHours = Duration.ofHours(3);
		System.out.println("Duration hours  : " + durationHours );
		System.out.println("Duration hours - hours  : " + durationHours.toHours());
		System.out.println("Duration hours - minutes  : " + durationHours.toMinutes());
		System.out.println("Duration hours - nanos  : " + durationHours.get(ChronoUnit.NANOS) );
		System.out.println("Duration hours - seconds  : " + durationHours.getSeconds() );
		
		Duration durationMinutes = Duration.ofMinutes(3);
		System.out.println("Duration minutes  : " + durationMinutes );
		System.out.println("Duration minutes - hours  : " + durationMinutes.toHours());
		System.out.println("Duration minutes - minutes  : " + durationMinutes.toMinutes());
		System.out.println("Duration minutes - nanos : " + durationMinutes.get(ChronoUnit.NANOS) );
		System.out.println("Duration minutes - seconds  : " + durationMinutes.getSeconds() );
		
		LocalTime localTime1 = LocalTime.of(7, 20);
		LocalTime localTime2 = LocalTime.of(8, 24);
		
		Duration duration = Duration.between(localTime1, localTime2);
		System.out.println("Duration between : " + duration );
		System.out.println("Duration between minutes : " + duration.toMinutes() );
		
		long diffUntil = localTime1.until(localTime2, ChronoUnit.MINUTES);
		System.out.println("diff until in minutes : " + diffUntil );
	}

}
