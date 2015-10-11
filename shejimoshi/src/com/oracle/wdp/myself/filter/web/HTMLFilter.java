package com.oracle.wdp.myself.filter.web;

public class HTMLFilter implements Filter {

	

	@Override
	public void doFilter(Request request, Response response,FilterChain chain) {
		// TODO Auto-generated method stub
		request.requestStr = request.requestStr.replace('<','[').replace('>',']');
		chain.doFilter(request, response, chain);
		response.responseStr+="HTMLFilter\t";
	}

}
