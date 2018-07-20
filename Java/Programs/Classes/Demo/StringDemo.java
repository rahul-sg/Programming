
import Packages.rsengupta.MiscLibraries.StringLibrary;

public class StringDemo {
	public static void main (String args[]) {
		StringLibrary strLib;

//		strLib = new Packages.rsengupta.StringLibrary(args[0], args[2], args[3], args[4], args[5]);

		strLib = new Packages.rsengupta.StringLibrary();

		if (args.length == 0) {
			System.out.println("Usage: StringDemo <option> <string>");
			System.out.println("Where, <option>:");
			System.out.println("	[0] = reverseString");
			System.out.println("	[1] = reverseWord");
			System.out.println("	[2] = isPalindrome");
			System.out.println("	[3] = removeCommonChar(1)");
			System.out.println("	[4] = removeCommonChar(2)");
			System.out.println("	[5] = vowelCounter");
			System.exit(0);
		}

		String reverse = strLib.reverseString(args[0]);
		System.out.println(reverse);

		boolean ispalin = strLib.isPalindrome(args[2]);
		System.out.println(ispalin ? "Yes" : "No");

		String comCharRem = strLib.commonCharRemover(args[3], args[4]);
		System.out.println(comCharRem);

		String vinp = args[5];
		String vinp1 = vinp.toLowerCase();
		System.out.println("Vowels in " + "'" + vinp + "'" + ": " +
						strLib.countVowel(args[5]));
	}
}
