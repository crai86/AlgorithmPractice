package com.greedy;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SnakeladderGame {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        int[][]move=new int[t][100];;
        for(int i=0;i<t;i++){
            move[i]=new int[100];
            int ladder=sc.nextInt();
            for(int j=0;j<ladder;j++){
                move[i][sc.nextInt()]=sc.nextInt();
            }
            int snake=sc.nextInt();
             for(int l=0;l<snake;l++){
                move[i][sc.nextInt()]=sc.nextInt();
            } 
        }
        for(int i=0;i<t;i++){
            totalmove(move[i]);
        }
    }
    public static void totalmove(int[] move){
        boolean[] visited=new boolean[100];
        for(int i=0;i<move.length;i++){
        	if(move[i]==0)
        	move[i]=-1;
        }
        Queue<QueueNode> q = new LinkedList<>();
        QueueNode s = new QueueNode(0,0);
        visited[0]=true;
        q.add(s);
        QueueNode qe=new QueueNode();
        while(!q.isEmpty()){
            qe =q.peek();
            int v =qe.v;
            if(v==99){
                break;
            }
            q.poll();
            for(int j=v+1;j<=v+6 && j<100;j++){
                if(!visited[j]){
                    QueueNode a=new QueueNode();
                    a.dist=qe.dist+1;
                    visited[j]=true;
                    if(move[j]!=-1){
                        a.v=move[j];
                    }else
                        a.v=j;
                    q.add(a);
                }
            }
            
        }
        System.out.println(qe.dist);
    }
    public static class QueueNode{
        int v;
        int dist;
        public QueueNode(int v,int dist){
            this.v=v;
            this.dist=dist;
        }
        public QueueNode(){
            
        }
    }
}
