package spoj;

class PPATH {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] pnums = new boolean[10000];
		int MAX = 9999;
		for (int i = 2; i <= 9999; i++) {
			if (!pnums[i]) {
				int k = 2;
				int j = k * i;
				while (j <= MAX) {
					pnums[j] = true;
					k++;
					j = k * i;
				}
			}
		}
		for(int i=1000;i<=9999;i++){
			if(!pnums[i]) System.out.print(i+" ");
		}
		System.out.println("");
	}

}
