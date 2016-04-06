package com.binaryTree;

public class SwapNodes {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next= new Node(5);
		head.next.next.next.next.next= new Node(6);
		Node cur = head;
		while (cur != null) {
			System.out.println(cur.data);
			cur = cur.next;
		}
		System.out.println("*****************");
		SwapNodes n = new SwapNodes();
		head = n.swapNode(head);
		cur = head;
		while (cur != null) {
			System.out.print(cur.data+" ");
			cur = cur.next;
		}
	}

	public Node swapNode(Node head) {
		Node prev = head, cur = prev.next;
		while (cur!= null) {
			if (prev == head) {
				prev.next = cur.next;
				cur.next = prev;
				head = cur;
				cur = cur.next.next.next;
			} else {
				prev.next.next = cur.next;
				cur.next = prev.next;
				prev.next = cur;
				prev = prev.next.next;
				if(cur.next.next!=null)
				cur = cur.next.next.next;
				else break;
			}
		}
		return head;
	}

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
}
