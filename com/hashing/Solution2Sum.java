package com.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2Sum {
		public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
		    Map<Integer,Integer> map = new HashMap<>();
		     ArrayList<Integer> res = new ArrayList<Integer>();
		     for(int i=0;i<a.size();i++){
		         if(map.containsKey(a.get(i))){
		             int index = map.get(a.get(i));
			         res.add(index+1) ;
				     res.add(i+1);
		             break;
		             
		         }else{
		        	 if(!map.containsKey(b-a.get(i)))
		            map.put(b-a.get(i),i); 
		         }
		     }

		    return res;
		    
		}
	
		public static void main(String[] args) {
			Solution2Sum s = new Solution2Sum();
			//4, 7, -4, 2, 2, 2, 3, -5, -3
			ArrayList<Integer> a= new ArrayList<Integer>(){{
				add(4);add(7);add(-4);add(2);add(2);add(2);add(3);add(-5);add(-3);
			}};
			s.twoSum(a, -3);
		}

}
