package spoj;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

class BitTree {
	long[] B1;
	long[] B2;
	int N;

	public BitTree(int n) {
		// TODO Auto-generated constructor stub
		B1 = new long[n + 1];
		B2 = new long[n + 1];
		N = n;
	}

	void update(long[] ft, int a, long v) {
		for (int p = a; p <= N; p += (p & (-p))) {
			ft[p] += v;
		}
	}

	void update(int a, int b, long v) {
		update(B1, a, v);
		update(B1, b + 1, -v);
		update(B2, a, v * (a - 1));
		update(B2, b + 1, -v * b);
	}

	long query(long[] ft, int b) {
		long sum = 0;
		for (int p = b; p > 0; p -= p & (-p))
			sum += ft[p];
		return sum;
	}

	long query(int a) {
		return query(B1, a) * a - query(B2, a);
	}

	long query(int a, int b) {
		return query(b) - query(a - 1);
	}
}

class HORRIBLE {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int c = in.nextInt();
			BitTree bt = new BitTree(n);
			for (int j = 0; j < c; j++) {
				int cmd = in.nextInt();
				if (cmd == 0) {
					int a = in.nextInt();
					int b = in.nextInt();
					long v = in.nextLong();
					bt.update(a, b, v);
				} else {
					int a = in.nextInt();
					int b = in.nextInt();
					pw.println(bt.query(a, b));
				}
			}
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
