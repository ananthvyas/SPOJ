package spoj;

public class CPCRC1C {
	static long getCount(int dig){
		if(dig==0) return 0;
		if(dig==1) return 45;
		return (getCount(dig-1)+45)*10;
	}
	static long getSumofDigits(String num){
		long sum=0;
		for(int i=0;i<num.length();i++){
			int n=Integer.parseInt(""+num.charAt(i));
			sum+=(n+1)*getCount(num.length()-i-1);
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getSumofDigits("23"));
	}

}
