package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class Pair {
	int max1;
	int max2;

	public Pair(int max1, int max2) {
		this.max1 = max1;
		this.max2 = max2;
	}
	public String toString() {
		return "(" + max1 + ", " + max2 + ")";
	}

	Pair compare(Pair p) {
		int max1 = this.max1;
		int max2 = this.max2;
		if (max1 < p.max1) {
			max1 = p.max1;
			if (this.max1 < p.max2)
				max2 = p.max2;
			else
				max2 = this.max1;
		} else {
			if (max2 < p.max1)
				max2 = p.max1;
		}
		return new Pair(max1, max2);
	}
}
class SegmentTree {
	int from;
	int to;
	boolean isLazy;
	int sum;
	int max1;
	int max2;
	static int[] arr;
	SegmentTree left;
	SegmentTree right;

	

	public SegmentTree(int from, int to) {
		// TODO Auto-generated constructor stub
		this.from = from;
		this.to = to;
		left = null;
		right = null;
		sum = -1;
	}

	int getSum(int begin, int end) {
		if (from >= begin && to <= end) {
			return sum;
		}
		int sum = 0;
		if (end < from)
			return 0;
		if (to < begin)
			return 0;
		sum = left.getSum(begin, end);
		sum += right.getSum(begin, end);
		return sum;
	}

	Pair getMax(int begin, int end) {
		if (begin > to)
			return new Pair(0, 0);
		if (end < from)
			return new Pair(0, 0);
		if (from >= begin && to <= end) {
			return new Pair(max1, max2);
		}
		Pair p = left.getMax(begin, end);
		Pair p2 = right.getMax(begin, end);
		// Pair p3= new Pair(max1, max2).compare(p2);
		Pair p4 = p2.compare(p);
		return p4;
	}

	void update(int index, int val) {
		if (index < from)
			return;
		if (index > to)
			return;
		if (index == from && index == to) {
			sum = val;
			max1 = val;
			max2 = 0;
			return;
		}
		left.update(index, val);
		right.update(index, val);
		Pair p = (new Pair(left.max1, left.max2)).compare(new Pair(right.max1,
				right.max2));
		max1 = p.max1;
		max2 = p.max2;
	}

	static void initialize(int[] ar) {
		arr = new int[ar.length];
		for (int i = 0; i < ar.length; i++)
			arr[i] = ar[i];
	}

	void constructTree(int from, int to) {
		if (from == to) {
			sum = arr[from];
			max1 = sum;
			max2 = 0;
			return;
		}
		int mid = (from + to) / 2;
		left = new SegmentTree(from, mid);
		right = new SegmentTree(mid + 1, to);
		left.constructTree(from, mid);
		right.constructTree(mid + 1, to);
		sum = left.sum;
		sum += right.sum;
		Pair p = new Pair(left.max1, left.max2).compare(new Pair(right.max1,
				right.max2));
		max1 = p.max1;
		max2 = p.max2;
	}
}

public class KGSS {
	private static Reader in;
	private static PrintWriter out;

	public static void main(String[] args) throws IOException {
		in = new Reader();
		out = new PrintWriter(System.out, true);
		int N = in.nextInt();
		SegmentTree a = new SegmentTree(0, N - 1);
		int[] arr = new int[N];
		for (int i = 1; i <= N; i++)
			arr[i - 1] = in.nextInt();
		SegmentTree.initialize(arr);
		a.constructTree(0, N - 1);
		int Q = in.nextInt(), s, e;
		for (int i = 0; i < Q; i++) {
			char command = in.nextChar();
			switch (command) {
			case 'Q': {
				s = in.nextInt();
				e = in.nextInt();
				Pair p = a.getMax(s - 1, e - 1);
				out.println(p.max1 + p.max2);
				break;
			}
			case 'U': {
				s = in.nextInt();
				e = in.nextInt();
				a.update(s - 1, e);
				break;
			}
			}
		}
	}
}
