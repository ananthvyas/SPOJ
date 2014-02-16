package spoj;

import java.io.IOException;
import java.io.PrintWriter;
class ZerosTree{
	int zeros;
	int from;
	int to;
	ZerosTree left;
	ZerosTree right;
	ZerosTree(int from,int to){
		this.from=from;
		this.to=to;
		zeros=to-from+1;
		if(from==to) return;
		int mid=(from+to)/2;
		left=null;
		right=null;
		if(mid>=from){
			left=new ZerosTree(from, mid);
		}
		if(mid+1<=to){
			right=new ZerosTree(mid+1, to);
		}
	}
	int getithZero(int i){
		if(i==1 && from==to){
			zeros=0;
			return from;
		}
		if(left.zeros>=i){
			zeros--;
			return left.getithZero(i);
		}
		zeros--;
		return right.getithZero(i-left.zeros);
	}
}
class ORDERS {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Reader sc = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			// Take Input here
			int size = sc.nextInt();
			int[] arr = new int[size];
			int[] lst = new int[size];

			for (int j = 0; j < size; j++) {
				arr[j] = sc.nextInt();
				lst[j]=1;
			}
			int[] res = new int[size];
			int k = size - 1;
			ZerosTree zt=new ZerosTree(1, size);
			//lst[k]=0;
			for (int j = k; j >= 0; j--) {
				res[j]=zt.getithZero(j-arr[j]+1);
			}
			for (int j = 0; j < size; j++)
				pw.print(res[j] + " ");
			pw.println();
		}
		sc.close();
	}

}

