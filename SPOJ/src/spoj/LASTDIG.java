package spoj;
import java.util.Scanner;

class LASTDIG {
	static int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static int[] mods = new int[9];

	static int getLastDig(int a, long b) {
		if (b == 0)
			return 1;
		a = a % 10;
		if (a == 0)
			return 0;
		if (mods[a - 1] == 1)
			return a;
		b = b % mods[a - 1];
		if (b == 0)
			b = mods[a - 1];
		return (int) Math.pow(a, b) % 10;
	}

	static void initMods() {
		for (int i = 1; i <= 9; i++) {
			int modc = 2;
			int init = i;
			int k = 3;
			int nxt = (int) Math.pow(i, 2) % 10;
			while (nxt != init) {
				nxt = (int) Math.pow(i, k) % 10;
				k++;
				modc++;
			}
			mods[i - 1] = modc - 1;
		}
	}

	public static void main(String[] args) {
		try {
			initMods();
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			for (int i = 0; i < num; i++) {
				int a = sc.nextInt();
				long b = sc.nextLong();
				System.out.println(getLastDig(a, b));
			}
			sc.close();
		} catch (Exception e) {
		}
	}
}