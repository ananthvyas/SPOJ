package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class POUR1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			pw.println(getSteps(a, b, 0, 0, c));
		}
	}

	static int getSteps(int afull, int bfull, int a, int b, int c) {
		if (a == c || b == c)
			return 0;
		int min = Integer.MAX_VALUE;
		if (a != 0)
			min = Math.min(min, 1 + getSteps(afull, bfull, 0, b, c));
		if (b != 0)
			min = Math.min(min, 1 + getSteps(afull, bfull, a, 0, c));
		if (a != afull)
			min = Math.min(min, 1 + getSteps(afull, bfull, afull, b, c));
		if (b != bfull)
			min = Math.min(min, 1 + getSteps(afull, bfull, a, bfull, c));
		if (a != 0)
			min = Math.min(min,
					1 + getSteps(afull, bfull, 0, Math.min(b + a, bfull), c));
		if (b != 0)
			min = Math.min(min,
					1 + getSteps(afull, bfull, Math.min(b + a, afull), 0, c));
		return min;
	}
}
