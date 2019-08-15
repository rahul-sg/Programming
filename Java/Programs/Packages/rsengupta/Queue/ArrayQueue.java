package Packages.rsengupta.Queue;

public class ArrayQueue implements QueueInterface {
	private static final int defaultSize = 10;

	private int maxSize;
	private int front;
	private int rear;
	private Object[] arrayQueue;

	public ArrayQueue() {
		this(defaultSize);
	}

	public ArrayQueue(int size) {
		maxSize = size + 1;
		rear = 0;
		front = 1;
		arrayQueue = (Object[]) new Object[maxSize];
	}

	public void clear() {
		rear = 0;
		front = 1;
	}

	public void enqueue(Object it) {
		assert ((rear + 2) % maxSize) != front : "Queue Overflow Error";
		rear = (rear + 1) % maxSize;
		arrayQueue[rear] = it;
	}

	public Object dequeue() {
		assert length() != 0 : "Queue Underflow Error";
		Object it = arrayQueue[front];
		front = (front + 1) % maxSize;
		return it;
	}

	public Object frontValue() {
		assert length() != 0 : "Queue Underflow Error";
		return arrayQueue[front];
	}

	public int length() {
		return ((rear + maxSize) - front + 1) % maxSize;
	}

	public void printElem() {
		for (int i = 0; i < arrayQueue.length; i++) {
			System.out.println(arrayQueue[i]);
		}
	}
}
