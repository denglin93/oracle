package com.oracle.wdp.myself.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Pro {

	public static void main(String[] args) {
		Hw real = new HwReal();
		InvocationHandler h = new ProxDemo(real);
		Hw prox = (Hw) Proxy.newProxyInstance(Pro.class.getClassLoader(),
				new Class[] { Hw.class }, h);
		prox.test1();
		prox.test2();
	}

}
