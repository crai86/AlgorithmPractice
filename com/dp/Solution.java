package com.dp;

public class Solution {

	public static void main(String[] args) {
		int []arr1 = {9,15,21,27,60,75,90,120,165,168,171,180,186};
		int []arr2=  {3,12,21,33,42,75,132,141,165,171,300};
		System.out.println("int value is : " + subway_hacker(arr1, arr2));
	}

	static int subway_hacker(int[] arr1, int[] arr2) {
		int k= arr1.length>arr2.length?arr2.length:arr1.length;
        int[] sum1=new int[arr1.length];
        int[] sum2= new int[arr2.length];
        sum1[0]=arr1[0];
        sum2[0]=arr2[0];
        int resSum=0;
        for(int i=1;i<k-1;i++){
            sum1[i]=Math.max(sum1[i-1]+arr1[i],sum2[i-1]+arr1[i]);
            sum2[i]=Math.max(sum2[i-1]+arr2[i],sum1[i-1]+arr2[i]);
            
        }
           if(arr1.length>arr2.length){
             int sum=0;
           for(int j=k-1;j<arr1.length;j++){
               sum+=arr1[j];
           }
//           sum1[k-1]=Math.max(sum1[k-2]+arr1[k-1]+sum,sum2[k-2]+arr1[k-1]);
          sum1[k-1]=Math.max(sum1[k-2],sum2[k-2]) + Math.max(sum,arr2[k-1]+arr1[k-1]);
           }else{
                int sum=0;
                 for(int j=k-1;j<arr2.length;j++){
                   sum+=arr2[j];
               }
         sum2[k-1]=Math.max(sum2[k-1],sum1[k-1]) + sum;
       }
       
      
        return Math.max(sum1[k-1],sum2[k-1]);

    }
}