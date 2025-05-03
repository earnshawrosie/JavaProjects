package com.modernjava.latestfeatures.sealed;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;

import com.modernjava.latestfeatures.sealed.Car;
import com.modernjava.latestfeatures.sealed.Dog;
import com.modernjava.latestfeatures.sealed.FlyingCar;
import com.modernjava.latestfeatures.sealed.Truck;
import com.modernjava.latestfeatures.sealed.Vehicle;

public class VehicleTest {
	
	@Test
	public void vehicleTest() {
		
		var car = new Car();
		var truck = new Truck();
		
		assertInstanceOf(Vehicle.class, car);
		assertInstanceOf(Vehicle.class, truck);
		
		var flyingCar = new FlyingCar();
		assertInstanceOf(Car.class, flyingCar);
		assertInstanceOf(Vehicle.class, flyingCar);
		
		var dog = new Dog();
		assertInstanceOf(Truck.class, dog);
		assertInstanceOf(Vehicle.class, dog);
	}

}
