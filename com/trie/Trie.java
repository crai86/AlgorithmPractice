package com.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	TrieNode root;
	Map<String, Integer> counter;
	public Trie(){
		root= new TrieNode();
		counter = new HashMap<String, Integer>();
	}
	
	public void insert(String word){
		
		Map<Character, TrieNode> children= root.getChildren();
		for(int i=0;i<word.length();i++){
			char ch = word.charAt(i);
			TrieNode t;
			if(children.containsKey(ch)){
				t=children.get(ch);
				
			}
			else{
				t=new TrieNode(ch);
				children.put(ch, t);
			}
			children=t.getChildren();
			if(i==word.length()-1){
				t.setLeaf(true);
			}
		}
		
	}
	public boolean search(String word){
		TrieNode t = searchNode(word);
		 
        if(t != null && t.isLeaf) {
        	if(counter.containsKey(word)){
        		counter.put(word, counter.get(word)+1);
        	}else{
        		counter.put(word, 1);
        	}
        	return true;
        }
        else
            return false;
	}

	private TrieNode searchNode(String word) {
		Map<Character, TrieNode> children= root.getChildren();
		TrieNode t = null;
		for(int i=0;i<word.length();i++){
			char ch = word.charAt(i);
			if(children.containsKey(ch)){
				t=children.get(ch);
				children=t.getChildren();
			}
			else{
				return null;
			}
		}
		return t;
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("cats");
		trie.insert("dogs");
		trie.insert("and");
		System.out.println(trie.search("ytrcats"));
		trie.search("cats");
		trie.search("cats");
		System.out.println(trie.counter);
	}

}
