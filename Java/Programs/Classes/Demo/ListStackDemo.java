import java.util.*;
import Packages.rsengupta.Stack.*;

public class ListStackDemo {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
		ListStack lStack;
		lStack = new Packages.rsengupta.Stack.ListStack();

		while (true) {
			System.out.println("Enter 0 for push, Enter 1 for pop: ");
			int inp = sc.nextInt();
			if (inp == 0) {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter Object to add to stack: ");
				Object obj = input.nextLine();
				try {
					lStack.push(obj);
				} catch (NullPointerException e) {
					System.out.println("Stack Overflow Error");
				}
				System.out.println("-----------------");
				lStack.printElem();
				System.out.println("-----------------");
			} else if (inp == 1) {
				try {
					lStack.pop();
				} catch (NullPointerException e) {
					System.out.println("Stack Underflow Error");
				}
				System.out.println("-----------------");
				lStack.printElem();
				System.out.println("-----------------");
			}
		}
	}

}
