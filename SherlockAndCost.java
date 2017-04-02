package hackerrank;

import java.util.Scanner;

public class SherlockAndCost {

	public static int getMaxDiff(int[] arr,int[] arr_so_far,int index) {
		if(index==arr.length) {
			int diff=0;
			for(int i=1;i<arr.length;i++) {
				diff+=Math.abs(arr_so_far[i]-arr_so_far[i-1]);
			}
			return diff;
		}
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=arr[index];i++) {
			arr_so_far[index]=i;
			max= Math.max(max,getMaxDiff(arr,arr_so_far,index+1));
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		int t = s.nextInt();
		for(int test = 0;test<t;test++) {
			int n=s.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=s.nextInt();
			}
			int[] arr_so_far = new int[n];
			System.out.println(getMaxDiff(arr, arr_so_far, 0));
 		}

	}

}
