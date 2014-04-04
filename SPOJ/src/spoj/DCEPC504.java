package spoj;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

class DCEPC504 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		boolean[] bits = new boolean[6];
		bits[0] = bits[3] = bits[5] = false;
		bits[1] = bits[2] = bits[4] = true;
		Reader in = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		int num = in.nextInt();
		//pw.println(Integer.MAX_VALUE+" "+Long.MAX_VALUE);
		for (int i = 0; i < num; i++) {
			int n=in.nextInt();
			long c=(long)Math.pow(2,n-1);
			long k = in.nextLong();
			k=Math.min(c,k);
			if(getChild(n,k)){
				pw.println("Female");
			}else{
				pw.println("Male");
			}
		}
	}
	static boolean getChild(int n, long k){
		if(k==1) return false;
		boolean par=getChild(n-1, (long)Math.ceil((double)k/2.0));
		if(par){
			if(k%2==0) return false;
			return true;
		}else{
			if(k%2==0) return true;
			return false;
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
