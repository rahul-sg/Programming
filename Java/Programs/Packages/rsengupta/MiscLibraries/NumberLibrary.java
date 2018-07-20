
package Packages.rsengupta.MiscLibraries;

public class NumberLibrary {
	public long iterative (long num1)
	{
		long n1 = 0;
		long n2 = 1;
		long n3 = 1;

		for (int i = 0; i < num1; i++) {
			n1 = n2;
			n2 = n3;
			n3 = n1 + n2;
		}

		return n1;
	}
	
	public long recursive(long num) {
		if (num <= 1) {
                        return num;
                } else {
                        return recursive (num - 1) + recursive (num - 2);
                }
        }
}
