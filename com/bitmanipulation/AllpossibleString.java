package com.bitmanipulation;
import java.util.*;
import java.lang.*;
import java.io.*;

public class AllpossibleString {
	


		public static void main(String[] args) {
			String s = "ABCD";
			char[] str = s.toCharArray();
			char[] buffer = new char[2 * str.length];
			buffer[0] = str[0];
			getCombinations(str, buffer, 1, 1, str.length);
		}
	 
		public static void getCombinations(char[] s, char[] buffer, int i, int j,
				int l) {
			if (i == l) {
				while (j < buffer.length) {
					buffer[j] = ' ';
					j++;
				}
				System.out.println(buffer);
				return;
			}
			buffer[j] = s[i];
			getCombinations(s, buffer, i + 1, j + 1, l);
	 
			buffer[j] = ' ';
			buffer[j + 1] = s[i];
			getCombinations(s, buffer, i + 1, j + 2, l);
			return;
		}
		
	}


