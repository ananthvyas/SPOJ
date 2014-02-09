package spoj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class PairR {
	int pathlen;
	int cost;

	public String toString() {
		return "(" + pathlen + ", " + cost + ")";
	}
}

class Node {
	int id;
	ArrayList<Node> nbrs;
	ArrayList<Integer> toll;
	ArrayList<Integer> length;
	static int[] tollseen;
	static int[] minseen;

	Node(int id) {
		this.id = id;
		nbrs = new ArrayList<Node>();
		toll = new ArrayList<Integer>();
		length = new ArrayList<Integer>();
	}

	void addNbr(Node nbr, int toll, int length) {
		if (nbr.id == this.id)
			return;
		nbrs.add(nbr);
		this.toll.add(toll);
		this.length.add(length);
	}

	static HashMap<Integer, ArrayList<PairR>> mem = new HashMap<Integer, ArrayList<PairR>>();

	ArrayList<PairR> getPath(int avail, int n, ArrayList<Integer> path) {
		if (n == id) {
			PairR p = new PairR();
			p.cost = 0;
			p.pathlen = 0;
			ArrayList<PairR> alp = new ArrayList<PairR>();
			alp.add(p);
			return alp;
		}
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		tmp.addAll(path);
		tmp.add(id);
		ArrayList<PairR> res = new ArrayList<PairR>();
		for (int i = 0; i < nbrs.size(); i++) {
			if (!path.contains(nbrs.get(i).id)) {
				if (mem.keySet().contains(nbrs.get(i).id)) {
					ArrayList<PairR> p = mem.get(nbrs.get(i).id);
					for (int j = 0; j < p.size(); j++) {
						PairR pr = new PairR();
						pr.cost = p.get(j).cost;
						pr.pathlen = p.get(j).pathlen;
						pr.pathlen += length.get(i);
						pr.cost += toll.get(i);
						res.add(pr);
					}
				} else {
					ArrayList<PairR> p = nbrs.get(i).getPath(avail, n, tmp);
					for (int j = 0; j < p.size(); j++) {
						PairR pr = new PairR();
						pr.cost = p.get(j).cost;
						pr.pathlen = p.get(j).pathlen;
						pr.pathlen += length.get(i);
						pr.cost += toll.get(i);
						if (pr.cost <= avail)
							res.add(pr);
					}
				}
			}
		}
		mem.put(id, res);
		return res;
	}
}

public class ROADS {
	public static void main(String[] args) {
		HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt() - 1;
			int r = sc.nextInt();
			Node.tollseen = new int[n + 1];
			Node.minseen = new int[n + 1];
			for (int j = 0; j < r; j++) {
				int from = sc.nextInt() - 1;
				int to = sc.nextInt() - 1;
				int len = sc.nextInt();
				int toll = sc.nextInt();
				Node fro;
				Node ton;
				if (!nodes.keySet().contains(from)) {
					Node tmp = new Node(from);
					nodes.put(from, tmp);
				}
				if (!nodes.keySet().contains(to)) {
					Node tmp = new Node(to);
					nodes.put(to, tmp);
				}
				fro = nodes.get(from);
				ton = nodes.get(to);
				fro.addNbr(ton, toll, len);
				// ton.addNbr(fro, toll, len);
			}
			ArrayList<Integer> path = new ArrayList<Integer>();
			ArrayList<PairR> pr = nodes.get(0).getPath(k, n, path);
			// System.out.println(pr);
			System.out.println(getMinimum(pr, k));
			Node.mem = new HashMap<Integer, ArrayList<PairR>>();
		}
		sc.close();

	}

	static int getMinimum(ArrayList<PairR> p, int k) {
		int min = Integer.MAX_VALUE;
		for (PairR pr : p) {
			if (pr.cost <= k && pr.pathlen < min) {
				min = pr.pathlen;
			}
		}
		if (min == Integer.MAX_VALUE)
			return -1;
		return min;
	}

}
