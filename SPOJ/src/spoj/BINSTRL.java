package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class BINSTRL {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		int d = in.nextInt();
		PrintWriter pw = new PrintWriter(System.out, true);
		//System.out.println(Integer.MAX_VALUE);
		for (int i = 0; i < d; i++) {
			int n = in.nextInt();
			int m = in.nextInt();
			//mem=new long[n+1][m+1];
			//pw.print(sterlingnum(n, m)+" ");
			if(((n-m)&((m-1)/2))==0) pw.println("1");
			else pw.println("0");
		}
	}
}


