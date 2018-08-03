import Packages.rsengupta.Library.Book;
import Packages.rsengupta.Library.CD;
import Packages.rsengupta.Library.Library;
import Packages.rsengupta.Library.User;
import java.util.*;

public class SCCL {
	static Scanner sc = new Scanner(System.in);
	static HashMap<String, User> userMap = new HashMap<String, User>();
	static User user;
	static Library lib;

	public static void main (String args[]) {	
		lib = new Library();
		while (true) {
			mainFunct();
		}
	}

	public static void mainFunct() {
		System.out.println("1: Admin");
		System.out.println("2: Customer");
		System.out.println("3: Close Program");
		System.out.print("Your Choice: ");
		int initC = Integer.parseInt(sc.nextLine());
		switch (initC) {
		case 1:
			while (true) {
				if (admin() == false) {
					break;
				}
			}
			break;
		case 2:
			while (true) {
				if (customer() == false) {
					break;
				}
			}
			break;
		case 3:
			System.exit(0);
		default:
			System.out.println("Wrong Choice");
			break;
		}
	}

	public static boolean admin() {
		int menuChoice;
		System.out.println("1: Add Items");
		System.out.println("2: Remove Items");
		System.out.println("3: View Items");
		System.out.println("4: Search Items");
		System.out.println("5: Log-out");

		System.out.print("Your Choice: ");
		menuChoice = Integer.parseInt(sc.nextLine());

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
			return false;
		default: 
			System.out.println("Wrong choice");
			break;
		}
		System.out.println();
		return true;
	}

	public static boolean custLogIn(String loginID) {
		try {
			String uID = userMap.get(loginID).getUserName();
		} catch (Exception e) {
			System.out.println("User ID doesn't exist");
			return true;
		}
		System.out.println("== " + loginID + " Menu ==");
		System.out.println("1: Search Items");
		System.out.println("2: View Items");
		System.out.println("3: Check-out");
		System.out.println("4: Return");
		System.out.println("5: User Profile");
		System.out.println("6: Logout");
		System.out.print("Your Choice: ");
		int logChoice = Integer.parseInt(sc.nextLine());
		switch (logChoice) {
		case 1:
			lib.searchItems();
			break;
		case 2:
			lib.viewItems();
			break;
		case 3:
			user.checkOut();
			break;
		case 4:
			user.returnItem();
			break;
		case 5:
			user.userProfile();
			break;
		case 6:
			return false;
		default:
			System.out.println("Wrong Choice");
			break;
		}
		return true;
	}
	
	public static void custRegister() {
		System.out.println("Welcome to Register");
		System.out.println("Enter the following information to create your SCCL account...");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Date of birth: ");
		String DOB = sc.nextLine();
		System.out.print("Email Address: ");
		String email = sc.nextLine();
		System.out.print("Custom User-ID: ");
		String userName = sc.nextLine();

		user = new User(name, DOB, email, userName, lib);
		userMap.put(userName, user);
		System.out.println("Thank you for Registering with SCCL");
	}

	public static boolean customer() {
		System.out.println("== Customer Menu ==");
		System.out.println("1: Log-in");
		System.out.println("2: Register");
		System.out.println("3: Back to Main Menu");
		System.out.print("Your Choice: ");
		int custChoice = Integer.parseInt(sc.nextLine());

		switch (custChoice) {
		case 1:
			System.out.print("Enter username: ");
			String loginID = sc.nextLine();
			while (true) {
				if (custLogIn(loginID) == false) {
					break;
				}
			}
			break;
		case 2:
			custRegister();
			break;
		case 3:
			return false;
		default: 
			System.out.println("Wrong Choice");
			break;
		}
		return true;
	}

}
