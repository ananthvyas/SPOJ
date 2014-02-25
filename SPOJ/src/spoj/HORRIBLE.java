package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class BitTree {
	long[] B1;
	long[] B2;
	int N;

	public BitTree(int n) {
		// TODO Auto-generated constructor stub
		B1 = new long[n + 1];
		B2 = new long[n + 1];
		N = n;
	}

	void update(long[] ft, int a, long v) {
		for (int p = a; p <= N; p += (p & (-p))) {
			ft[p] += v;
		}
	}

	void update(int a, int b, long v) {
		update(B1, a, v);
		update(B1, b + 1, -v);
		update(B2, a, v * (a - 1));
		update(B2, b + 1, -v * b);
	}

	long query(long[] ft, int b) {
		long sum = 0;
		for (int p = b; p > 0; p -= p & (-p))
			sum += ft[p];
		return sum;
	}

	long query(int a) {
		return query(B1, a) * a - query(B2, a);
	}

	long query(int a, int b) {
		return query(b) - query(a - 1);
	}
}

class HORRIBLE {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int c = in.nextInt();
			BitTree bt = new BitTree(n);
			for (int j = 0; j < c; j++) {
				int cmd = in.nextInt();
				if (cmd == 0) {
					int a = in.nextInt();
					int b = in.nextInt();
					long v = in.nextLong();
					bt.update(a, b, v);
				} else {
					int a = in.nextInt();
					int b = in.nextInt();
					pw.println(bt.query(a, b));
				}
			}
		}
	}

}


