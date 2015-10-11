package com.oracle.wdp.myself.single;

public class Singleton2 {
	//¶öººÊ½Ê½µ¥Àý
	private static Singleton2 singleton;
	
	public static synchronized Singleton2 getSingleton2(){
		if(singleton==null){
			singleton =  new Singleton2();
		}
		return singleton;
	}
	private Singleton2(){
	}
}
