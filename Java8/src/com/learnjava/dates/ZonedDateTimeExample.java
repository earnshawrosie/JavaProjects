package com.learnjava.dates;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class ZonedDateTimeExample {
	
	public static void main(String[] args) {
		
		ZonedDateTime zonedDT = ZonedDateTime.now();
		System.out.println("zonedDataTime :" + zonedDT);
		
		System.out.println("zone offset : " + zonedDT.getOffset());

		System.out.println("num zones supported : " + ZoneId.getAvailableZoneIds().size());
		
		//CST,EST,MST,PST
		System.out.println("Chicago CST :" + ZonedDateTime.now(ZoneId.of("America/Chicago")));
		System.out.println("Detroit EST :" + ZonedDateTime.now(ZoneId.of("America/Detroit")));
		System.out.println("LA PST :" + ZonedDateTime.now(ZoneId.of("America/Los_Angeles")));
		System.out.println("Denver MST :" + ZonedDateTime.now(ZoneId.of("America/Denver")));
		
		System.out.println("Denver MST using clock :" 
				+ ZonedDateTime.now(Clock.system(ZoneId.of("America/Denver"))));
		
		System.out.println("Local Date Time - Denver : " 
				+ LocalDateTime.now(ZoneId.of("America/Denver")));
		
		System.out.println("Local Date Time using clock - Denver : " 
				+ LocalDateTime.now(Clock.system(ZoneId.of("America/Denver"))));
		
		System.out.println("Local Date Time Instant - Denver : " 
				+ LocalDateTime.ofInstant(Instant.now(), ZoneId.of("America/Denver")));
		
		System.out.println("Local Date Time Instant - sys default : " 
				+ LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));
		
		//ZoneId.getAvailableZoneIds()
			//	.stream().forEach(zone -> System.out.println(zone));
		
		/**
		 * Convert from localdatetime,instant to ZonedDataTime
		 */
		
		LocalDateTime convert = LocalDateTime.now();
		System.out.println("before convert : " + convert);
		
		System.out.println("convert at zone chicago : "  + 
				convert.atZone(ZoneId.of("America/Chicago")));
		
		System.out.println("instant at zone detroit : "  + 
				Instant.now().atZone(ZoneId.of("America/Detroit")));
		
		System.out.println("convert at offset -6 : "  + 
				convert.atOffset(ZoneOffset.ofHours(-6)));
		
	}

}
