package com.dp;

public class coinChanging {

	public static int cointChange(int[] coins, int sum) {
		int[][] table = new int[coins.length ][sum + 1];
		for (int i = 0; i <coins.length; i++)
			table[i][0] = 1;
		table[0][0]=1;
		for (int i = 1; i<=sum; i++)
			table[0][i] = 1;
		for (int i = 1; i <coins.length; i++) {
			for (int j = 1; j <=sum; j++) {
              if(j>=coins[i]){
            	  table[i][j]=table[i-1][j]+table[i][j-coins[i]];
              }
              else{
            	  table[i][j]=table[i-1][j];
              }
			}
		}
		return table[coins.length-1][sum];
	}
	
	public static int miniumCoins(int[]coins,int sum){
		int[][]table = new int[coins.length][sum+1];
		for(int i=0;i<coins.length;i++)
		table[i][0]=0;
		for (int i = 1; i<=sum; i++)
			table[0][i] = i;
		for(int i=1;i<coins.length;i++){
			for(int j=1;j<=sum;j++){
				if(j>=coins[i]){
					table[i][j]=Math.min(table[i-1][j],1+table[i][j-coins[i]]);
				}
				else {
					table[i][j]=table[i-1][j];
				}
			}
		}
		
		return table[coins.length-1][sum];
	}
	public static void main(String[] args) {
		System.out.println(cointChange(new int[]{1,4}, 7));
		System.out.println(miniumCoins(new int[]{1,2,3}, 5));
	}

}
