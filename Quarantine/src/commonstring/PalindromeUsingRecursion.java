package commonstring;

public class PalindromeUsingRecursion {

	public static void main(String[] args) {
		String data = "lool";
		System.out.println(isPalindrome(data, 0, data.length() - 1));
	}

	private static boolean isPalindrome(String data, int i, int j) {
		if (i == j) {
			return true;
		}
		if (data.charAt(i) != data.charAt(j)) {
			return false;
		}
		if (i < j + 1) {
			return isPalindrome(data, i + 1, j - 1);
		}
		return true;
	}
}
