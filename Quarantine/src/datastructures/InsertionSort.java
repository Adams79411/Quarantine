package datastructures;

public class InsertionSort {
	// o(n)
	public static void main(String[] args) {
		int[] dataArray = { 5, 4, 3, 2, 1 };
		doInsertionSort(dataArray);
		for (int i = 0; i < dataArray.length; ++i) {
			System.out.println(dataArray[i]);
		}
	}

	private static void doInsertionSort(int[] dataArray) {
		int size = dataArray.length;
		for (int i = 0; i < size; i++) {
			int key = dataArray[i];
			int j = i - 1;
			while (j >= 0 && dataArray[j] > key) {
				dataArray[j + 1] = dataArray[j];
				j = j - 1;
			}
			dataArray[j + 1] = key;
		}
	}
}