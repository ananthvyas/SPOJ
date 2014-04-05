package spoj;

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


