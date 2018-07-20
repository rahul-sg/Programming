public class VowelCount
{
	public static void main (String args[]) 
	{
		String inp = args[0];
		String inp1 = inp.toLowerCase();
		System.out.println ("Vowels in " + "'" + inp + "'" + ": " + countVowel(inp1));
	}

	public static int countVowel (String inp)
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
}
