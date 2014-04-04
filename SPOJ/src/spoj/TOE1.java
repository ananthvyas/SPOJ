package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class TOE1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Reader sc = new Reader();
		int num = sc.nextInt();
		PrintWriter pw = new PrintWriter(System.out, true);
		for (int i = 0; i < num; i++) {
			char[][] mat = new char[3][3];
			for (int j = 0; j < 3; j++)
				for (int k = 0; k < 3; k++)
					mat[j][k] = sc.nextChar();
			if (isValid(mat))
				pw.println("yes");
			else
				pw.println("no");
		}
		sc.close();
	}

	static boolean isValid(char[][] mat) {
		int countX = countX(mat);
		int countO = countO(mat);
		int Xwin = numX(mat);
		int Owin = numO(mat);
		if (countO > countX)
			return false;
		if (countX - countO > 1)
			return false;
		if (Xwin + Owin > 1)
			return false;
		if (countX > countO && Owin == 1)
			return false;
		if (countX == countO && Xwin == 1)
			return false;
		return true;
	}

	static int countX(char[][] mat) {
		int count = 0;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (mat[i][j] == 'X')
					count++;
		return count;
	}

	static int countO(char[][] mat) {
		int count = 0;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (mat[i][j] == 'O')
					count++;
		return count;
	}

	static int numX(char[][] mat) {
		// diagonals
		int diag = 0;
		int row = 0;
		int col = 0;
		if (mat[0][0] == mat[1][1] && mat[1][1] == mat[2][2]
				&& mat[2][2] == 'X')
			diag++;
		if (mat[0][2] == mat[1][1] && mat[1][1] == mat[2][0]
				&& mat[2][0] == 'X')
			diag++;
		// row-wise
		if (mat[0][0] == mat[0][1] && mat[0][1] == mat[0][2]
				&& mat[0][2] == 'X')
			row++;
		if (mat[1][0] == mat[1][1] && mat[1][1] == mat[1][2]
				&& mat[1][2] == 'X')
			row++;
		if (mat[2][0] == mat[2][1] && mat[2][1] == mat[2][2]
				&& mat[2][2] == 'X')
			row++;
		// column-wise
		if (mat[0][0] == mat[1][0] && mat[1][0] == mat[2][0]
				&& mat[2][0] == 'X')
			col++;
		if (mat[0][1] == mat[1][1] && mat[1][1] == mat[2][1]
				&& mat[2][1] == 'X')
			col++;
		if (mat[0][2] == mat[1][2] && mat[1][2] == mat[2][2]
				&& mat[2][2] == 'X')
			col++;
		if (row > 1 || col > 1)
			return 2;
		if (row + col + diag == 0)
			return 0;
		return 1;
	}

	static int numO(char[][] mat) {
		// diagonals
		int diag = 0;
		int row = 0;
		int col = 0;
		if (mat[0][0] == mat[1][1] && mat[1][1] == mat[2][2]
				&& mat[2][2] == 'O')
			diag++;
		if (mat[0][2] == mat[1][1] && mat[1][1] == mat[2][0]
				&& mat[2][0] == 'O')
			diag++;
		// row-wise
		if (mat[0][0] == mat[0][1] && mat[0][1] == mat[0][2]
				&& mat[0][2] == 'O')
			row++;
		if (mat[1][0] == mat[1][1] && mat[1][1] == mat[1][2]
				&& mat[1][2] == 'O')
			row++;
		if (mat[2][0] == mat[2][1] && mat[2][1] == mat[2][2]
				&& mat[2][2] == 'O')
			row++;
		// column-wise
		if (mat[0][0] == mat[1][0] && mat[1][0] == mat[2][0]
				&& mat[2][0] == 'O')
			col++;
		if (mat[0][1] == mat[1][1] && mat[1][1] == mat[2][1]
				&& mat[2][1] == 'O')
			col++;
		if (mat[0][2] == mat[1][2] && mat[1][2] == mat[2][2]
				&& mat[2][2] == 'O')
			col++;
		if (row > 1 || col > 1)
			return 2;
		if (row + col + diag == 0)
			return 0;
		return 1;
	}
}
