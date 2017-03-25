package hackerrank;

import java.util.HashMap;
import java.util.Scanner;

public class ModularGameOfNumbers {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int n = s.nextInt();
		int p = s.nextInt();
		int q = s.nextInt();
		int[] a = new int[p];
		int[] b = new int[q];
		for(int i=0;i<p;i++) {
			a[i]=s.nextInt();
		}
		for(int i=0;i<q;i++) {
			b[i]=s.nextInt();
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=1;i<=n;i++) {
			map.put(i,0);
		}
		for(int k=1;k<=n;k++) {
			boolean flag = false;
			for(int i=0;i<p;i++) {
				int first = a[i];
				for(int j=0;j<q;j++) {
					int second = b[j];
					int x = (first+second) % n;
					int temp = x+k;
					if(temp%n==0) {
						flag = true;
						map.put(k, map.get(k)+1);
					}
				}
			}
			if(!flag) {
				System.out.println(k);
				return;
			}
		}
		int min = Integer.MAX_VALUE;
		int ans = -1;
		for(int i=1;i<=n;i++) {
			if(min>map.get(i)) {
				min = map.get(i);
				ans = i;
			}
		}
		System.out.println(ans);
	}
}
