package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class AMR12D {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		int n = in.nextInt();
		PrintWriter pw = new PrintWriter(System.out, true);
		for (int i = 0; i < n; i++) {
			char[] str = in.readLine().trim().toCharArray();
			int k = 0, j = str.length - 1;
			boolean pali = true;
			while (k <= j) {
				if (str[k++] != str[j--]) {
					pali = false;
					break;
				}
			}
			if (pali)
				pw.println("YES");
			else
				pw.println("NO");
		}
	}

}
