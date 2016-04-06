package com.backtracking;

import java.util.ArrayList;

public class Solution {
	public ArrayList<String> letterCombinations(String a) {
		ArrayList<ArrayList<Character>> arr =makeArray();
		ArrayList<ArrayList<Character>> temp= new ArrayList<ArrayList<Character>>();
		for(int i=0;i<a.length();i++){
			temp.add(arr.get(a.charAt(i)-'0'));
		}
	    
	    return permute(temp,0);
	    
	}

	private ArrayList<String> permute(ArrayList<ArrayList<Character>> temp,int k) {
		if(k==temp.size()-1)
		{
			ArrayList<String> xy = new ArrayList<String>();
			for(Character c1:temp.get(k)){
				xy.add(Character.toString(c1));
			}
			return xy;
		}
		ArrayList<Character> l1 = temp.get(k);
		ArrayList<String> res=permute(temp, k+1);
	    ArrayList<String> t = new ArrayList<String>();
			for(Character c1 : l1){
				for(int i=0;i<res.size();i++){
					String s = c1+res.get(i);
					t.add(s);
				}
			}
		return t;
		
	}

	private ArrayList<ArrayList<Character>> makeArray() {
		ArrayList<ArrayList<Character>> arr = new ArrayList<>();
	    ArrayList<Character> t = new ArrayList<Character>();
	    t.add('0');
	    arr.add(t);
	    t = new ArrayList<Character>();
	    t.add('1');
	    arr.add(t);
	    t = new ArrayList<Character>();
	    t.add('a');
	    t.add('b');
	    t.add('c');
	    arr.add(t);
	    t = new ArrayList<Character>();
	    t.add('d');
	    t.add('e');
	    t.add('f');
	    arr.add(t);
	    t = new ArrayList<Character>();
	    t.add('g');
	    t.add('h');
	    t.add('i');
	    arr.add(t);
	    t = new ArrayList<Character>();
	    t.add('j');
	    t.add('k');
	    t.add('l');
	    arr.add(t);
	    t = new ArrayList<Character>();
	    t.add('m');
	    t.add('n');
	    t.add('o');
	    arr.add(t);
	    t = new ArrayList<Character>();
	    t.add('p');
	    t.add('q');
	    t.add('r');
	    t.add('s');
	    arr.add(t);
	    t = new ArrayList<Character>();
	    t.add('t');
	    t.add('u');
	    t.add('v');
	    arr.add(t);
	    t = new ArrayList<Character>();
	    t.add('w');
	    t.add('x');
	    t.add('y');
	    t.add('z');
	    arr.add(t);
	    return arr;
	}
	
	public static void main(String[] args) {
		Solution st = new Solution();
		System.out.println(st.letterCombinations("123"));
	}
}

