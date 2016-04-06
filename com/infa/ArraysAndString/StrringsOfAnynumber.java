package com.infa.ArraysAndString;

public class StrringsOfAnynumber {
	
	private static String[] single_units={"zero","one","two","three","four","five","six","seven","eight","nine"
		,"ten","eleven","tweleve","thriteen","fourteen","fifteen","sixteen","seventeen","eighteen","ninteen"};
	private static String[] deci_units={"","","twenty","thiry","fortee","fifty","sixty","seventy","eighty","ninety"};
	private static String[] highs={"thousands","lacs","crores"};
	
	public static String numbertoString(int num){
		StringBuilder sb = new StringBuilder();
		sb.insert(0,lessthantwenty(num%100));
		num=num/100;
		sb.insert(0,"hundred ");
		sb.insert(0, single_units[num%10]+" ");
		num=num/10;
		int count=0;
		while(num!=0){
			sb.insert(0, highs[count]+" ");
			sb.insert(0, lessthantwenty(num%100)+" ");
			num/=100;
			count++;
			
		}
		return sb.toString();
	}

	private static String lessthantwenty(int n) {
		StringBuilder sb = new StringBuilder();
		sb.append(deci_units[n/10]+" ");
		sb.append(single_units[n%10]);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(numbertoString(1234567));
	}

}
