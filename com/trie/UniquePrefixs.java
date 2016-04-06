package com.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UniquePrefixs {
		public ArrayList<String> prefix(ArrayList<String> a) {
		    Trie trie = new Trie();
		    for(String s : a){
		        trie.insert(s);
		    }
		    ArrayList<String> prefix = new ArrayList<>();
//		    StringBuffer st = new StringBuffer();
//		    trie.findPrefixes(prefix,st);
		    for(String s:a){
		    	String t = trie.query(s);
		    	prefix.add(t);
		    }
		    return prefix;
		}
		public static class TrieNode{
		    char element;
		    int freq;
		    HashMap<Character,TrieNode> children = new HashMap<>();
		    boolean isLeaf;
		    public TrieNode(char c){
		        this.element=c;
		    }
		     public TrieNode(){
		         
		     }
		     public boolean isLeaf() {
			        return isLeaf;
		        }
		   public void setLeaf(boolean isLeaf) {
			        this.isLeaf = isLeaf;
		        }
		    public HashMap<Character, TrieNode> getChildren() {
			return children;
		  }
		}
		public static class Trie{
		    TrieNode root;
		    public Trie(){
		        root=new TrieNode();
		    }
		    public void insert(String word){
		        Map<Character,TrieNode> children = root.getChildren();
		        for(int i=0;i<word.length();i++){
		            char ch = word.charAt(i);
		            TrieNode t ;
		            if(children.containsKey(ch)){
		                t=children.get(ch);
		            }else{
		                t=new TrieNode(ch);
		                children.put(ch,t);
		            }
		            children=t.getChildren();
		            t.freq++;
		            if(i==word.length()-1){
		                t.setLeaf(true);
		            }
		        }
		    }
		    
	      public void findPrefixes(ArrayList<String> res,StringBuffer st){
	          if(root==null){
	              return;
	          }
//	          if(root.isLeaf){
//	              return;
//	          }
	          if(root.freq==1){
	              res.add(st.toString());
	              st=new StringBuffer();
	              return;
	          }
	          for(Map.Entry<Character,TrieNode> entry : root.getChildren().entrySet()){
	              root=entry.getValue();
	              st.append(entry.getKey());
	              findPrefixes(res,st);
	             //if(root.freq>1)
	              st=new StringBuffer(st.substring(0,st.length()-1));
	   
	          }
	      }	
	      public String query(String s){
	    	  StringBuffer st = new StringBuffer();
	    	  Map<Character, TrieNode> children = root.getChildren();
	    	  TrieNode t = null;
	    	  for(int i=0;i<s.length();i++){
	    		  char ch =s.charAt(i);
	    		  if(children.containsKey(ch)){
	    			  st.append(ch);
	    			  t=children.get(ch);
	    			  children=t.getChildren();
	    		  }
	    		  if(t!=null && t.freq==1){
	    			  return st.toString();
	    		  }
	    	  }
	    	  return st.toString();
	      }
	   }
		public static void main(String[] args) {
			UniquePrefixs uq= new UniquePrefixs();
			ArrayList<String> st = new ArrayList<String>();
			st.add("zebra");
			st.add("dog");
			st.add("duck");
			st.add("dot");
			System.out.println(uq.prefix(st));
		}
	}

