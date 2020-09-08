package practice;

import java.util.Arrays;

public class Anagram {
	public static void main(String[] args) {
		int a = 1;
		int c = 0;
		int b = a / c;
		System.out.println(b);
	}

	private static void customCode(String data1, String data2) {
		char temp;
		int dataLength1 = data1.length();
		int dataLength2 = data2.length();
		char[] dataArray1 = data1.toCharArray();
		char[] dataArray2 = data2.toCharArray();
		if (dataLength1 != dataLength2) {
			System.out.println("Not an anagram");
			return;
		}
		for (int i = 0; i < dataLength1 - 1; i++) {
			for (int j = i + 1; j < dataLength1; j++) {
				if (dataArray1[i] > dataArray1[j]) {
					temp = dataArray1[i];
					dataArray1[i] = dataArray1[j];
					dataArray1[j] = temp;
				}
				if (dataArray2[i] > dataArray2[j]) {
					temp = dataArray2[i];
					dataArray2[i] = dataArray2[j];
					dataArray2[j] = temp;
				}
			}
		}
		for (int i = 0; i < dataLength1; i++) {
			if (dataArray1[i] != dataArray2[i]) {
				System.out.println("Its not an anagram");
				return;
			}
		}
		System.out.println("Its an anagram");
	}

	private static void isAnagramByInbuiltFunctions(String data1, String data2) {
		char[] dataArray1 = data1.toCharArray();
		char[] dataArray2 = data2.toCharArray();
		Arrays.sort(dataArray1);
		Arrays.sort(dataArray2);
		if (Arrays.equals(dataArray1, dataArray2)) {
			System.out.println("They are anagrams");
		} else {
			System.out.println("They are not anagrams");
		}
	}
}
