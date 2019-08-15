public class ReverseDigitLimit {
	public static void main(String[] args) {
		checkRev(1000000000);
	}
    
	public static void checkRev(int revLimit) {
		int count = 0;
		String reverse = "";
		String orig;
		String sumStr;
		int rev;
		int ori;
		boolean isCount = false;
		int sum;
		for (int i = 0; i <= revLimit; i++) {
			orig = Integer.toString(i);;
			for(int a = orig.length() - 1; a >= 0; a--) {
				reverse = reverse + orig.charAt(a);
			}
			rev = Integer.parseInt(reverse);
			ori = Integer.parseInt(orig);
			sum = ori + rev;
			sumStr = Integer.toString(sum);
			char curr;
			int curI;
			// System.out.println(ori + " + " + reverse + " = " + sumStr);

			if (ori % 10 != 0 && rev % 10 != 0) {
				for (int j = 0; j < sumStr.length(); j++) {
					curr = sumStr.charAt(j);
					curI = Integer.parseInt(String.valueOf(curr));
					if (curI % 2 != 0) {
						isCount = true;
					} else {
						isCount = false;
						break;
					}
				}
			}
            
			if (isCount && (ori % 10 != 0 && rev % 10 != 0)) {
				count++;
				// System.out.println("Count: " + count);
				// System.out.println();
			}
			reverse = "";
		}
		// System.out.println();
		// System.out.println("---------------------");
		System.out.println("Final Count: " + count);
	}

}
