package com.string;

public class FindString {
	
	public static int findString(String[] s ,int start,int end,String target){
		while(start<=end){
			while(s[end].equals("")){
				--end;
			}
			if(start>end) return -1;
			int mid=start+(end-start)/2;
			if(s[mid].equals(target)){
				return mid;
			}
			else if(s[mid]==""){
				while(s[mid]!=""){
					mid++;
				}
			}
			int r =s[mid].compareTo(target);
			if(r==0) return mid;
			else if(r<0) end=mid-1;
			else start =mid+1;
			
		}
		
		return -1;
	}

}
