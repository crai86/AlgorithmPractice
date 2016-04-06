package com.greedy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Blub {
	public int bulbs(ArrayList<Integer> a) {
		 int state= 0, ans = 0;
		    for (int i = 0; i < a.size();i++) {
		        if (a.get(i) == state) {
		            ans++;
		            state = 1 - state;
		        }
		    }
		     
		    return ans;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Blub blub = new Blub();
		ArrayList<Integer> a = new ArrayList<Integer>();
		// 1, 1, 0, 0, 1, 1, 0, 0, 1
		a.add(0);a.add(1);a.add(0);a.add(1);
		//a.add(1);a.add(1);a.add(0);a.add(0);a.add(1);a.add(1);a.add(0);a.add(0);a.add(1);
		System.out.println(blub.bulbs(a));

		
	}
}
