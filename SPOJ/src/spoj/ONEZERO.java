package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class ONEZERO {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Reader sc = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			int n = sc.nextInt();
			long res = 0;
			int j=1;
			while(true) {
				long a = Long.parseLong(Integer.toBinaryString(j));
				if (a % n == 0) {
					res = a;
					break;
				}
				j++;
			}
			pw.println(res);
		}
		sc.close();
	}

}

