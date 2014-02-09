package spoj;

import java.util.Arrays;
import java.util.Scanner;

public class CHOCOLA {

	static int[][] mem;

	static int getMinimum(int[] hor, int[] vert, int x, int y, int i, int j) {
		if (mem[i + 1][j + 1] != -1)
			return mem[i + 1][j + 1];
		if (x == hor.length + 1) {
			int res = 0;
			for (int k = 0; k <= j; k++) {
				res += (vert[k] * x);
			}
			mem[i + 1][j + 1] = res;
			return res;
		}
		if (y == vert.length + 1) {
			int res = 0;
			for (int k = 0; k <= i; k++) {
				res += (hor[k] * y);
			}
			mem[i + 1][j + 1] = res;
			return res;
		}
		int xmax = hor[i];
		int ymax = vert[j];
		mem[i + 1][j + 1] = Math.min(
				xmax * y + getMinimum(hor, vert, x + 1, y, i - 1, j), ymax * x
						+ getMinimum(hor, vert, x, y + 1, i, j - 1));
		return mem[i + 1][j + 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int[] hor = new int[m - 1];
			int[] vert = new int[n - 1];
			for (int j = 0; j < m - 1; j++)
				hor[j] = sc.nextInt();
			for (int j = 0; j < n - 1; j++)
				vert[j] = sc.nextInt();
			mem = new int[m][n];
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < n; k++)
					mem[j][k] = -1;
			}
			Arrays.sort(hor);
			Arrays.sort(vert);
			System.out.println(getMinimum(hor, vert, 1, 1, m - 2, n - 2));
		}
		sc.close();
	}

}
