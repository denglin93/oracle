package com.oracle.wdp.myself.filter;

public class SensitiveFilter implements Filter {

	@Override
	public String doFilter(String str) {
		String r= str.replace("����ҵ", "***");
		return r;
	}

}
