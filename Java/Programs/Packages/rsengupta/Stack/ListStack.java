package Packages.rsengupta.Stack;
import java.util.*;

public class ListStack implements StackInterface {
	private LinkedList<E> top;
	private int size;

	public ListStack() {
		top = null;
		size = 0;
	}

	public ListStack(int size) {
		top = null;
		size = 0;
	}

	public void clear() {
		top = null;
		size = 0;
	}

	public void push(E it) {
		top = new LinkedList<E>(it, top);
		size++;
	}

	public E pop() {
		assert top != null : "Stack is empty";
		E it = top.element();
		top = top.next();
		size--;
		return it;
	}

	public E topValue() {
		assert top != null : "Stack is empty";
		return top.element();
	}

	public int length() {
		return size;
	}
}

