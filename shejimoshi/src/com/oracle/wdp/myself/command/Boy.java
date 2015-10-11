package com.oracle.wdp.myself.command;

import java.util.ArrayList;
import java.util.List;

public class Boy {
	private String name;
	private List<Command> commands=new ArrayList<Command>(); 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void doSomeThing() {
		// TODO Auto-generated method stub
		
	}

	public void addCommand(Command c) {
		// TODO Auto-generated method stub
		this.commands.add(c);
	}

	public void executeCommand() {
		// TODO Auto-generated method stub
		for(Command c:commands){
			c.execute();
		}
	}
	public void undoCommands(){
		//已经执行了的command
	}
	
}
