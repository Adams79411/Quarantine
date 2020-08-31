package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FirstRepeatingChar {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the character");
		String data = scan.nextLine();
		List<Character> dataList = new ArrayList<>();
		List<Character> repeatingList = new ArrayList<>();
		for (int i = 0; i < data.length(); i++) {
			if (repeatingList.contains(data.charAt(i))) {
				System.out.println(data.charAt(i));
				return;
			} else {
				repeatingList.add(data.charAt(i));
			}
		}
	}
}
