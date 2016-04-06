package com.hashing;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class SolutionCopyList {
	/**
	 * Definition for singly-linked list with a random pointer. class
	 * RandomListNode { int label; RandomListNode next, random;
	 * RandomListNode(int x) { this.label = x; } };
	 */
	public RandomListNode copy(RandomListNode head) {

		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode cur = head;
		RandomListNode newHead = new RandomListNode(-1);
		RandomListNode newcur=newHead;
		while (cur != null) {
			RandomListNode t = new RandomListNode(cur.label);
			newcur.next = t;
			map.put(cur, t);
			cur = cur.next;
			newcur=newcur.next;
		}
		newHead = newHead.next;
		cur = head;
		while (cur != null) {
           RandomListNode  t = map.get(cur);
           RandomListNode random=map.get(cur.random);
           t.random=random;
           cur=cur.next;
		}
		return newHead;
	}

	public RandomListNode copyRandomList(RandomListNode head) {
		Map<Integer, RandomListNode> map = new HashMap<>();
		RandomListNode cur = head;
		while (cur != null) {
			map.put(cur.label, cur);
			cur = cur.next;
		}
		RandomListNode newHead = new RandomListNode(head.label);
		RandomListNode headNext = new RandomListNode(head.next.label);
		RandomListNode random = new RandomListNode(head.random.label);
		newHead.next = headNext;
		newHead.random = random;
		cur = newHead.next;
		Map<Integer, RandomListNode> newmap = new HashMap<>();
		newmap.put(head.label, newHead);
		newmap.put(headNext.label, headNext);
		newmap.put(random.label, random);
		while (cur != null) {
			if (map.containsKey(cur.label)) {
				RandomListNode oldcur = map.get(cur.label);
				if (oldcur.next != null) {
					if (newmap.containsKey(oldcur.next.label)) {
						cur.next = newmap.get(oldcur.next.label);
					} else
						cur.next = new RandomListNode(oldcur.next.label);
				} else
					cur.next = null;

				if (oldcur.random != null) {
					if (newmap.containsKey(oldcur.random.label)) {
						cur.random = newmap.get(oldcur.random.label);
					} else
						cur.random = new RandomListNode(oldcur.random.label);
				} else
					cur.random = null;
			}
			if (!newmap.containsKey(cur.label))
				newmap.put(cur.label, cur);
			cur = cur.next;
		}
		return newHead;
	}

	public static void main(String[] args) {
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode nextnode = new RandomListNode(2);
		RandomListNode nextnextnode = new RandomListNode(3);
		node1.next = nextnode;
		nextnode.next = nextnextnode;
		node1.random = nextnextnode;
		nextnextnode.random = node1;
		nextnode.random = node1;
		SolutionCopyList cp = new SolutionCopyList();
//		cp.copyRandomList(node1);
		RandomListNode n= cp.copy(node1);
		while(n!=null){
			System.out.println(n.label+" "+n.random.label);
			n=n.next;
		}
		BigInteger big=new BigInteger(String.valueOf(10));
		big.intValue();
		

	}

	public static class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}

		@Override
		public String toString() {
			return "RandomListNode [label=" + label + ", next=" + next
					+ ", random=" + random + "]";
		}

	};

}
