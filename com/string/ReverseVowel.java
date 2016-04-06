package com.string;

public class ReverseVowel {
	public String reverseVowel(String s){
		int j=0;
		StringBuilder st = new StringBuilder();
		for(int i=0;i<s.length();){
			if(s.charAt(i)==' '){
				String t=reverseword(s.substring(j,i));
				st.append(t);
				st.append(" ");
				j=i+1;
				i=i+t.length();
			}else{
				i++;
			}
		}
		String t=reverseword(s.substring(j,s.length()));
		st.append(t);
		return st.toString();
	}

	private String reverseword(String substring) {
		
		int i=0;
		int j =substring.length()-1;
		while(i<=j){
			if(isVowel(substring.charAt(i)) && isVowel(substring.charAt(j))){
				substring=swap(substring,i,j);
				i++;
				j--;
			}
			else if(!isVowel(substring.charAt(i))){
				i++;
			}
			else if(!isVowel(substring.charAt(j))){
				j--;
			}
			
		}
		return substring;
	}

	private String swap(String substring, int i, int j) {
		char[] a =substring.toCharArray();
		char t = a[i];
		a[i]=a[j];
		a[j]=t;
     	return String.valueOf(a);
		
	}

	private boolean isVowel(char ch) {
		if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') return true;
		return false;
	}

	public static void main(String[] args) {
		ReverseVowel rv = new ReverseVowel();
		System.out.println(rv.reverseVowel("I work for tasitoe Flipkart"));
	}
}
