package practice;

public class Fibonacci {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(fibonacci(i));
		}
	}

	private static int fibonacci(int i) {
		if (i == 1 || i == 2) {
			return 1;
		}
		return fibonacci(i - 1) + fibonacci(i - 2);
	}
}
