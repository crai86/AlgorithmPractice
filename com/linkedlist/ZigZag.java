package com.linkedlist;

public class ZigZag {
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
		Node cur=head;
		while(cur!=null){
			System.out.println(cur.data);
			cur=cur.next;
		}
		ZigZag z = new ZigZag();
		head=z.reArraange(head);
		cur=head;
		System.out.println("****************");
		while(cur!=null){
			System.out.println(cur.data);
			cur=cur.next;
		}
	}
	
	public Node reverseList(Node head){
		Node prev=null,curr,next;
		curr=head;
		while(curr!=null){
			next = curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		return prev;
	}
	
	public Node reArraange(Node head){
		Node slow,fast;
		slow=head;
		fast=slow.next;
		while(fast!=null && fast.next !=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		Node head1,head2;
		head1=head;
		head2=slow.next;
		slow.next=null;
		head2=reverseList(head2);
		
		head = new Node(0);
		Node curr=head;
		while(head1!=null || head2!=null){
			if(head1!=null){
				curr.next=head1;
				curr=curr.next;
				head1=head1.next;
			}
			if(head2!=null){
				curr.next=head2;
				curr=curr.next;
				head2=head2.next;
			}
		}
		head= head.next;
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
