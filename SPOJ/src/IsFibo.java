import java.math.BigInteger;
import java.util.Scanner;

public class IsFibo {

	/**
	 * @param args
	 */
	public static BigInteger sqrt(BigInteger n) {
		if (n.signum() >= 0) {
			final int bitLength = n.bitLength();
			BigInteger root = BigInteger.ONE.shiftLeft(bitLength / 2);

			while (!isSqrt(n, root)) {
				root = root.add(n.divide(root)).divide(new BigInteger("2"));
			}
			return root;
		} else {
			throw new ArithmeticException("square root of negative number");
		}
	}

	private static boolean isSqrt(BigInteger n, BigInteger root) {
		final BigInteger lowerBound = root.pow(2);
		final BigInteger upperBound = root.add(BigInteger.ONE).pow(2);
		return lowerBound.compareTo(n) <= 0 && n.compareTo(upperBound) < 0;
	}

	static boolean isSquare(BigInteger a) {
		BigInteger b = sqrt(a);
		if (b.multiply(b).equals(a))
			return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < num; i++) {
			String k = sc.nextLine();
			BigInteger n = new BigInteger(k);
			if (checkFib(n))
				System.out.println("IsFibo");
			else
				System.out.println("IsNotFibo");
		}
		sc.close();
	}

	static boolean checkFib(BigInteger n) {
		BigInteger a = n.multiply(n).multiply(new BigInteger("5"))
				.subtract(new BigInteger("4"));
		BigInteger b = n.multiply(n).multiply(new BigInteger("5"))
				.add(new BigInteger("4"));
		if (isSquare(a) || isSquare(b))
			return true;
		return false;
	}

}
