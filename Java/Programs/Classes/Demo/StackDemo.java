import java.util.*;
import Packages.rsengupta.Stack.*;

public class StackDemo {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1: List Stack");
		System.out.println("2: Array Stack");
		System.out.println("3: ArrayList Stack");
		int choice = sc.nextInt();
		
		//StackInterface sI;

		if (choice == 1) {
			ListStackDemo lStack;
			lStack = new ListStackDemo();
			//sI = lStack;
			lStack.LStack();
		} else if (choice == 2) {
			ArrayStackDemo aStack;
			aStack = new ArrayStackDemo();
			//sI = aStack;
			aStack.AStack();
		} else if (choice == 3) {
			ArrayListStackDemo aLStack;
			aLStack = new ArrayListStackDemo();
			//sI = aLStack;
			aLStack.ALStack();
		}
	}
}
