public class ArgsConvert {
	public static void main (String args[]) {
		int choice = Integer.parseInt(args[0]);

		String outStr = argsToString(args);
		System.out.println(outStr);
		
	}


	
	public static String argsToString (String str[]) {
		String outStr = str[1];

		for (int i = 2; i < str.length; i++) {
			outStr += " " + str[i];
		}

		return outStr;
	}
	
	
}
