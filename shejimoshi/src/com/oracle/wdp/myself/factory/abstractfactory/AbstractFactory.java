package com.oracle.wdp.myself.factory.abstractfactory;

public abstract class AbstractFactory {
	public abstract Vehicle createVehicle();

	public abstract Weapon createWeapon();

	public abstract Food createFood();
}
