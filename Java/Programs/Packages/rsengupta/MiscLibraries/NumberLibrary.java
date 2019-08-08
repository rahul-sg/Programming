
package Packages.rsengupta.MiscLibraries;

public class NumberLibrary {
	public long iterative (long num1)
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
	
	public long recursive(long num) {
		if (num <= 1) {
                        return num;
                } else {
                        return recursive (num - 1) + recursive (num - 2);
                }
        }

	public static char getNumber(char num) {
		char key = Character.toUpperCase(num);
        	switch (key) {
        		case 'A': case 'B': case 'C':
				return '2';
			case 'D': case 'E': case 'F':
				return '3';
			case 'G': case 'H': case 'I':
				return '4';
			case 'J': case 'K': case 'L':
				return '5';
			case 'M': case 'N': case 'O':
				return '6';
			case 'P': case 'Q': case 'R': case 'S':
				return '7';
			case 'T': case 'U': case 'V':
				return '8';
			case 'W': case 'X': case 'Y': case 'Z':
				return '9';
			case ' ': case '-':
				return '-';
			default:
				return ' ';
		}
	}
}
