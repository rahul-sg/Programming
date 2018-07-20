public class ReverseWords
{
	public static String reverseSentence(String inp)
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
				//System.out.println(newStr);
				revInp = revInp + inp.charAt(0) + reverseWord (newStr, start, end);
			}
		}
		return revInp;
	}

	public static String reverseWord (String inp, int start, int end)
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

	public static String argsToString (String str[]) {
		String outStr = str[0];

		for (int i = 1; i < str.length; i++) {
			outStr += " " + str[i];
		}

		return outStr;
	}

	public static void main(String args[])
	{
		String inp = argsToString(args);
		String revInp = reverseSentence(inp);
		System.out.println("Original: " + inp);
		System.out.println("Reversed: " + revInp);
	}
}
