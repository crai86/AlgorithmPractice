package com.string;

public class SolutionLongestPlain {
	public String longestPalindrome(String s) {
	    
		int len=s.length();
		int low,high;
		int maxLength=1,start=0;
		 for (int i = 1; i < len; ++i)
		    {
		        // Find the longest even length palindrome with center points
		        // as i-1 and i.  
		        low = i - 1;
		        high = i;
		        while (low >= 0 && high < len && s.charAt(low)==s.charAt(high))
		        {
		            if (high - low + 1 > maxLength)
		            {
		                start = low;
		                maxLength = high - low + 1;
		            }
		            --low;
		            ++high;
		        }
		 
		        // Find the longest odd length palindrome with center 
		        // point as i
		        low = i - 1;
		        high = i + 1;
		        while (low >= 0 && high < len && s.charAt(low)==s.charAt(high))
		        {
		            if (high - low + 1 > maxLength)
		            {
		                start = low;
		                maxLength = high - low + 1;
		            }
		            --low;
		            ++high;
		        }
		    }    
	    return s.substring(start,start+maxLength);
	}
	
	public boolean isPalindrome(String s,int i,int j){
	    for(int k=i;k<=j/2;k++){
	        if(s.charAt(k)!=s.charAt(j-k)) return false;
	    }
	    return true;
	}

	public static void main(String[] args) {
		SolutionLongestPlain pl = new SolutionLongestPlain();
		System.out.println(pl.longestPalindrome("abacdfgdcaba"));
	}
}
