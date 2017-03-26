package hackerrank;

import java.util.Scanner;

public class Equal {
	static int minSoFar = Integer.MAX_VALUE;
	public static int equal(int[] arr,int valueSoFar) {
		if(minSoFar<valueSoFar) {
			return Integer.MAX_VALUE;
		}
		if(allElementsEqual(arr)) {
			minSoFar = Math.min(minSoFar, valueSoFar);
			return valueSoFar;
		}
		int index = getMaxIndice(arr);
		int[] one = increaseEveryoneExcept(arr.clone(), index, 1);
		int num_1= equal(one,valueSoFar+1);
		int[] two  = increaseEveryoneExcept(arr.clone(), index, 2);
		int num_2 = equal(two,valueSoFar+1);
		int[] five = increaseEveryoneExcept(arr.clone(), index, 5);
		int num_5 = equal(five,valueSoFar+1);
		return Math.min(num_1, Math.min(num_2, num_5));
	}
	public static int[] increaseEveryoneExcept(int[] arr,int index,int value) {
		for(int i=0;i<arr.length;i++) {
			if(i!=index) {
				arr[i]+=value;
			}
		}
		return arr;
	}
	public static boolean allElementsEqual(int[] arr) {
		int comp = arr[0];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=comp) {
				return false;
			}
		}
		return true;
	}
	public static int getMaxIndice(int[] arr) {
		int max = Integer.MIN_VALUE;
		int index = -1;
		for(int i=0;i<arr.length;i++) {
			if(max>arr[i]) {
				max = arr[i];
				index = i;
			}
		}
		return index;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int test = 0;test<t;test++) {
			int n = s.nextInt();
			int[] arr= new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=s.nextInt();
			}
			System.out.println(equal(arr, 0));
		}
	}

}
