package spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WORDCNT {

	/**
	 * @param args
	 */
	static int getMaxCount(String str) {
		String[] wrds = str.split("[ ]+");
		int cnt = 1;
		int maxcnt = cnt;
		int len = wrds[0].length();
		for (int i = 1; i < wrds.length; i++) {
			if (wrds[i].length() == len) {
				cnt++;
				if (cnt > maxcnt)
					maxcnt = cnt;
			} else {
				cnt = 1;
				len = wrds[i].length();
			}
		}
		return maxcnt;
	}

	public static void main(String[] args) {
		try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(System.in, "UTF-8"));
			String line = bufferedReader.readLine();
			int num = Integer.parseInt(line);
			for (int i = 0; i < num; i++) {
				String pal = bufferedReader.readLine();
				if (pal.equals(""))
					System.out.println("0");
				else
					System.out.println(getMaxCount(pal));
			}
			bufferedReader.close();
		} catch (Exception e) {
		}
	}

}
