package com.oracle.wdp.myself.single;

public class Singleton {
	//����ʽ����
	private static Singleton singleton = new Singleton();
	private Singleton(){
		
	}
	public static Singleton getSingleton(){
		return singleton;
	}
}
