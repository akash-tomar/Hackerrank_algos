package hackerrank;

import java.util.Scanner;

public class EqualV2 {
	
	public static int getIterations(int[] arr,int min) {
		int ans = 0;
		for(int i=0;i<arr.length;i++) {
			int diff = arr[i]-min;
			if(diff==0) {
				continue;
			}
			if(diff>=5) {
				float val = (float) (diff/5.0);
				ans+=(int)val;
				diff-=((int)val)*5;
			}
			if(diff>=2) {
				float val = (float) (diff/2.0);
				ans+=(int)val;
				diff-=((int)val)*2;
			}
			if(diff>=1) {
				float val = (float) (diff/1.0);
				ans+=(int)val;	
				diff-=((int)val)*1;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int test = s.nextInt();
		for(int t=0;t<test;t++) {
			int n = s.nextInt();
			int[] arr= new int[n];
			int min = Integer.MAX_VALUE;
			for(int i=0;i<n;i++) {
				arr[i]=s.nextInt();
				min=Math.min(min,arr[i]);
			}
			int ans = Integer.MAX_VALUE;
			ans = Math.min(ans, getIterations(arr, min));
			ans = Math.min(ans, getIterations(arr, min-1));
			ans = Math.min(ans, getIterations(arr, min-2));
			ans = Math.min(ans, getIterations(arr, min-5));
			System.out.println(ans);
		}
	}

}
