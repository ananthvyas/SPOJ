package spoj;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

class RABBIT1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		int num = in.nextInt();
		PrintWriter pw = new PrintWriter(System.out, true);
		for (int i = 0; i < num; i++) {
			int n = in.nextInt();
			int m = (int) Math.pow(2, in.nextInt());
			pw.println(getFib(n, m));
		}
	}

	static long[][] multiplyMatrix(long[][] a, long[][] b, int m) {
		long[][] c = new long[2][2];
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				for (int k = 0; k < 2; k++)
					c[i][j] = (c[i][j] + (a[i][k] * b[k][j])) % m;
		return c;
	}

	static long[][] powMatrix(long[][] a, int p, int m) {
		if (p == 1)
			return a;
		if (p % 2 == 1)
			return multiplyMatrix(a, powMatrix(a, p - 1, m), m);
		int mid = p / 2;
		long[][] res = powMatrix(a, mid, m);
		return multiplyMatrix(res, res, m);
	}

	static long getFib(int n, int m) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2 % m;
		int[] vect = new int[2];
		vect[0] = 1;
		vect[1] = 2;
		long[][] mat = new long[2][2];
		mat[0][0] = 0;
		mat[0][1] = 1;
		mat[1][0] = 1;
		mat[1][1] = 1;
		long[][] res = powMatrix(mat, n, m);
		return res[1][1];
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
