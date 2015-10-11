package com.oracle.wdp.myself.iterator;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList list=new ArrayList();
		Collection list = new ArrayList();
		
		for(int i=0;i<15;i++){
			list.add(new Cat(i));
		}
		 
		System.out.println(list.size());
		Iterator it=list.iterator();
		while(it.hasNext()){
			Object o =it.next();
			System.out.println(o+" ");
		}
		
	
	}

}
