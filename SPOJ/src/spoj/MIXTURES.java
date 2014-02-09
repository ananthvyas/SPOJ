package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MIXTURES {
	static int[][] smoke;
	static int[] mix;

	static int sum(int[] arr, int i, int j) {
		int sum = mix[j];
		if (i != 0)
			sum -= mix[i - 1];
		if (sum < 0)
			return sum + 100;
		return sum;
	}

	static int getMinSmoke(int[] arr, int i, int j) {
		if (smoke[i][j] != -1)
			return smoke[i][j];
		if (i >= j)
			return 0;
		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			min = Math.min(min, sum(arr, i, k) * sum(arr, k + 1, j)
					+ getMinSmoke(arr, i, k) + getMinSmoke(arr, k + 1, j));
		}
		smoke[i][j] = min;
		return min;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while ((str = br.readLine()) != null) {
			try {
				int num = Integer.parseInt(str);
				int[] arr = new int[num];
				smoke = new int[num][num];
				mix = new int[num];
				String[] nums = br.readLine().split("[ ]+");
				for (int i = 0; i < num; i++) {
					arr[i] = Integer.parseInt(nums[i]);
					if (i == 0)
						mix[i] = arr[i] % 100;
					else {
						mix[i] = (mix[i - 1] + arr[i]) % 100;
					}
				}
				for (int i = 0; i < num; i++)
					for (int j = 0; j < num; j++)
						smoke[i][j] = -1;
				System.out.println(getMinSmoke(arr, 0, num - 1));
			} catch (Exception e) {

			}
		}
	}
}