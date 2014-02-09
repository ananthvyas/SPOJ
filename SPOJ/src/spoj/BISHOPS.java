package spoj;
import java.math.BigInteger;
import java.util.Scanner;

class BISHOPS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		while (true) {
			try {
				if (num.equals("1")) {
					System.out.println(1);
					num = sc.next();
					continue;
				}
				BigInteger b = new BigInteger(num);
				BigInteger c = b.subtract(new BigInteger("1")).multiply(
						new BigInteger("2"));
				System.out.println(c);
				num = sc.next();
			} catch (Exception e) {
				sc.close();
				System.exit(0);
			}
		}
	}
}
