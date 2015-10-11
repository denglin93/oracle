package com.oracle.wdp.myself.iterator;

public class Cat {
	private int id;

	public Cat(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "cat" + id;
	}
}
