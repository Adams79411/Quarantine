package practice;

import java.util.Scanner;

public class PermutationOfString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the string:");
		String data = in.nextLine();
		performPerm(data, "");
	}

	public static void performPerm(String data, String answer) {
		if (data.length() == 0) {
			System.out.println(answer);
			return;
		}
		for (int i = 0; i < data.length(); i++) {
			char ch = data.charAt(i);
			String ans = data.substring(0, i) + data.substring(i + 1);
			performPerm(ans, answer + ch);
		}
	}
}
