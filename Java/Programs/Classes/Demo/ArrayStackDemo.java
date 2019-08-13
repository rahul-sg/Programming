import java.util.*;
import Packages.rsengupta.Stack.*;

public class ArrayStackDemo {
	public void AStack () {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of Array Stack: ");

		int size = sc.nextInt();

		ArrayStack aStack;
		aStack = new Packages.rsengupta.Stack.ArrayStack(size);

		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter 0 for push, Enter 1 for pop: ");
			int inp = input.nextInt();
			if (inp == 0) {
				Scanner s = new Scanner(System.in);
				System.out.println("Enter Object to add to stack: ");
				Object obj = s.nextLine();
				try {
					aStack.push(obj);
				} catch (NullPointerException e) {
					System.out.println("Stack Overflow Error");
				}
				System.out.println("-----------------");
				aStack.printElem();
				System.out.println("-----------------");
			} else if (inp == 1) {
				try {
					aStack.pop();
				} catch (NullPointerException exc) {
					System.out.println("Stack Underflow Error");
				}
				System.out.println("-----------------");
				aStack.printElem();
				System.out.println("-----------------");
			}
		}

		
	}

}
