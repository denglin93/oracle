package com.oracle.wdp.myself.factory;

/**
 * @author ����
 * 
 * �����˲���������߼��������Գ�֮Ϊ������صķ���
 * ��̬�Ĺ���ģʽ��ͨ����̬������ã� 
 */
public class Car implements Moveable{
	private static Car car = new Car();

	

	// getInstance��̬��������
	public static Car getInstance() {
		return car;
	}

	@Override
	public void run() {
		System.out.println("�����ܵ�car");
	}

	
}
