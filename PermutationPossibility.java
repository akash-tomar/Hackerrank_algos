package hackerrank;

import java.util.HashMap;
import java.util.Scanner;

public class PermutationPossibility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		HashMap<Integer,Boolean> map = new HashMap<>();
//		boolean flag=false;
		for(int i=0;i<m;i++) {
			int a = s.nextInt();
			if(map.containsKey(a)) {
				System.out.println("NO");
				return;
//				flag=true;
			} else {
				map.put(a, true);
			}
		}
		System.out.println("TRUE");
	}

}
