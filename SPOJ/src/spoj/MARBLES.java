package spoj;
import java.util.HashMap;
import java.util.Scanner;

public class MARBLES {

	/**
	 * @param args
	 */
	static class PairA {
		int n;
		int r;

		PairA(int n, int r) {
			this.n = n;
			this.r = r;
		}

		public String toString() {
			return n + " " + r;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (obj == null || obj.getClass() != this.getClass()) {
				return false;
			}
			PairA p = (PairA) obj;
			if (p.n == this.n && p.r == this.r)
				return true;
			return false;
		}

		@Override
		public int hashCode() {
			return n * 10 + r;
		}
	}

	static HashMap<PairA, Long> ncr = new HashMap<PairA, Long>();

	// static BigInteger[][] ncr = new BigInteger[1000001][1000001];
	// static long[][] ncr2 = new long[1000000][1000000];
	//
	// static void initializeNCR() {
	// for (int i = 0; i < 1000001; i++) {
	// for (int j = 0; j < 1000001; j++) {
	// if (j == 0) {
	// //ncr[i][j] = new BigInteger("1");
	// ncr2[i][j] = 1;
	// }
	// if (i <= j) {
	// //ncr[i][j] = new BigInteger("1");
	// ncr2[i][j] = 1;
	// } else {
	// //ncr[i][j] = ncr[i - 1][j].add(ncr[i - 1][j - 1]);
	// ncr2[i][j] = ncr2[i - 1][j] + (ncr2[i - 1][j - 1]);
	// }
	// }
	// }
	// }
	static long calculateNCR(int n, int r) {
		if (ncr.containsKey(new PairA(n, r))) {
			System.out.println("Hit");
			return ncr.get(new PairA(n, r));
		} else {
			if (r == 0) {
				ncr.put(new PairA(n, r), (long) 1);
				return 1;
			}
			if (n == r) {
				ncr.put(new PairA(n, r), (long) 1);
				return 1;
			}
			if (n < r) {
				ncr.put(new PairA(n, r), (long) 0);
				return 0;
			}
			long res = calculateNCR(n - 1, r) + calculateNCR(n - 1, r - 1);
			ncr.put(new PairA(n, r), res);
			return res;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// initializeNCR();
		Scanner sc = new Scanner(System.in);
		int j = sc.nextInt();
		for (int m = 0; m < j; m++) {
			// System.out.println(Long.MAX_VALUE);
			int n = sc.nextInt();
			int r = sc.nextInt();
			int k = r - 1;
			n--;
			double res = 1.0;
			for (int i = k; i >= 1; i--) {
				res *= ((double) n / (double) i);
				n--;
			}
			System.out.println(Math.round(res));
		}
		sc.close();
	}

}
