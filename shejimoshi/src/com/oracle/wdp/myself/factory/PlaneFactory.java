package com.oracle.wdp.myself.factory;

public class PlaneFactory extends VehicleFactory {

	@Override
	Moveable create() {
		// TODO Auto-generated method stub
		return new Plane();
	}
	
}
