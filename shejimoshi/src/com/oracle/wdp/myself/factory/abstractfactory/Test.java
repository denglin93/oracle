package com.oracle.wdp.myself.factory.abstractfactory;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//AbstractFactory df = new DefaultFactory();
		AbstractFactory df = new MagicFactory();

		Vehicle c = df.createVehicle();
		c.run();
		Weapon ak = df.createWeapon();
		ak.shoot();
		Food a = df.createFood();
		a.printName();
	}

}
