package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class ANARC05H {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out, true);
		String num = sc.readLine();
		int i = 1;
		while (!num.equals("bye")) {
			// Take Input here
			try {
				char[] str = num.toCharArray();
				pw.println((i++) + ". " + getPossibilities(str, 0, 0, 0));
				num = sc.readLine();
			} catch (Exception e) {
				break;
			}
		}
		sc.close();
	}

	static int getPossibilities(char[] str, int index, int prev, int curr) {
		if (index == str.length) {
			if (curr >= prev)
				return 1;
			else
				return 0;
		}
		if (curr < prev || index == 0) {
			return getPossibilities(str, index + 1, prev, curr + str[index]
					- 48);
		}
		return getPossibilities(str, index + 1, curr, str[index] - 48)
				+ getPossibilities(str, index + 1, prev, curr + str[index] - 48);
	}
}

