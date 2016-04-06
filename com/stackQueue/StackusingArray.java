package com.stackQueue;

public class StackusingArray {

	private static int stackSize=300;
	private static int[] buffer= new int[stackSize*3];
	private static int[] stackPointer = {0,0,0};
	
	public static void push(int stackNum,int value){
		int index=stackNum*stackSize+stackPointer[stackNum]+1;
		stackPointer[stackNum]++;
		buffer[index]=value;
	}
	public static int pop(int stackNum){
		int index=stackNum*stackSize+stackPointer[stackNum];
		stackPointer[stackNum]--;
		int value = buffer[index];
		buffer[index]=0;
		return value;
		}
	public static int peek(int stackNum){
		int index=stackNum*stackSize+stackPointer[stackNum];
		return buffer[index];
	}
	
}
