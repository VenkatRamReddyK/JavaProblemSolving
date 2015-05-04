/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving;

/**
 *
 * @author venkatramreddykunta
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ConnectingGrid {

    static int[][] input;
    static boolean[][] visited;
    static int M,N;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    
    	Scanner stdin=new Scanner(System.in);
        int j,k,i;
          M=stdin.nextInt();
          N=stdin.nextInt();           
          input=new int[M][N];
          visited=new boolean[M][N];
        int maxCountCells=1,_maxCountCells=0;
          //System.out.println("M:"+M+",N:"+N);        
          for(j=0;j<M;j++){  
              for(k=0;k<N;k++){  
                   input[j][k]=stdin.nextInt();
                   if(input[j][k]==1){
                      visited[j][k]=false;
                  }else
                      visited[j][k]=true;
              }           
          }
                          //System.out.println();
          for(j=0;j<M;j++){  
              for(k=0;k<N;k++){  
                if(!visited[j][k]){
                    _maxCountCells=countCells(j,k); // counts the no of 1's in a connected grid
                    if(maxCountCells<_maxCountCells){
                        maxCountCells=_maxCountCells;
                    }
                }
              }
          }
        System.out.println(maxCountCells);
                    
    }
    // counts the cells in the maximum grid and returns the total cells by making a recursion 
    static int countCells(int row, int col){
        int totalCells=0;
        if(row+1<M && !visited[row+1][col]){
            visited[row+1][col]=true;            
            totalCells+=countCells(row+1,col)+1;
        }
        if(row-1>=0 && !visited[row-1][col]){
            visited[row-1][col]=true;            
            totalCells+=countCells(row-1,col)+1;
        }        

        if(col+1<N && !visited[row][col+1]){
            visited[row][col+1]=true;        
            totalCells+=countCells(row,col+1)+1;            
        }
        if(col-1>=0 && !visited[row][col-1]){
            visited[row][col-1]=true;        
            totalCells+=countCells(row,col-1)+1;            
        }        
            
        if((row+1)<M && (col+1)<N && !visited[row+1][col+1]){
            visited[row+1][col+1]=true;        
            totalCells+=countCells(row+1,col+1)+1;                  
        }
        if((row-1)>=0 && (col-1)>=0 && !visited[row-1][col-1]){
            visited[row-1][col-1]=true;        
            totalCells+=countCells(row-1,col-1)+1;                  
        }
        if((row+1)<M && (col-1)>=0 && !visited[row+1][col-1]){
            visited[row+1][col-1]=true;        
            totalCells+=countCells(row+1,col-1)+1;                  
        }
        if((row-1)>=0 && (col+1)<N && !visited[row-1][col+1]){
            visited[row-1][col+1]=true;        
            totalCells+=countCells(row-1,col+1)+1;                  
        }
        return totalCells;
    }
}
