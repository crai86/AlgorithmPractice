package com.binaryTree;

import java.util.ArrayList;

public class Possiblepath {
	public int hasPathSum(TreeNode a, int b) {
		int k = recurit(a, b);
		return k;
	}

	public int recurit(TreeNode root, int sum) {
		if ((sum > 0 || sum < 0) && root == null) {
			return 0;
		}
		if (sum == 0) {
			return 1;
		}
		if (sum < 0 && root != null) {
			return 0;
		}
		sum = sum - root.data;
		return recurit(root.left, sum) | recurit(root.right, sum);

	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> t = new ArrayList<>();
		recurit(root, sum, res, t);
		return res;
	}

	public void recurit(TreeNode root, int sum,
			ArrayList<ArrayList<Integer>> res, ArrayList<Integer> t) {
		if ((sum > 0 || sum < 0) && root == null) {
			if(t.size()>1)
			t.remove(t.size()-1);
			return;
		}
		if (sum == 0) {
			if(!res.contains(t))
			res.add(t);
			t = new ArrayList<>();
			return;
		}
		if (sum < 0 && root != null) {
			t.remove(t.size()-1);
			return;
		}
		sum = sum - root.data;
		t.add(root.data);
		recurit(root.left, sum, res, t);
		recurit(root.right, sum, res, t);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1000);
		root.right = new TreeNode(200);
		Possiblepath pt = new Possiblepath();
		int k = 0;
		System.out.println(pt.pathSum(root, 205));
	}

}
