import java.util.HashMap;

public class CharCount
{
	public static void main (String args[]) {
		int value;

		HashMap <Character, Integer> hashTable = new HashMap 
						<Character,Integer>();
		String input = args[0];

		for (int i = 0; i < input.length(); i++) {
			if (hashTable.containsKey (input.charAt(i))) {
				value = hashTable.get (input.charAt(i));
				value++;
				hashTable.put (input.charAt (i), value);
			} else {
				hashTable.put (input.charAt (i), 1);
			}
		}
	
		for (char key : hashTable.keySet()) {
			System.out.println("Character: " + "'" + 
			key + "'" + "   Count: " + hashTable.get (key));
		}
	}
}
