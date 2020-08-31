package commonstring;

public class NonRepeatedChar {
	public static void main(String[] args) {
		String data = "gggrraammmmmj";
		char[] array = data.toCharArray();
		for (int i = 0; i < array.length; i++) {
			int j;
			for (j = 0; j < array.length; j++) {
				if (i != j && array[i] == array[j]) {
					break;
				}
			}
			if (j == array.length) {
				System.out.println(array[i]);
				return;
			}
		}
	}
}
