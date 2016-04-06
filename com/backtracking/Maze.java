package com.backtracking;

import java.util.ArrayList;

public class Maze {
	
	ArrayList<Point> current_path = new ArrayList<Point>();
	public boolean findPath(int x,int y){
		Point p = new Point(x, y);
		current_path.add(p);
		boolean success=false;
		if(x==0 && y==0) return true;
		if(x>=1 && isFree(x-1,y)){
			success=findPath(x-1, y);
		}
		else if (!success && y>=1 && isFree(x,y-1)){
			success=findPath(x, y-1);
		}
		if(!success){
			current_path.remove(p);
		}
		
		return success;
	}
	
	private boolean isFree(int i, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	static class Point{
		int x;
		int y;
		public Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}

}
