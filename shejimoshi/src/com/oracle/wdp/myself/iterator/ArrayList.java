package com.oracle.wdp.myself.iterator;
import com.oracle.wdp.myself.iterator.Collection;
public class ArrayList implements Collection{
	Object[] objects = new Object[10];
	int index = 0;

	public void add(Object o) {
		if (index == objects.length) {
			Object[] newObjects = new Object[objects.length * 2];
			System.arraycopy(objects, 0, newObjects, 0, objects.length);
			objects = newObjects;
		}
		objects[index] = o;
		index++;

	}
	public int size(){
		return index;	
	}
	public Iterator iterator(){
		return new ArrayListIterator();
	}
	private class ArrayListIterator implements Iterator{
		private int currentIndex=0;
		@Override
		public Object next() {
			// TODO Auto-generated method stub
			Object o= objects[currentIndex];
			currentIndex ++;
			return o;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(currentIndex>=index)
			return false;
			else return true;
		}
		
	}
}
