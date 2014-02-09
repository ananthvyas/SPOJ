package spoj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PALDR {

	/**
	 * @param args
	 */
	static boolean isPALDR(String pal) {
		// boolean chk = false;
		int[] palcnt = new int[pal.length()];
		char[] str = pal.toCharArray();
		int cnt = 0;
		palcnt[0] = 0;
		for (int i = 1; i < str.length; i++) {
			if ((i - cnt - 1) >= 0) {
				if (str[i - cnt - 1] == str[i]) {
					cnt += 2;
				} else {
					if (palcnt[i - cnt - 1] > 0) {
						int k = cnt;
						while ((i - k - 1) >= 0 && palcnt[i - k - 1] > 0) {
							k += palcnt[i - k - 1];
						}
						if ((i - k - 1) < 0)
							cnt = 0;
						else if (str[i - k - 1] == str[i])
							cnt = k + 2;
					} else
						cnt = 0;
				}
			} else
				cnt = 0;
			palcnt[i] = cnt;
		}
		cnt = 0;
		int i = palcnt.length - 1;
		do {
			// System.out.print(palcnt[i] + " ");
			if ((i - palcnt[i] + 1) == 0)
				return true;
			if (palcnt[i] == 0)
				return false;
			i -= palcnt[i];
		} while (true);
		// System.out.println(chk);
		// return chk;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// try {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in, "UTF-8"));
		String line = bufferedReader.readLine();
		int num = Integer.parseInt(line);
		for (int i = 0; i < num; i++) {
			String pal = bufferedReader.readLine();
			if (pal.equals("")) {
				System.out.println("YES");
			} else if (isPALDR(pal))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		bufferedReader.close();
		// } catch (Exception e) {
		// }
	}

}
