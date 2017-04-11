package hackerrank;
import java.util.*;
public class AccurateSorting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            boolean flag = false;
            for(int i=0;i<n;i++) {
            	for(int j=i+1;j<n;j++) {
            		if(a[i]>a[j] && a[i]-a[j]>=2) {
            			System.out.println("No");
            			flag=true;
            			break;
            		}
            	}
            	if(flag) {
            		break;
            	}
            }
            if(flag) {
            	continue;
            } else {
            	System.out.println("Yes");
            }
        }
    }
}
