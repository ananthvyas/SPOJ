package spoj;
import java.util.Scanner;

public class DSUBSEQ {

	/**
	 * @param args
	 */
	static int getNumSubSeq(String str) {
		if (str.equals(""))
			return 1;
		char[] word = str.toCharArray();
		int[] mem = new int[word.length + 1];
		int[] seen = new int[256];
		mem[word.length] = 1;
		for (int i = word.length - 1; i >= 0; i--) {
			if (seen[word[i]] == 0)
				mem[i] = (mem[i + 1] * 2) % 1000000007;
			else {
				mem[i] = ((mem[i + 1] * 2) % 1000000007 - mem[seen[word[i]] + 1] % 1000000007);
				if (mem[i] < 0)
					mem[i] += 1000000007;
			}
			seen[word[i]] = i;
		}
		return mem[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			String str = sc.next();
			System.out.println(getNumSubSeq(str));
		}
		sc.close();
	}

}
