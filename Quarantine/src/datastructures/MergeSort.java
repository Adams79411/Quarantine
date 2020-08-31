package datastructures;

public class MergeSort {
	// o(nlogn)
	public static void main(String[] args) {
		int[] array = { 5, 4, 3, 2, 1 };
		sort(array, 0, array.length - 1);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	private static void sort(int[] array, int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			sort(array, l, mid);
			sort(array, mid + 1, r);
			merge(array, l, mid, r);
		}
	}

	static void merge(int[] array, int l, int mid, int r) {
		int size1 = mid - l + 1;
		int size2 = r - mid;
		int[] arr1 = new int[size1];
		int[] arr2 = new int[size2];
		for (int i = 0; i < size1; ++i)
			arr1[i] = array[l + i];
		for (int j = 0; j < size2; ++j)
			arr2[j] = array[mid + 1 + j];

		int i = 0, j = 0, k = l;
		while (i < size1 && j < size2) {
			if (arr1[i] <= arr2[j]) {
				array[k] = arr1[i];
				i++;
			} else {
				array[k] = arr2[j];
				j++;
			}
			k++;
		}
		while (i < size1) {
			array[k] = arr1[i];
			i++;
			k++;
		}
		while (j < size2) {
			array[k] = arr2[j];
			j++;
			k++;
		}
	}
}
