package com.linkedlist;




public class SwapNumbers {
	public static void main(String[] args) {
		Node head = new Node(10);
		head.next=new Node(15);
		head.next.next=new Node(12);
		head.next.next.next=new Node(13);
		head.next.next.next.next=new Node(20);
		head.next.next.next.next.next=new Node(14);
		Node cur=head;
		while(cur!=null){
			System.out.println(cur.data);
			cur=cur.next;
		}
		SwapNumbers s= new SwapNumbers();
		head = s.swapNumbers(head, 12, 20);
		cur=head;
		System.out.println(head.data+"********************");
		while(cur!=null){
			System.out.println(cur.data);
			cur=cur.next;
		}
	}
	
	public Node swapNumbers(Node head,int n1,int n2){
		Node prev1,curr1,prev2,curr2,curr=head,next1=null,next2=null;
		prev1=null;prev2=null;
		while(curr !=null && curr.data!=n1){
			prev1=curr;
			next1 = curr.next;
			curr=curr.next;
		}
		curr1=curr;
		next1 = curr.next;
		while(curr!=null  && curr.data!=n2){
			prev2=curr;
			next2=curr.next;
			curr=curr.next;
		}
		curr2=curr;
		next2=curr.next;
		prev1.next=curr2;
		prev2.next=curr1;
        curr2.next=next1;
        curr1.next=next2;
		return head;
	}
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data){
			this.data=data;
		}
	}


}
