import Packages.rsengupta.Library.Book;
import Packages.rsengupta.Library.Library;
import java.util.*;

public class SCCL {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		Library lib = new Library();
		int menuChoice;
		while (true) {
			System.out.println("1: Add Items");
			System.out.println("2: Remove Items");
			System.out.println("3: View Items");
			System.out.println("4: Search Items");
			System.out.println("5: Close Program");
			
			System.out.print("Your Choice: ");
			menuChoice = sc.nextInt();
		
			switch (menuChoice) {
				case 1: 
					lib.addItem();
					break;
				case 2:
					lib.removeItem();
					break;
				case 3:
					lib.viewItems();
					break;
				case 4:
					lib.searchItems();
					break;
				case 5: 
					System.exit(0);
				default: 
					System.out.println("Wrong choice");
					break;
			}
			System.out.println();
		}
	}
}
