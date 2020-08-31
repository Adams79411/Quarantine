package practice;

public class IntegerPalindrome {
	public static void main(String[] args) {
		int data = 1221;
		int number = data;
		int reversed = 0;
		while (data != 0) {
			int digit = data % 10;
			reversed = reversed * 10 + digit;
			data /= 10;
		}
		if (number == reversed) {
			System.out.println("It is a palindrome");
		} else {
			System.out.println("Not");
		}
	}
}
