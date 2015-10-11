package com.oracle.wdp.myself.factory.abstractfactory;

public class DefaultFactory extends AbstractFactory{
	
	@Override
	public Vehicle createVehicle() {
		// TODO Auto-generated method stub
		return new Car();
	}

	@Override
	public Weapon createWeapon() {
		// TODO Auto-generated method stub
		return new AK47();
	}

	@Override
	public Food createFood() {
		// TODO Auto-generated method stub
		return new Apple();
	}
}
