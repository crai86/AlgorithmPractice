package com.string;

import java.util.ArrayList;
import java.util.List;

public class SolutionIPAddress {
	
	public List<String> restoreIpAddress2(String s){
		if(s.length()<4 || s.length()>12) return null;
		ArrayList<String> res = new ArrayList<String>();
		for(int i=1;i<4;i++){
			String first = s.substring(0,i);
			if(!isValid(first)) continue;
			for(int j=1;i+j<s.length() && j<4;j++){
				String second=s.substring(i,i+j);
				if(!isValid(second)) continue;
				for(int k=1;i+j+k<s.length() && k<4;k++){
					String third=s.substring(i+j,i+j+k);
					String fourth=s.substring(i+j+k);
					if(isValid(third)&& isValid(fourth)){
						res.add(first+"."+second+"."+third+"."+fourth);
					}
				}
			}
		}
		return res;
	}

	private boolean isValid(String s) {
		if(s.length()>1 && s.charAt(0)=='0') return false;
		if(!s.isEmpty() && Integer.valueOf(s)<=255 && Integer.valueOf(s)>=0) return true;
		else 
		return false;
	}

	public List<String> restoreIpAddresses(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> t = new ArrayList<String>();
		dfs(result, s, 0, t);
		
		ArrayList<String> finalres = new ArrayList<String>();
		for(ArrayList<String> str:result){
			StringBuilder sb = new StringBuilder();
			for(String l:str){
				sb.append(l+".");
			}
			sb.setLength(sb.length()-1);
			finalres.add(sb.toString());
		}
		return finalres;
	}

	private void dfs(ArrayList<ArrayList<String>> result, String s, int start,
			ArrayList<String> t) {
		// base cases
		if(t.size()>=4 && start!=s.length()) return;
		
		if(t.size()+s.length()-start+1<4) return;
		
		if(t.size()==4 && start==s.length()){
			ArrayList<String> temp = new ArrayList<String>(t);
			result.add(temp);
			return;
		}
		
		for(int i=1;i<=3;i++){
			
			if(start+i>s.length())break;
			
			String sub=s.substring(start,start+i);
			// for 001 case
			if(i>1 && s.charAt(start)=='0') break;
			
			// Ip Address should not have more than 255
			if(Integer.valueOf(sub)>255) break;
			t.add(sub);
			dfs(result, s, start+i, t);
			t.remove(t.size()-1);
			
		}
	}

	
	public static void main(String[] args) {
		SolutionIPAddress st = new SolutionIPAddress();
		System.out.println(st.restoreIpAddresses("25525511135"));
		System.out.println(st.restoreIpAddress2("25525511135"));
	}
}
