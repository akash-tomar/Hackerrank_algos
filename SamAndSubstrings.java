package hackerrank;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class SamAndSubstrings {
	
	public static ArrayList<String> getSubstringsIterative(String str) {
		long ans = 0;
		ArrayList<String> list = new ArrayList<>();
		for(int i=0;i<str.length();i++) {
			if(list.size()!=0) {
				ArrayList<String> newlist = (ArrayList<String>)list.clone();
				for(int j=0;j<list.size();j++) {
					String temp = list.get(j);
					if(!temp.equals("")) {
						if(temp.charAt(temp.length()-1)==str.charAt(i-1)) {
							temp = temp+str.charAt(i);
							newlist.add(temp);
						}
					} else {
						temp = temp+str.charAt(i);
						newlist.add(temp);
					}
				}
				list = newlist;
			} else {
				list.add(str.charAt(i)+"");
				list.add("");
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.next();
		ArrayList<String> list = getSubstringsIterative(str);
		BigInteger sum = new BigInteger("0");
		for(String st1r : list) {
			if(!st1r.equals("")) {
				BigInteger b = new BigInteger(st1r);
				sum = sum.add(b);
				BigInteger bi = new BigInteger("1000000007");
				sum.mod(bi);
			}
		}
		System.out.println(sum.longValue());
	}

}
