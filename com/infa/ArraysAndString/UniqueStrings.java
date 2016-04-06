package com.infa.ArraysAndString;

public class UniqueStrings {
	public static boolean uniqueStrings(String s){
		boolean[] ch = new boolean[256];
		for(int i=0;i<s.length();i++){
			int k =s.charAt(i);
		    if(ch[k]) return false;
		    else
		    	ch[k]=true;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(uniqueStrings("abc"));
		System.out.println(reverseString("abcd"));
		System.out.println(removeDuplicate("abababdababa"));
		System.out.println(anagramOrNot("mary","army"));
		System.out.println(replaceSpace("How are you".toCharArray()));
	}
	
	public static String reverseString(String s){
		char[] ch = s.toCharArray();
		for(int i=0;i<ch.length/2;i++){
			char t =ch[i];
			ch[i]=ch[ch.length-1-i];
			ch[ch.length-1-i]=t;
		}
		return new String(ch);
	}
	public static String removeDuplicate(String s){
		if(s==null) return s;
		if(s.length()<2) return s;
		boolean[] h = new boolean[256];
		int first = s.charAt(0);
		h[first]=true;
		char[] str = s.toCharArray();
		int tail=1;
		for(int i=1;i<str.length;i++){
			int k =s.charAt(i);
			if(!h[k]){
				str[tail]=str[i];
				tail++;
				h[k]=true;
			}
		}
		str[tail]=0;
		return new String(str);
	}
	
	public static boolean anagramOrNot(String s ,String t){
		if(s.length()!=t.length()) return false;
		int[] ch = new int[256];
		int numofunique=0;
		int numofcompleted=0;
		//1 way to solve this problem
		/**int[] tch = new int[256];
		for(int i=0;i<s.length();i++){
			ch[(int)s.charAt(i)]++;
		}
		for(int j=0;j<t.length();j++){
			tch[(int)t.charAt(j)]++;
		}
		for(int i=0;i<256;i++){
			if(ch[i]!=tch[i]) 
				return false;
		}**/
		for(int i=0;i<s.length();i++){
			if(ch[(int)s.charAt(i)]==0) numofunique++;
			ch[(int)s.charAt(i)]++;
		}
		for(int i=0;i<t.length();i++){
			int k =t.charAt(i);
			if(ch[k]==0) return false;
			
			ch[k]--;
			if(ch[k]==0){
				++numofcompleted;
				if(numofcompleted==numofunique){
					return i==t.length()-1;
				}
			}
		}
		return true;
	}
	
	public static String replaceSpace(char [] s){
		int length = s.length;
		int count=0;
		for(int i=0;i<length;i++){
			if(s[i]==' ')count++;
		}
		int newlength =length+2*count;
		char[] t = new char[newlength];
		for(int i=length-1;i>=0;i--){
			if(s[i]==' '){
				t[newlength-1]='0';
				t[newlength-2]='2';
				t[newlength-3]='%';
				newlength-=3;
			}
			else{
				t[newlength-1]=s[i];
				newlength-=1;
			}
		}
		return new String(t);
	}
}
