package commonstring;

public class DuplicateCharInString {
	public static void main(String[] args) {
		String data = "StenStenSten";
		char[] dataArray = data.toCharArray();
		char[] resultArray = new char[dataArray.length];
		for (int i = 0; i < dataArray.length; i++) {
			for (int j = 0; j < dataArray.length; j++) {
				if (dataArray[i] == dataArray[j]) {
					resultArray[j] = dataArray[j];
					break;
				}
			}
		}
		for (int i = 0; i < resultArray.length; i++) {
			System.out.println(resultArray[i]);
		}
	}
}
