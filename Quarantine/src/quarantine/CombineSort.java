package quarantine;

public class CombineSort {

	public static void main(String[] args) {
		int[] dataArray = { 45, 66, 43, 1, 2, 3, 4, 56, 4, 3, 4, 56, 7, 5, 3, 3, 3 };
		doBubbleSort(dataArray);
		System.out.println("After Bubble Sort:");
		for (int i = 0; i < dataArray.length; ++i) {
			System.out.println(dataArray[i]);
		}
		int[] dataArray1 = { 45, 66, 43, 1, 2, 3, 4, 56, 4, 3, 4, 56, 7, 5, 3, 3, 3 };
		doInsertionSort(dataArray1);
		System.out.println("After Insertion Sort:");
		for (int i = 0; i < dataArray1.length; ++i) {
			System.out.println(dataArray1[i]);
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
		for (int i = 0; i < size - 1; i++)
			for (int j = 0; j < size - i - 1; j++)
				if (dataArray[j] > dataArray[j + 1]) {
					int temp = dataArray[j];
					dataArray[j] = dataArray[j + 1];
					dataArray[j + 1] = temp;
				}
	}
}