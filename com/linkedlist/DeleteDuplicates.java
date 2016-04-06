package com.linkedlist;

import com.linkedlist.MergePointLinkedList.ListNode;

public class DeleteDuplicates {
	
	public static void main(String[] args) {
		DeleteDuplicates l = new DeleteDuplicates();
//		A : [ 45 -> 50 -> 45 -> 28 -> 43 -> 7 -> 21 -> 45 -> 50 -> 45 ]
		ListNode node = new ListNode(1);
		node.next=new ListNode(1);
		node.next.next= new ListNode(1);
		node.next.next.next= new ListNode(2);
		node.next.next.next.next= new ListNode(2);
		node.next.next.next.next.next= new ListNode(3);
//		node.next.next.next.next.next.next= new ListNode(21);
//		node.next.next.next.next.next.next.next= new ListNode(45);
//		node.next.next.next.next.next.next.next.next= new ListNode(50);
//		node.next.next.next.next.next.next.next.next.next= new ListNode(45);
		System.out.println(l.deleteDuplicates(node));
	}
	
	public ListNode deleteDuplicates(ListNode a) {
	    ListNode t= new ListNode(0);
	    t.next=a;
	    ListNode cur=t;
	    ListNode next =null;
	    while(cur.next!=null){
	        next=cur.next;
	        if(cur.data==next.data){
	        	int dup=cur.data;
	        	while(next!=null && next.data==dup){
	        		next=next.next;
	        	}
	        	 t.next=next;
	        }
	      cur=cur.next; 
	    }
	    
	    return t.next;
	}

}
