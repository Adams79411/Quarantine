package commonstring;

public class CheckRotation {
	public static void main(String[] args) {
		String data = "StenyAdamsJ";
		String data1 = "JStenyAdams";
		String data3 = data + data;
		if (data3.contains(data1)) {
			System.out.println("It is a rotation");
		} else {
			System.out.println("Not");
		}
	}
}
