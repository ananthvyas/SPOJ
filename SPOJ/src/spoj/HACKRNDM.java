package spoj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

class HACKRNDM {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		int num = in.nextInt();
		int m = in.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = in.nextInt();
		}
		pw.println(getNumPairs(arr, m));
		in.close();
	}

	static long getNumPairs(int[] arr, int m) {
		Arrays.sort(arr);
		int i = 0, j = 1;
		long cnt = 0;
		while (j < arr.length) {
			if (arr[j] - arr[i] == m) {
				cnt++;
				i++;
			} else if (arr[j] - arr[i] < m) {
				j++;
			} else if (arr[j] - arr[i] > m) {
				i++;
			}
		}
		return cnt;
	}
}

