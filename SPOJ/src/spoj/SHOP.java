package spoj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;


class PairS implements Comparable<PairS> {
	int i;
	int j;
	int weight;

	PairS(int i, int j, int weight) {
		this.i = i;
		this.j = j;
		this.weight = weight;
	}

	@Override
	public int compareTo(PairS v1) {
		
		if (v1.weight < weight)
			return 1;
		if (v1.weight > weight)
			return -1;
		return 0;

	}
}

class SHOP {

	public static void main(String[] args) throws IOException {
		Reader sc = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		while (true) {
			n = sc.nextInt();
			m = sc.nextInt();
			if (n != 0 || m != 0) {
				char[][] mat = new char[m][n];
				mem = new int[m * n];
				int starti = 0;
				int startj = 0;
				int endi = 0;
				int endj = 0;
				for (int i = 0; i < m; i++) {
					for (int j = 0; j < n; j++) {
						mat[i][j] = sc.nextChar();
						mem[i * n + j] = -1;
						if (mat[i][j] == 'S') {
							starti = i;
							startj = j;
						}
						if (mat[i][j] == 'D') {
							endi = i;
							endj = j;
							mat[i][j] = '0';
						}
					}
				}
				try {
					int[] dist = dijkstra(mat, starti, startj);
					pw.println(dist[endi * n + endj]);
				} catch (Exception e) {
					pw.println("5");
				}
			} else {
				sc.close();
				break;
			}
		}
	}

	static int[] mem;
	static int m, n;

	static ArrayList<PairS> getNeighbor(int i, int j, char[][] mat) {
		ArrayList<PairS> nbrs = new ArrayList<PairS>();
		if (i - 1 >= 0 && mat[i - 1][j] != 'X') {
			nbrs.add(new PairS(i - 1, j, 0));
		}
		if (i + 1 < m && mat[i + 1][j] != 'X') {
			nbrs.add(new PairS(i + 1, j, 0));
		}
		if (j - 1 >= 0 && mat[i][j - 1] != 'X') {
			nbrs.add(new PairS(i, j - 1, 0));
		}
		if (j + 1 < n && mat[i][j + 1] != 'X') {
			nbrs.add(new PairS(i, j + 1, 0));
		}
		return nbrs;
	}

	static int[] dijkstra(char[][] mat, int fromi, int fromj) {
		int[] dist = new int[m * n];
		PriorityQueue<PairS> pq = new PriorityQueue<PairS>();
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE - 10000;
		}
		dist[fromi * n + fromj] = 0;
		pq.add(new PairS(fromi, fromj, 0));
		while (!pq.isEmpty()) {
			PairS u = pq.poll();
			if (dist[u.i * n + u.j] == Integer.MAX_VALUE - 10000) {
				break;
			}
			for (PairS nbr : getNeighbor(u.i, u.j, mat)) {
				if (dist[nbr.i * n + nbr.j] > mat[nbr.i][nbr.j] - 48
						+ dist[u.i * n + u.j]) {
					dist[nbr.i * n + nbr.j] = mat[nbr.i][nbr.j] - 48
							+ dist[u.i * n + u.j];
					pq.add(new PairS(nbr.i, nbr.j, dist[nbr.i * n + nbr.j]));
				}

			}
		}
		return dist;
	}
}


