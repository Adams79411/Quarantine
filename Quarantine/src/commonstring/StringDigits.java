package commonstring;

public class StringDigits {
	public static void main(String[] args) {
		String data = "1224243";
		for (int i = 0; i < data.length(); i++) {
			if (!Character.isDigit(data.charAt(i))) {
				System.out.println("Not a digit");
				break;
			} else if (i == data.length() - 1 && Character.isDigit(data.charAt(i))) {
				System.out.println("Digit");
			}
		}
	}
}
