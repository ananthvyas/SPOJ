package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class STREETR {
	static long multipleGCD(long[] nums, int from, int to) {
		if (nums.length == 0)
			return -1;
		if (from == to)
			return nums[(to)];
		if (from == to - 1)
			return gcd(nums[(to)], nums[(from)]);
		int mid = (from + to) / 2;
		return gcd(multipleGCD(nums, from, mid), multipleGCD(nums, mid + 1, to));
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

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Reader in = new Reader();
		// Scanner in = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out, true);
		int n = 0;
		long[] diff;
		long[] arr = null;
		long gcd = 0;

		n = in.nextInt();

		diff = new long[n - 1];
		arr = new long[n];

		for (int i = 0; i < n; i++) {
			arr[i] = in.nextLong();
		}

		for (int i = 1; i < n; i++) {
			diff[i - 1] = arr[i] - arr[i - 1];
		}

		gcd = multipleGCD(diff, 0, n - 2);

		if (arr != null) {
			int i = 1;
			long k = arr[0];
			int cnt = 0;
			while (i < arr.length) {
				if (k + gcd != arr[i]) {
					cnt++;
					k += gcd;
				} else {
					k = arr[i];
					i++;
				}
			}
			pw.println(cnt);
		}
	}
}
