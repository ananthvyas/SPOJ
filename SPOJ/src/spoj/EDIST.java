package spoj;

import java.util.Scanner;

public class EDIST {
	static int[][] mem;

	static int getEditDistance(char[] s1, int i, char[] s2, int j) {
		if (mem[i][j] != -1)
			return mem[i][j];
		if (i == s1.length){
			mem[i][j]=s2.length - j;
			return s2.length - j;
		}
		if (j == s2.length){
			mem[i][j]=s1.length - i;
			return s1.length - i;
		}
		if (s1[i] == s2[j]) {
			mem[i][j] = getEditDistance(s1, i + 1, s2, j + 1);
			return mem[i][j];
		}
		mem[i][j] = Math.min(1 + getEditDistance(s1, i + 1, s2, j + 1), Math
				.min(1 + getEditDistance(s1, i, s2, j + 1),
						1 + getEditDistance(s1, i + 1, s2, j)));
		return mem[i][j];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < num; i++) {
			String a = sc.nextLine();
			String b = sc.nextLine();
			mem = new int[a.length()+1][b.length()+1];
			for (int j = 0; j <= a.length(); j++)
				for (int k = 0; k <= b.length(); k++)
					mem[j][k] = -1;
			System.out.println(getEditDistance(a.toCharArray(), 0,
					b.toCharArray(), 0));

		}
		sc.close();
	}
}
