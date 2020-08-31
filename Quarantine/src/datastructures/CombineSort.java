package datastructures;

public class CombineSort {

	public static void main(String[] args) {
		int[] dataArray = { 5, 4, 3, 2, 1 };
		doBubbleSort(dataArray);
		System.out.println("After Bubble Sort:");
		for (int i = 0; i < dataArray.length; ++i) {
			System.out.println(dataArray[i]);
		}
		int[] dataArray1 = { 5, 4, 3, 2, 1 };
		doInsertionSort(dataArray1);
		System.out.println("After Insertion Sort:");
		for (int i = 0; i < dataArray1.length; ++i) {
			System.out.println(dataArray1[i]);
		}
		int[] dataArray2 = { 5, 4, 3, 2, 1 };
		doSelectionSort(dataArray2);
		System.out.println("After selection Sort:");
		for (int i = 0; i < dataArray2.length; ++i) {
			System.out.println(dataArray2[i]);
		}
	}

	private static void doSelectionSort(int[] dataArray1) {
		int length = dataArray1.length;
		for (int i = 0; i < length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < length; j++) {
				if (dataArray1[j] < dataArray1[minIndex]) {
					minIndex = j;
				}
			}
			int temp = dataArray1[minIndex];
			dataArray1[minIndex] = dataArray1[i];
			dataArray1[i] = temp;
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
	}
}