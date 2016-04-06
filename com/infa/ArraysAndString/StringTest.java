package com.infa.ArraysAndString;

public class StringTest {
	
	public static void namechange(String s){
		s=s.concat("kumar");
	}
	
	public static void main(String[] args) {
		String s ="chandan";
		namechange(s);
		System.out.println(s);
		System.out.println(Integer.valueOf("56"));
		StringBuffer st = new StringBuffer("10");
		st.insert(0, "1");
		System.out.println(st.toString());
		System.out.println(addBinary("11", "1"));
	}
		
public static String addBinary(String a, String b) {
		    int i=a.length()-1,j=b.length()-1;
		    int carry=0;
		    StringBuilder st = new StringBuilder();
		    while(i>=0 && j>=0){
		        int a1=Character.getNumericValue(a.charAt(i));
		        int a2=Character.getNumericValue(b.charAt(j));
		        int sum=a1+a2+carry;
		        if(sum==1){
		            carry=0;
		             st.insert(0,"1");
		        }
		        else if(sum==2){
		            st.insert(0,"0");
		            carry=1;
		        }
		        else if(sum==3){
		             st.insert(0,"1");
		            carry=1;
		        }
		        else{
		             st.insert(0,"0");
		             carry=0;
		        }
		        i--;j--;
		    }
		    while(i>=0){
		        int sum=carry+Character.getNumericValue(a.charAt(i));
		        if(sum==1){
		            carry=0;
		             st.insert(0,"1");
		        }
		        else if(sum==2){
		            st.insert(0,"0");
		            carry=1;
		        }
		        else if(sum==3){
		             st.insert(0,"1");
		            carry=1;
		        }else{
		             st.insert(0,"0");
		             carry=0;
		        }
		        i--;
		    }
		    while(j>=0){
		        int sum=carry+Character.getNumericValue(b.charAt(j));
		        if(sum==1){
		            carry=0;
		             st.insert(0,"1");
		        }
		        else if(sum==2){
		            st.insert(0,"0");
		            carry=1;
		        }
		        else if(sum==3){
		             st.insert(0,"1");
		            carry=1;
		        }
		        else{
		             st.insert(0,"0");
		             carry=0;
		        }
		        j--;
		    }
		    if(carry>0)
		    st.insert(0,carry);
		    return st.toString();
		}
	
}



