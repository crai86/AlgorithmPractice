package com.linkedlist;

public class MergePointLinkedList {
	
	public ListNode getIntersectionNode(ListNode a, ListNode b) {
	    ListNode curb=b;
	    while(curb.next!=null)curb=curb.next;
	    ListNode cura=a;
	    while(cura.next!=null)cura=cura.next;
	    if(cura==curb) return a;
	    return null;
	}
	public static void main(String[] args) {
		MergePointLinkedList l = new MergePointLinkedList();
//		A : [ 45 -> 50 -> 45 -> 28 -> 43 -> 7 -> 21 -> 45 -> 50 -> 45 ]
		ListNode node = new ListNode(45);
		node.next=new ListNode(50);
		node.next.next= new ListNode(45);
		node.next.next.next= new ListNode(28);
		node.next.next.next.next= new ListNode(43);
		node.next.next.next.next.next= new ListNode(7);
		node.next.next.next.next.next.next= new ListNode(21);
		node.next.next.next.next.next.next.next= new ListNode(45);
		node.next.next.next.next.next.next.next.next= new ListNode(50);
		node.next.next.next.next.next.next.next.next.next= new ListNode(45);
		System.out.println(l.lPalin(node));
	}

	public static class ListNode{
		int data;
		ListNode next;
		public ListNode() {
			
		}
		public ListNode(int data){
			this.data=data;
			this.next=null;
		}
	}
	 
	    public int lPalin(ListNode A) {
	        ListNode cur =A;
	        int count=0;
	        while(cur!=null){
	            cur=cur.next;
	            count++;
	        }
	        int mid=count/2;
	        cur=A;
	        ListNode halfList=null;
	        for(int i=0;i<mid-1;i++){
	            cur=cur.next;
	        }
	        if(count%2==1 && cur.next!=null){
	            halfList=cur.next.next;
	        }
	        else{
	            halfList=cur.next;
	        }
	        cur =A;
	        halfList=reverse(halfList);
	        while(cur!=null && halfList!=null){
	            if(cur.data!=halfList.data) return 0;
	            cur=cur.next;
	            halfList=halfList.next;
	        }
	        return 1;
	    }
	    
	    public ListNode reverse(ListNode head){
	        ListNode prev=null;
	        ListNode next=null;
	        ListNode cur=head;
	        while(cur!=null){
	            next=cur.next;
	            cur.next=prev;
	            prev=cur;
	            cur=next;
	            
	        }
	        return prev;
	    }
}
