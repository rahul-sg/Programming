package Packages.rsengupta.Library;

import Packages.rsengupta.Library.Library;
import Packages.rsengupta.Library.Book;
import Packages.rsengupta.Library.CD;
import Packages.rsengupta.Library.LibraryModelMongo;

import com.mongodb.client.MongoDatabase;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteResult;

import java.util.*;

public class User {
	protected String name;
	protected String DOB;
	protected String email;
	protected String userName;

	Scanner sc = new Scanner(System.in);
	public Book[] checkOutBook = new Book[100];
	public CD[] checkOutCD = new CD[30];
	int checkBookI = 0;
	int checkCDI = 0;
	Library lib;

	public User(String name, String DOB, String email, String userName, Library lib) {
		this.name = name;
		this.DOB = DOB;
		this.email = email;
		this.userName = userName;
		this.lib = lib;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String DOB) {
		this.DOB = DOB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void checkOut(LibraryModelMongo db) {
		System.out.println("1: Book");
		System.out.println("2: CD");
		System.out.print("Your Choice: ");
		int checkChoice = Integer.parseInt(sc.nextLine());
		switch (checkChoice) {
		case 1:
			System.out.print("What book would you like to check out? ");
			String bChoice = sc.nextLine();
			Book b = lib.searchBook(bChoice);
			String title = lib.searchBook(bChoice).getTitle();
			int c = b.getCount();
			b.setCount(c - 1);
			checkOutBook[checkBookI] = b;
			lib.books.put(bChoice, b);

			db.update_book(title);
			checkBookI++;
			break;
		case 2:
			System.out.print("What CD would you like to check out? ");
			String cChoice = sc.nextLine();
			CD cdc = lib.cds.get(cChoice);
			String title1 = lib.searchCD(cChoice).getTitle();
			int cc = cdc.getCount();
			cdc.setCount(cc - 1);
			checkOutCD[checkCDI] = cdc;
			lib.cds.put(cChoice, cdc);
			db.update_cd(title1);
			checkCDI++;
			break;
		default:
			System.out.println("Wrong Choice");
			break;
		}
	}

	public void returnItem(LibraryModelMongo db) {
		System.out.println("1: Book");
		System.out.println("2: CD");
		System.out.print("Your Choice: ");
		int retChoice = Integer.parseInt(sc.nextLine());
		switch (retChoice) {
		case 1:
			System.out.print("What book would you like to return? ");
			String ret = sc.nextLine();
			Book retB = lib.books.get(ret);
			String retBT = retB.getTitle();
			int retc = retB.getCount();
			retB.setCount(retc + 1);
			/*for (int i = 0; i < checkOutBook.length; i++) {
				if (ret.equals(checkOutBook[i].getTitle())) {
					checkOutBook[i] = null;
					break;
				}
			}*/

			db.return_book(retBT);
			break;
		case 2:
			System.out.print("What CD would you like to return? ");
			String ret1 = sc.nextLine();
			CD retCD = lib.cds.get(ret1);
			String retCDT = lib.cds.get(ret1).getTitle();
			int retCDc = retCD.getCount();
			retCD.setCount(retCDc + 1);
			for (int i = 0; i < checkOutCD.length; i++) {
				if (ret1.equals(checkOutCD[i].getTitle())) {
					checkOutCD[i] = null;
					break;
				}
			}
			
			db.return_cd(retCDT);
			break;
		default:
			System.out.println("Wrong Choice");
			break;
		}
	}

	public void userProfile() {
		System.out.println("== User Profile ==");
		System.out.println("Name: " + name);
		System.out.println("Date of Birth: " + DOB);
		System.out.println("Email: " + email);
		System.out.println("User-ID: " + userName);

		System.out.println();
		try {
			System.out.println("Books checked out: " + checkBookI);
			for (Book bk : checkOutBook) {
				System.out.println("Book: " + bk.getTitle());
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println();
			//System.out.println("You have no Books checked out...");
		}
		System.out.println();

		try {
			System.out.println("CDs checked out: " + checkCDI);
			for (CD cds : checkOutCD) {
				System.out.println("CD: " + cds.getTitle());
				System.out.println();
			}
		} catch (Exception f) {
			System.out.println();
			//System.out.println("You have no CDs checked out...");
		}
	}
}
