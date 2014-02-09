package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class SQRBR {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		int num = in.nextInt();
		PrintWriter pw = new PrintWriter(System.out, true);
		for (int i = 0; i < num; i++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[] arr = new int[k];
			for (int j = 0; j < k; j++) {
				arr[j] = in.nextInt();
			}
			mem = new int[2 * n][2 * n + 1];
			for (int j = 0; j < 2 * n; j++) {
				for (int p = 0; p <= 2 * n; p++)
					mem[j][p] = -1;
			}
			pw.println(getCount(arr, 0, 2 * n, 0, 1));
		}
	}

	static int[][] mem;

	static int getCount(int[] arr, int i, int n, int count, int seen) {
		if (count < 0)
			return 0;
		if (seen > n) {
			if (count == 0)
				return 1;
			return 0;
		}
		if (mem[count][seen] != -1)
			return mem[count][seen];

		if (i < arr.length)
			if (seen == arr[i]) {
				mem[count][seen] = getCount(arr, i + 1, n, count + 1, seen + 1);
				return mem[count][seen];
			}
		mem[count][seen] = getCount(arr, i, n, count + 1, seen + 1)
				+ getCount(arr, i, n, count - 1, seen + 1);
		return mem[count][seen];
	}
}
