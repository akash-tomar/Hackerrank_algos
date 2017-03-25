package hackerrank;

import java.io.*;
import java.util.*;
public class Solution {
	
	public static long[][] coin=new long[251][51];
	public static long coinChange(int amountToBeMade,int index, int[] coins) {
		if( amountToBeMade < 0 ) {
			return 0;
		}
		if( amountToBeMade == 0 ) {
			return 1;
		}
		if( index<0 ) {
			return 0;
		}
		if(coin[amountToBeMade][index]!=-1) {
			return coin[amountToBeMade][index];
		}
		coin[amountToBeMade][index]=coinChange(amountToBeMade, index-1, coins)+coinChange(amountToBeMade-coins[index], index, coins);		
		return coin[amountToBeMade][index];
	}
	
	
	public static void main(String[] args) {		
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		int[] coins = new int[m];
		for(int i=0;i<m;i++) {
			coins[i]=s.nextInt();
		}
		for(int i=0;i<coin.length;i++) {
			for(int j=0;j<coin[i].length;j++) {
				coin[i][j]=-1;
			}
		}
		System.out.println(coinChange(n,coins.length-1,coins));
	}
}

