package datastructures;

import java.util.Arrays;

public class RemoveDuplicates {
	public static void main(String[] args) {
		int[] array = { 3, 3, 5, 4, 6, 5, 7, 8, 8, 9, 1, 1, 6 };
		Arrays.sort(array);
		int firstElement = array[0];
		int[] result = new int[array.length];
		result[0] = firstElement;
		for (int i = 1; i < array.length; i++) {
			int data = array[i];
			if (firstElement != data) {
				result[i] = data;
			}
			firstElement = data;
		}
		for (int i = 0; i < result.length; i++) {
			if (result[i] != 0) {
				System.out.println(result[i]);
			}
		}
	}
}
