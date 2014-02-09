package spoj;

import java.util.Scanner;

public class AIBHOP {
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

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		for (int k = 0; k < num; k++) {
			try {
				String s = sc.nextLine();
				mem = new int[s.length()][s.length()];
				for (int i = 0; i < s.length(); i++) {
					for (int j = 0; j < s.length(); j++)
						mem[i][j] = -1;
				}
				System.out.println(getMinforPal(s.toCharArray(), 0,
						s.length() - 1, 0));
			} catch (Exception e) {

			}
		}
		sc.close();
	}

}
