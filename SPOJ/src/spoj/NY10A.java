package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class NY10A {
	static int countSubstring(String subStr, String str) {
		return (str.length() - str.replace(subStr, "").length())
				/ subStr.length();
	}

	public static void main(String[] args) throws IOException {
		Reader in = new spoj.Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		int n = in.nextInt();
		String[] seqs = { "TTT", "TTH", "THT", "THH", "HTT", "HTH", "HHT",
				"HHH" };
		for (int i = 0; i < n; i++) {
			int ds = in.nextInt();
			char[] seq = in.readLine().toCharArray();
			pw.print(ds);
			for (String str : seqs) {
				int count = 0;
				char[] s = str.toCharArray();
				for (int j = 0; j < seq.length - s.length + 1; j++) {
					boolean check = true;
					for (int k = 0; k < s.length; k++) {
						if (s[k] != seq[j + k])
							check = false;
					}
					if (check)
						count++;
				}
				pw.print(" " + count);
			}
			pw.println();
		}
	}

}
