package datastructures;

public class QuickSort {
	public static void main(String[] args) {
		int[] array = { 5, 4, 3, 2, 1 };
		doQuickSort(array, 0, array.length - 1);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	private static void doQuickSort(int[] array, int i, int j) {
		if (i < j) {
			int partition = doPartition(array, i, j);
			doQuickSort(array, i, partition - 1);
			doQuickSort(array, partition + 1, j);
		}
	}

	private static int doPartition(int[] array, int i, int j) {
		int pivot = array[j];
		int pivotPos = (i - 1);
		for (int k = i; k < j; k++) {
			if (array[k] < pivot) {
				pivotPos++;
				int temp = array[pivotPos];
				array[pivotPos] = array[k];
				array[k] = temp;
			}
		}
		int temp = array[pivotPos + 1];
		array[pivotPos + 1] = array[j];
		array[j] = temp;
		return pivotPos + 1;
	}
}
