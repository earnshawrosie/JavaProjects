package com.payara.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payara.entity.Passenger;
import com.payara.repository.PassengerRepository;

@Service
public class PassengerService implements IPassengerService {
	
	@Autowired
	private PassengerRepository passengerRepository;

	@Override
	public Passenger addPassenger(Passenger passenger) {
		return passengerRepository.save(passenger);
	}

	@Override
	public Optional<Passenger> getPassenger(Long id) {
		return passengerRepository.findById(id);
	}

	@Override
	public List<Passenger> getAllPassengers() {
		return passengerRepository.findAll();
	}

}
