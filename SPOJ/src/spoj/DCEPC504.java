package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class DCEPC504 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		boolean[] bits = new boolean[6];
		bits[0] = bits[3] = bits[5] = false;
		bits[1] = bits[2] = bits[4] = true;
		Reader in = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		int num = in.nextInt();
		//pw.println(Integer.MAX_VALUE+" "+Long.MAX_VALUE);
		for (int i = 0; i < num; i++) {
			int n=in.nextInt();
			long c=(long)Math.pow(2,n-1);
			long k = in.nextLong();
			k=Math.min(c,k);
			if(getChild(n,k)){
				pw.println("Female");
			}else{
				pw.println("Male");
			}
		}
	}
	static boolean getChild(int n, long k){
		if(k==1) return false;
		boolean par=getChild(n-1, (long)Math.ceil((double)k/2.0));
		if(par){
			if(k%2==0) return false;
			return true;
		}else{
			if(k%2==0) return true;
			return false;
		}
	}
}



