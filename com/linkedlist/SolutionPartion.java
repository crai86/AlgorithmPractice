package com.linkedlist;

import com.linkedlist.MergePointLinkedList.ListNode;

public class SolutionPartion {
	public static ListNode partition(ListNode a, int b) {
		ListNode newList = new ListNode(0);
		ListNode oldlist = new ListNode(0);
		oldlist.next = a;
		ListNode t = newList;
		ListNode cur = oldlist.next;
		ListNode pre = oldlist;
		while (cur != null) {
			if (cur.data < b) {
				t.next = cur;
				pre.next = cur.next;
				cur = cur.next;
				t = t.next;
				t.next = null;

			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		t.next = oldlist.next;
		return newList.next;
	}
	public ListNode insertionSortList(ListNode a) {
	    ListNode newList = new ListNode(Integer.MIN_VALUE);
	    ListNode cur=a;
	    ListNode cura=newList;
	    ListNode next=null;
	    while(cur!=null){
	        next=cur.next;
	        if(next!=null && cur.data>=next.data){
	            cura=newList;
	            while(cura!=null && cura.data<=next.data){
	                cura=cura.next;
	            }
	            cura.next=next;
	            cur.next=next.next;
	            next.next=cura.next;
	            cur=cur.next;
	            cura=cura.next;
	            
	        }else{
	             cura=newList;
	            while(cura!=null && cura.data<=cur.data){
	                cura=cura.next;
	            }
	            cura.next=cur;
	            ListNode t=cur;
	            cur=next;
	            t.next=cura.next;
	            cura=cura.next;
	            
	        }
	    }
	    return newList.next;
	}

	public static void main(String[] args) {
		ListNode l = new ListNode(10);
		l.next = new ListNode(11);
		l.next.next = new ListNode(12);
		l.next.next.next = new ListNode(2);
		l.next.next.next.next = new ListNode(5);
		l.next.next.next.next.next = new ListNode(2);

		System.out.println(partition(l, 3));

	}
}
