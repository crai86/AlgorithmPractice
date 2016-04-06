package com.stackQueue;

import java.util.Stack;		

public class StackWithMin extends Stack<StackWithMin.NodewithMin> {

	public void push(int data) {
		int min = Math.min(data, min());
		super.push(new NodewithMin(data, min));
	}

	private int min() {
		if (this.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return peek().min;
		}
	}
	public static void main(String[] args) {
		StackWithMin st = new StackWithMin();
		st.push(10);
		st.push(5);
		st.push(3);
		st.push(8);
		System.out.println(st.peek().min);
	}

	public static class NodewithMin {
		int value;
		int min;

		public NodewithMin(int value, int min) {
			this.value = value;
			this.min = min;
		}
	}
}
