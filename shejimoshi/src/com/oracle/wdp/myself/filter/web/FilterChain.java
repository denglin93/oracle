package com.oracle.wdp.myself.filter.web;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter{
	List<Filter> filters = new ArrayList<Filter>();
	int index =0;
	public FilterChain addFilter(Filter f){
		this.filters.add(f);
		return this;
	}
	
	@Override
	public void doFilter(Request request, Response response,FilterChain chain) {
		// TODO Auto-generated method stub
		if(index==filters.size())return;
		Filter f = filters.get(index);
		index++;
		f.doFilter(request, response, chain);
	}
}
