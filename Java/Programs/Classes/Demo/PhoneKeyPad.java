import Packages.rsengupta.MiscLibraries.NumberLibrary;

public class PhoneKeyPad {
	public static void main (String args[]) {
		NumberLibrary numLib;
		numLib = new Packages.rsengupta.MiscLibraries.NumberLibrary();
		
		String input = args[0];
		char[] chars = input.toCharArray();

		char[] nums = new char[chars.length];

		for (int i = 0; i < chars.length; i++) {
			char num = numLib.getNumber(chars[i]);
			nums[i] = num;
		}

		for (int j = 0; j < nums.length; j++) {
			System.out.print(nums[j]);
		}
		System.out.println("");
	}
}
