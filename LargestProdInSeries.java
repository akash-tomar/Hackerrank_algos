package hackerrank;

import java.util.Scanner;

public class LargestProdInSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int test=0;test<t;test++) {
			int n =s.nextInt();
			int k = s.nextInt();
			String str = s.next();
			long prod = Long.MIN_VALUE;
			for(int i=0;i<=n-k;i++) {
				long max = 1;
				for(int j=i;j<i+k;j++) {
					max*=Integer.parseInt(str.charAt(j)+"");
				}
				prod = Math.max(max, prod);
			}
			System.out.println(prod);
		}
	}

}
