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
	String menuChoice;
	int count;

	public void addItem() {
		System.out.print("Would you like to add Books or CDs (1 = book) (2 = CD)? ");
		menuChoice = sc.nextLine();
		int choice = Integer.parseInt(menuChoice);
		switch (choice) {
			case 1:
			
				System.out.print("How many books would you like to add? ");
				count = Integer.parseInt(sc.nextLine());
				System.out.println();
		
				for (int i = 0; i < count; i++) {
					System.out.print("What book would you like to add? ");
					key = sc.nextLine();

					System.out.print("Title: ");
					String title = sc.nextLine();
					System.out.print("Author: ");
					String author = sc.nextLine();
					System.out.print("ISBN #: ");
					String isbn = sc.nextLine();
					System.out.print("Description: ");
					String des = sc.nextLine();
					/*System.out.print("Borrow Time: ");
					int bt = sc.nextInt();*/
					System.out.print("Publisher: ");
					String pu = sc.nextLine();
					System.out.print("Price: ");
					double pr = Double.parseDouble(sc.nextLine());
					System.out.print("How many of this book would you like to add? ");
					value = Integer.parseInt(sc.nextLine());


					Book newBook = new Book(title, author, isbn, des, 0, pu, pr, value);

					books.put(key, newBook);
				}
				break;
			case 2:
				System.out.print("How many CDs would like to add? ");
				//count = sc.nextInt();
				count = Integer.parseInt(sc.nextLine());
				
				for (int i = 0; i < count; i++) {
					System.out.println("What CD would you liek to add? ");
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
					/*System.out.println("Borrow Time: ");
					int bt = sc.nextInt();*/
					System.out.print("Artist: ");
					String ar = sc.nextLine();

					System.out.print("How many of this CD would you like to add? ");
					value = Integer.parseInt(sc.nextLine());

					CD newCD = new CD(title, author, isbn, des, 0, true, ar, value);
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
		
		String search;
		menuChoice = sc.nextLine();
		int choice = Integer.parseInt(menuChoice);
		switch (choice) {
			case 1:
				System.out.println("What would you like to remove? ");
				search = sc.nextLine();
				
				books.remove(search);
				break;
			case 2:
				System.out.println("What would you like to remove? ");
				search = sc.nextLine();

				cds.remove(search);
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

			System.out.println();
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
			System.out.println();
		}
	}
}
