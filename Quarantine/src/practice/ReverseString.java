package practice;

public class ReverseString {
	public static void main(String[] args) {
		String given = "Steny Adams J";
		String reversed = "";
		for (int i = given.length() - 1; i >= 0; i--) {
			reversed += given.charAt(i);
		}
		System.out.println(reversed);
	}
}
