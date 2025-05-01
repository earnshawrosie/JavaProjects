package com.payara.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.payara.entity.Passenger;

@SpringBootTest
public class PassengerServiceTest {


	@Autowired
	private PassengerService passengerService;
	
	@Test
	public void testFindAll() {
		List<Passenger> passengers = passengerService.getAllPassengers();
		assertTrue(passengers.size() == 5);
	}
}
