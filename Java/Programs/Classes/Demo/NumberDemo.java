import Packages.rsengupta.MiscLibraries.NumberLibrary;

public class NumberDemo {
	public static void main (String args[]) {
		NumberLibrary numLib;
		numLib = new Packages.rsengupta.MiscLibraries.NumberLibrary();
		
		if (args.length == 0) {
			System.out.println("Usage: NumberDemo <input>");
			System.out.println("Where, <input>:");
			System.out.println("    [0] = Fibonacci Sequence");
			System.exit(0);
		}

		int num = Integer.parseInt(args[0]);
		for (int i = 1; i <= num; i++) {
			System.out.println (i + ": " + numLib.iterative(i));
		}
		
		int num1 = Integer.parseInt(args[1]);
		for (int i = 1; i <= num1; i++) {
			System.out.println (i + ": " + numLib.recursive(i));
		}

	}
}
