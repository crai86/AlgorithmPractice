package com.backtracking;

import java.util.ArrayList;

public class GrayCode {
	public ArrayList<Integer> grayCode(int n) {
	    ArrayList<Integer> ret = new ArrayList<>();
        ret.add(0);
        for (int i = 0; i < n; i++) {
            int size = ret.size();
            for (int j = size - 1; j >= 0; j--)
                ret.add(ret.get(j) + size);
        }
        return ret;
    
	}
	public static void main(String[] args) {
		GrayCode gc = new GrayCode();
		gc.grayCode(3);
		System.out.println("egative"+-2147483648*-1);
	}
	
	
}
