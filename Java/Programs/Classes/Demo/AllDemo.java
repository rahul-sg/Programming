import Packages.rsengupta.MiscLibraries.StringLibrary;
import Packages.rsengupta.MiscLibraries.NumberLibrary;
import Packages.rsengupta.MiscLibraries.SearchLibrary;
import Packages.rsengupta.MiscLibraries.Rectangle;
import Packages.rsengupta.MiscLibraries.RectPrism;
import Packages.rsengupta.MiscLibraries.Triangle;

public class AllDemo {
	public static void main (String args[]) {
		StringLibrary strLib = new StringLibrary();
		NumberLibrary numLib = new NumberLibrary();
		SearchLibrary searchLib = new SearchLibrary();

		if (args.length == 0) {
			System.out.println("Usage: <Menu Option (1 - 11)> <Program Input>");
			System.out.println("Where (Menu Option) is:");
			System.out.println("	String Library:");
			System.out.println("		[1]: Reverse String");
			System.out.println("		[2]: Is Palindrome");
			System.out.println("		[3]: Common Character Remover");
			System.out.println("		[4]: Vowel Counter");
			System.out.println("		[5]: Reverse Sentence");
			System.out.println("	Number Library:");
			System.out.println("		[6]: Fibonacci - Iterative");
			System.out.println("		[7]: Fibonacci - Recursive");
			System.out.println("	Search Library:");
			System.out.println("		[8]: First Non-Repeating Character");
			System.out.println("		[9]: Character Count");
			System.out.println("	Shape Library:");
			System.out.println("		[10]: <Width> <Length>");
			System.out.println("		[11]: <Width> <Length> <Height>");
			System.exit(0);
		}

		int menuOp = Integer.parseInt(args[0]);
		
		double rPrisW;
		double rPrisL;
		double rPrisH;
		String style;

		switch (menuOp) {
		//String Library Demo
		case 1:
			String ret = strLib.argsToString(args, 2, args.length);
			String reverse = strLib.reverseString(ret);
			System.out.println(reverse);
			break;
		
		case 2:
			String palinInp = strLib.argsToString(args, 2, args.length);
			boolean ispalin = strLib.isPalindrome(palinInp);
			System.out.println(ispalin ? "Yes" : "No");
			break;
	
		case 3:
			String comRet1 = strLib.argsToString(args, 2, args.length - 1);
			String comRet2 = strLib.argsToString(args, args.length - 1, args.length);
			String comCharRem = strLib.commonCharRemover(comRet1, comRet2);
			System.out.println(comCharRem);
			break;
		
		case 4:
			String vinp = strLib.argsToString(args, 2, args.length);
			String vinp1 = vinp.toLowerCase();
			System.out.println("Vowels in " + "'" +
				vinp + "'" + ": " + strLib.countVowel(vinp));
			break;
		
		case 5:
			String outStr = strLib.argsToString(args, 2, args.length);
			String revSet = strLib.reverseSentence(outStr);
			System.out.println("Original: " + outStr);
			System.out.println("Reversed: " + revSet);
			break;
		
		//Number Library Demo
		case 6:
			int num = Integer.parseInt(args[1]);
			for (int i = 1; i <= num; i++) {
				System.out.println (i + ": " + numLib.iterative(i));
			}
			break;
	
		case 7:
			int num1 = Integer.parseInt(args[1]);
			for (int i = 1; i <= num1; i++) {
				System.out.println (i + ": " + numLib.recursive(i));
			}
			break;
	
		//Search Library Demo
		case 8:
			String seaInput = strLib.argsToString(args, 2, args.length);
			char repeat = searchLib.repChar(seaInput);
			if (repeat != 0) {
				System.out.println("The first non-repeating " +
						   "character is '" + repeat +
						   "'");
			} else {
				System.out.println("All characters are repeating!");
			}
			break;
	
		case 9:
			String charCInp = strLib.argsToString(args, 2, args.length);
			searchLib.charCount(charCInp);
			break;

		case 10:
			rPrisW = Double.parseDouble(args[1]);
			rPrisL = Double.parseDouble(args[2]);
			
			Rectangle rDemo = new Rectangle(rPrisW, rPrisL);

			System.out.println(rDemo.isSquare() ? "Square" : "Rectangle");
			System.out.println("Dimensions:");
			System.out.println("	Width: " + rDemo.getWidth());
			System.out.println("	Length: " + rDemo.getLength());
			System.out.println("Area: " + rDemo.getArea());
			System.out.println("Perimeter: " + rDemo.getPeri());
			break;

		case 11:
			rPrisW = Double.parseDouble(args[1]);
			rPrisL = Double.parseDouble(args[2]);
			rPrisH = Double.parseDouble(args[3]);
			RectPrism rPrisDemo = new RectPrism(rPrisW, rPrisL, rPrisH);

			System.out.println(rPrisDemo.isCube() ? "Cube" : "Rectangular Prism");
			rPrisDemo.volume();
			System.out.println("Dimensions:");
			System.out.println("	Width: " + rPrisDemo.getWidth());
			System.out.println("	Length: " + rPrisDemo.getLength());
			System.out.println("	Height: " + rPrisDemo.getHeight());
			System.out.println("Volume: " + rPrisDemo.getVolume());
			break;

		case 12:
			rPrisW = Double.parseDouble(args[1]);
			rPrisL = Double.parseDouble(args[2]);

			Triangle triDemo = new Triangle(rPrisW, rPrisL);
			System.out.println(triDemo.getStyle() + " Triangle");
			System.out.println("Dimensions:");
			System.out.println("	Width: " + triDemo.getWidth());
			System.out.println("	Height: " + triDemo.getLength());
			System.out.println("Area: " + triDemo.getArea());
			break;

		default:
			System.out.println("Please Enter a valid choice!");
			break;
		}
	}
}
