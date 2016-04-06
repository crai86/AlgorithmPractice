package com.info.cache;

import java.util.HashMap;
import java.util.Map;

public class LCache {
	int capacity;
	Node head;
	Node end;
	Map<Integer, Node> map = new HashMap<Integer, Node>();

	public LCache(int capacity) {
		super();
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			sethead(n);
			return n.value;
		}
		return -1;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node old = map.get(key);
			old.value = value;
			remove(old);
			sethead(old);

		} else {
			Node created = new Node(key, value);
			if (map.size() == capacity) {
				map.remove(end.key);
				remove(end);
				sethead(created);
			} else {
				sethead(created);
			}
		}
	}

	private void sethead(Node n) {
		n.next=head;
		n.pre=null;
        if(head!=null){
			head.pre=n;
		}
        head=n;
		if(end==null){
			end=head;
		}

	}

	private void remove(Node n) {
		if(n.pre==null){
			head=n.next;
		}
		else{
			n.pre.next = n.next;
		
		}
		if(n.next!=null){
			n.next.pre = n.pre;
		}else{
			end =n.pre;
		}
	}
	public static void main(String[] args) {
		LCache lc = new LCache(1);
		lc.set(2,1);
		System.out.println(lc.get(2));
	}

}
