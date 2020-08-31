package practice;

public class PrimeNumberCheck {
	public static void main(String[] args) {
		isPrime(131);
		System.out.println(isPrime1(131));
	}

	private static boolean isPrime1(int data) {
		int sqrt = (int) Math.sqrt(data) + 1;
		for (int i = 2; i < sqrt; i++) {
			if (data % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static void isPrime(int data) {
		if (data < 0) {
			System.out.println("Not valid");
		}
		if (data == 0 || data == 1) {
			System.out.println("Not Prime");
		}
		if (data == 2 || data == 3) {
			System.out.println("Prime");
		}
		if ((data * data - 1) % 24 == 0) {
			System.out.println("Prime");
		} else {
			System.out.println("Not Prime");
		}
	}
}
