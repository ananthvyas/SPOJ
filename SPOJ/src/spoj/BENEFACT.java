package spoj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;





class BENEFACT {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Reader sc = new Reader();
		int num = sc.nextInt();
		PrintWriter pw = new PrintWriter(System.out, true);
		for (int i = 0; i < num; i++) {
			int nodes = sc.nextInt();
			ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
			for (int j = 0; j < nodes; j++) {
				graph.add(new ArrayList<Edge>());
			}
			for (int j = 0; j < nodes - 1; j++) {
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				int c = sc.nextInt();
				graph.get(a).add(new Edge(b, c));
				graph.get(b).add(new Edge(a, c));
			}
			Edge e = getDiameter(graph, 0, -1);
			pw.println(e.weight);
		}
		sc.close();
	}

	static class Pair {
		Edge e;
		int weight;

		Pair(Edge e, int weight) {
			this.e = e;
			this.weight = weight;
		}
	}

	static Edge getDiameter(ArrayList<ArrayList<Edge>> graph, int root, int prev) {
		ArrayList<Pair> res = new ArrayList<Pair>();
		for (Edge e : graph.get(root)) {
			if (e.to != prev) {
				res.add(new Pair(getDiameter(graph, e.to, root), e.weight));
			}
		}
		if (res.size() == 0)
			return new Edge(0, 0);
		if (res.size() == 1) {
			Pair p = res.get(0);
			Edge e = p.e;
			int weight = p.weight;
			if (e.weight < e.to + weight)
				return new Edge(e.to + weight, e.to + weight);
			else
				return new Edge(e.to + weight, e.weight);
		}
		int dia = -1;
		int height1 = -1;
		int height2 = -1;
		for (Pair p : res) {
			if (p.e.to + p.weight > height2) {
				if (p.e.to + p.weight > height1) {
					height2 = height1;
					height1 = p.e.to + p.weight;
				} else
					height2 = p.e.to + p.weight;
			}
			if (p.e.weight > dia)
				dia = p.e.weight;
		}
		if (dia < height1 + height2)
			dia = height1 + height2;
		return new Edge(height1, dia);
	}
}
