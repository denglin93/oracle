package com.oracle.wdp.myself.filter.web;

public interface Filter {
	void doFilter(Request request,Response response,FilterChain fc);

}
