package quarantine;

@FunctionalInterface
interface Square {
	int calculate(int x);
}

class Test {
	public static void main(String args[]) {
		new Thread(() -> {
			System.out.println("A");
		}).start();
	}
}