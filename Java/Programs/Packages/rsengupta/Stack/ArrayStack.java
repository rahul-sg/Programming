package Packages.rsengupta.Stack;
public class ArrayStack implements StackInterface {
	private static final int defaultSize = 10;

	private int maxSize;
	private int top;
	private Object[] listArray;

	public ArrayStack() {
		this(defaultSize);
	}
	@SuppressWarnings("unchecked")
	public ArrayStack(int size) {
		maxSize = size;
		top = 0;
		listArray = (Object[]) new Object[size];
	}

	public void clear() {
		top = 0;
	}

	public void push(Object it) {
		if (top < maxSize) {
			listArray[top++] = it;
		} else {
			throw new NullPointerException();
		}
	}

	public Object pop() {
		if (top > 0) {
			Object it = listArray[top - 1];
			listArray[top - 1] = null;
			top--;
			return it;
		} else {
			throw new NullPointerException();
		}
	}

	public Object topValue() {
		assert top != 0 : "Stack is empty";
		return listArray[top - 1];
	}

	public int length() {
		return top;
	}

	public void printElem() {
		System.out.println("Current stacktop: " + top);
		for (int i = 0; i < listArray.length; i++) {
			System.out.println(listArray[i]);
		}
	}
}

