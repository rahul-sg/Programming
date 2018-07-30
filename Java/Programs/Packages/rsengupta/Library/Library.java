package Packages.rsengupta.Library;

import Packages.rsengupta.Library.Book;
import Packages.rsengupta.Library.CD;
import java.util.*;

public class Library {
	HashMap<String, Integer> books = new HashMap<String, Integer>();
	HashMap<String, Integer> cds = new HashMap<String, Integer>();

	
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
			
				System.out.print("How many books would you liek to add? ");
				count = sc.nextInt();
				System.out.println();
		
				for (int i = 0; i < count; i++) {
					System.out.print("What book would you like to add? ");
					key = sc.nextLine();
					System.out.println();
					System.out.println("How many of this book would you like to add? ");
					value = sc.nextInt();

					books.put(key, value);
				}
				break;
			case 2:
				System.out.print("How many CDs would liek to add? ");
				count = sc.nextInt();

				for (int i = 0; i < count; i++) {
					System.out.println("What CD would you liek to add? ");
					key = sc.nextLine();
					System.out.println();
					System.out.println("How many of this CD would you like to add? ");
					value = sc.nextInt();
					cds.put(key, value);
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
		for (String key : books.keySet()) {
			String value = books.get(key).toString();
				System.out.println("Book: " + key + "	Inventory: " + value);
		}
		for (String key : cds.keySet()) {
			String value = cds.get(key).toString();

			System.out.println("CD: " + key + "	Inventory: " + value);
		}
	}
}
