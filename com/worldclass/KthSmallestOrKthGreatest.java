package com.worldclass;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class KthSmallestOrKthGreatest {
    

    public static void findAllKth(int[] a ,Query[] query){
        for(Query q:query){
            int p=binarySearch(a,q.x);
            if(p==-1){
                System.out.println("-1");
                continue;
            }
            if(q.type==0){
                if((long)(p+q.k)<(long)a.length)
                     System.out.println(a[(p+q.k)]);
                else
                    System.out.println("-1");
            }else{
             //   System.out.println("debug1");
             if((long)(p-q.k)>=(long)0){
                  System.out.println(a[p-q.k]);   
                }
                else
                    System.out.println("-1");
            }
        }
    }
   public static int binarySearch(int[]a,int key){
       int low=0;
       int high=a.length-1;
       while(low<=high){
           long t = (long)((long)low+(long)(high-low)/2);
           int mid=(int) t;
           if(a[mid]==key){
               return (int)mid;
           }
           else if(a[mid]>key){
                high=mid-1;
           }else{
              low=mid+1  ;
           }
       }
       return -1;
   }
   
   public static void main(String[] args) {
       /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	   int[][]k=new int[2][1];
	   System.out.println(k.length);
       Scanner sc = new Scanner(System.in);
       int n =sc.nextInt();
       int q=sc.nextInt();
       int[]a = new int[n];
       Query[]query=new Query[q];
       for(int i=0;i<n;i++){
           a[i]=sc.nextInt();
       }
       for(int i=0;i<q;i++){
           query[i]=new Query(sc.nextInt(),sc.nextInt(),sc.nextInt());
       }
       findAllKth(a,query);

   }
   static class Query{
       int x;
       int k;
       int type;
       public Query(int x,int k,int type){
           this.x=x;
           this.k=k;
           this.type=type;
       }
   }
}