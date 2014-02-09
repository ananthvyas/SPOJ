package spoj;
import java.util.Scanner;


public class ACPC10A {

	/**
	 * @param args
	 */
	static void apOrGP(int a, int b, int c){
		if(b==c && c==0){
			System.out.println("GP 0");
			return;
		}
		int dif1=b-a,dif2=c-b;
		if(dif1==dif2){
			System.out.println("AP "+(c+dif1));
			return;
		}
		double div1=(b/a),div2=(c/b);
		if(div1==div2){
			System.out.println("GP "+(int)(c*div1));
		}
	}
	public static void main(String[] args) {
		try {
			//initMods();
			Scanner sc = new Scanner(System.in);
			do {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c=sc.nextInt();
				if(a==b && b==c && c==0) break;
				apOrGP(a, b, c);
			}while(true);
			sc.close();
		} catch (Exception e) {
		}
	}

}
