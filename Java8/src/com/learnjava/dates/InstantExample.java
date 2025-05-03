package com.learnjava.dates;

import java.time.Duration;
import java.time.Instant;

public class InstantExample {

	public static void main(String[] args) {
		
		Instant ins = Instant.now();
		System.out.println("Instant now : " + ins);
		
		//Jan 1st 1970 -> Epoch -> each day 86400 seconds
		System.out.println("epoch second : " + Instant.ofEpochSecond(0));
		
		System.out.println("Instant now - epoch second : " + ins.getEpochSecond());
		
		Instant ins1 = Instant.now();
		Duration duration = Duration.between(ins, ins1);
		System.out.println("between nano : " + duration.getNano());
	}

}
