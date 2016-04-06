package com.doit.comp;

public class MagicNumber {
	
	public void magicnumber(int n){
		
		for(int i=1;i<n;i++){
			if(checkMagicNumber(i)) System.out.println(i); 
		}
		
		
		
	}
public boolean checkMagicNumber(int n){
	int sum=0;
	for(int i=5;n-sum>0;i*=5){
		sum+=i;
		if(n-sum == 0)return true;
	}
	return false;
}
public static void main(String[] args) {
	MagicNumber m = new MagicNumber();
	m.magicnumber(31);
}
}
