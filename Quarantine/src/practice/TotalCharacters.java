package practice;

public class TotalCharacters {
	public static void main(String[] args) {
		String character = "Hi my name is Steny Adams J";
		int counter = 0;
		for (int i = 0; i < character.length(); i++) {
			counter++;
		}
		System.out.println(counter);
	}
}
