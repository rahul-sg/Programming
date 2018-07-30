import Packages.rsengupta.Library.Book;
import Packages.rsengupta.Library.Library;
import java.util.*;

public class SCCL {
	public static void main (String args[]) {
		Book bookDemo = new Book("Harry Potter and the Sorcerer's Stone", "J. K. Rowling", "978-0439708180", "Harry Potter has no idea how famous he is. That's because he's being raised by his miserable aunt and uncle who are terrified Harry will learn that he's really a wizard, just as his parents were. But everything changes when Harry is summoned to attend an infamous school for wizards, and he begins to discover some clues about his illustrious birthright. From the surprising way he is greeted by a lovable giant, to the unique curriculum and colorful faculty at his unusual school, Harry finds himself drawn deep inside a mystical world he never knew existed and closer to his own noble destiny.", 21, "Scholastic Corporation", 29.99);

		System.out.println("Book: " + bookDemo.getTitle());
		System.out.println("Author: " + bookDemo.getAuthor());
		System.out.println("ISBN: " + bookDemo.getIsbn());
		System.out.println("Description: " + bookDemo.getDescription());
		System.out.println("Borrow Tenure: " + bookDemo.getBorrowTime() + " Days");
		System.out.println("Publisher: " + bookDemo.getPublisher());
		System.out.println("Price: $" + bookDemo.getCost());

		Scanner sc = new Scanner(System.in);
		Library lib = new Library();
		int menuChoice;
		while (true) {
			System.out.println("1: Add book");
			System.out.println("2: Remove book");
			System.out.println("3: View books");
			System.out.println("4: Close Program");
	
			System.out.print("Your Choice: ");
			menuChoice = sc.nextInt();
		
			switch (menuChoice) {
				case 1: 
					lib.addBook();
					break;
				case 2:
					lib.removeBook();
					break;
				case 3:
					lib.viewBooks();
					break;
				case 4: 
					System.exit(0);
				default: 
					System.out.println("Wrong choice");
					break;
			}
			System.out.println();
		}
	}
}
