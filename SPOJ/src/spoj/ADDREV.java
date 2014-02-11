package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class ADDREV {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Reader sc = new Reader();
		int num = sc.nextInt();
		PrintWriter pw = new PrintWriter(System.out, true);
		for (int i = 0; i < num; i++) {
			char[] first = ("" + sc.nextInt()).toCharArray();
			char[] second = ("" + sc.nextInt()).toCharArray();
			int j = 0, k = first.length - 1;
			while (j <= k) {
				char tmp = first[j];
				first[j] = first[k];
				first[k] = tmp;
				j++;
				k--;
			}
			j = 0;
			k = second.length - 1;
			while (j <= k) {
				char tmp = second[j];
				second[j] = second[k];
				second[k] = tmp;
				j++;
				k--;
			}
			char[] res = ("" + (Integer.parseInt(new String(first)) + Integer
					.parseInt(new String(second)))).toCharArray();
			j = 0;
			k = res.length - 1;
			while (j <= k) {
				char tmp = res[j];
				res[j] = res[k];
				res[k] = tmp;
				j++;
				k--;
			}
			pw.println(Integer.parseInt(new String(res)));
		}
		sc.close();
	}

}


