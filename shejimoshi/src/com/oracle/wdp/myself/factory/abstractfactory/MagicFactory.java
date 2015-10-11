package com.oracle.wdp.myself.factory.abstractfactory;

public class MagicFactory extends AbstractFactory{

	@Override
	public Vehicle createVehicle() {
		// TODO Auto-generated method stub
		return new Broom();
	}

	@Override
	public Weapon createWeapon() {
		// TODO Auto-generated method stub
		return new MagicStick();
	}

	@Override
	public Food createFood() {
		// TODO Auto-generated method stub
		return new MushRoom();
	}
	
}
