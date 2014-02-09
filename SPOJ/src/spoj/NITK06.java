package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NITK06 {
	static boolean isPossible(long[] arr) {
		if (arr[0] > arr[1])
			return false;
		if (arr[arr.length - 1] > arr[arr.length - 2])
			return false;
		long oddsum = 0;
		long evensum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0)
				evensum += arr[i];
			else
				oddsum += arr[i];
		}
		return oddsum == evensum;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			try {
				int k = Integer.parseInt(br.readLine());
				long[] arr = new long[k];
				String[] str = (br.readLine()).split("[ ]+");
				for (int j = 0; j < k; j++)
					arr[j] = Long.parseLong(str[j]);
				if (isPossible(arr))
					System.out.println("YES");
				else
					System.out.println("NO");
			} catch (Exception e) {
			}
		}
		br.close();
	}
}
