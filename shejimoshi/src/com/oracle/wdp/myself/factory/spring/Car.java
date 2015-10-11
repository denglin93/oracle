package com.oracle.wdp.myself.factory.spring;

/**
 * @author 邓林
 * 
 * 控制了产生对象的逻辑，都可以称之为工厂相关的方法
 * 静态的工厂模式（通过静态方法获得） 
 */
public class Car implements Moveable{
	

	@Override
	public void run() {
		System.out.println("地上跑的car");
	}

	
}
