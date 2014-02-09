package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class GNY07H {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
			
		PrintWriter pw = new PrintWriter(System.out, true);
		int num = in.nextInt();
		for (int i = 1; i <= num; i++) {
			int width = in.nextInt();
			memh = new int[width+1];	
			memf = new int[width+1];	
			memg = new int[width+1];	
			memi = new int[width+1];	
			memj = new int[width+1];
			int res = f(width);
			pw.println(i + " " + res);
		}
	}

	static int[] memh;
	static int[] memi;
	static int[] memf;
	static int[] memg;
	static int[] memj;
	static int h(int width){
		if(width<0) return 0;
		if(memh[width]!=0) return memh[width];
		
		if(width==0) return 1;
		memh[width]= f(width)+h(width-1);
		return memh[width];
	}
	static int f(int width){
		if(width<0) return 0;
		if(memf[width]!=0) return memf[width];
		if(width==0) return 1;
		memf[width]= h(width-1)+g(width-2);
		return memf[width];
	}
	static int g(int width) {
		if(width<0) return 0;
		if(memg[width]!=0) return memg[width];
		//if(width<0) return 0;
		//if(width==0) return 1;
		memg[width]= i(width)+j(width);
		return memg[width];
	}
	static int i(int width){
		if(width<0) return 0;
		if(memi[width]!=0) return memi[width];
		//if(width<0) return 0;
		//if(width==0) return 1;
		memi[width]= f(width)+i(width-2);
		return memi[width];
	}
	static int j(int width){
		if(width<0) return 0;
		if(memj[width]!=0) return memj[width];
		//if(width<0) return 0;
		//if(width==0) return 1;
		memj[width]= h(width)+f(width);
		return memj[width];
	}
}
