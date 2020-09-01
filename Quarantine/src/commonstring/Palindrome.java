package commonstring;

public class Palindrome {
	public static void main(String[] args) {
		String data = "tenet";
		String reversed = "";
		for (int i = data.length() - 1; i >= 0; i--)
			reversed += data.charAt(i);
		if (data.equals(reversed)) {
			System.out.println("palindrome");
		} else {
			System.out.println("not");
		}
	}
}
