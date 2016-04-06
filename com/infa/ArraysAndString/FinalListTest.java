package com.infa.ArraysAndString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FinalListTest {
	public static void swap(final List<Integer> list){
		int t =list.get(0);
		list.set(0, list.get(1));
		list.set(1, t);	
	}

	public static void main(String[] args) {
		final List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		int t =list.get(0);
		list.set(0, list.get(1));
		list.set(1, t);
		Collections.swap(list, 1, 2);
		
		for (int i:list){
			System.out.println(i);
		}
		swap(list);
		for (int i:list){
			System.out.println(i);
		}
	}
}
