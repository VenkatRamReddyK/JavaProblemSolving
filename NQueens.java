/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

/**
 *
 * @author venkatramreddykunta
 */

public class NQueens {
    int[] board;int size;
    public NQueens(int size) {
        board=new int[size];
        this.size=size;
    }
    
    public static void main(String[] args) {
        NQueens nQueens=new NQueens(8);
        nQueens.nqueens(0);
        
    }

    private void nqueens(int k) {
        for(int i=0;i<size;i++){
            if(place(k,i)){
                board[k]=i;
                if(k==size-1){
                    System.out.println("PROBLEM SOLVED");      
                    display();
                }else{
                    nqueens(k+1);
                }
            }
        }
    }

    private boolean place(int rowsCovered,int whichCol) {
      for(int rowIndex=0;rowIndex<rowsCovered;rowIndex++){
          if(board[rowIndex]==whichCol  // same col
         || (Math.abs( board[rowIndex] - whichCol)==Math.abs(rowIndex-rowsCovered)))
         {//
              return false;
          }
          
      }
        return true;
    }

    private void display() {
        for(int i=0;i<size;i++){
            System.out.println(i+" - "+board[i]);
        }
    }
}
