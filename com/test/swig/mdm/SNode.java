package com.test.swig.mdm;

import java.util.ArrayList;
import java.util.List;

public class SNode {
	char name;
	SNode parent;
	List<SNode> children=new ArrayList<SNode>();
	public SNode(char name) {
		super();
		this.name = name;
	}
	public char getName() {
		return name;
	}
	public void setName(char name) {
		this.name = name;
	}
	public List<SNode> getChildren() {
		return children;
	}
	public void setChildren(List<SNode> children) {
		this.children = children;
	}
	public void addChild(SNode n){
		this.children.add(n);
	}
	

}
