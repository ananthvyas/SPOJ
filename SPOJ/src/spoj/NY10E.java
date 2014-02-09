package spoj;
import java.util.Scanner;

public class NY10E {
	static long[][] mem;

	static long getNumSeq(int curr, int dig) {
		if(dig==0) return 0;
		if (mem[curr][dig] != 0)
			return mem[curr][dig];
		if (dig == 1) {
			mem[curr][dig] = 10 - curr;
			return 10 - curr;
		}
		long total = 0;
		for (int i = curr; i <= 9; i++) {
			total += getNumSeq(i, dig - 1);
		}
		mem[curr][dig] = total;
		return total;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			int seq = sc.nextInt();
			int dig = sc.nextInt();
			mem = new long[10][dig + 1];
			System.out.println(seq + " " + getNumSeq(0, dig));
		}
		sc.close();
	}

}
