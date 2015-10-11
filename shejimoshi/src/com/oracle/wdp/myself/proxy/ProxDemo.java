package com.oracle.wdp.myself.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxDemo implements InvocationHandler {
	private Hw hw ;
	
	
	public ProxDemo(Hw hw) {
		this.hw = hw;
	}


	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
		System.out.println("before");
		Object ret = arg1.invoke(hw, arg2);
		System.out.println("after");
		return ret;
	}

}
