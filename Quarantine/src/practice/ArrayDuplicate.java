package practice;

public class ArrayDuplicate {
	public static void main(String[] args) {
		int[] array = new int[10];
		int[] temp = new int[10];
		array[0] = 1;
		array[1] = 2;
		array[2] = 1;
		array[3] = 3;
		array[4] = 3;
		array[5] = 15;
		array[6] = 15;
		array[7] = 2;
		array[8] = 3;
		array[9] = 11;
		int j = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] != array[i + 1]) {
				temp[j++] = array[i];
			}
		}
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}
	}
}
