package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class FCTRL {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Reader sc = new Reader();
		PrintWriter pw=new PrintWriter(System.out, true);
		int n = sc.nextInt();
		int[] lookup=new int[15];
		int temp=5;
		//System.out.println(Math.pow(5,15));
		for(int i=0;i<15;i++){
			lookup[i]=temp;
			temp=temp*5;
		}
		for (int i = 0; i < n; i++) {
			int num=sc.nextInt();
			int count=0;
			int mul=5;
			int div=num/mul;
			int j=1;
			while(div!=0){
				count+=div;
				div=num/lookup[j];
				j++;
			}
			pw.println(count);
		}
		sc.close();
	}

}

