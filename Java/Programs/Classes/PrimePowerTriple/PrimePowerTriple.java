import java.util.*;

public class PrimePowerTriple {
	static List<Integer> sum1;
	static List<Integer> sum2;
	static List<Integer> sum3;
	
	public static void main(String[] args) {
		findSum(50);
	}

	public static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
/*		if (n % 2 == 0) {
			return false;
		}*/
		for (int i = 2; i <= (int) Math.sqrt(n) + 1; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void findSum(int max) {
        	sum1 = getNumOne(max);
		sum2 = getNumTwo(max);
		sum3 = getNumThree(max);
		List<Long> finSums = new ArrayList<Long>();

		int counter = 0;
		System.out.print("[");
		for (int n1 : sum1) {
			if (n1 > 0) {
				System.out.print(n1 + ", ");
			}
		}
		System.out.print("]");
		System.out.println();

		System.out.print("[");
		for (int n2 : sum2) {
			if (n2 > 0) {
				System.out.print(n2 + ", ");
			}
		}
		System.out.print("]");
		System.out.println();
		
		System.out.print("[");
		for (int n3 : sum3) {
			if (n3 > 0) {
				System.out.print(n3 + ", ");
			}
		}
		System.out.print("]");
		System.out.println();

		for (long i : sum1) {
			for (long j : sum2) {
				for (long k : sum3) {
					long sum = i + j + k;
					if (sum < max) {
						if (sum > 0) {
							finSums.add(sum);
						}
					}
				}
			}
		}

		for (long fin : finSums) {
			counter++;
			//System.out.println(fin);
		}
		System.out.println("Count: " + counter);
	}

	// Getting prime numbers under max

	public static List<Integer> getNumOne(int max) {
		int num1 = 2;
		int i = 0;
		int sq = 0;
		List<Integer> nums = new ArrayList<Integer>();
		while (i < max) {
			if (isPrime(i)) {
				num1 = i;
				sq = num1 * num1;
				if (sq < max) {
					nums.add(sq);
				}
			}
			i++;
		}

		return nums;
	}

	public static List<Integer> getNumTwo(int max) {
		int num2 = 2;
		int i = 0;
		int cube = 0;
		List<Integer> nums = new ArrayList<Integer>();

		while (i < max) {
			if (isPrime(i)) {
				num2 = i;
				cube = num2 * num2 * num2;
				if (cube < max) {
					nums.add(cube);
				}
			}
			i++;
		}

		return nums;
	}

	public static List<Integer> getNumThree(int max) {
		int num3 = 2;
		int i = 0;
		int powFour = 0;
		List<Integer> nums = new ArrayList<Integer>();

		while (i < max) {
			if (isPrime(i)) {
				num3 = i;
				powFour = num3 * num3 * num3 * num3;
				if (powFour < max) {
					nums.add(powFour);
				}
			}
			i++;
		}
		return nums;
	}

}

/*
The smallest number expressible as the sum of a
prime square, prime cube, and prime fourth power is 28.
In fact, there are exactly four numbers below fifty
that can be expressed in such a way:

28 = 2^2 + 2^3 + 2^4
33 = 3^2 + 2^3 + 2^4
49 = 5^2 + 2^3 + 2^4
47 = 2^2 + 3^3 + 2^4

How many numbers below fifty million can be
expressed as the sum of a
prime square, prime cube, and prime fourth power?
*/


