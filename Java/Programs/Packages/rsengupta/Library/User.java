package Packages.rsengupta.Library;

import Packages.rsengupta.Library.Library;
import Packages.rsengupta.Library.Book;
import Packages.rsengupta.Library.CD;
import java.util.*;

public class User {
	protected String name;
	protected String DOB;
	protected String email;
	protected String userName;

	Scanner sc = new Scanner(System.in);
	Book[] checkOutBook = new Book[100];
	CD[] checkOutCD = new CD[30];
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

	public void checkOut() {
		System.out.println("1: Book");
		System.out.println("2: CD");
		System.out.print("Your Choice: ");
		int checkChoice = Integer.parseInt(sc.nextLine());
		switch (checkChoice) {
		case 1:
			System.out.print("What book would you like to check out? ");
			String bChoice = sc.nextLine();
			Book b = lib.searchBook(bChoice);
			int c = b.getCount();
			b.setCount(c - 1);
			checkOutBook[checkBookI] = b;
			lib.books.put(bChoice, b);
			checkBookI++;
			break;
		case 2:
			System.out.print("What CD would you like to check out? ");
			String cChoice = sc.nextLine();
			CD cdc = lib.cds.get(cChoice);
			int cc = cdc.getCount();
			cdc.setCount(cc - 1);
			checkOutCD[checkCDI] = cdc;
			lib.cds.put(cChoice, cdc);
			checkCDI++;
			break;
		default:
			System.out.println("Wrong Choice");
			break;
		}
	}

	public void returnItem() {
		System.out.println("1: Book");
		System.out.println("2: CD");
		System.out.print("Your Choice: ");
		int retChoice = Integer.parseInt(sc.nextLine());
		switch (retChoice) {
		case 1:
			System.out.print("What book would you like to return? ");
			String ret = sc.nextLine();
			Book retB = lib.books.get(ret);
			int retc = retB.getCount();
			retB.setCount(retc + 1);
			for (int i = 0; i < checkOutBook.length; i++) {
				if (ret.equals(checkOutBook[i].getTitle())) {
					checkOutBook[i] = null;
					break;
				}
			}
			break;
		case 2:
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
			System.out.println("You have no Books checked out...");
		}
		System.out.println();

		try {
			System.out.println("CDs checked out: " + checkCDI + 1);
			for (CD cds : checkOutCD) {
				System.out.println("CD: " + cds.getTitle());
				System.out.println();
			}
		} catch (Exception f) {
			System.out.println("You have no CDs checked out...");
		}
	}
}
