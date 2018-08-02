import Packages.rsengupta.Library.Book;
import Packages.rsengupta.Library.Library;
import Packages.rsengupta.Library.User;
import java.util.*;

public class SCCL {
	public static void main (String args[]) {
		
		Scanner sc = new Scanner(System.in);
		HashMap<String, User> userMap = new Hashmap<String, User>();
		System.out.print("Are you an Admin {1} or Customer {2}? ");i
		int initC = Integer.parseInt(sc.nextLine());
		switch (initC) {
		case 1:
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
			break;
		case 2:
			System.out.println("1: Log-in");
			System.out.println("2: Register");
			System.out.print("Your Choice: ");
			int custChoice = Integer.parseInt(sc.nextLine());

			switch (custChoice) {
			case 1:
				System.out.print("Enter Username: ");
				String loginID = sc.nextLine();
				try {
					String uID = userMap.get(loginID);
					System.out.println("1: Search Items");
					System.out.println("2: View Items");
					System.out.println("3: Check-out");
					System.out.println("4: Return");
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
						// Make lib file for check out
						break;
					case 4:
						// Make lib files for return
						break;
					default:
						System.out.println("Wrong Choice");
						break;
					}
				} catch (Exception e) {
					System.out.println("User ID doesn't exist");
				}


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
				System.out.print("Custom Username: ");
				String userName = sc.nextLine();

				User user = new User(name, DOB, email, userName);
				userMap.put(userName, user);
				System.out.println("Thank you for Registering with SCCL");
				break;
			default: 
				System.out.println("Wrong Choice");
				break
			}


			break;
		default:
			System.out.println("Wrong Choice");
			break;
	}
}
