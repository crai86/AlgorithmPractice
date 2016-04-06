package com.bitmanipulation;

public class Solution2 {
    public int singleNumber(int[] A) {
        int res=0;
        int[] count=new int[32];
        for(int i=0;i<32;i++){
            for(int j=0;j<A.length;j++){
                if(((A[j]>>i)&1)==1){
                    count[i]=count[i]+1;
                }
            }
            if((count[i]%3)!=0){
                res=res|(1<<i);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
		Solution2 w = new Solution2();
		System.out.println(w.singleNumber(new int[]{1,2,2,2,3,3,3}));
	}
}
