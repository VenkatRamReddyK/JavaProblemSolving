/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving.knapsack;

import java.util.ArrayList;

/**
 *
 * @author venkatramreddykunta
 */
public class Knapsack {

    public Knapsack() {
    
    }
    
    public static void main(String[] args) {
    int[][] knapsack=new int[7][9];
    int weight[]={1,2,3,4,2,1};
    int cost[]={2,4,5,5,2,3};
    ArrayList<Integer> finalList=new ArrayList<>();
    
        for (int i = 0; i < 9; i++) {
            knapsack[0][i]=0;
        }
        for (int i = 0; i < 7; i++) {
            knapsack[i][0]=0;
        }
        System.out.println("Init ok ");
        for (int i = 1; i < 7; i++) {
//            System.out.println("i "+i);
            for (int j = 1; j < 9; j++) {
             //   System.out.println("i: "+i+", j: "+j+"weight[i]:"+weight[i-1]);
                if(j-weight[i-1]>0)
                    knapsack[i][j]=Math.max(knapsack[i-1][j], (knapsack[i-1][j-weight[i-1]]+cost[i-1]));
                else
                    knapsack[i][j]=knapsack[i-1][j];
                System.out.print(" "+knapsack[i][j]);//"j:"+j+", knapsack:"+
            }
            System.out.println();
        }
        System.out.println("Max Capacity: "+knapsack[6][8]);
        
        System.out.println("Trace back the elements of the knapsack bag:");
    
        int i=6;
            for (int j = 8; j >0;) {                
                if(j-weight[i-1]>0){
                    if(knapsack[i][j]-knapsack[i-1][j-weight[i-1]]== cost[i-1]){
                            finalList.add(i);
                            j-=weight[i-1];
                     }
                }
                i--;                
                if(i==0 || j<=0)
                    break;
            }
        
        System.out.println("Final list: "+finalList);
    
    }
}
