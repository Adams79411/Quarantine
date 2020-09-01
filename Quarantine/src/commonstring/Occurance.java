package commonstring;

import java.util.Scanner;

public class Occurance {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the string:");
		String data = in.nextLine();
		System.out.println("Enter the character:");
		String dataChar = in.nextLine();
		int counter = 0;
		for (int i = 0; i < data.length(); i++) {
			if (String.valueOf(data.charAt(i)).equals(dataChar)) {
				counter++;
			}
		}
		System.out.println(counter);
	}
}
