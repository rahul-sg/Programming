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
		
				for (int i = 0; i < count; i++) {
					System.out.print("What book would you like to add? ");
					key = sc.nextLine();
					System.out.println();

					System.out.print("Title: ");
					String title = sc.nextLine();
					System.out.print("Author: ");
					String author = sc.nextLine();
					System.out.print("ISBN #: ");
					String isbn = sc.nextLine();
					System.out.print("Description: ");
					String des = sc.nextLine();
					System.out.print("Borrow Time: ");
					int bt = sc.nextInt();
					System.out.println("Publisher: ");
					String pu = sc.nextLine();
					System.out.println("Price: ");
					double pr = sc.nextDouble();
					System.out.println("How many of this book would you like to add? ");
					value = sc.nextInt();


					Book newBook = new Book(title, author, isbn, des, bt, pu, pr, value);

					books.put(key, newBook);
				}
				break;
			case 2:
				System.out.print("How many CDs would like to add? ");
				count = sc.nextInt();
				
				for (int i = 0; i < count; i++) {
					System.out.println("What CD would you liek to add? ");
					key = sc.nextLine();
					System.out.println();
					
					System.out.println("Title: ");
					String title = sc.nextLine();
					System.out.println("Author: ");
					String author = sc.nextLine();
					System.out.println("ISBN #: ");
					String isbn = sc.nextLine();
					System.out.println("Description: ");
					String des = sc.nextLine();
					System.out.println("Borrow Time: ");
					int bt = sc.nextInt();
					System.out.println("Artist: ");
					String ar = sc.nextLine();

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
				search = sc.nextLine();
				
				for (String searchKey : books.keySet()) {
					if (search == searchKey) {
						books.remove(searchKey);
					}
				}
				break;
			case 2:
				System.out.println("What would you like to remove? ");
				search = sc.nextLine();

				for (String searchKey : cds.keySet()) {
					if (search == searchKey) {
						cds.remove(searchKey);
					}
				}
				break;
			default:
				System.out.println("Wrong Choice");
				break;
		}
	}

	public void viewItems() {
		for (Book bKey : books.values()) {
			System.out.println("Book: " + bKey.getTitle());
			System.out.println("Author: " + bKey.getAuthor());
			System.out.println("ISBN: " + bKey.getIsbn());
			System.out.println("Description: " + bKey.getDescription());
			System.out.println("Borrow-Time: " + bKey.getBorrowTime());
			System.out.println("Publisher: " + bKey.getPublisher());
			System.out.println("MSRP: " + bKey.getPrice());
			System.out.println("Inventory: " + bKey.getCount());
		}

		for (CD cdKey : cds.values()) {
			System.out.println("Book: " + cdKey.getTitle());
			System.out.println("Author: " + cdKey.getAuthor());
			System.out.println("ISBN: " + cdKey.getIsbn());
			System.out.println("Description: " + cdKey.getDescription());
			System.out.println("Borrow-Time: " + cdKey.getBorrowTime());
			System.out.println("Bluray: " + cdKey.getBluray());
			System.out.println("Artist: " + cdKey.getArtist());
			System.out.println("Inventory: " + cdKey.getCount());
		}

	}
}
