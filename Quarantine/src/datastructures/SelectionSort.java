package datastructures;

public class SelectionSort {
	// 0(nsquare)
	public static void main(String[] args) {
		int[] dataArray = { 5, 4, 3, 2, 1 };
		doSelectionSort(dataArray);
	}

	private static void doSelectionSort(int[] dataArray) {
		int size = dataArray.length;
		for (int i = 0; i < size - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < size; j++) {
				if (dataArray[j] < dataArray[minIndex]) {
					minIndex = j;
				}
			}
			int temp = dataArray[minIndex];
			dataArray[minIndex] = dataArray[i];
			dataArray[i] = temp;
		}
		for (int i = 0; i < size; i++) {
			System.out.println(dataArray[i]);
		}
	}
}
