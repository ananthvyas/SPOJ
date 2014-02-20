package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class RABBIT1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		int num = in.nextInt();
		PrintWriter pw = new PrintWriter(System.out, true);
		for (int i = 0; i < num; i++) {
			int n = in.nextInt();
			int m = (int) Math.pow(2, in.nextInt());
			pw.println(getFib(n, m));
		}
	}

	static long[][] multiplyMatrix(long[][] a, long[][] b, int m) {
		long[][] c = new long[2][2];
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				for (int k = 0; k < 2; k++)
					c[i][j] = (c[i][j] + (a[i][k] * b[k][j])) % m;
		return c;
	}

	static long[][] powMatrix(long[][] a, int p, int m) {
		if (p == 1)
			return a;
		if (p % 2 == 1)
			return multiplyMatrix(a, powMatrix(a, p - 1, m), m);
		int mid = p / 2;
		long[][] res = powMatrix(a, mid, m);
		return multiplyMatrix(res, res, m);
	}

	static long getFib(int n, int m) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2 % m;
		int[] vect = new int[2];
		vect[0] = 1;
		vect[1] = 2;
		long[][] mat = new long[2][2];
		mat[0][0] = 0;
		mat[0][1] = 1;
		mat[1][0] = 1;
		mat[1][1] = 1;
		long[][] res = powMatrix(mat, n, m);
		return res[1][1];
	}
}


