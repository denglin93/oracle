package com.oracle.wdp.myself.factory;

/**
 * @author 邓林
 * 
 * 控制了产生对象的逻辑，都可以称之为工厂相关的方法
 * 静态的工厂模式（通过静态方法获得） 
 */
public class Car implements Moveable{
	private static Car car = new Car();

	

	// getInstance静态工厂方法
	public static Car getInstance() {
		return car;
	}

	@Override
	public void run() {
		System.out.println("地上跑的car");
	}

	
}
