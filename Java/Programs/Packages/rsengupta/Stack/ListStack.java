package Packages.rsengupta.Stack;
import java.util.*;

public class ListStack implements StackInterface {
	private LinkedList<Object> top;
	private int size;

	public ListStack() {
		top = new LinkedList<Object>();
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
			Object it = top.getLast();
			top.removeLast();
			size--;
			return it;
		} else {
			throw new NullPointerException();
		}
	}

	public Object topValue() {
		assert top != null : "Stack is empty";
		return top.element();
	}

	public int length() {
		return size;
	}

	public void printElem() {
		for (int i = 0; i < top.size(); i++) {
			System.out.println(top.get(i));
		}
	}
}

