package com.stackQueue;

import java.util.Stack;

public class StackString {
	
	public static int braces(String input) {
		
		char[] str=input.toCharArray();
		Stack<Character> Stk = new Stack<Character>();
		for(int i = 0; i < str.length; ++i) {
	         
	        if(str[i] == ')') {
	         
	            int cnt = 0;
	         
	            while(Stk.peek() != '(') {
	                    Stk.pop();
	                    cnt++;
	            }
	         
	            Stk.pop();
	            if(cnt < 2)
	                    return 1;
	        } 
	         
	        else {
	            Stk.push(str[i]);
	        }
	    }
	         
	    boolean is = true;
	     
	    while(!Stk.isEmpty()) {
	         
	        if(Stk.peek() == '(' || Stk.peek() == ')') {
	                is = false;
	                break;
	        }
	        Stk.pop();
	    }
	 
	    if(!is) return 1;
	    return 0;
	}
	public static void main(String[] args) {
		System.out.println(braces("(a)"));
	}

}
