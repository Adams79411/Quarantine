package commonstring;

public class ReverseUsingRecur {
	public static void main(String[] args) {
		String data = "Steny";
		reverseUsingRecursion(data);
		reverseUsingLoop(data);
	}

	private static void reverseUsingLoop(String data) {
		String reversed = "";
		for (int i = data.length() - 1; i >= 0; i--)
			reversed += data.charAt(i);
		System.out.println(reversed);
	}

	private static void reverseUsingRecursion(String data) {
		if (data == null || data.length() <= 1) {
			System.out.println(data);
		} else {
			System.out.println(data.charAt(data.length() - 1));
			reverseUsingRecursion(data.substring(0, data.length() - 1));
		}
	}
}
