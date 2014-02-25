package spoj;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class BPair {
	int x;
	int y;

	BPair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class BITMAP {
	static List<BPair> que = new ArrayList<BPair>();

	static void printBitmap(char[][] mat) {
		int row = mat.length;
		int col = mat[0].length;
		int[][] bitmap = new int[row][col];
		boolean[][] visited=new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				bitmap[i][j] = Integer.MAX_VALUE;
			}
		}
		int[] xseq = { 0, 1, -1, 0 };
		int[] yseq = { 1, 0, 0, -1 };
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (mat[i][j] == '1') {
					visited[i][j]=true;
					que.add(new BPair(i, j));
					bitmap[i][j] = 0;
				}
			}
		}
		while (que.size() > 0) {
			BPair p = que.get(0);
			que.remove(0);
			int x = p.x;
			int y = p.y;
			for (int k = 0; k < 4; k++) {
				int xc = x + xseq[k];
				int yc = y + yseq[k];
				if (xc >= 0 && xc < row && yc >= 0 && yc < col && !visited[xc][yc]) {
					if (bitmap[xc][yc] > bitmap[x][y] + 1) {
						bitmap[xc][yc] = bitmap[x][y] + 1;
						que.add(new BPair(xc, yc));
						visited[xc][yc]=true;
					}
				}
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				pw.print(bitmap[i][j] + " ");
			}
			pw.println();
		}
	}

	static PrintWriter pw = new PrintWriter(System.out, true);

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		int num = in.nextInt();
		for (int p = 0; p < num; p++) {
			int row = in.nextInt();
			int col = in.nextInt();
			char[][] mat = new char[row][col];
			for (int i = 0; i < row; i++)
				for (int j = 0; j < col; j++)
					mat[i][j] = in.nextChar();
			printBitmap(mat);
		}
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
