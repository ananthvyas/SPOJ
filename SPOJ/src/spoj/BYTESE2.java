package spoj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class TimePair {
	int time;
	boolean isStart;

	TimePair(int time, boolean isStart) {
		this.time = time;
		this.isStart = isStart;
	}

}

class BYTESE2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Reader sc = new Reader();
		int t = sc.nextInt();
		PrintWriter pw = new PrintWriter(System.out, true);
		for (int j = 0; j < t; j++) {
			int num = sc.nextInt();
			ArrayList<TimePair> lst = new ArrayList<TimePair>();
			for (int i = 0; i < num; i++) {
				int time = sc.nextInt();
				TimePair tp = new TimePair(time, true);
				lst.add(tp);
				time = sc.nextInt();
				tp = new TimePair(time, false);
				lst.add(tp);
			}
			Collections.sort(lst, new Comparator<TimePair>() {

				@Override
				public int compare(TimePair t1, TimePair t2) {
					if (t1.time > t2.time)
						return 1;
					if (t1.time < t2.time)
						return -1;
					return 0;
				}

			});
			int cnt = 0;
			int max = 0;
			for (TimePair tp : lst) {
				if (tp.isStart) {
					cnt++;
					if (cnt > max)
						max = cnt;
				} else {
					cnt--;
				}
			}
			pw.println(max);
		}
		sc.close();
	}

}


