package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class RPLC {
	public static void main(String[] args) throws IOException {
		Reader in = new Reader();
		int n = in.nextInt();
		PrintWriter pw = new PrintWriter(System.out, true);
		for (int i = 0; i < n; i++) {
			int k = in.nextInt();
			int[] arr = new int[k];
			for (int j = 0; j < k; j++) {
				arr[j] = in.nextInt();
			}
			pw.println("Scenario #" + (i + 1) + ": " + getWaitTime(arr));
		}
	}

	static long getWaitTime(int[] arr) {
		long min = Integer.MAX_VALUE;
		long seen = 0;
		for (int i = 0; i < arr.length; i++) {
			seen += arr[i];
			if (seen < min)
				min = seen;
		}
		if (min < 0)
			return -(min - 1);
		else
			return 1;
	}
}


