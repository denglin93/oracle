package com.oracle.wdp.myself.command;

public class MM {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void order(Boy b){
	Command c = new ShoppingCommand();
	b.addCommand(c);
	c= new HugCommand();
	b.addCommand(c);
	b.executeCommand();
	}
	
}
