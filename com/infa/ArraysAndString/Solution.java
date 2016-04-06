package com.infa.ArraysAndString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public  static  int kthsmallest(final List<Integer> a, int k) {
	    if(k<0 || k>a.size()) return -1;
	    int low =0,high=k;
	    while(low<=high){
	        if(low==high) return a.get(low);
	        int pivot = (int) (low+Math.floor(Math.random()*(high-low+1))); //left + floor(rand() * (right - left + 1))
	        pivot= partition(a, low, high,pivot);
	        int r=pivot-low+1;
	        if(r==k) return a.get(pivot);
	        else if(r>k){ 
	           high= pivot-1;
	        }
	        else {
	            low=pivot+1;
	            k=k-r;
	        }
	    }
	    return -1;
	    
	}
	
	public static int mytypeSolution(final List<Integer> a,int k){
		int low=0,high=a.size()-1;
		while(low<=high){
			if(low==high) return a.get(low);
			int pivot=(int) (low+Math.floor(Math.random()*(high-low+1)));
			pivot = partition(a, low, high, pivot);
			int p=pivot-low+1;
			if(p==k) return a.get(pivot);
			else if(k<p){
				high=pivot-1;
			}
			else{
				low=pivot+1;
				k=k-p;
			}
			
		}
		return -1;
	}
	
	public static void main(String[] args) {
		final List<Integer> list = new ArrayList<Integer>();
		list.add(20);
		list.add(10);
		list.add(30);
		list.add(50);
		list.add(40);
		List<Integer> tr=Collections.unmodifiableList(list);
		 
////		tr.set(2, 5);
//		List<Integer>l1 = new ArrayList<Integer>();
//		l1=tr.subList(0, 4);
////		l1.set(2, 5);
//		//Collections.copy(l1, list.subList(0, 4));
	    System.out.println(kthsmallest(list, 5));
	    System.out.println(mytypeSolution(list, 2));
	}
	public static int partition(final List<Integer> a,int low,int high,int k){
		 int pivot_item = a.get(k);
	     int store_index=low;
	     swap(a,k,high);
	     for(int i=low;i<high;i++){
	         if(a.get(i)<=pivot_item){
	             swap(a,store_index,i);
	             store_index++;
	         }
	     }
	     swap(a,high,store_index);
		 return store_index;  
	   
	}
	public static void swap(final List<Integer> a,int l,int h){
		   int t =a.get(l);
			a.set(l, a.get(h));
			a.set(h, t); 
		}
	
}