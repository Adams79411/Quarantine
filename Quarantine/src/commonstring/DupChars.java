package commonstring;

import java.util.Arrays;

public class DupChars {
	public static void main(String[] args) {
		String data = "StenyAdAmSJ";
		char[] dataArray = data.toCharArray();
		Arrays.sort(dataArray);
		char[] resultArray = new char[dataArray.length];
		char firstElem = dataArray[0];
		for (int i = 1; i < dataArray.length; i++) {
			char data1 = dataArray[i];
			if (String.valueOf(firstElem).equals(String.valueOf(data1))) {
				resultArray[i] = data1;
			}
			firstElem = dataArray[i];
		}
		for (int i = 0; i < resultArray.length; i++) {
			if (String.valueOf(resultArray[i]) != " ") {
				System.out.println(resultArray[i]);
			}
		}
	}
}
