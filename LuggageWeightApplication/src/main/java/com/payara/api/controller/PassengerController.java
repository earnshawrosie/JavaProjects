package com.payara.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payara.entity.Passenger;
import com.payara.service.PassengerService;

@RestController
@RequestMapping("/api/passenger")
public class PassengerController {

	@Autowired
	private PassengerService passengerService;

	@GetMapping(value = "/passengers", produces = "application/json")
	public List<Passenger> getPassengers() {
		return passengerService.getAllPassengers();
	}
}
