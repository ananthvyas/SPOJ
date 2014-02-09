package spoj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class Graph {
	ArrayList<Graph> children;
	int id;

	Graph(int id) {
		children = new ArrayList<Graph>();
		this.id = id;
	}

	void addChild(Graph chld) {
		children.add(chld);
	}
}

class Tree {
	Tree left;
	Tree right;
	Tree parent;
	int id;

	Tree() {
		left = null;
		right = null;
		parent = null;
	}

	void addParent(Tree p) {
		this.parent = p;
	}

	void addChild(Tree tr) {
		if (left == null) {
			left = tr;
		} else {
			right = tr;
		}
	}
}

class PT07Z {
	static Pair getDiamater(Graph graph, int prev) {
		if (graph.children.size() == 1 && graph.children.get(0).id == prev) {
			return new Pair(0, 0);
		}
		int height = 0;
		int dia = 0;
		int[] dias = new int[graph.children.size()];
		int[] heights = new int[graph.children.size()];
		int i = 0;
		for (Graph chld : graph.children) {
			if (chld.id != prev) {
				Pair p = getDiamater(chld, graph.id);
				heights[i] = 1 + p.max1;
				dias[i++] = p.max2;
			}
		}

		Arrays.sort(dias);
		Arrays.sort(heights);
		height = heights[heights.length - 1];
		if (heights.length > 1)
			dia = heights[heights.length - 1] + heights[heights.length - 2];
		else
			dia = heights[heights.length - 1];
		dia = Math.max(dia, dias[dias.length - 1]);
		return new Pair(height, dia);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		ArrayList<Graph> graph = new ArrayList<Graph>();
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			Graph g = new Graph(i + 1);
			graph.add(g);
		}
		for (int i = 0; i < n - 1; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			graph.get(from - 1).addChild(graph.get(to - 1));
			graph.get(to - 1).addChild(graph.get(from - 1));
		}
		System.out.println(getDiamater(graph.get(0), -1).max2);
	}

}
