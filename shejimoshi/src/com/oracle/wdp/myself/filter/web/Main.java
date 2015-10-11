package com.oracle.wdp.myself.filter.web;

public class Main {
	public static void main(String[] args) {
		String msg = "大家好，:)明高，<script> ,被就业";
		Request request = new Request();
		request.setRequestStr(msg);
		Response response = new Response();
		response.setResponseStr("response");
		FilterChain fc = new FilterChain();
		fc.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter());
		fc.doFilter(request, response, fc);
		System.out.println(request.getRequestStr());
		
		System.out.println(response.getResponseStr());

	}
}
