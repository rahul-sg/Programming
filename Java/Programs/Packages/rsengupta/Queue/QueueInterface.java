package Packages.rsengupta.Queue;

public interface QueueInterface {
	public void clear();
	public void enqueue(Object it);
	public Object dequeue();
	public Object frontValue();
	public int length();
	public void printElem();
}
