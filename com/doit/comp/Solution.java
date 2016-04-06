package com.doit.comp;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	// DO NOT MODIFY THE LIST
	public int search(final List<Integer> a, int b) {
	    int pivot=Integer.MAX_VALUE;
	    int i=0;
	    for(i=0;i<a.size()-1;i++){
	        if(a.get(i)>a.get(i+1)){
	            pivot=a.get(i+1);
	            break;
	        }
	    }
	
	    System.out.println(pivot+" "+(i+1)+" b is"+b);
	    if(pivot==b){
	         System.out.println(pivot+"HelloWorld"+(i+1));
	        return i+1;
	    }
	    else
	    {
	    int k = binarySearch(a,0,i+1,b);
	    if(k!=-1) return k;
	    else {
	    int j = binarySearch(a,i+1,a.size(),b);
	    System.out.println("j is"+j);
	    if(j!=-1)
	    return j-1;
	    else
	    return -1;
	    }
	    }
	    
	}
	
	public int binarySearch(List<Integer>a ,int low,int high,int key){
	    while(low<high){
	    int mid=(low+high)/2;
	    if(key==a.get(mid)){
	        return mid;
	    }
	    else if(key<a.get(mid)){
	        high=mid-1;
	    }
	    else {
	        low=mid+1;
	    }
	   }
	   return -1;
	}
	
 public static void main(String[] args) {
	Solution s = new Solution();
	List<Integer> a = new ArrayList<Integer>();
	a.add(4);
	a.add(5);
	a.add(6);
	a.add(7);
	a.add(0);
	a.add(1);
	a.add(2);
	
	System.out.println("final"+s.search(a, 9));
}	
}

