package com.oracle.wdp.myself.factory;

public class CarFactory extends VehicleFactory {

	@Override
	Moveable create() {
		// TODO Auto-generated method stub
		return new Car();
	}

}
