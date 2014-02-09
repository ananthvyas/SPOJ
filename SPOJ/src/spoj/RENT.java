package spoj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Order {
	int begin;
	int end;
	int weight;

	Order(int a, int b, int c) {
		begin = a;
		end = a + b;
		weight = c;
	}

	public String toString() {
		return "(" + begin + ", " + end + ", " + weight + ")";
	}
}

class RENT {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Order> orders = new ArrayList<Order>();
		Reader in = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		int num = in.nextInt();
		for (int i = 0; i < num; i++) {
			orders = new ArrayList<Order>();
			int tot = in.nextInt();
			int[] sum = new int[tot];
			for (int j = 0; j < tot; j++) {
				int a = in.nextInt();
				int b = in.nextInt();
				int c = in.nextInt();
				Order o = new Order(a, b, c);
				orders.add(o);
			}
			Collections.sort(orders, new Comparator<Order>() {

				@Override
				public int compare(Order o1, Order o2) {
					if (o1.begin < o2.begin)
						return -1;
					if (o1.begin > o2.begin)
						return 1;
					if (o1.end < o2.end)
						return -1;
					if (o1.end > o2.end)
						return 1;
					return 0;
				}

			});
			int[] begin = new int[tot];
			int[] end = new int[tot];
			int[] weights = new int[tot];
			int ind = 0;
			for (Order o : orders) {
				begin[ind] = o.begin;
				end[ind] = o.end;
				weights[ind] = o.weight;
				ind++;
			}
			// pw.println(orders);
			sum[orders.size() - 1] = orders.get(tot - 1).weight;
			for (int k = orders.size() - 2; k >= 0; k--) {
				ind = binarySearch(begin, k + 1, tot - 1, end[k]);
				if (ind != -1)
					sum[k] = Math.max(weights[k] + sum[ind], sum[k + 1]);
				else
					sum[k] = Math.max(weights[k], sum[k + 1]);
			}
			// for (int n : sum)
			// pw.print(n + " ");
			pw.println(sum[0]);
		}
	}

	static int binarySearch(int[] arr, int from, int to, int key) {
		if (from > to)
			return -1;
		if (from == to) {
			if (arr[from] > key)
				return from;
			return -1;
		}
		int mid = (from + to) / 2;
		if (arr[mid] > key && arr[mid - 1] <= key)
			return mid;
		if (arr[mid] <= key)
			return binarySearch(arr, mid + 1, to, key);
		return binarySearch(arr, from, mid - 1, key);
	}
}
