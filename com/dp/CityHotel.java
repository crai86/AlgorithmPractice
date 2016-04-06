package com.dp;

import java.util.Scanner;

public class CityHotel {
	
	public static void findMaxHotels(int[][]city,int m,int n){
        long[][]t=new long[m+1][n+1];
        t[0][0]=city[0][0];
        for(int i=1;i<=m;i++){
             t[i][0] = t[i-1][0] * city[i][0];
        }
        for(int i=1;i<=n;i++){
            t[0][i]=t[0][i-1]* city[0][i];
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
            	long temp = t[i-1][j-1];
            	if(i-1==0){
            		temp+=t[i-1][j];
            	}
            	if(j-1==0){
            		temp+=t[i][j-1];
            	}
            	
                t[i][j]=(temp)*city[i][j];
            }
        }
        System.out.println(t[m][n]%1000000007);
	}
	 public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	         Scanner sc = new Scanner(System.in);
	       int m =sc.nextInt();
	       int n =sc.nextInt();
	       int[][]city=new int[m][n];
	       for(int i=0;i<m;i++){
	           for(int j=0;j<n;j++){
	               city[i][j]=sc.nextInt();
	           }
	       }
	       findMaxHotels(city,m-1,n-1);
	    }
}
