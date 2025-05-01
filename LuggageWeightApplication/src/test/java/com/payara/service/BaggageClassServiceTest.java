package com.payara.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.payara.entity.BaggageClass;

@SpringBootTest
public class BaggageClassServiceTest {

	@Autowired
	private BaggageClassService baggageClassService;
	
	@Test
	public void testFindAll() {
		List<BaggageClass> bcs = baggageClassService.getAllBaggageClasses();
		assertTrue(bcs.size() == 2);
	}
}
