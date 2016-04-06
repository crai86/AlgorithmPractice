package com.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	int capacity;
	Map<Integer, Node> nodes = new HashMap<Integer, Node>();
	Node head=null;
	Node end=null;
	
	public LRUCache(int capacity){
		this.capacity=capacity;
	}
	
	public int get(int key){
		if(nodes.containsKey(key)){
			Node n = nodes.get(key);
			remove(n);
			sethead(n);
			return n.value;
		}
		return -1;
	}

	private void sethead(Node n) {
		n.pre=null;
		n.next=head;
		if(head!=null){
			head.pre=n;
		}
		head=n;
		if(end==null){
			end=head;
		}
		
		
	}

	private void remove(Node n) {
		if(n.pre!=null){
			n.pre.next=n.next;
		}
		else{
			head=n.next;
		}
		if(n.next!=null){
			n.next.pre=n.pre;
		}
		else{
			end=n.pre;
		}
		
	}

}
