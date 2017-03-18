package hackerrank;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class SubsetComponents {
	public static ArrayList<ArrayList<String>> getSubsets(String[] str,int index) {
		if(index==str.length) {
			ArrayList<ArrayList<String>> arr = new ArrayList<>();
			ArrayList<String> temp = new ArrayList<>();
			arr.add(temp);
			return arr;
		}
		if(index==str.length-1) {
			ArrayList<ArrayList<String>> arr = new ArrayList<>();
			ArrayList<String> temp = new ArrayList<>();
			temp.add("");
			ArrayList<String> temp1 = new ArrayList<>();
			temp.add(str[index]);
			arr.add(temp);
			arr.add(temp1);
			return arr;
		}
		
		String ch = str[index];
		ArrayList<ArrayList<String>> subsets = getSubsets(str,index+1);
		int size = subsets.size();
		for(int i=0;i<size;i++) {
			ArrayList<String> node = (ArrayList<String>) subsets.get(i).clone();
			node.add(ch);
			subsets.add(node);
		}
		return subsets;
	}
	
	public static String getBinary(String num) {
		BigInteger b = new BigInteger(num);
		return b.toString(2);
	}
	
	public static ArrayList<Integer> getNumberOfOnes(String num) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<num.length();i++) {
			if(num.charAt(i)=='1') {
				list.add(i);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String[] array = new String[n];
		for(int i=0;i<n;i++) {
			array[i]=s.next();
		}
		
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();
		for(String st:array) {
			ArrayList<Integer> ones = getNumberOfOnes(getBinary(st));
			map.put(st, ones);
		}
		ArrayList<Integer> temp_l = new ArrayList<>();
		temp_l.add(64);
		map.put("", temp_l);
		ArrayList<ArrayList<String>> subsets = getSubsets(array,0);
		subsets.sort(Comparator.comparing(ArrayList::size));
		long ans = 0;
		
		for(int i=0;i<subsets.size();i++) {
			ArrayList<String> temp = subsets.get(i);
			if(temp.size()==1) {
				if(!temp.get(0).equals("")) {
					ArrayListmap.get(temp.get(0));
				}
			} else if(temp.size()>1) {
				
			} 
		}
		
		
		
		
		for(int i=0;i<subsets.size();i++) {
			ArrayList<String> temp = subsets.get(i);
			if(temp.size()==1) {
				ans+=(65-map.get(temp.get(0)));
			} else if(temp.size()>1) {
				int ones = 0;
				for(String stst : temp) {
					if(!stst.equals("")) {
						ones+=map.get(stst);
					}
				}
				ans+=(65-ones);
			} else {
				ans+=64;
			}
		}
		System.out.println(ans);
		s.close();
	}
}
