package spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CANDYIII {
	public static void main(String[] args) {
		try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(System.in, "UTF-8"));
			String line = bufferedReader.readLine();

			int num = Integer.parseInt(line);
			for (int i = 0; i < num; i++) {
				bufferedReader.readLine();
				long children=Long.parseLong(bufferedReader.readLine());
				long candy=0;
				for(long j=0;j<children;j++){
					candy=(candy+Long.parseLong(bufferedReader.readLine()))%children;
				}
				if(candy==0) System.out.println("YES");
				else System.out.println("NO");
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
