package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class HOTELS {

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
		pw.println(getMaxPossible(arr, m));
		in.close();
	}

	static int getMaxPossible(int[] arr, int m) {
		int max = 0;
		int temp = 0;
		int i = 0, j = 0;
		while (j < arr.length) {
			while (temp <= m && j < arr.length) {
				temp += arr[j++];
				if (temp > max && temp <= m) {
					max = temp;
				}
			}
			while (i <= j && temp > m) {
				temp -= arr[i];
				i++;
				if (temp <= m && temp > max)
					max = temp;
			}
		}
		return max;
	}
}
