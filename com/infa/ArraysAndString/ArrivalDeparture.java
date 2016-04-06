package com.infa.ArraysAndString;

public class ArrivalDeparture {
	
	public static boolean isPossible(int[]a,int []d,int availableRooms){
		int i=0,j=0;
		int roomallocated=0;
		while(i<a.length && j<d.length){
			if(a[i]<d[j]){
				roomallocated++;
				i++;
				if(roomallocated>availableRooms) return false;
			}
			else{
				roomallocated--;
				j++;
			}
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		System.out.println(isPossible(new int[]{1,3,5}, new int[]{2,6,8}, 1));
	}

}
