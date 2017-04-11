package hackerrank;

import java.util.HashMap;
import java.util.Scanner;

public class BeautifulWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.next();
		HashMap<Character, Boolean> vowels = new HashMap<>();
		vowels.put('a', true);
		vowels.put('e', true);
		vowels.put('i', true);
		vowels.put('o', true);
		vowels.put('u', true);
		vowels.put('y', true);
		char prev = str.charAt(0);
		for(int i=1;i<str.length();i++) {
			if(str.charAt(i)==prev) {
				System.out.println("No");
				return;
			} else if(vowels.containsKey(str.charAt(i)) && vowels.containsKey(prev)) {
				System.out.println("No");
				return;
			}
			prev=str.charAt(i);
		}
		System.out.println("Yes");
	}

}
