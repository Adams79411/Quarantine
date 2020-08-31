package commonstring;

public class VowelsandConsonants {
	public static void main(String[] args) {
		String data = "stenyadamsjbillinhayden";
		int vowelCount = 0, consonant = 0;
		for (int i = 0; i < data.length(); i++) {
			if (String.valueOf(data.charAt(i)).equals("a") || String.valueOf(data.charAt(i)).equals("e")
					|| String.valueOf(data.charAt(i)).equals("i") || String.valueOf(data.charAt(i)).equals("o")
					|| String.valueOf(data.charAt(i)).equals("u")) {
				vowelCount++;
			} else {
				consonant++;
			}
		}
		System.out.println("No of vowels is '" + vowelCount + "'");
		System.out.println("No of vowels is '" + consonant + "'");
	}
}
