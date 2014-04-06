package spoj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Vertex implements Comparable<Vertex> {
	int distance;
	int id;

	Vertex(int id, int distance) {
		this.distance = distance;
		this.id = id;
	}

	@Override
	public int compareTo(Vertex v1) {
		// TODO Auto-generated method stub

		if (v1.distance < distance)
			return 1;
		if (v1.distance > distance)
			return -1;
		return 0;

	}
}

class Edge {
	int to;
	int weight;

	Edge(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
}

class MICEMAZE {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Reader sc = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		int num = sc.nextInt();
		int exit = sc.nextInt() - 1;
		int time = sc.nextInt();
		ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
		for (int j = 0; j < num; j++) {
			graph.add(new ArrayList<Edge>());
		}
		int m = sc.nextInt();

		for (int j = 0; j < m; j++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt();
			graph.get(a).add(new Edge(b, c));
			graph.get(b).add(new Edge(a, c));

		}
		int[] dist = dijkstra(graph, exit);
		int count = 0;
		for (int i = 0; i < dist.length; i++) {
			if (dist[i] <= time)
				count++;
		}
		pw.println(count);
		sc.close();
	}

	static int[] dijkstra(ArrayList<ArrayList<Edge>> graph, int from) {
		int[] dist = new int[graph.size()];
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		for (int i = 0; i < graph.size(); i++) {
			dist[i] = Integer.MAX_VALUE - 10000;
		}
		dist[from] = 0;
		pq.add(new Vertex(from, 0));
		while (!pq.isEmpty()) {
			Vertex u = pq.poll();
			if (dist[u.id] == Integer.MAX_VALUE - 10000) {
				break;
			}
			for (Edge e : graph.get(u.id)) {
				if (dist[e.to] > e.weight + dist[u.id]) {
					dist[e.to] = e.weight + dist[u.id];
					pq.add(new Vertex(e.to, dist[e.to]));
				}

			}
		}
		return dist;
	}
}

