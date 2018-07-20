
package Packages.rsengupta.MiscLibraries;

public class StringLibrary {
	public String reverseString(String inp) {
		String reverseInp = "";

		for (int i = inp.length() - 1; i >= 0; i--) {
			reverseInp = reverseInp + inp.charAt(i);
		}
		return reverseInp;
	}

	public boolean isPalindrome (String inp) {
		int inpLength = inp.length();
		int i, j;
		boolean isPalin = true;

		for (i = 0, j = inpLength - 1; i <= j; i++,  j--) {
			if (inp.charAt(i) != (inp.charAt(j))) {
				isPalin = false;
				break;
			}

		}
		return isPalin;
	}

	public int countVowel (String inp)
	{
		int vowelCount = 0;
		for (int i = 0; i < inp.length(); i++) {
			char iChar = inp.charAt(i);
			if (iChar == 'a' || iChar == 'e' || iChar == 'i' || iChar == 'o' || iChar == 'u') {
				vowelCount++;
			}
		}
		return vowelCount;
        }

	public String commonCharRemover (String inp1, String inp2) {
		for (int i = 0; i < inp2.length(); i++) {
			for (int j = 0; j < inp1.length(); j++) {
				if (inp2.charAt(i) == inp1.charAt(j)) {
					inp1 = inp1.substring (0, j) + 
							inp1.substring (j + 1);
				}
			}
		}
                return inp1;
	}

	public String reverseWord (String inp, int start, int end)
        {
                char temp;
                char[] inpChars = inp.toCharArray();

                for (start = 0, end = inp.length() - 1; start <= end; start++, end--) {
                        temp = inpChars[start];
                        inpChars[start] = inpChars[end];
                        inpChars[end] = temp;
                }
                String ret = new String(inpChars);
                return ret;
        }

	public String reverseSentence(String inp)
	{
		String newInp = reverseWord (inp, 0, inp.length());
		int start;
		int end;
		String revInp = "";
		String newStr = "";
		
		for (start = 0, end = 0; end < newInp.length(); end++) {
			if (newInp.charAt(end) == ' ') {
				newStr = newInp.substring(start, end);
				revInp = revInp + reverseWord(newStr, start, end) + ' ';
				end++;
				start = end;
		}
		
			if (end == newInp.length() - 1) {
				newStr = newInp.substring(start, end);
				revInp = revInp + inp.charAt(0) + reverseWord (newStr, start, end);
			}
		}
		return revInp;
	}

	public String argsToString (String str[], int start, int end) {
		String outStr = str[1];

		for (int i = start; i < end; i++) {
			outStr += " " + str[i];
		}

		return outStr;
	}
}
