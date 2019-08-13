import java.util.*;
import Packages.rsengupta.Stack.*;

public class ArrayListStackDemo {
	public static void main (String args[]) {
		ArrayListStack aStack;
		aStack = new Packages.rsengupta.Stack.ArrayListStack();

		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter 0 for push, Enter 1 for pop: ");
			int inp = input.nextInt();
			if (inp == 0) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter Object to add to stack: ");
				Object obj = sc.nextLine();
				aStack.push(obj);
				System.out.println("-----------------");
				aStack.printElem();
				System.out.println("-----------------");
			} else if (inp == 1) {
				try {
					aStack.pop();
				} catch (NullPointerException e) {
					System.out.println("Stack Underflow Error");
				}
				System.out.println("-----------------");
				aStack.printElem();
				System.out.println("-----------------");
			}
		}
	}

}
