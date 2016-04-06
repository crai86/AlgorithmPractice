package com.backtracking;

import java.util.ArrayList;

public class SodukuSolver2 {

		public void solveSudoku(ArrayList<ArrayList<Character>> a) {
		    ArrayList<Integer> temp = findUnassigned(a);
		    if(temp==null){
		        return;
		    }
		    int row =temp.get(0);
		    int col=temp.get(1);
	        for(int i=1;i<=9;i++){
	            a.get(row).set(col,(char)(i+'0'));
	            if(isSafe(a,row,col,i)){
	                solveSudoku(a);
	            }else{
	                 a.get(row).set(col,'.');
	            }
	        }
		}
		public ArrayList<Integer> findUnassigned(ArrayList<ArrayList<Character>> a){
		    int m=a.size();
		    int n=a.get(0).size();
		    ArrayList<Integer> temp = new ArrayList<>();
		    for(int i=0;i<m;i++){
		        for(int j=0;j<n;j++){
		            if(a.get(i).get(j)=='.'){
		                temp.add(i);
		                temp.add(j);
		                return temp;
		            }
		        }
		    }
		    return null;
		}
		public boolean isSafeRowwise(ArrayList<ArrayList<Character>> a,int row,int num){
		    int col=a.get(0).size();
		    for(int i=0;i<col;i++){
		        if(a.get(row).get(i)==(char)('0'+num)) return false;
		    }
		    return true;
		}
		public boolean isSafeColwise(ArrayList<ArrayList<Character>> a,int col,int num){
		    int row=a.size();
		    for(int i =0;i<row;i++){
		        if(a.get(i).get(col)==(char)('0'+num)) return false;
		    }
		    return true;
		}
		public boolean isSafeBoxWise(ArrayList<ArrayList<Character>> a,int row,int col,int num){
		    row=row-row%3;
		    col=col-col%3;
		    for(int i=0;i<3;i++){
		        for(int j=0;j<3;j++){
		            if(a.get(row+i).get(col+j)==(char)('0'+num)) return false;
		        }
		    }
		    return true;
		}
		public boolean isSafe(ArrayList<ArrayList<Character>> a,int row,int col,int i){
		    return isSafeRowwise(a,row,i)&&isSafeColwise(a,col,i)&&isSafeBoxWise(a,row,col,i);
		}
		
		public static void main(String[] args) {
			ArrayList<ArrayList<Character>> ch = new ArrayList<ArrayList<Character>>();
		   for(int i=0;i<9;i++){
			   ArrayList<Character> c = new ArrayList<Character>();
			   c.add('5');c.add('6');c.add('.');c.add('.');c.add('.');c.add('.');c.add('8');c.add('.');c.add('9');
			   ch.add(c);
		   }
		   SodukuSolver2 sy = new SodukuSolver2();
		   sy.solveSudoku(ch);
		}
	}

