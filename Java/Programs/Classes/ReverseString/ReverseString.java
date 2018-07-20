public class ReverseString
{
	public static void main (String args[])
	{

		String inp = args[0];
		String reverseInp = "";
		
		for (int i = inp.length() - 1; i >= 0; i--) {
			reverseInp = reverseInp + inp.charAt(i);
		}
		
		System.out.println ("Reversed string: " + reverseInp);
		
	}
}
