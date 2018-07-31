package Packages.rsengupta.Library;

import Packages.rsengupta.Library.Book;
import Packages.rsengupta.Library.CD;
import java.util.*;

public class Library {
	HashMap<String, Book> books = new HashMap<String, Book>();
	HashMap<String, CD> cds = new HashMap<String, CD>();

	
	Scanner sc = new Scanner(System.in);
	String key;
	int value;
	int menuChoice;
	int count;

	public void addItem() {
		System.out.print("Would you like to add Books or CDs (1 = book) (2 = CD) ");
		menuChoice = sc.nextInt();
		switch (menuChoice) {
			case 1:
			
				System.out.print("How many books would you like to add? ");
				count = sc.nextInt();
				System.out.println();
		
				String title;
				String author;
				String isbn;
				String des;
				String bt;
				String pu;
				String pr;

				for (int i = 0; i < count; i++) {
					System.out.print("What book would you like to add? ");
					key = sc.nextLine();
					System.out.println();

					System.out.print("Title: ");
					title = sc.nextLine();
					System.out.print("Author: ");
					author = sc.nextLine();
					System.out.print("ISBN #: ");
					isbn = sc.nextLine();
					System.out.print("Description: ");
					des = sc.nextLine();
					System.out.print("Borrow Time: ");
					bt = sc.nextLine();
					System.out.println("Publisher: ");
					pu = sc.nextLine();
					System.out.println("Price: ");
					pr = sc.nextInt();
					System.out.println("How many of this book would you like to add? ");
					value = sc.nextInt();


					Book newBook = new Book(title, author, isbn, des, bt, value);

					books.put(key, newBook);
				}
				break;
			case 2:
				System.out.print("How many CDs would like to add? ");
				count = sc.nextInt();
				
				String title;
				String author;
				String isbn;
				String des;
				String bt;
				boolean bl;
				String ar;

				for (int i = 0; i < count; i++) {
					System.out.println("What CD would you liek to add? ");
					key = sc.nextLine();
					System.out.println();
					
					System.out.println("Title: ");
					title = sc.nextLine();
					System.out.println("Author: ");
					author = sc.nextLine();
					System.out.println("ISBN #: ");
					isbn = sc.nextLine();
					System.out.println("Description: ");
					des = sc.nextLine();
					System.out.println("Borrow Time: ");
					bt = sc.nextInt();
					System.out.println("Artist: ");
					ar = sc.nextLine();

					System.out.println("How many of this CD would you like to add? ");
					value = sc.nextInt();

					CD newCD = new CD(title, author, isbn, des, bt, true, ar, value);
					cds.put(key, newCD);
				}
				break;

			default:
				System.out.println("Wrong choice");
				break;
		}
	}

	public void removeItem() {
		System.out.print("Would you like to remove Books or CDs (1 = Books) (2 = CD)? ");
		menuChoice = sc.nextInt();

		String search;
		switch (menuChoice) {
			case 1:
				System.out.println("What would you like to remove? ");
				search = sc.next();
				
				for (String searchKey : books.keySet()) {
					if (search == searchKey) {
						books.remove();
					}
				}
				break;
			case 2:
				System.out.println("What would you like to remove? ");
				search = sc.next();

				for (String searchKey : cds.keySet()) {
					if (search == searchKey) {
						cds.remove();
					}
				}
				break;
			default:
				System.out.println("Wrong Choice");
				break;
		}
	}

	public void viewItems() {
	
	}
}
