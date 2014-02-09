package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class ACPC10D {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		int c = 1;
		while (true) {
			int n = in.nextInt();
			if (n == 0)
				break;
			int[][] mat = new int[n][3];
			mem = new long[n][3];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 3; j++) {
					mat[i][j] = in.nextInt();
				}
			}
			pw.println((c++) + ". " + getShortest(mat, 0, 1));
		}
	}

	static long[][] mem;

	static long getShortest(int[][] mat, int i, int j) {
		if (mem[i][j] != 0)
			return mem[i][j];
		if (i == mat.length - 1 && j == 1)
			return mat[i][j];
		long min = 10000000;
		if (i < mat.length - 1)
			min = Math.min(min, mat[i][j] + getShortest(mat, i + 1, j));
		if (j < 2)
			min = Math.min(min, mat[i][j] + getShortest(mat, i, j + 1));
		if (i < mat.length - 1 && j < 2)
			min = Math.min(min, mat[i][j] + getShortest(mat, i + 1, j + 1));
		if (i < mat.length - 1 && j > 0)
			min = Math.min(min, mat[i][j] + getShortest(mat, i + 1, j - 1));
		mem[i][j] = min;
		return min;
	}
}
