public class Fibonacci_Param {

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
		int menuChoice = Integer.parseInt(args[0]);
		
		if (menuChoice == 1) {			
			int num = Integer.parseInt(args[1]);
                	for (int i = 1; i <= num; i++) {
                        	System.out.println (i + ": " + recursive(i));
			}
	
		} else if (menuChoice == 2) {
			int num1 = Integer.parseInt(args[1]);
			for (int i = 1; i <= num1; i++) {
				System.out.println (i + ": " + iterative(i));
			}			
		}
        }
}
