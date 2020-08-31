package practice;

public class Armstrong {
	public static void main(String[] args) {
		int number = 153;
		int data = number;
		int counter = 0;
		while (number != 0) {
			int digit = number % 10;
			counter += digit * digit * digit;
			number /= 10;
		}
		if (data == counter) {
			System.out.println("It is an armstrong number");
		} else {
			System.out.println("Not");
		}
	}
}
