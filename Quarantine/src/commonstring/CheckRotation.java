package commonstring;

public class CheckRotation {
	public static void main(String[] args) throws DataNotFoundException {
		try {
			int data = 4 / 0;
		} catch (ArithmeticException e) {
			throw new DataNotFoundException("Hindi Teriyaathu poda");
		}
	}
}
