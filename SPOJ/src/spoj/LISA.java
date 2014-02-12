package spoj;
import java.util.Scanner;

public class LISA {
	static long[][] memmin;
	static long[][] memmax;

	static boolean containsDigits(char[] exp, int i, int j) {
		for (int k = i; k <= j; k++) {
			if (!Character.isDigit(exp[k]))
				return false;
		}
		return true;
	}

	static long getMax(char[] exp, int i, int j) {
		if (memmax[i][j] != -1)
			return memmax[i][j];
		if (containsDigits(exp, i, j)) {
			String s = "";
			for (int k = i; k <= j; k++)
				s += exp[k];
			memmax[i][j] = Long.parseLong(s);
			return memmax[i][j];
		}
		long res = Integer.MIN_VALUE;
		int k = i;
		for (k = i; k <= j; k++) {
			if (exp[k] == '*') {
				res = Math.max(res,
						getMax(exp, i, k - 1) * getMax(exp, k + 1, j));
			}
			if (exp[k] == '+') {
				res = Math.max(res,
						getMax(exp, i, k - 1) + getMax(exp, k + 1, j));
			}
		}
		memmax[i][j] = res;
		return res;
	}

	static long getMin(char[] exp, int i, int j) {
		if (memmin[i][j] != -1)
			return memmin[i][j];
		if (containsDigits(exp, i, j)) {
			String s = "";
			for (int k = i; k <= j; k++)
				s += exp[k];
			memmin[i][j] = Long.parseLong(s);
			return memmin[i][j];
		}
		long res = Long.MAX_VALUE;
		int k = i;
		for (k = i; k <= j; k++) {
			if (exp[k] == '*') {
				res = Math.min(res,
						getMin(exp, i, k - 1) * getMin(exp, k + 1, j));
			}
			if (exp[k] == '+') {
				res = Math.min(res,
						getMin(exp, i, k - 1) + getMin(exp, k + 1, j));
			}
		}
		memmin[i][j] = res;
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			String exp = sc.next();
			memmax = new long[exp.length()][exp.length()];
			memmin = new long[exp.length()][exp.length()];
			for (int j = 0; j < exp.length(); j++) {
				for (int k = 0; k < exp.length(); k++) {
					memmax[j][k] = memmin[j][k] = -1;
				}
			}
			System.out.println(getMax(exp.toCharArray(), 0, exp.length() - 1)
					+ " " + getMin(exp.toCharArray(), 0, exp.length() - 1));
		}
		sc.close();
	}

}
