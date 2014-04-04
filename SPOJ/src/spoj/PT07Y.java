package spoj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class PT07Y {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Reader sc = new Reader();
		int num = sc.nextInt();
		int edg = sc.nextInt();
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		for (int i = 1; i <= num; i++) {
			ArrayList<Integer> lst = new ArrayList<Integer>();
			adj.add(lst);
		}
		for (int i = 0; i < edg; i++) {
			// Take Input here
			int from = sc.nextInt();
			int to = sc.nextInt();
			adj.get(from - 1).add(to - 1);
			adj.get(to - 1).add(from - 1);
		}

		PrintWriter pw = new PrintWriter(System.out, true);
		if (isTree(adj, 0, -1) && visited.size() == num)
			pw.println("YES");
		else
			pw.println("NO");
		sc.close();
	}

	static HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

	static boolean isTree(ArrayList<ArrayList<Integer>> adj, int root,
			int parent) {
		List<Integer> nbrs = adj.get(root);
		visited.put(root, true);
		boolean check = true;
		for (int nbr : nbrs) {
			if (nbr == root)
				return false;
			if (nbr != parent) {
				if (visited.keySet().contains(nbr))
					return false;
				check = check & isTree(adj, nbr, root);
			}
		}
		return check;
	}
}

