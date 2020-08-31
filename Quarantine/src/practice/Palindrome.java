package practice;

public class Palindrome {
	public static void main(String[] args) {
		String data = "taat";
		String reverse = "";
		for (int i = data.length() - 1; i >= 0; i--) {
			reverse += data.charAt(i);
		}
		if (data.equals(reverse)) {
			System.out.println("Palindrome");
		} else {
			System.out.println("Not");
		}
	}
}
