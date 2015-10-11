package com.oracle.wdp.myself.single;

public class Singleton3 {
	// ����ʽʽ����
	private static Singleton3 singleton;

	public static Singleton3 getSingleton2() {
		if (singleton == null) {
			synchronized (singleton) {
				if (singleton == null) {
					singleton = new Singleton3();
				}
			}

		}
		return singleton;
	}

	private Singleton3() {
	}
}
