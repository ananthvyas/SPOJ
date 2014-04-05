package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class MAJOR {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		int num = in.nextInt();
		PrintWriter pw = new PrintWriter(System.out, true);
		for (int i = 0; i < num; i++) {
			int size = in.nextInt();
			int[] arr = new int[size];
			for (int j = 0; j < size; j++)
				arr[j] = in.nextInt();
			int maj = arr[0];
			int count = 1;
			for (int j = 1; j < size; j++) {
				if (arr[j] != maj) {
					if (count == 0) {
						maj = arr[j];
						count = 1;
					} else {
						count--;
					}
				} else {
					count++;
				}
			}
			int check = 0;
			for (int j = 0; j < size; j++)
				if (arr[j] == maj)
					check++;
			if (check > (size / 2))
				pw.println("YES " + maj);
			else
				pw.println("NO");
		}
	}

}
