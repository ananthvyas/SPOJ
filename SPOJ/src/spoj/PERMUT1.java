package spoj;

import java.util.Scanner;

public class PERMUT1 {
	static int[][] mem;
	static int getPerms(int n, int perm){
		if(perm<0) return 0;
		if(mem[n][perm]!=-1) return mem[n][perm];
		if(perm==0) return 1;
		int max=(n*(n-1))/2;
		if(perm>max) return 0;
		int total=0;
		for(int i=1;i<=n;i++){
			total+=getPerms(n-1,perm-(i-1));
		}
		mem[n][perm]=total;
		return total;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int k = 0; k < num; k++) {
			int n=sc.nextInt();
			int perm=sc.nextInt();
			mem=new int[n+1][perm+1];
			for(int i=0;i<=n;i++){
				for(int j=0;j<=perm;j++)
					mem[i][j]=-1;
			}
			System.out.println(getPerms(n,perm));
		}
		sc.close();
	}

}
