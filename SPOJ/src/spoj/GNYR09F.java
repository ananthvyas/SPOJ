package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class GNYR09F {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Reader sc = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			// Take Input here
			int casenum = sc.nextInt();
			int len = sc.nextInt();
			int ones = sc.nextInt();
			mem = new int[len + 1][ones + 1][2];
			for (int j = 0; j <= len; j++) {
				for (int h = 0; h <= ones; h++)
					for (int k = 0; k < 2; k++)
						mem[j][h][k] = -1;
			}
			pw.println(casenum + " " + getPossible(len, 0, ones, false));
		}
		sc.close();
	}

	static int[][][] mem;

	static int getPossible(int len, int curr, int ones, boolean isOne) {
		int chk = 0;
		if (isOne)
			chk = 1;
		if (len < (ones - curr))
			return 0;
		if (curr > ones)
			return 0;
		if (len == 0) {
			if (curr == ones)
				return 1;
			return 0;
		}
		if (mem[len][curr][chk] != -1)
			return mem[len][curr][chk];
		if (isOne) {
			mem[len][curr][chk] = getPossible(len - 1, curr + 1, ones, isOne)
					+ getPossible(len - 1, curr, ones, !isOne);
			return mem[len][curr][chk];
		} else {
			mem[len][curr][chk] = getPossible(len - 1, curr, ones, isOne)
					+ getPossible(len - 1, curr, ones, !isOne);
			return mem[len][curr][chk];
		}
	}
}

