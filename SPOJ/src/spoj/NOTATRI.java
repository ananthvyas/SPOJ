package spoj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

class NOTATRI {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		while (true) {
			int n = in.nextInt();
			if (n == 0)
				break;
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = in.nextInt();
			Arrays.sort(arr);
			int cnt = 0;
			int MAX = arr[arr.length - 1];
			int[] mem = new int[MAX + 1];
			int tmp = 0;
			int j = arr.length - 2;
			for (int i = 0; i < arr.length; i++) {
				mem[arr[i]] += 1;
			}
			for (int i = mem.length - 1; i >= 0; i--) {
				int var = tmp;
				tmp += mem[i];
				mem[i] = var;
			}
			for (int i = 0; i < arr.length - 1; i++) {
				for (j = i + 1; j < arr.length; j++) {
					if (arr[i] + arr[j] < mem.length)
						cnt += mem[arr[i] + arr[j]];
				}
			}
			pw.println(cnt);
		}
	}
}
