package hackerrank;
import java.util.*;
public class AccurateSorting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            HashMap<Integer, Integer> map =new HashMap<>();
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
                map.put(a[a_i], a_i);
            }
            
            
            int[] arr= a.clone();
            Arrays.sort(arr);
            int end = arr.length-1;
            boolean flag = false;
            HashMap<Integer, Boolean> seen = new HashMap<>();
            while(end>=0) {
            	int index = map.get(arr[end]);
            	for(int i=index+1;i<n;i++) {
            		if(Math.abs(a[i]-a[index])>=2 && !seen.containsKey(a[i])) {
            			System.out.println("No");
            			flag=true;
            			break;
            		} 
            	}
            	if(flag) {
            		break;
            	} else {
            		seen.put(a[index],true);
            	}
            	end--;
            }
            if(flag) {
            	continue;
            } else {
            	System.out.println("Yes");
            }
        }
    }
}
