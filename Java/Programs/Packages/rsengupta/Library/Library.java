package Packages.rsengupta.Library;

import Packages.rsengupta.Library.Book;
import Packages.rsengupta.Library.CD;
import Packages.rsengupta.Library.LibraryModelMongo;
import Packages.rsengupta.Library.User;
import java.util.*;

public class Library {
	public HashMap<String, Book> books;
	public HashMap<String, CD> cds;
	public LibraryModelMongo db;

	Scanner sc = new Scanner(System.in);
	String key;
	int value;
	String menuChoice;
	int count;

	public Library(HashMap<String, User> userMap) {
		books = new HashMap<String, Book>();
		cds = new HashMap<String, CD>();
		db = new LibraryModelMongo(userMap, books, cds);
	}
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
					System.out.println();

					System.out.print("Title: ");
					String title = sc.nextLine();
					key = title;
					System.out.print("Author: ");
					String author = sc.nextLine();
					System.out.print("ISBN #: ");
					String isbn = sc.nextLine();
					System.out.print("Description: ");
					String des = sc.nextLine();
					System.out.print("Publisher: ");
					String pu = sc.nextLine();
					System.out.print("Price: ");
					double pr = Double.parseDouble(sc.nextLine());
					System.out.print("How many of this book would you like to add? ");
					value = Integer.parseInt(sc.nextLine());


					Book newBook = new Book(title, author, isbn, des, 0, pu, pr, value);

