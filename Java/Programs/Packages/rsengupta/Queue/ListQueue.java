package Packages.rsengupta.Queue;
import java.util.*;

public class ListQueue implements QueueInterface {
	LinkedList<Object> lQueue = new LinkedList<Object>();
	int size;

	public ListQueue() {
		init();
	}

	private void init() {
		size = 0;
	}

	public void clear() {
		lQueue.clear();
		size = 0;
	}

	public void enqueue(Object it) {
		lQueue.add(it);
		size++;
	}

	public Object dequeue() {
		if (size > 0) {
			Object it = lQueue.getFirst();
			lQueue.removeFirst();
			size--;
			return it;
		} else {
			throw new NullPointerException();
		}
	}

	public Object frontValue() {
		if (size > 0) {
			return lQueue.get(0);
		} else {
			throw new NullPointerException();
		}
	}

	public int length() {
		return size;
	}

	public void printElem() {
		for (int i = 0; i < lQueue.size(); i++) {
			System.out.println(lQueue.get(i));
		}
	}
}
