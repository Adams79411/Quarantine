package practice;

public class Factorial {
	public static void main(String[] args) {
		int fact = 6;
		int result = 1;
		while (fact != 0) {
			result = result * fact;
			fact--;
		}
		System.out.println(result);
	}
}
