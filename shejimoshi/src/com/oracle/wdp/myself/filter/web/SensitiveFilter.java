package com.oracle.wdp.myself.filter.web;

public class SensitiveFilter implements Filter {

	

	@Override
	public void doFilter(Request request, Response response,FilterChain chain) {
		// TODO Auto-generated method stub
		request.requestStr= request.requestStr.replace("±»¾ÍÒµ", "***");
		chain.doFilter(request, response, chain);
		response.responseStr+="SensitiveFilter\t";
	}
	

}
