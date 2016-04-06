package com.stackQueue;


public class StackUsingNode {
	private static int stackSize=100;
	private static int indexUsed=0;
	private static int[] stackPointer={-1,-1,-1};
    private static StackNode[] buffer = new StackNode[stackSize*3];	
    
    public static void push(int stackNum,int value){
      int lastindex = stackPointer[stackNum];
      stackPointer[stackNum]=indexUsed;
      indexUsed++;
      buffer[stackPointer[stackNum]]=new StackNode(value, lastindex);
    }
    public static int pop(int stackNum){
    	int value=buffer[stackPointer[stackNum]].value;
    	int lastIndex = stackPointer[stackNum];
    	stackPointer[stackNum]=buffer[stackPointer[stackNum]].pre;
    	buffer[lastIndex]=null;
    	indexUsed--;
    	return value;
    }
    public static int peek(int stackNum){
    	return buffer[stackPointer[stackNum]].value;
    }
    public static boolean isEmpty(int stackNum){
    	return stackPointer[stackNum]==-1;
    }
	static class StackNode{
		int value;
		int pre;
		public StackNode(int value,int prev) {
			this.value=value;
			this.pre=pre;
		}
	}

}
