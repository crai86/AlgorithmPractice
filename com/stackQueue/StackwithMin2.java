package com.stackQueue;

import java.util.Stack;

public class StackwithMin2 extends Stack<Integer> {
	Stack<Integer> s2;
	
	public StackwithMin2(){
		s2=new Stack<Integer>();
	}
	
	public void push(int data){
		if(data<=min()){
			s2.push(data);
		}
		super.push(data);
	}
	public Integer pop(){
		int value =super.pop();
		if(value==s2.peek()){
			s2.pop();
		}
		return value;
	}
	
	public static void main(String[] args) {
		StackwithMin2 st = new StackwithMin2();
		st.push(10);
		st.push(6);
		st.push(4);
		
		st.push(5);st.push(13);
		System.out.println(st.min());
		
	}
	
	public int min(){
		if(this.isEmpty()){
			return Integer.MAX_VALUE;
		}
		else{
			return s2.peek();
		}
	}

}
