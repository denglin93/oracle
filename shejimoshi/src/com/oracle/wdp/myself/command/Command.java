package com.oracle.wdp.myself.command;

/**
 * @author 邓林
 * 
 * 类说明: struts1和2中认为的execute就实现了command命令模式
 * 
 * 在原始的的设计模式中需要实现undo
 */
public abstract class Command {
	public abstract void execute();

	public abstract void unDo();
}
