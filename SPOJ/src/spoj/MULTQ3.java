package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class SegTree {
	int from;
	int to;
	int mod;
	int divcount;
	SegTree left;
	SegTree right;
	int lazycount=0;

	public SegTree(int from, int to) {
		// TODO Auto-generated constructor stub
		this.from = from;
		this.to = to;
		left = null;
		right = null;
		divcount = 1;
		mod = 0;
		constructTree(from, to);
	}

	int getDivCount(int begin, int end) {
		if (from >= begin && to <= end) {
			if(lazycount>0){
				
			}
			return divcount;
		}
		int sum = 0;
		if (end < from)
			return 0;
		if (to < begin)
			return 0;
		sum = left.getDivCount(begin, end);
		sum += right.getDivCount(begin, end);
		return sum;
	}

	void update(int from, int to) {
		if (this.from > to)
			return;
		if (this.to < from)
			return;
		if (this.from == this.to) {
			mod = (mod + 1) % 3;
			if (mod == 0)
				divcount = 1;
			else
				divcount = 0;
			return;
		}
		left.update(from, to);
		right.update(from, to);
		divcount = left.divcount + right.divcount;
	}

	void constructTree(int from, int to) {
		if (from == to) {
			mod = 0;
			divcount = 1;
			return;
		}
		int mid = (from + to) / 2;
		left = new SegTree(from, mid);
		right = new SegTree(mid + 1, to);
		left.constructTree(from, mid);
		right.constructTree(mid + 1, to);
		divcount = left.divcount + right.divcount;
	}
}

public class MULTQ3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		//Scanner in=new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out, true);
		int N = in.nextInt();
		int Q = in.nextInt();
		SegTree st = new SegTree(0, N - 1);
		for (int i = 0; i < Q; i++) {
			int q = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			if (q == 0) {
				st.update(a, b);
			} else {
				pw.println(st.getDivCount(a, b));
			}
		}
	}
}

