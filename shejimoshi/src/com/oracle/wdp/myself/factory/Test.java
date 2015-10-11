package com.oracle.wdp.myself.factory;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Moveable v=new Plane();
		v.run();
		System.out.println(".................");
		
		
		
		
		
		
		
		
		
		VehicleFactory f = new PlaneFactory();
		Moveable m = f.create();
		m.run();

		VehicleFactory ff = new BroomFactory();
		Moveable mm = ff.create();
		mm.run();
	}

}
