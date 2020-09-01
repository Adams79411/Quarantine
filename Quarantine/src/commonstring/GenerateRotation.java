package commonstring;

public class GenerateRotation {

	public static void main(String[] args) {
		String data = "Steny";
		int n = data.length();
		StringBuffer sb = new StringBuffer(data);
		sb.append(data);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(sb.charAt(i + j));
			System.out.println();
		}
	}
}
