package spoj;
import java.util.ArrayList;
import java.util.Scanner;

public class BITMAP {
	static void getModifiedBitmap(int[][] bitmap, ArrayList<Integer> rowPos,
			ArrayList<Integer> colPos) {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			ArrayList<Integer> rowPos = new ArrayList<Integer>();
			ArrayList<Integer> colPos = new ArrayList<Integer>();
			for (int k = 0; k < num; k++) {
				int rows = sc.nextInt();
				int cols = sc.nextInt();
				int[][] bitmap = new int[rows][cols];
				for (int i = 0; i < rows; i++) {
					String col = sc.next();
					for (int j = 0; j < col.length(); j++) {
						bitmap[i][j] = Integer.parseInt("" + col.charAt(j));
						if (bitmap[i][j] == 1) {
							rowPos.add(i);
							colPos.add(j);
						}
					}
				}
				getModifiedBitmap(bitmap, rowPos, colPos);
			}
			sc.close();
		} catch (Exception e) {
		}
	}
}
