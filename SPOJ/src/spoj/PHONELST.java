package spoj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

class PHONELST {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			String[] phones = new String[num];
			for (int j = 0; j < num; j++) {
				phones[j] = in.readLine();
			}
			Arrays.sort(phones);
			boolean check = true;
			for (int j = 0; j < num - 1; j++) {
				if (phones[j + 1].startsWith(phones[j])) {
					check = false;
					break;
				}
			}
			if (check)
				pw.println("YES");
			else
				pw.println("NO");
		}
	}

}
