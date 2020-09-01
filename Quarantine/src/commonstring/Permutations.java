package commonstring;

public class Permutations {
	public static void main(String[] args) {
		String data = "ABC";
		permute(data, 0, data.length() - 1);
	}

	private static void permute(String data, int low, int high) {
		if (low == high) {
			System.out.println(data);
		} else {
			for (int i = low; i <= high; i++) {
				data = swap(data, low, i);
				permute(data, low + 1, high);
				data = swap(data, low, i);
			}
		}
	}

	private static String swap(String data, int low, int i) {
		char temp;
		char[] array = data.toCharArray();
		temp = array[low];
		array[low] = array[i];
		array[i] = temp;
		return String.valueOf(array);
	}
}
