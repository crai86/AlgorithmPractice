package com.linkedlist;

import com.linkedlist.MergePointLinkedList.ListNode;

public class CycleSolution {
	
		public static ListNode detectCycle(ListNode a) {
		    ListNode slow=a;
		    ListNode fast=a;
		    int k=0;
		    while(slow!=null && fast!=null && fast.next!=null){
		        slow=slow.next;
		        fast=fast.next.next;
		        if(slow==fast){
		            fast=fast.next;
		            k++;
		            while(slow!=fast){
		            	fast=fast.next;
		            	k++;
		            }
		            break;
		        }
		    }
		    ListNode cur = a;
		    ListNode cur2 =a;
		    if(k==0){
		    	return null;
		    }
		    while(k>0){
		    	cur2=cur2.next;
		    	k--;
		    }
		    while(cur!=cur2){
		    	cur=cur.next;
		    	cur2=cur2.next;
		    }
		    return cur2;
		}

 public static void main(String[] args) {
	 
	 ListNode head =  new ListNode(1);
	 head.next=new ListNode(2);
	 head.next.next=new ListNode(3);
	 head.next.next.next= new ListNode(4);
	 head.next.next.next.next=  new ListNode(5);
	 head.next.next.next.next.next=head.next;
	 System.out.println(detectCycle(head).data);
	 
	
}

}
