public class Palindromes {
	
	public static void main (String args[])
	{
		String inp = args[0];
		int inpLength = inp.length();
		int i, j;
		boolean isPalin = true;

		for (i = 0, j = inpLength - 1; i <= j; i++,  j--) {
			if (inp.charAt(i) != (inp.charAt(j))) {
				isPalin = false;
				break;
			}
			
		}
		
		if (isPalin == true) {
			System.out.println("Yes");
		} else {	
			System.out.println("No");
		}
	}
}
