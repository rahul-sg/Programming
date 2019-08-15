import java.util.*;


public class Calculator {
	public static void main(String args[]) {
		if (args.length == 0) {
			System.out.println("Usage:");
			System.out.println("{Addition}	1 <num1> <num2>");
			System.out.println("{Subtract}	2 <num1> <num2>");
			System.out.println("{Multiply}	3 <num1> <num2>");
			System.out.println("{Divide}	4 <num1> <num2>");
			System.out.println("{Exponents}	5 <num1> <num2>");
		}
		int choice = Integer.parseInt(args[0]);
		double num1;
		double num2;
		switch(choice) {
		case 1:
			num1 = Double.parseDouble(args[1]);
			num2 = Double.parseDouble(args[2]);
			double sum = add(num1, num2);
			System.out.println("Sum of " + num1 + " and " + num2 + " = " + sum);
			break;
		case 2:
			num1 = Double.parseDouble(args[1]);
			num2 = Double.parseDouble(args[2]);
			double diff = subtract(num1, num2);
			System.out.println("Difference of " + num1 + " and " + num2 + " = " + diff);
			break;
		case 3:
			num1 = Double.parseDouble(args[1]);
			num2 = Double.parseDouble(args[2]);
			double res = multiply(num1, num2);
			System.out.println("Product of " + num1 + " and " + num2 + " = " + res);
			break;
		case 4:
			num1 = Double.parseDouble(args[1]);
			num2 = Double.parseDouble(args[2]);
			double ans = divide(num1, num2);
			System.out.println("Quotient of " + num1 + " and " + num2 + " = " + ans);
			break;
		case 5:
			num1 = Double.parseDouble(args[1]);
			num2 = Double.parseDouble(args[2]);
			double exp = exponent(num1, num2);
			System.out.println("Exponential answer of " + num1 + " and " + num2 + " = " + exp);
			break;
		default:
			System.out.println("Wrongly Entered");
			break;
		}
			
	}
	
	public static double add(double num1, double num2) {
		double sum = num1 + num2;
		return sum;
	}

	public static double subtract(double num1, double num2) {
		double diff = num1 - num2;
		return diff;
	}

	public static double multiply(double num1, double num2) {
		double res = num1 * num2;
		return res;
	}

	public static double divide(double num1, double num2) {
		double res = num1 / num2;
		return res;
	}

	public static double exponent(double base, double exp) {
		double pow = Math.pow(base, exp);
		return pow;
	}
}
