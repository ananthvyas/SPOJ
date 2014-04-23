package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class CANDY {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Reader sc = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		int num = sc.nextInt();
		while (num != -1) {
			int[] arr = new int[num];
			int sum = 0;
			for (int i = 0; i < num; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			if (sum % num != 0)
				pw.println("-1");
			else {
				int size = sum / num;
				int count = 0;
				for (int i = 0; i < num; i++) {
					if (arr[i] < size) {
						count += (size - arr[i]);
					}
				}
				pw.println(count);
			}
			num=sc.nextInt();
		}
		sc.close();
	}

}


