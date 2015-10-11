package com.oracle.wdp.myself.factory.spring;

import java.io.IOException;
import java.util.Properties;

public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Properties p= new Properties();
		try {
		
			p.load(Test.class.getClassLoader().getResourceAsStream("com/oracle/wdp/myself/factory/spring/spring.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String vehicleTypename = p.getProperty("VehicleType");
		Object o = Class.forName(vehicleTypename).newInstance();
		Moveable m=(Moveable)o;
		m.run();
	}

}
