package com.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FourSumsSolution {

		public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {
		    Collections.sort(a);
		    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		    for(int i=0;i<a.size();i++){
		    	int j=i+1;
		    	int k =j+1;
		    	int l=a.size()-1;
		    	int sum=a.get(i)+a.get(j);
		    	while(k<l){
		    	int target = b-sum;
		    	int tempSum=a.get(k)+a.get(l);
		    	if(target==tempSum){
		    		ArrayList<Integer> rt = new ArrayList<Integer>();
		    		rt.add(a.get(i));
		    		rt.add(a.get(j));
		    		rt.add(a.get(k));
		    		rt.add(a.get(l));
		    		res.add(rt);
		    	}
		    	else if(target<tempSum){
		    		l--;
		    	}else{
		    		k++;
		    	}
		    	}
		    }
		    return res;
//		    Map<Integer,ArrayList<Integer>> map = new HashMap<>();
//		    for(int i=0;i<a.size();i++){
//		        for(int j=i;j<a.size();j++){
//		            ArrayList<Integer> t= new ArrayList<Integer>();
//		            t.add(a.get(i));
//		            t.add(a.get(j));
//		            map.put(a.get(i)+a.get(j),t);
//		        }
//		    }
//		    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//		    for(int i=0;i<a.size();i++){
//		        for(int j=i;j<a.size();j++){
//		            int sum = a.get(i)+a.get(j);
//		            int t = b-sum;
//		            if(map.containsKey(t)){
//		                ArrayList<Integer> temp= map.get(t);
//		                ArrayList<Integer> k = new ArrayList<>();
//		                k.add(a.get(i));
//		                k.add(a.get(j));
//		                k.addAll(temp);
//		                //Collections.sort(k);
//		                res.add(k);
//		            }
//		        }
//		    }
//		   // Collections.sort(res,new Comparator<ArrayList<Integer>>(){
//		   //      @Override
//	    //         public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
//	    //             return a.get(0)-b.get(0);
//	    // }
//		   // });
//		    return res;
		}
	}
