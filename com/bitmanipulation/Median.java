package com.bitmanipulation;
import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.List;



public class Median {
	
	public double mo2(int a,int b){
		return (a+b)/2.0;
	}
	public double mo3(int a,int b,int c){
		return (a+b+c-Math.max(a, Math.max(b, c))-Math.min(a, Math.min(b, c)));
	}
	public double mo4(int a,int b,int c,int d){
		int max=max(a, max(b,max(c, d)));
		int min = min(a,min(b,min(c,d)));
		return (a+b+c+d-max-min)/2.0;
	}
	
	public double findmedian(List<Integer>a,int n,List<Integer> b,int m){
		if(n==1){
			if(m==1)
				return mo2(a.get(0), b.get(0));
			if((m&1)==1){
				return mo2(b.get(m/2),(int) mo3(a.get(0), b.get(m/2-1), b.get(m/2+1)));
			}
			 return mo3( b.get(m/2), b.get(m/2 - 1), a.get(0) );
		}
		else if(n==2){
			if(m==2){
				return mo4(a.get(0),a.get(1), b.get(0), b.get(1));
			}
			// Case 5: If the larger array has odd number of elements, then median
	        // will be one of the following 3 elements
	        // 1. Middle element of larger array
	        // 2. Max of first element of smaller array and element just
	        //    before the middle in bigger array
	        // 3. Min of second element of smaller array and element just
	        //    after the middle in bigger array
	        if((m & 1)==1 )
	            return mo3( b.get(m/2),
	                         max( a.get(0), b.get(m/2 - 1) ),
	                         min( a.get(1), b.get(m/2 + 1) )
	                       );
	 
	        // Case 6: If the larger array has even number of elements, then
	        // median will be one of the following 4 elements
	        // 1) & 2) The middle two elements of larger array
	        // 3) Max of first element of smaller array and element
	        //    just before the first middle element in bigger array
	        // 4. Min of second element of smaller array and element
	        //    just after the second middle in bigger array
	        return mo4( b.get(m/2),
	                     b.get(m/2 - 1),
	                     max( a.get(0), b.get(m/2 - 2) ),
	                     min(a.get(1), b.get(m/2 + 1) )
	                   );
		}
		int idxa=(n-1)/2;
		int idxb=(m-1)/2;
		if(a.get(idxa)>b.get(idxb)){
			List<Integer> tempa=a.subList(0, idxa);
			List<Integer> tempb= b.subList(idxb, m-1);
			return findmedian(tempa,tempa.size(),tempb,tempb.size());
		}
		else{
			List<Integer> tempa=a.subList(idxa, n-1);
			List<Integer> tempb=b.subList(0, idxb);
			return findmedian(tempa,tempa.size(),tempb,tempb.size());
		}
		
	}
	
	public double findMedian1(final ArrayList<Integer> a,final ArrayList<Integer>b) {
		int n = a.size();
		int m =b.size();
		if(n<m){
			return findmedian(a, n, b, m);
		}
		else{
		   return findmedian(b, m, a, n);	
		}
	}
	public static void main(String[] args) {
		Median m = new Median();
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(7);
		a.add(10);
		b.add(4);
		b.add(5);
		b.add(9);
		b.add(15);
		b.add(16);
		
		System.out.println(m.findMedian1(a, b));
		
	}

}
