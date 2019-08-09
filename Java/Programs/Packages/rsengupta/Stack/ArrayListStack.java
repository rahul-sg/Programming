package Packages.rsengupta.Stack;
import java.util.*;

public class ArrayListStack implements StackInterface {
	private ArrayList<Object> top;
	private int size;

	public ArrayListStack() {
		top = new ArrayList<Object>();
		size = 0;
	}

	public ArrayListStack(int size) {
		top = new ArrayList<Object>();
		size = 0;
	}

	public void clear() {
		top = null;
		size = 0;
	}

	public void push(Object it) {
		top.add(it);
		size++;
	}

	public Object pop() {
		if (size > 0) {
			size--;
			return top.remove(top.size() - 1);
		} else {
			throw new NullPointerException("Stack index less than 0");
		}
	}

	public Object topValue() {
		if (size > 0) {
			return top.get(top.size() - 1);
		} else {
			throw new NullPointerException();
		}
	}

	public int length() {
		return top.size();
	}


	public void printElem() {
		for (int i = 0; i < top.size(); i++) {
			System.out.println(top.get(i));
		}
	}

}

