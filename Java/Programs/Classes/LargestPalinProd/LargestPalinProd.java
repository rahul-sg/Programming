import java.util.*;

public class LargestPalinProd {
	public static void main(String[] args) {
	
		int prod = 0;
		int max = 999;
		int min = 100;
		ArrayList<Integer> prods = new ArrayList<Integer>();
		for (int i = max; i >= min; i--) {
			for (int j = max; j >= min; j--) {
				prod = i * j;
				if (isPalin(prod)) {
					prods.add(prod);
				}
			}
		}

		System.out.println("Largest Palindrome that is product of numbers between " + min + " and " + max + " is: " + Collections.max(prods));
	}
    
	public static boolean isPalin(int number) {
		char [] digits = String.valueOf(number).toCharArray();
		
		for (int i = digits.length - 1, j = 0; i >= j; i--, j++) {
			if (digits[j] != digits[i]) {
				return false;
			}
		}

		return true;
	}
}
