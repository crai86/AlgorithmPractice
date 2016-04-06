package com.stackQueue;

import java.util.Stack;

public class Solutionparenthese {
	public int isValid(String a) {
	    Stack<Character> st = new Stack<>();
	    
	    for(int i=0;i<a.length();i++){
	        switch(a.charAt(i)){
	            case '(':
	            case '{':
	            case '[':st.push(a.charAt(i));
	                break;
	        }
	         switch(a.charAt(i)){
	            case ')':
	             if(!st.isEmpty() && st.peek()!='(') return 0;
	             break;
	                
	            case '}':
	            	char t1 =st.pop();
		             if(!st.isEmpty() && st.peek()!='{') return 0;
		             break;
	            case ']':
	            	char t2 =st.pop();
		             if(!st.isEmpty() && st.peek()!='[') return 0;
		             break;
	                
	        }
	    }
	    return 1;
	}
	
	public static void main(String[] args) {
		StringBuilder st = new StringBuilder();
		String a = new String("/home//foo/");
		System.out.println(simplifyPath(a));
	
	}
	
	public  static String simplifyPath(String a) {
	    Stack<String> st = new Stack<>();
	    String[] sarr= a.split("/");
	    for(int i=1;i<sarr.length;i++){
	        if(!st.isEmpty() && sarr[i].equals("..")){
	            st.pop();
	        }
	        else if(!sarr[i].equals("..") && !sarr[i].equals(".") && !sarr[i].equals("")){
	            st.push(sarr[i]);
	        }
	    }
	    StringBuilder str = new StringBuilder();
	    if(st.isEmpty()) return "/";
	    while(!st.isEmpty()){
//	    	if(st.size()>1)
	        str.insert(0,"/"+st.pop());
	    }
	    return str.toString();
	}
}
