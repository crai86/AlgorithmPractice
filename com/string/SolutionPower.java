package com.string;

public class SolutionPower {
	public static int power(String a) {
		if (a == null || a.length() == 0)
			return 0;
		if (a.isEmpty())
			return 0;
		int k = a.length() - 1;
		StringBuilder s = new StringBuilder();
		int t = Character.getNumericValue(a.charAt(k));
		s.insert(0, a.charAt(k));
		while (t != 1 && t % 2 == 0) {
			if (k > 0 && t < 2) {
				s.insert(0, a.charAt(--k));
				t = Integer.valueOf(s.toString());
			} else if (k > 0) {
				s = new StringBuilder(a.charAt(k));
				t = Character.getNumericValue(a.charAt(--k));
			}
			if (t > 1)
				t /= 2;
		}
		// long k =Long.valueOf(a);
		// while(k!=1){
		// if(k%2!=0) return 0;
		// k=k/2;
		// }
		if (t == 1)
			return 1;
		else
			return 0;
	}

	public static int power_correct(String A) {

		String dividend = A;
		StringBuilder str;

		if (A == null || A.length() == 0)
			return 0;

		if (A.length() == 1 && A.charAt(0) == '0')
			return 0;

		while (dividend.length() > 0 && !dividend.equalsIgnoreCase("2")) {
			str = new StringBuilder();
			int carry = 0;
			int n = dividend.length();

			if (n > 0) {
				int num = dividend.charAt(n - 1) - '0';

				if (num % 2 == 1)
					return 0;
			}

			for (int i = 0; i < n; i++) {

				char c = (char) (dividend.charAt(i) - '0');
				int res = c + 10 * carry;

				c = (char) (res / 2 + '0');
				carry = res % 2;

				str.append(c);
			}

			if (str.charAt(0) == '0')
				str.deleteCharAt(0);

			dividend = str.toString();
		}

		return 1;

	}
	
	public static String multiply(String a, String b) {
	    int x=0;
	    for(x=0;x<a.length();x++){
	    	if(a.charAt(x)!='0') break;
	    }
	    a=a.substring(x);
	    for(x=0;x<b.length();x++){
	    	if(b.charAt(x)!='0') break;
	    }
	    b=b.substring(x);
	    System.out.println(a+" "+b);
	    int m =a.length();
	    int n = b.length();
	    int count=0;
	    StringBuilder finalStr= new StringBuilder();
	    StringBuilder str;
	    for(int i=m-1;i>=0;i--){
	        str=new StringBuilder();
	        int carry=0;
	        for(int j=n-1;j>=0;j--){
	            int res=(((a.charAt(i)-'0')*(b.charAt(j)-'0'))+carry);
	            carry =res/10;
	            char c=(char)(res%10+'0');
	            str.insert(0,c);
	        }
	        str.insert(0, (char)(carry+'0'));
	       if(count==0){
	           finalStr =str;
	       } 
	       else{
	           int k=str.length()-1;
	           StringBuilder temp = new StringBuilder();
	           int y=finalStr.length()-1-count;
	           temp.append(finalStr.substring(y+1>0?y+1:finalStr.length()-1));
	           int carry2=0;
	           while(k>=0 && y>=0){
	               int res = (str.charAt(k)-'0')+(finalStr.charAt(y)-'0')+carry2;
	               carry2=res/10;
	               char c=(char)(res%10+'0');
	               temp.insert(0,c);
	               k--;y--;
	           }
	           k--;
	           while(k>=0){
	        	   int res = (str.charAt(k)-'0')+carry2;
	               carry2=res/10;
	               char c=(char)(res%10+'0');
	               temp.insert(0,c);
	               k--;
	           }
	           temp.insert(0, (char)(carry2+'0'));
	           finalStr=temp;
	       }
	       count++;
	    }

	    
	    if(finalStr.charAt(0)=='0' && finalStr.charAt(1)!='0') return finalStr.substring(1).toString();
	    else   if(finalStr.charAt(0)=='0' && finalStr.charAt(1)=='0') return "0";
	    return finalStr.toString();
	}

	public static void main(String[] args) {
//		System.out.println(power("64"));
		System.out.println(power_correct("128"));
		String a="abc";
		String b ="abc";
		StringBuilder k = new StringBuilder("hello");
		k.insert(1, 'a');
		System.out.println(k.substring(k.length()-2));
		String c= new String("abc");
		System.out.println(c.intern());
		System.out.println(a.equals(c));
		System.out.println(multiply("000111", "00010"));
	}

}
