package com.linkedlist;

import com.linkedlist.MergePointLinkedList.ListNode;

public class SolutionSwapl {
	public ListNode swapPairs(ListNode a) {
	    ListNode list1=new ListNode(0);
	    ListNode list2=new ListNode(0);
	    ListNode cur=a;
	    ListNode curlist=list1;
	    while(cur!=null && cur.next!=null){
	    curlist.next=cur;
	    curlist=curlist.next;
	    cur=cur.next.next;
	    curlist.next=null;
	    }
	    cur=a.next;
	    curlist=list2;
	    while(cur!=null && cur.next!=null){
	    curlist.next=cur;
		curlist=curlist.next;
		cur=cur.next.next;
	    curlist.next=null;
	    
	    }
	   ListNode resList=new ListNode(0);
	   list1=list1.next;
	   ListNode finalList=resList;
	   list2=list2.next;
	   boolean flag=false;
	   while(list1!=null && list2!=null){
	       if(!flag){
	           finalList.next=list2;
	           list2=list2.next;
	           flag=!flag;
	       }else{
	            finalList.next=list1;
	           list1=list1.next;
	           flag=!flag;
	       }
	       finalList=finalList.next;
	   }
	   if(list1==null){
	       finalList.next=list2;
	   }
	   else{
	       finalList.next=list1;
	   }
	    return resList.next;
	    
	}
	
	public static void main(String[] args) {
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(4);
		SolutionSwapl s =new SolutionSwapl();
		s.swapPairs(l);
	}

}
