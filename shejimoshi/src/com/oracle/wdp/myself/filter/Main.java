package com.oracle.wdp.myself.filter;

public class Main {
	public static void main(String[] args) {
		String msg = "��Һã�:)���ߣ�<script> ,����ҵ";
		MsgProcessor mp = new MsgProcessor();
		mp.setMsg(msg);
		FilterChain fc = new FilterChain();
		fc.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter());
		mp.setFc(fc);
		String result=mp.process();
		System.out.println(result);

	}
}
