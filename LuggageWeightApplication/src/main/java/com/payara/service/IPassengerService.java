package com.payara.service;

import java.util.List;
import java.util.Optional;

import com.payara.entity.Passenger;

public interface IPassengerService {
	
	Passenger addPassenger(Passenger passenger);
	Optional<Passenger> getPassenger(Long id);
	List<Passenger> getAllPassengers();

}
