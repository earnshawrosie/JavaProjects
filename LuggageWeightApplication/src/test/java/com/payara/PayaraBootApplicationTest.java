package com.payara;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.payara.api.controller.BaggageController;
import com.payara.api.controller.PassengerController;

@SpringBootTest
class PayaraBootApplicationTest {

	@Autowired
	private BaggageController baggageController;
	
	@Autowired
	private PassengerController passengerController;

	@Test
	void contextLoads() throws Exception {
		assertTrue(baggageController != null);
		assertTrue(passengerController != null);
	}
}
