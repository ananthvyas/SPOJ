package spoj;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;

class CANDYDIST {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		while (true) {
			int n = in.nextInt();
			if (n == 0)
				break;
			int[] arr = new int[n];
			int[] val = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = in.nextInt();
			for (int i = 0; i < n; i++)
				val[i] = in.nextInt();
			Arrays.sort(arr);
			Arrays.sort(val);
			BigInteger cnt = new BigInteger("0");
			for (int i = 0; i < n; i++){
				BigInteger one=new BigInteger(""+arr[i]);
				BigInteger two=new BigInteger(""+val[n-i-1]);
				cnt=cnt.add(one.multiply(two));
			}
			pw.println(cnt);
		}
	}

}


