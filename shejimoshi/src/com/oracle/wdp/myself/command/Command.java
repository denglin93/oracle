package com.oracle.wdp.myself.command;

/**
 * @author ����
 * 
 * ��˵��: struts1��2����Ϊ��execute��ʵ����command����ģʽ
 * 
 * ��ԭʼ�ĵ����ģʽ����Ҫʵ��undo
 */
public abstract class Command {
	public abstract void execute();

	public abstract void unDo();
}
