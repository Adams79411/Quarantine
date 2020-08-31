package datastructures;

public class BubbleSort {
	// o(nsquare
	// takes o(n) when array is already sorted
	public static void main(String[] args) {
		int[] array = { 232, 345345, 5343453, 32323, 43, 23, 4, 6, 3, 2, 34, 5, 342432432, 32, 3, 4 };
		doBubbleSort(array);
	}

	private static void doBubbleSort(int[] dataArray) {
		int size = dataArray.length;
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1; j++) {
				if (dataArray[j] > dataArray[j + 1]) {
					int temp = dataArray[j];
					dataArray[j] = dataArray[j + 1];
					dataArray[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < size; i++) {
			System.out.println(dataArray[i]);
		}
	}
}