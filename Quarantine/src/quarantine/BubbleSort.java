package quarantine;

public class BubbleSort {
	public static void main(String[] args) {
		int[] dataArray = { 43, 56, 4332, 2, 2, 3, 7, 8, 454334 };
		doBubbleSort(dataArray);
		for (int i = 0; i < dataArray.length; ++i) {
			System.out.println(dataArray[i]);
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