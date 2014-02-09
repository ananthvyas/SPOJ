package spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Palin {

	/**
	 * @param args
	 */
	static char nextDigit(char dig) {
		if (dig != '9') {
			return (char) ((int) dig + 1);
		} else
			return '0';
	}

	static String getNextPalindrome(String num) {
		char[] digits = num.toCharArray();
		int i, j;
		if (digits.length % 2 == 1) {
			i = j = (digits.length / 2);
		} else {
			i = (digits.length / 2) - 1;
			j = i + 1;
		}
		boolean carry = true;
		while (i >= 0 && j < digits.length) {
			if (carry) {
				if ((int) digits[i] < (int) digits[j]) {
					digits[i] = nextDigit(digits[i]);
					digits[j] = digits[i];
					carry = false;
				} else {
					if ((int) digits[i] == (int) digits[j]) {
						if (digits[i] == '9') {
							digits[i] = digits[j] = '0';
						} else {
							digits[i] = digits[j] = nextDigit(digits[i]);
							carry = false;
						}
					} else {
						digits[j] = digits[i];
						carry = false;
					}
				}
			} else {
				digits[j] = digits[i];
			}
			i--;
			j++;
		}
		boolean chk = true;
		for (i = 0; i < digits.length; i++) {
			if (digits[i] != '0')
				chk = false;
		}
		if (chk) {
			String tmp = "1";
			for (i = 0; i < digits.length - 1; i++) {
				tmp += "0";
			}
			tmp += "1";
			digits = tmp.toCharArray();
			return tmp;
		}
		char[] digits2 = num.toCharArray();
		i = 0;
		j = digits2.length - 1;
		while (i <= j) {
			digits2[j] = digits2[i];
			i++;
			j--;
		}
		if (new String(digits).compareTo(num) > 0
				&& new String(digits2).compareTo(num) > 0) {
			if (new String(digits).compareTo(new String(digits2)) > 0)
				return new String(digits2);
			return new String(digits);
		}
		if (new String(digits).compareTo(num) > 0)
			return new String(digits);
		return new String(digits2);
		// System.out.println(new String(digits)+"\n"+new String(digits2));
		// return "";//new String(digits);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(System.in, "UTF-8"));
			String line = bufferedReader.readLine();

			int num = Integer.parseInt(line);
			for (int i = 0; i < num; i++) {
				String k = bufferedReader.readLine().replaceFirst("^0+(?!$)",
						"");
				System.out.printf("%s\n", getNextPalindrome(k));
				// System.out.println(getNextPalindrome(k));
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
