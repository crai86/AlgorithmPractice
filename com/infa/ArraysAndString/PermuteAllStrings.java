package com.infa.ArraysAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class PermuteAllStrings {
	
	public static ArrayList<String> permute(String s){
		ArrayList<String> permute = new ArrayList<String>();
		if(s==null) return null;
		else if(s.length()==0){
           permute.add("");
           return permute;
		}
		char first =s.charAt(0);
		String rem =s.substring(1);
		ArrayList<String> words =permute(rem);
		for(String word:words){
			for(int i=0;i<=word.length();i++){
				permute.add(insertcharAt(word,i,first));
			}
		}
		return permute;
		
	}
	
	public static void printpar(int l,int r,char[] s,int count){
		if(l<0 || r<l) return;
		if(l==0 && r==0){
			System.out.println(s);
		}
		else{
			if(l>0){
				s[count]='(';
				printpar(l-1, r, s, count+1);
				
			}
			if(r>l){
				s[count]=')';
				printpar(l, r-1, s, count+1);
			}
		}
	}

	private static String insertcharAt(String word, int i, char first) {
		
		return word.substring(0,i)+first+word.substring(i);
		
	}
	
	public static void merge(int[]a,int[]b,int m ,int n){
		int k=m+n-1;
		int i=m-1;
		int j=n-1;
		while(i>=0 && j>=0){
			if(a[i]>b[j]){
				a[k--]=a[i--];
			}
			else{
				a[k--]=b[j--];
			}
		}
		while(j>=0){
			a[k--]=b[j--];
		}
		
	}
	public static void main(String[] args) {
		System.out.println(permute("abc"));
		printpar(3, 3, new char [6], 0);
		String[] s={"chandan","andanch","mary","test","army"};
		Arrays.sort(s, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return sortchars(o1).compareTo(sortchars(o2));
			}

			private String sortchars(String o1) {
                 char[] ch =o1.toCharArray();
                 Arrays.sort(ch);
				return new String(ch);
			}
			
		});
		for(String k:s){
			System.out.println(k);
		}
	}

}
