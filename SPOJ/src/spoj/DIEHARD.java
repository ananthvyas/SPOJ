package spoj;

import java.io.IOException;
import java.io.PrintWriter;

public class DIEHARD {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int h = in.nextInt();
			int a = in.nextInt();
			mem=new int[1100][1100][4];
			pw.println(getMaxLife(h, a, 0)-1);
		}
	}
	static int[][][] mem;
	static int getMaxLife(int h, int a, int pos) {
		if (h <= 0 || a <= 0)
			return 0;
		if(mem[h][a][pos]!=0) return mem[h][a][pos];
		int max = Integer.MIN_VALUE;
		if (pos != 1)
			max = Math.max(max, 1 + getMaxLife(h + 3, a + 2, 1));
		if (pos != 2)
			max = Math.max(max, 1 + getMaxLife(h - 5, a - 10, 2));
		if (pos != 3)
			max = Math.max(max, 1 + getMaxLife(h - 20, a + 5, 3));
		mem[h][a][pos]=max;
		return max;
	}
}
