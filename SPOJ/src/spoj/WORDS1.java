package spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class WeightedQuickUnionUF {
	private int[] id; // parent link (site indexed)
	private int[] sz; // size of component for roots (site indexed)
	private int count; // number of components

	public WeightedQuickUnionUF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
		sz = new int[N];
		for (int i = 0; i < N; i++)
			sz[i] = 1;
	}

	public int count() {
		return count;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	private int find(int p) { // Follow links to find a root.
		while (p != id[p])
			p = id[p];
		return p;
	}

	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j)
			return;
		// Make smaller root point to larger one.
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}
}

public class WORDS1 {

	/**
	 * @param args
	 */

	static boolean isPossible(String[] words) {
		int[] map = new int[256];
		int[] out = new int[256];
		int[] in = new int[256];
		for (int i = 0; i < 256; i++) {
			map[i] = out[i] = in[i] = 0;
		}
		int[] set = new int[256];
		Set<Integer> vert = new HashSet<Integer>();
		for (int i = 0; i < words.length; i++) {
			out[(int) words[i].charAt(0)]++;
			in[(int) words[i].charAt(words[i].length() - 1)]++;
			set[(int) words[i].charAt(0)] = 1;
			set[(int) words[i].charAt(words[i].length() - 1)] = 1;
			vert.add((int) words[i].charAt(0));
			vert.add((int) words[i].charAt(words[i].length() - 1));
		}
		WeightedQuickUnionUF wf = new WeightedQuickUnionUF(vert.size());
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>(vert);
		for (int i = 0; i < al.size(); i++) {
			hm.put(al.get(i), i);
		}
		for (int i = 0; i < words.length; i++) {
			int a = hm.get((int)words[i].charAt(0));
			int b = hm.get((int)words[i].charAt(words[i].length() - 1));
			wf.union(a, b);
		}
		if (wf.count() != 1)
			return false;
		// System.out.println(map);
		// System.out.println(in);
		// System.out.println(out);
		int oddcount = 0;
		ArrayList<Character> verts = new ArrayList<Character>();
		for (int i = 0; i < 256; i++) {
			int outs = out[i];
			int ins = in[i];
			if (Math.abs(outs - ins) > 1)
				return false;
			if (Math.abs(outs - ins) == 1) {
				oddcount++;
				verts.add((char) i);
			}
		}
		if (oddcount == 0)
			return true;
		if (oddcount == 2) {
			int outs1 = 0, ins1 = 0;
			int outs2 = 0, ins2 = 0;
			char c1 = verts.get(0);
			char c2 = verts.get(1);

			outs1 = out[(int) c1];
			ins1 = in[(int) c1];
			outs2 = out[(int) c2];
			ins2 = in[(int) c2];
			if ((outs1 - ins1 + outs2 - ins2) == 0)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(System.in, "UTF-8"));
			String line = bufferedReader.readLine();
			int num = Integer.parseInt(line);
			for (int i = 0; i < num; i++) {
				line = bufferedReader.readLine();
				int num2 = Integer.parseInt(line);
				String[] words = new String[num2];
				for (int j = 0; j < num2; j++) {
					words[j] = bufferedReader.readLine();
				}
				if (isPossible(words))
					System.out.println("Ordering is possible.");
				else
					System.out.println("The door cannot be opened.");
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
