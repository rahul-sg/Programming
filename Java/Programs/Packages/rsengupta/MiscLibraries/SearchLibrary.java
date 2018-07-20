
package Packages.rsengupta.MiscLibraries;

import java.util.HashMap;

public class SearchLibrary {
	public char repChar(String input) {
		HashMap<Character, Integer> hashTable = new HashMap<Character,
                                                                    Integer>();
		char choice = 0;
		String none = "There are no repeating characters!";
	
		for (int i = 0; i < input.length(); i++) {
			choice = input.charAt(i);
			if (hashTable.containsKey(choice)) {
				hashTable.put(choice,hashTable.get(choice) + 1);
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

	public void charCount(String input) {
		int value;

		HashMap <Character, Integer> hashTable = new HashMap
							<Character,Integer>();

		for (int i = 0; i < input.length(); i++) {
			if (hashTable.containsKey (input.charAt(i))) {
				value = hashTable.get (input.charAt(i));
				value++;
				hashTable.put (input.charAt (i), value);				} else {
				hashTable.put (input.charAt (i), 1);
			}
		}

		for (char key : hashTable.keySet()) {
			System.out.println("Character: " + "'" +
			key + "'" + "   Count: " + hashTable.get (key));
		}

	}

}
