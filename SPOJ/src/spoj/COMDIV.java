package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class COMDIV {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		try {
			int num = in.nextInt();
			for (int i = 0; i < num; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				pw.println(getDivisors(a, b));
			}
		} catch (Exception e) {

		}
		in.close();
	}

	static int getDivisors(int a, int b) {
		int c = gcd(a, b);
		if(c==1) return 1;
		int cnt = 2;
		for (int i = 2; i <= (c / 2); i++) {
			if (c % i == 0)
				cnt++;
		}
		return cnt;
	}

	static int gcd(int a, int b) {
		if (a % b == 0)
			return b;
		if (b % a == 0)
			return a;
		if (a > b)
			return gcd(a - b, b);
		return gcd(a, b - a);
	}
}


