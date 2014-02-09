package spoj;

import java.io.IOException;

class AIBOHP {
	static int[][] mem;

	static int getMinforPal(char[] str, int i, int j, int curr) {
		if (mem[i][j] != -1)
			return mem[i][j];
		if (i >= j) {
			return curr;
		}
		if (str[i] == str[j]) {
			mem[i][j] = getMinforPal(str, i + 1, j - 1, curr);
			return mem[i][j];
		} else {
			mem[i][j] = Math.min(getMinforPal(str, i + 1, j, curr + 1),
					getMinforPal(str, i, j - 1, curr + 1));
			return mem[i][j];
		}
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		Reader sc = new Reader();
		int num = Integer.parseInt(sc.readLine());
		for (int k = 0; k < num; k++) {

			String s = sc.readLine();
			mem = new int[s.length()][s.length()];
			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < s.length(); j++)
					mem[i][j] = -1;
			}
			System.out.println(getMinforPal(s.toCharArray(), 0, s.length() - 1,
					0));

		}
		sc.close();
	}

}


