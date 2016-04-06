package com.test.swig.mdm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SolutionTest {
	public static SNode root;
	static Map<Character, SNode> map = new HashMap<Character, SNode>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENter all tuples");
		while(true){
			String s =sc.nextLine();
			if(s.equals("break")) break;
			else
			process(s);
		}
		System.out.println(map.toString());
		findRoot();
	}
	
	private static void findRoot() {
		for(Map.Entry<Character, SNode> entry:map.entrySet()){
			SNode value=entry.getValue();
			if(value.parent==null){
				root=value;
			}
		}
		
	}

	public static void process(String s){
		char ch =s.split(",")[0].charAt(1);
		char ch2 =s.split(",")[1].charAt(0);
		SNode temp=null;
		if(map.containsKey(ch)){
			temp = map.get(ch);
			SNode tempchild= new SNode(ch2);
			tempchild.parent=temp;
			temp.addChild(tempchild);
		}else{
		   temp = new SNode(ch);
		   SNode tempchild= new SNode(ch2);
		   tempchild.parent=temp;
		   temp.addChild(tempchild);
		   map.put(ch,temp);
		}
	}
	
	public static boolean moreThan2Child(){
	     for(Map.Entry<Character, SNode> entry:map.entrySet()){
	    	SNode temp=entry.getValue();
	    	if(temp.getChildren().size()>2){
	    		return true;
	    	}
	     }
		return false;
	}
	public static boolean duplicateTuples() {
		return false;
	}
	public static boolean detectcycle() {
		return false;
	}
	public static boolean moreThanAParent() {
		return false;
	}
	
	

}
