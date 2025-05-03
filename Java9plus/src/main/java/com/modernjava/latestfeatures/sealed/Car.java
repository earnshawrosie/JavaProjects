package com.modernjava.latestfeatures.sealed;

public sealed class Car extends Vehicle implements SmartMediaPlayer permits FlyingCar {

	@Override
	public String drive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void connectPhone() {
		// TODO Auto-generated method stub
		
	}

}
