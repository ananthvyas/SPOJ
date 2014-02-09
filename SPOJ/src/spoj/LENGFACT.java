package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class LENGFACT {
	static double PI = 3.14159265358979323;
	static double E = 2.71828182845904523536;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			long num = in.nextLong();
			pw.println(getFactLen(num));
		}
	}

	static long getFactLen(long num) {
		// if(num==1) return 1;
		long res = (long) (((Math.log(2 * num * PI) / 2.0) + num
				* (Math.log(num) - Math.log(E))) / Math.log(10)) + 1;
		return res;
	}
}
