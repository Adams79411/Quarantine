package practice;

import java.util.Scanner;

public class PowerO1 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number:");
		int x = in.nextInt();
		int y = in.nextInt();
		System.out.println(power(x, y));
	}

	private static int power(int x, int y) {
		if (y == 0) {
			return 1;
		} else if (y % 2 == 0) {
			return power(x, y / 2) * power(x, y / 2);
		} else {
			return x * power(x, y / 2) * power(x, y / 2);
		}
	}
}
