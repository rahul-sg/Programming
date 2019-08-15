import java.util.*;
import Packages.rsengupta.Queue.*;

public class QueueDemo {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		QueueInterface qI;
		
		System.out.println("1: List Queue");
		System.out.println("2: Array Queue");
		int choice = sc.nextInt();
		Scanner s = new Scanner(System.in);
		if (choice == 1) {
			ListQueue lQueue = new Packages.rsengupta.Queue.ListQueue();
			qI = lQueue;
			while(true) {
				System.out.println("0 for enqueue, 1 for dequeue: ");
				int inp = s.nextInt();
				if (inp == 0) {
					Scanner c = new Scanner(System.in);
					System.out.println("Enter Object to enqueue: ");
					Object it = c.nextLine();
					qI.enqueue(it);
				} else if (inp == 1) {
					try {
						qI.dequeue();
					} catch (NullPointerException e) {
						System.out.println("Queue Underflow Error");
					}
				}
				System.out.println("-------------");
				qI.printElem();
				System.out.println("-------------");
			}
		} else if (choice == 2) {
			Scanner a = new Scanner(System.in);
			System.out.println("Enter size of Queue: ");
			int size = a.nextInt();
			ArrayQueue aQueue = new Packages.rsengupta.Queue.ArrayQueue(size);
			qI = aQueue;
			while(true) {
				System.out.println("0 for enqueue, 1 for dequeue: ");
				Scanner b = new Scanner(System.in);
				int ch = b.nextInt();
				if (ch == 0) {
					Scanner d = new Scanner(System.in);
					System.out.println("Enter Object to enqueue: ");
					Object it = d.nextLine();
					qI.enqueue(it);
				} else if (ch == 1) {
					qI.dequeue();
			
				}
				System.out.println("-------------");
				qI.printElem();
				System.out.println("-------------");
			}
		}
	}
}
