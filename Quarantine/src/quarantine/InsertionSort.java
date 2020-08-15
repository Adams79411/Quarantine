package quarantine;

public class InsertionSort {

	public static void main(String[] args) {
		int[] dataArray = { 43, 6, 343, 445, 666, 43, 1, 0 };
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