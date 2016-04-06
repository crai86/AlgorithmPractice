
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Testtey {
	 public static void main(String args[] ) throws Exception {
	        /*
	         * Read input from stdin and provide input before running

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);
	        for (int i = 0; i < N; i++) {
	            System.out.println("hello world");
	        }
	        */

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String s =br.readLine();
	        ArrayList<Integer> res =solution(s);
	        for(int i=0;i<res.size();i++){
	        	System.out.println(res.get(i));
	        }
	    }
	    public static ArrayList<Integer> solution(String s){
	    	ArrayList<Integer> res = new ArrayList<Integer>();
	    	StringBuffer st = new StringBuffer();
	    	for(int i=0;i<s.length();i++){
	    		int k = s.charAt(i)-'0';
	    		if(k>=0&&k<=9){
	    			st.append(k);
	    		}else{
	    			if(!st.toString().isEmpty())
	    			res.add(Integer.parseInt(st.toString()));
	    			st=new StringBuffer();
	    			
	    		}
	    	}
	    	return res;
	    }
}

