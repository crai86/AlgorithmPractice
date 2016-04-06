package com.dp;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Red John has committed another murder. But this time, he doesn't leave a red
 * smiley behind. What he leaves behind is a puzzle for Patrick Jane to solve.
 * He also texts Teresa Lisbon that if Patrick is successful, he will turn
 * himself in. The puzzle begins as follows.
 * 
 * There is a wall of size 4xN in the victim's house. The victim also has an
 * infinite supply of bricks of size 4x1 and 1x4 in her house. There is a hidden
 * safe which can only be opened by a particular configuration of bricks in the
 * wall. In every configuration, the wall has to be completely covered using the
 * bricks. There is a phone number written on a note in the safe which is of
 * utmost importance in the murder case. Gale Bertram wants to know the total
 * number of ways in which the bricks can be arranged on the wall so that a new
 * configuration arises every time. He calls it M. Since Red John is back after
 * a long time, he has also gained a masters degree in Mathematics from a
 * reputed university. So, he wants Patrick to calculate the number of prime
 * numbers (say P) up to M (i.e. <= M). If Patrick calculates P, Teresa should
 * call Red John on the phone number from the safe and he will surrender if
 * Patrick tells him the correct answer. Otherwise, Teresa will get another
 * murder call after a week.
 * 
 * You are required to help Patrick correctly solve the puzzle.
 * 
 * Input Format
 * 
 * The first line of input will contain an integer T followed by T lines each
 * containing an integer N.
 * 
 * Output Format
 * 
 * Print exactly one line of output for each test case. The output should
 * contain the number P.
 * 
 * Constraints 1<=T<=20 1<=N<=40
 * 
 * @author crai
 *
 */

public class HR_Solution {

	 public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
	        while(t>0){
	            int n =sc.nextInt();
	            int z = solve(n);
	            System.out.println(z);
	            t--;
	        }
	    }
	    public static int solve(int n){
	        if(n<=1) 
	            return 0;
	        long[]t =new long[n+1];
	        t[0]=t[1]=t[2]=t[3]=1;
	        for(int i=4;i<=n;i++){
	            t[i]=t[i-1]+t[i-4];
	        }
	        int ret=0;
	        long temp=0;
	        for(long i=2;i<=t[n];i++){
	            for(long k=i+i;k<=t[n];k=k+i){
	                   temp++;
	            }
	        }
	        ret=(int)(t[n]-temp);
	        return ret;
	       
	    }
	    public static boolean isPrime(int n){
	        for(int i=2;i<=(int)Math.sqrt(n);i++){
	            if(n%i==0){
	                return false;
	            }
	        }
	        return true;
	    }
	}