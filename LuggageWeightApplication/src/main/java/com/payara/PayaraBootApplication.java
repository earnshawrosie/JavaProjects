package com.payara;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.payara.entity.BaggageClass;
import com.payara.entity.Passenger;
import com.payara.model.BaggageType;
import com.payara.service.BaggageClassService;
import com.payara.service.PassengerService;

@SpringBootApplication
public class PayaraBootApplication implements CommandLineRunner {
	
	private static final Class<PayaraBootApplication> applicationClass = PayaraBootApplication.class;
	
	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);
	}
	
	public PayaraBootApplication() {
		super();
	}
	
	@Autowired
	private PassengerService passengerService;
	
	@Autowired
	private BaggageClassService baggageClassService;

	@Override
	public void run(String... args) throws Exception {
		
		Passenger passenger = new Passenger("Mary", "Poppins", "GB23467801", 3);
		passengerService.addPassenger(passenger);
		
		passenger = new Passenger("Peter", "Pan", "IE23456801", 5);
		passengerService.addPassenger(passenger);
		
		passenger = new Passenger("Mickey", "Mouse", "US45671230", 2);
		passengerService.addPassenger(passenger);
		
		passenger = new Passenger("Jack", "Horner", "GB45873429", 4);
		passengerService.addPassenger(passenger);
		
		passenger = new Passenger("Red", "RidingHood", "GB77865421", 4);
		passengerService.addPassenger(passenger);
		
		BaggageClass baggageClass = new BaggageClass(0.00, 7.00, new BigDecimal(10).setScale(2), BaggageType.LIGHT);
		baggageClassService.addBaggageClass(baggageClass);
		
		baggageClass = new BaggageClass(7.00, 25.00, new BigDecimal(25).setScale(2), BaggageType.HEAVY);
		baggageClassService.addBaggageClass(baggageClass);
		
	}
}