					books.put(key, newBook);
					db.write_book(title, author, des, isbn, 0, pu, pr, value);

				}
				break;
			case 2:
				System.out.print("How many CDs would like to add? ");
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
					System.out.print("Artist: ");
					String ar = sc.nextLine();

					System.out.print("How many of this CD would you like to add? ");
					value = Integer.parseInt(sc.nextLine());

					CD newCD = new CD(title, author, isbn, des, 0, true, ar, value);
					cds.put(key, newCD);
					db.write_cd(title, author, isbn, des, 0, true, ar, value);
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
				System.out.print("What would you like to remove? ");
				search = sc.nextLine();
				
				books.remove(search);
				break;
			case 2:
				System.out.print("What would you like to remove? ");
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
			System.out.println("CD: " + cdKey.getTitle());
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

	public void searchItems() {
		System.out.print("Would you like to search for a Book {1} or CD {2}? ");
		int menuChoice = Integer.parseInt(sc.nextLine());
		switch (menuChoice) {
			case 1:
				try {
					System.out.print("What book would you like to search for? ");
					String search = sc.nextLine();

					String ti = books.get(search).getTitle();
					System.out.println("Book: " + ti);
					String au = books.get(search).getAuthor();
					System.out.println("Author: " + au);
					String is = books.get(search).getIsbn();
					System.out.println("ISBN #: " + is);
					String de = books.get(search).getDescription();
					System.out.println("Description: " + de);
					int bo = books.get(search).getBorrowTime();
					System.out.println("Borrow-Time: " + bo);
					String pub = books.get(search).getPublisher();
					System.out.println("Publisher: " + pub);
					double pri = books.get(search).getPrice();
					System.out.println("MSRP: " + pri);
					int inv = books.get(search).getCount();
					System.out.println("Inventory: " + inv);

				} catch (Exception e) {
					System.out.println("The book you are searching for doesn't exist...");
				}
				break;
			case 2:
				try {
					System.out.print("What CD would you like to search for? ");
					String search1 = sc.nextLine();

					String bk = cds.get(search1).getTitle();
					System.out.println("Title: " + bk);
					String at = cds.get(search1).getAuthor();
					System.out.println("Author: " + at);
					String in = cds.get(search1).getIsbn();
					System.out.println("ISBN: " + in);
					String dc = cds.get(search1).getDescription();
					System.out.println("Description: " + dc);
					int br = cds.get(search1).getBorrowTime();
					System.out.println("Borrow-Time: " + br);
					boolean bu = cds.get(search1).getBluray();
					System.out.println("Bluray: " + bu);
					String art = cds.get(search1).getArtist();
					System.out.println("Artist: " + art);
					int inve = cds.get(search1).getCount();
					System.out.println("Inventory: " + inve);
				} catch (Exception e) {
					System.out.println("The CD you are searching for doesn't exist...");
				}
				break;
			default:
				System.out.println("Wrong Choice");
				break;
		}
	}

	public Book searchBook(String input) {
		return books.get(input);
	}

	public CD searchCD(String input) {
		return cds.get(input);
	}

	public void updateItems() {
		System.out.print("Would you like to update a Book {1} or CD {2}? ");
		int menuChoice = Integer.parseInt(sc.nextLine());

		switch (menuChoice) {
			case 1:
				System.out.print("What book would you like to update? ");
				String search = sc.nextLine();

				if (search.equals(books.get(search).getTitle())) {
					System.out.println("What field would you like to update? ");
					System.out.println("{1}: Author (" + books.get(search).getAuthor() + ")");
					System.out.println("{2}: ISBN (" + books.get(search).getIsbn() + ")");
					System.out.println("{3}: Description (" + books.get(search).getDescription() + ")");
					System.out.println("{4}: Count (" + books.get(search).getCount() + ")");
					System.out.println("{5}: Publisher (" + books.get(search).getPublisher() + ")");
					System.out.println("{6}: MSRP (" + books.get(search).getPrice() + ")");
					System.out.println();
					System.out.print("Your choice: ");
					int choice = Integer.parseInt(sc.nextLine());
					Book upBook = books.get(search);
					switch (choice) {
						case 1:
							System.out.println("New Author: ");
							upBook.setAuthor(sc.nextLine());

							break;
						case 2:
							System.out.print("New ISBN#: ");
							upBook.setIsbn(sc.nextLine());
							break;
						case 3:
							System.out.print("New Description: ");
							upBook.setDescription(sc.nextLine());
							break;
						case 4:
							System.out.print("New Inventory: ");
							upBook.setCount(Integer.parseInt(sc.nextLine()));
							break;
						case 5:
							System.out.print("New Publisher: ");
							upBook.setPublisher(sc.nextLine());
							break;
						case 6:
							System.out.print("New Price: ");
							upBook.setPrice(Double.parseDouble(sc.nextLine()));
							break;
						default:
							System.out.println("Wrong Choice");
							break;
					}
					books.put(search, upBook);
				}

				break;
			case 2:
				System.out.print("What CD would you like to update? ");
				String search2 = sc.nextLine();

				if (search2.equals(cds.get(search2).getTitle())) {
					System.out.println("What field would you like to update? ");
					System.out.println("{1}: Author (" + cds.get(search2).getAuthor() + ")");
					System.out.println("{2}: ISBN (" + cds.get(search2).getIsbn() + ")");
					System.out.println("{3}: Description (" + cds.get(search2).getDescription() + ")");
					System.out.println("{4}: Count (" + cds.get(search2).getCount() + ")");
					System.out.println("{5}: Artist (" + cds.get(search2).getArtist() + ")");
					System.out.println();
					System.out.print("Your choice: ");
					int choice2 = Integer.parseInt(sc.nextLine());
					CD upCd = cds.get(search2);
					switch (choice2) {
						case 1:
							System.out.println("New Author: ");                                             
							upCd.setAuthor(sc.nextLine());
                                                        break;
						case 2: 
							System.out.print("New ISBN#: ");                                                
							upCd.setIsbn(sc.nextLine());                                                  
							break;
						case 3:
							System.out.print("New Description: ");
							upCd.setDescription(sc.nextLine());
							break;
						case 4:
							System.out.print("New Inventory: ");
							upCd.setCount(Integer.parseInt(sc.nextLine()));
							break;
						case 5:
							System.out.print("New Artist: ");
							upCd.setArtist(sc.nextLine());
							break;
						default:
							System.out.println("Wrong Choice");
							break;
					}
					cds.put(search2, upCd);
				}

				break;

			default:
				System.out.println("Wrong Choice");
				break;
		}
	}
}
