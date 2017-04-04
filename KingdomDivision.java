package hackerrank;

import java.util.HashMap;
import java.util.Scanner;

public class KingdomDivision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		HashMap<Integer,Integer> count = new HashMap<>();
		for(int i=1;i<=n-1;i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			if(count.containsKey(a)) {
				count.put(a,count.get(a)+1);
			} else {
				count.put(a, 1);
			}
			if(count.containsKey(b)) {
				count.put(b,count.get(b)+1);
			} else {
				count.put(b, 1);
			}
		}
		int num = n;
		for(int i=1;i<=num;i++) {
			if(count.containsKey(i)) {
				if(count.get(i)==1) {
					n--;
				}
			}
		}
		long ans = (long) Math.pow(2,n);
		long lol = (long)(ans%(Math.pow(10, 9)+7));
		System.out.println(lol);
	}

}
