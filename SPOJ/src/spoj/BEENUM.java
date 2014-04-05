package spoj;

import java.util.Scanner;

public class BEENUM{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		while(num!=-1){
			if(num%6==1) System.out.println("YES");
			else System.out.println("NO");
			num=sc.nextInt();
		}
	}
}

