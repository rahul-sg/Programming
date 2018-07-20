import Packages.rsengupta.MiscLibraries.SearchLibrary;

public class SearchDemo {
	public static void main (String args[]) {
		SearchLibrary searchLib;
		searchLib = new Packages.rsengupta.SearchLibrary();

		if (args.length == 0) {
			System.out.println("Usage: SearchDemo <input>");
			System.out.println("Where, <input>:");
			System.out.println("    [0] = First Non-Repeating Character");
			System.out.println("    [1] = Character Count");
			System.out.println("    [2] = Binary Search");
			System.exit(0);
		}


		String input = args[0];
		char repeat = searchLib.repChar(input);

		if (repeat != 0) {
			System.out.println("The first non-repeating " +
						"character is " + repeat);
		} else {
			System.out.println("All characters are repeating!");
		}

		searchLib.charCount(args[1]);

		//String outStr = strLib.argsToString(args);
		//System.out.println(outStr);
	}
	
	
}
