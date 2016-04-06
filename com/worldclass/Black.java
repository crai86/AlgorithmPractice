package com.worldclass;

import java.util.ArrayList;

public class Black {
	public int black(ArrayList<String> a) {
		int count = 0;
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.get(i).length(); j++) {
				if (a.get(i).charAt(j) == 'X') {
					// explore(a,i,j,a.size(),a.get(i).length());
					count++;
				}
			}
		}
		return count;
	}

	void explore(ArrayList<String> a,int i,int j,int m,int n)
	{
	    if(i < 0 || i > m-1)
	    {
	       return;
	    }
	    if(j < 0 || j > n-1)
	    {
	      return;
	    }
	    String ch =a.get(i);
	    System.out.println(ch);
	    if(ch.charAt(j)== 'O'||ch.charAt(j)== '+')
	    {
	      return;
	    }
	    
	    StringBuilder st = new StringBuilder(a.get(i));
	    st.setCharAt(j,'+');
	    a.set(i,st.toString());

	   //Open below to include diagonal also
	   
	   explore(a,i-1,j-1,m,n);
	   explore(a,i+1,j+1,m,n);
	   explore(a,i-1,j+1,m,n);
	   explore(a,i+1,j-1,m,n);
	   

	   explore(a,i,j-1,m,n);
	   explore(a,i,j+1,m,n);
	   explore(a,i-1,j,m,n);
	   explore(a,i+1,j,m,n);
	}
}
