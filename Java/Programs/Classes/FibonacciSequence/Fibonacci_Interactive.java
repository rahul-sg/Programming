import java.util.Scanner;

public class Fibonacci_Interactive {

	public static long recursive(long num)
	{
		if (num <= 1) {
			return num;
        	} else {
			return recursive (num - 1) + recursive (num - 2);
		}
	}
	
	public static long iterative (long num1)
	{
		long n1 = 0;
		long n2 = 1;
		long n3 = 1;
		
		for (int i = 0; i < num1; i++) {
			n1 = n2;
			n2 = n3;
			n3 = n1 + n2;
		}

		return n1;
	}
	
	public static void main (String[] args)
        {
		Scanner menu = new Scanner(System.in);
		
		System.out.println("Choices: 1 - Recursive Method, 2 - Iterative Method");
		System.out.print("Your Choice: ");
		
		int menuChoice = menu.nextInt();
		
		if (menuChoice == 1) {			
			System.out.print("Enter how many numbers you would like to see in the Fibonacci Sequence: ");
                	Scanner in = new Scanner(System.in);
                	int num = in.nextInt();

                	for (int i = 1; i <= num; i++) {
                        	System.out.println (i + ": " + recursive(i));
			}
	
		} else if (menuChoice == 2) {
			
			System.out.print("Enter how many numbers you would like to see in the Fibonacci Sequence: ");
                        Scanner in1 = new Scanner(System.in);
                        int num1 = in1.nextInt();
			
			for (int i = 1; i <= num1; i++) {
				System.out.println (i + ": " + iterative(i));
				
			}			
		}
        }
}
