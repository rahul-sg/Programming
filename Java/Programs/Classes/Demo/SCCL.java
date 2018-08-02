import Packages.rsengupta.Library.Book;
import Packages.rsengupta.Library.CD;
import Packages.rsengupta.Library.Library;
import Packages.rsengupta.Library.User;
import java.util.*;

public class SCCL {
	static Scanner sc = new Scanner(System.in);
	static HashMap<String, User> userMap = new HashMap<String, User>();
	static User user;

	public static void main (String args[]) {	
		mainFunct();
	}

	public static void mainFunct() {
		System.out.println("1: Admin");
		System.out.println("2: Customer");
		System.out.print("Your Choice: ");
		int initC = Integer.parseInt(sc.nextLine());
		switch (initC) {
		case 1:
			admin();
		case 2:
			customer();
			break;
		default:
			System.out.println("Wrong Choice");
			break;
		}
	}

	public static void admin() {
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

	public static void custLogIn() {
		Library lib1 = new Library();
		System.out.print("Enter Username: ");
		String loginID = sc.nextLine();
		try {
			String uID = userMap.get(loginID).getUserName();
			System.out.println("1: Search Items");
			System.out.println("2: View Items");
			System.out.println("3: Check-out");
			System.out.println("4: Return");
			System.out.println("5: Logout");
			System.out.print("Your Choice: ");
			int logChoice = Integer.parseInt(sc.nextLine());
			switch (logChoice) {
			case 1:
				lib1.searchItems();
				break;
			case 2:
				lib1.viewItems();
				break;
			case 3:
				user.checkOut();
				break;
			case 4:
				user.returnItem();
				// Make lib files for return
				break;
			case 5:
				mainFunct();
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
		} catch (Exception e) {
			System.out.println("User ID doesn't exist");
		}
	}

	public static void customer() {
		System.out.println("1: Log-in");
		System.out.println("2: Register");
		System.out.print("Your Choice: ");
		int custChoice = Integer.parseInt(sc.nextLine());

		switch (custChoice) {
		case 1:
			custLogIn();
			break;
		case 2:
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

			user = new User(name, DOB, email, userName);
			userMap.put(userName, user);
			System.out.println("Thank you for Registering with SCCL");
			customer();
			break;
		default: 
			System.out.println("Wrong Choice");
			break;
		}
	}

}
