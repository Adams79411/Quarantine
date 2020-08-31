package practice;

public class ReverseNumber {
	public static void main(String[] args) {
		int data = 126342348;
		int reversed = 0;
		while (data != 0) {
			int digit = data % 10;
			reversed = reversed * 10 + digit;
			data /= 10;
		}
		System.out.println(reversed);
	}
}
