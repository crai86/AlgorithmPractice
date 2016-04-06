package com.dp;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordbreakProblem {
	static Set<String> dict = new HashSet<String>();

	public static void wordbreakproblem(String w) {
		int m = w.length();
		boolean[][] t = new boolean[m][m];
		for (int i = 0; i < m; i++) {
			String s = String.valueOf(w.charAt(i));
			if (dict.contains(s)) {
				t[i][i] = true;
			} else {
				t[i][i] = false;
			}
		}
		for (int i = 1; i <=m; i++) {
			for (int j = 0; j < m - i + 1; j++) {
				int y = i + j-1;
				String sub = w.substring(j, y+1);
				if (dict.contains(sub)) {
					t[j][y] = true;
					continue;
				}
				for (int k = j+1; k <=y; k++) {
					if (t[j][k-1] && t[k][y]) {
						t[j][y]=true;
						break;
					}	
				}
			}

		}
		System.out.println(t[0][m - 1]);
	}
	
	/**
	 * most efficient
	 * @param s
	 * @param dict
	 * @return
	 */
	 public boolean wordBreak(String s, Set<String> dict) {
	        boolean[] t = new boolean[s.length()+1];
	        t[0] = true; //set first to be true, why?
	        //Because we need initial state
	 
	        for(int i=0; i<s.length(); i++){
	            //should continue from match position
	            if(!t[i]) 
	                continue;
	 
	            for(String a: dict){
	                int len = a.length();
	                int end = i + len;
	                if(end > s.length())
	                    continue;
	 
	                if(t[end]) continue;
	 
	                if(s.substring(i, end).equals(a)){
	                    t[end] = true;
	                }
	            }
	        }
	 
	        return t[s.length()];
	    }
	public static String breakWordDP(String word, Set<String> dict){
        int T[][] = new int[word.length()][word.length()];
        
        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[i].length ; j++){
                T[i][j] = -1; //-1 indicates string between i to j cannot be split
            }
        }
        
        //fill up the matrix in bottom up manner
        for(int l = 1; l <= word.length(); l++){
            for(int i=0; i < word.length() -l + 1 ; i++){
                int j = i + l-1;
                String str = word.substring(i,j+1);
                //if string between i to j is in dictionary T[i][j] is true
                if(dict.contains(str)){
                    T[i][j] = i;
                    continue;
                }
                //find a k between i+1 to j such that T[i][k-1] && T[k][j] are both true 
                for(int k=i+1; k <= j; k++){
                    if(T[i][k-1] != -1 && T[k][j] != -1){
                        T[i][j] = k;
                        break;
                    }
                }
            }
        }
        if(T[0][word.length()-1] == -1){
            return null;
        }
        
        //create space separate word from string is possible
        StringBuffer buffer = new StringBuffer();
        int i = 0; int j = word.length() -1;
        while(i < j){
            int k = T[i][j];
            if(i == k){
                buffer.append(word.substring(i, j+1));
                break;
            }
            buffer.append(word.substring(i,k) + " ");
            i = k;
        }
        
        return buffer.toString();
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String k = sc.next();
			dict.add(k);
		}
		String w = sc.next();
		wordbreakproblem(w);
		System.out.println(breakWordDP(w, dict));
		
	}
}
