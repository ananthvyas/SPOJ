package spoj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class GUESSTHE {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		String line = "";
		while (true) {
			line = in.readLine().trim();
			if (line.equals("*"))
				break;
			pw.println(getLCM(line.toCharArray()));
		}
	}

	static long getLCM(char[] line) {
		ArrayList<Integer> dos = new ArrayList<Integer>();
		ArrayList<Integer> donts = new ArrayList<Integer>();
		for (int i = 1; i <= line.length; i++) {
			if (line[i - 1] == 'Y')
				dos.add(i);
			else
				donts.add(i);
		}
		long lcm = multipleLCM(dos, 0, dos.size() - 1);
		boolean check = true;
		for (int num : donts) {
			if (lcm % num == 0)
				check = false;
		}
		if (!check)
			return -1;
		return lcm;
	}

	static long multipleLCM(ArrayList<Integer> nums, int from, int to) {
		if (nums.size() == 0)
			return -1;
		if (from == to)
			return nums.get(to);
		if (from == to - 1)
			return LCM(nums.get(to), nums.get(from));
		int mid = (from + to) / 2;
		return LCM(multipleLCM(nums, from, mid), multipleLCM(nums, mid + 1, to));
	}

	static long LCM(long a, long b) {
		return (a * b) / (gcd(a, b));
	}

	static long gcd(long a, long b) {
		if (a % b == 0)
			return b;
		if (b % a == 0)
			return a;
		if (a == b)
			return b;
		if (a == 1 || b == 1)
			return 1;
		if (a > b)
			return gcd(a - b, b);
		return gcd(a, b - a);
	}
}
