/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving.LCS;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author venkatramreddykunta
 */
public class HackerRankLIS {
    
    public static void main(String[] args) {
        
        Scanner stdin=new Scanner(System.in);
        int n=Integer.parseInt(stdin.nextLine());        
        int i,j;
        int top[]=new int[n];
        int left[]=new int[n];        
        
        for(i=0;i<n;i++){
          top[i]=stdin.nextInt();  
          left[i]=top[i];  
        } 
        
        StringBuffer solution=new StringBuffer();
        
        //char[] top=topString.toCharArray();
        //char[] left=topString.toCharArray();

        Arrays.sort(left);

        int m=n;
        //      j  - > n top
        //  i (l)eft
        //  |
        //  v
        //  m
        
        // initialization 
        int lcs[][]=new int[m+1][n+1];        
        for (i = 0; i < m+1; i++) {                    
            lcs[i][0]=0;
        }
        for (i = 0; i < n+1; i++) {                    
            lcs[0][i]=0;
        }
        
        // Populating LCS uysing Dynammic programming
        
        for (i = 1; i < m+1; i++) {
            for (j = 1; j < n+1; j++) {
                if(left[i-1]==top[j-1]){ //  *** top and left starts from 0 and i,j starts from 1
                    lcs[i][j]=lcs[i-1][j-1]+1;
                }
                else{
                    lcs[i][j]=Math.max(lcs[i-1][j],lcs[i][j-1]);
                }
            }            
        }        
        System.out.println(" Longest Increasing Subsequence");
        
            for (i = 0; i < m+1; i++) {
                for (j = 0; j < n+1; j++) {
                    System.out.print(" "+lcs[i][j]);
                }
               System.out.println("");
           }
        
    // Backtracking               
          i=m;
          for(j=n;j>0 && i>0;){              
             // System.out.println("i: "+i+"top "+top[j-1]+",j: "+j+" , left: "+left[i-1]);
              if(left[i-1]==top[j-1]){ 
                  solution.append(left[i-1]);
                  i--;j--;
               //   System.out.println("D ");
              }else{
                  
                  if(lcs[i][j]==lcs[i-1][j]){
                      i--;
                 //     System.out.println(" ^ top");
                  }
                  else if(lcs[i][j]==lcs[i][j-1]){
                  //    System.out.println("<- left");
                      j--;
                  }
              }
              
              
          }
 //         System.out.println(" Back Tracing for solution: ");
//          System.out.println("Solution: "+solution.length());
          System.out.println("Solution"+solution.length());                      
    }
    
}


