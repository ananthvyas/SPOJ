package spoj;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

class SHOP {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

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
				for (int i = 0; i < m; i++) {
					for (int j = 0; j < n; j++) {
						mat[i][j] = sc.nextChar();
						mem[i * m + j] = -1;
						if (mat[i][j] == 'S') {
							starti = i;
							startj = j;
						}
					
					}
				}
				
				ArrayList<Integer> seen = new ArrayList<Integer>();
				seen.add(starti * m + startj);
				pw.println(getDistance(mat, starti, startj, seen));
			} else {
				sc.close();
				break;
			}
		}
	}

	static int[] mem;
	static int m, n;

	static int[] dijkstra(char[][] graph, int fromi, int fromj) {
		int[] dist = new int[m*n];
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE - 10000;
		}
		dist[fromi*m+fromj] = 0;
		pq.add(new Vertex(fromi*m+fromj, 0));
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

class Reader {
	final private int BUFFER_SIZE = 1 << 16;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;

	public Reader() {
		din = new DataInputStream(System.in);
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}

	public Reader(String file_name) throws IOException {
		din = new DataInputStream(new FileInputStream(file_name));
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}

	public String readLine() throws IOException {
		byte[] buf = new byte[64]; // line length
		int cnt = 0, c;
		while ((c = read()) != -1) {
			if (c == '\n' || c == '\r')
				break;
			buf[cnt++] = (byte) c;
		}
		return new String(buf, 0, cnt);
	}

	public int nextInt() throws IOException {
		int ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}

	public long nextLong() throws IOException {
		long ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}

	public double nextDouble() throws IOException {
		double ret = 0, div = 1;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0' && c <= '9');
		if (c == '.')
			while ((c = read()) >= '0' && c <= '9')
				ret += (c - '0') / (div *= 10);
		if (neg)
			return -ret;
		return ret;
	}

	public char nextChar() throws IOException {
		byte c = read();
		while (c <= ' ')
			c = read();
		return (char) c;
	}

	private void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1)
			buffer[0] = -1;
	}

	private byte read() throws IOException {
		if (bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}

	public void close() throws IOException {
		if (din == null)
			return;
		din.close();
	}
}
