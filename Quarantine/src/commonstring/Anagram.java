package commonstring;

import java.util.Arrays;

public class Anagram {
	public static void main(String[] args) {
		String data1 = "Steny";
		String data2 = "ynetS";
		char[] data1Array = data1.toCharArray();
		char[] data2Array = data2.toCharArray();
		isAnagramUsingInBuild(data1Array, data2Array);
		isAnagramWithoutInBuilt(data1Array, data2Array);
	}

	private static void isAnagramWithoutInBuilt(char[] data1Array, char[] data2Array) {
		int length1 = data1Array.length;
		int length2 = data2Array.length;
		if (length1 != length2) {
			System.out.println("Not an anagram");
			return;
		}
		for (int i = 0; i < length1 - 1; i++) {
			for (int j = 0; j < length1 - 1; j++) {
				if (data1Array[i] > data1Array[j]) {
					char temp = data1Array[i];
					data1Array[i] = data1Array[j];
					data1Array[j] = temp;
				}
				if (data2Array[i] > data2Array[j]) {
					char temp = data2Array[i];
					data2Array[i] = data2Array[j];
					data2Array[j] = temp;
				}
			}
		}
		for (int i = 0; i < length1; i++) {
			if (data1Array[i] != data2Array[i]) {
				System.out.println("Not an anagram");
				return;
			} else {
				System.out.println("Anagram");
				return;
			}
		}
	}

	private static void isAnagramUsingInBuild(char[] data1Array, char[] data2Array) {
		Arrays.sort(data1Array);
		Arrays.sort(data2Array);
		if (Arrays.equals(data1Array, data2Array)) {
			System.out.println("Anagram");
		} else {
			System.out.println("Not an anagram");
		}
	}
}
