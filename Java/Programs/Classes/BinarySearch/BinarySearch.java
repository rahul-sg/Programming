import java.util.Scanner;

public class BinarySearch
{
	public static void main (String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.print ("How many numbers would you like to enter? ");
		int num = input.nextInt();
		int[] numbers = new int[num];

		for (int i = 0; i < num; i++) {
			System.out.print ("Number " + (i + 1) + ": ");
			numbers[i] = input.nextInt();
		}

		int temp;

		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (numbers[i] < numbers[j]) {
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}

		for (int i = 0; i < numbers.length; i++) {
			System.out.print (numbers[i] + " ");
		}

		System.out.println ();
		System.out.print ("What number would you like to search for? ");

		int target = input.nextInt();
		int end = numbers.length - 1;
		boolean ret = binarySearch(numbers, target, 0, end);

		if (ret == true) {
			System.out.println("The number " + target + " was found in the entries!");
		} else {
			System.out.println("The number " + target + " was NOT found in the entries!");
		}
	}

	public static boolean binarySearch (int[] numbers, int target, int start, int end)
	{
		int arrMid = (start + end) / 2;
		boolean ret;

		if (start > end) {
			ret = false;
		} else if (target == numbers[arrMid]) {
			ret = true;
		} else if (target < numbers[arrMid]) {
			return binarySearch (numbers, target, start, arrMid - 1);
		} else {
			return binarySearch (numbers, target, arrMid + 1, end);
		}

		return ret;
	}
}
