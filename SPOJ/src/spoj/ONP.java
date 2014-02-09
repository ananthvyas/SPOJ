package spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class BTree<T> {
	T data;
	BTree<T> left;
	BTree<T> right;
	static String postorderstr="";
	BTree(T data) {
		this.data = data;
		left = null;
		right = null;
	}
	void postorder(){
		if(this.left!=null) this.left.postorder();
		if(this.right!=null) this.right.postorder();
		System.out.print(data);
	}
}

public class ONP {

	static BTree<Character> buildExpressionTree(char[] exp, int i, int j) {
		if (j == i)
			return new BTree<Character>(exp[i]);
		if (j < i)
			return null;
		int bracket = 0;
		int k;
		boolean chk=false;
		if(exp[i]=='(') chk=true;
		for (k = i; k <= j; k++) {
			if ((exp[k] == '*' || exp[k] == '+' || exp[k] == '-'
					|| exp[k] == '/' || exp[k] == '^')
					&& bracket <= 1) {
				break;
			}
			if(exp[k]=='(') bracket++;
			if(exp[k]==')') bracket--;
		}
		BTree<Character> root=new BTree<Character>(exp[k]);
		if(chk){
			i++;
			j--;
		}
		root.left=buildExpressionTree(exp, i, k-1);
		root.right=buildExpressionTree(exp, k+1, j);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(System.in, "UTF-8"));
			String line = bufferedReader.readLine();

			int num = Integer.parseInt(line);
			for (int i = 0; i < num; i++) {
				String exp = bufferedReader.readLine().trim();
				buildExpressionTree(exp.toCharArray(), 0, exp.length()-1).postorder();
				System.out.println("");
				// System.out.println(getNextPalindrome(k));
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
