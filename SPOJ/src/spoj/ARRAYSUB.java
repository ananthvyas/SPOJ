package spoj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ARRAYSUB {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// try {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine().trim());
		int[] arr = new int[num];
		int[] lr = new int[num];
		int[] rl = new int[num];
		boolean[] limit = new boolean[num];
		br.readLine();
		String[] nums = br.readLine().trim().split("[ ]+");
		for (int i = 0; i < num; i++)
			arr[i] = Integer.parseInt(nums[i]);
		int k = Integer.parseInt(br.readLine().trim());
		int[] max = new int[num - k + 1];
		int mx = arr[0];
		for (int i = 0; i < num; i++) {
			if (i % k == 0) {
				if (i != 0)
					limit[i - 1] = true;
				else
					limit[i] = false;
				mx = arr[i];
			} else if (arr[i] > mx) {
				mx = arr[i];
				limit[i - 1] = false;
			}
			lr[i] = mx;
		}
		mx = arr[num - 1];
		for (int i = num - 1; i >= 0; i--) {
			if (limit[i]) {
				mx = arr[i];
			} else if (arr[i] > mx) {
				mx = arr[i];
			}
			rl[i] = mx;
		}
		for (int i = 0; i < num - k + 1; i++) {
			max[i] = Math.max(rl[i], lr[i + k - 1]);
		}
		for (int i = 0; i < num - k; i++)
			System.out.print(max[i] + " ");
		System.out.println(max[num - k]);
		br.close();
		// } catch (Exception e) {
		//
		// }
	}
}
