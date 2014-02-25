package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class SHAHBG {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Reader sc = new Reader();
		int num = sc.nextInt();
		boolean[] hands = new boolean[20000];
		PrintWriter pw = new PrintWriter(System.out, true);
		int cnt = 0;
		for (int i = 0; i < num; i++) {
			int n = sc.nextInt();
			boolean left = false;
			boolean right = false;
			if (n - 2 >= 0)
				left = hands[n - 2];
			if (n < 20000)
				right = hands[n];
			hands[n - 1] = true;
			if (left == false && right == false)
				cnt++;
			else if (left == true && right == true)
				cnt--;
			pw.println(cnt);
		}
		pw.println("Justice");
		sc.close();
	}

}


