package spoj;

import java.util.ArrayList;
import java.util.Scanner;

public class PT07X {

	/**
	 * @param args
	 */
	static int count = 0;

	static boolean vertexcount(ArrayList<ArrayList<Integer>> graph, int i) {
		if (graph.get(i).size() == 0)
			return false;
		boolean check = false;
		for (int chld : graph.get(i)) {
			if (!vertexcount(graph, chld))
				check = true;
		}
		if (check)
			count++;
		return check;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < num; i++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			graph.add(tmp);
		}
		for (int i = 0; i < num - 1; i++) {
			String edge = sc.nextLine();
			int from = Integer.parseInt(edge.split("[ ]+")[0]) - 1;
			int to = Integer.parseInt(edge.split("[ ]+")[1]) - 1;

			ArrayList<Integer> s = graph.get(from);
			s.add(to);
			graph.set(from, s);

		}
		if (num == 1)
			System.out.println("1");
		else {
			int j = 0;
			while (graph.get(j).size() == 0)
				j++;
			vertexcount(graph, j);
			System.out.println(count);
		}
		sc.close();
	}

}
