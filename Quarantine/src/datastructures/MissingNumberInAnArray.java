package datastructures;

import java.util.BitSet;

public class MissingNumberInAnArray {
	public static void main(String[] args) {
		int[] array = { 1, 3, 4, 5 };
		int total = 10;
		BitSet set = new BitSet(total);
		for (int i = 0; i < array.length; i++) {
			set.set(array[i] - 1);
		}
		int counter = 0;
		for (int i = 0; i < total - array.length; i++) {
			counter = set.nextClearBit(counter);
			System.out.println(++counter);
		}
	}
}
