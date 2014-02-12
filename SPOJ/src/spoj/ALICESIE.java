package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class ALICESIE {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		int num = in.nextInt();
		for (int i = 0; i < num; i++) {
			int n = in.nextInt();
			pw.println(n - (n / 2));
		}
		in.close();
	}

}

