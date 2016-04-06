package com.stackQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Slidingmax {

	public void slidingmax(List<Integer> a,int w){
		Deque<Integer> q= new LinkedList<Integer>();
		for(int i=0;i<w;i++){
			while(!q.isEmpty() && a.get(i)>=q.peekLast())
				q.removeLast();
			q.addLast(i);
		}
		int n = a.size();
		int[]b = new int[n-w+1];
		for(int i=w+1;i<n;i++){
			b[i-w]=a.get(q.peekFirst());
			while(!q.isEmpty() && a.get(i)>=q.peekLast())
				q.removeLast();
			while(!q.isEmpty() && q.peekFirst()<=(i-w))
				q.removeFirst();
			q.addLast(i);
		}
		b[n-w]=a.get(q.peekFirst());
	}
}
