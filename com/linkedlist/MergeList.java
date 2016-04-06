package com.linkedlist;

import com.linkedlist.MergePointLinkedList.ListNode;

public class MergeList {
	public  static ListNode mergeTwoLists(ListNode a, ListNode b) {
	    ListNode head = new ListNode(0);
	    ListNode t = head;
	    while(a!=null && b!=null){
	        if(a.data<b.data){
	            t.next=new ListNode(a.data);
	            a=a.next;
	            
	        }
	        else if(b.data<a.data){
	              t.next=new ListNode(b.data);
	              b=b.next;
	        }
	        else if(b.data==a.data){
	             t.next=new ListNode(b.data);
	              b=b.next;
	              a=a.next;
	        }
	        t=t.next;
	    }
	    if(a!=null){
	        t.next=a;
	    }
	    if(b!=null){
	        t.next=b;
	    }
	    return head.next;
	}
	public static void main(String[] args) {
		ListNode l = new ListNode(5);
		l.next= new ListNode(8);
		l.next.next=new ListNode(20);
		ListNode b = new ListNode(4);
		b.next=new ListNode(11);
		b.next.next=new ListNode(11);
		mergeTwoLists(l, b);
	}
}
