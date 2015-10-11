package com.oracle.wdp.myself.iterator;
import com.oracle.wdp.myself.iterator.Collection;
public class LinkedList implements Collection{
	Node head = null;
	Node tail = null;
	int size = 0;

	public void add(Object o) {
		Node n = new Node(o, null);
		if (head == null) {
			head = n;
			tail = n;
		}
		tail.setNext(n);
		tail=n;
		size++;
	}

	public int size() {
		return size;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
