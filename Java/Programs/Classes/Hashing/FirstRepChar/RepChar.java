
import java.util.HashMap;

public class RepChar
{
	public static void main (String args[])
	{
		String input = args[0];
		char repeat = repChar(input);

		if (repeat != 0) {
			System.out.println("The first non-repeating " +
					   "character is " + repeat);
		} else {
			System.out.println("All characters are repeating!");
		}
	}

	public static char repChar(String input) {
		HashMap<Character, Integer> hashTable = new HashMap<Character,
								    Integer>();
		char choice = 0;
		String none = "There are no repeating characters!";

		for (int i = 0; i < input.length(); i++) {
			choice = input.charAt(i);
			if (hashTable.containsKey(choice)) {
				hashTable.put(choice,
					      hashTable.get(choice) + 1);
			} else {
				hashTable.put(choice, 1);
			}
			//System.out.print(choice);
		}
		//System.out.println();

		for (int i = 0; i < input.length(); i++) {
			choice = input.charAt(i);
			if (hashTable.get(choice) == 1) {
				return choice;
			}

		}
		return 0;
	}
}
