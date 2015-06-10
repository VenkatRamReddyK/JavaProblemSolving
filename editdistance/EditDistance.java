/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving.editdistance;

/**
 *
 * @author venkatramreddykunta
 */
public class EditDistance {

    public EditDistance() {
    }
    
    public static void main(String[] args) {
        String u1="fast";
        String v1="cats";
        char[] result=new char[5];
        
        char[] u=u1.toCharArray();
        char[] v=v1.toCharArray();
        
        int min=Integer.MAX_VALUE;
        int[][] dp=new int[5][5];
        
        for (int i = 0; i < 5; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i < 5; i++) {
            dp[0][i]=i;
        }
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.print(" "+dp[i][j]);
//            }
//            System.out.println(" ");
//        }
        
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
               min=Math.min(Math.min(dp[i-1][j-1], dp[i][j-1])  ,dp[i-1][j]);
               if(u[i-1]==v[j-1]){
                dp[i][j]=min;   
               }else{
                dp[i][j]=min+1;   
               }
            }
        }
        System.out.println(" DP ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(" "+dp[i][j]);
            }
            System.out.println(" ");
        }
        
        System.out.println("Back tracking");
        int i=u.length;
        for(int j=v.length;j>0;){
           // if(u[i-1]==v[j-1]){
                
                if(dp[i][j]==dp[i-1][j-1] || dp[i][j]==dp[i-1][j-1]+1){
                
                    
                    System.out.println("D "+u[i-1]+" - > "+v[j-1]);
                    i--;j--;
                }
                else if(dp[i][j]==dp[i][j-1]){
                
                    System.out.println("L "+u[i-1]+" - > "+v[j-1]);
                    j--;
                }
                else if(dp[i][j]==dp[i-1][j]){
                    
                    System.out.println("U "+u[i-1]+" - > "+v[j-1]);
                i--;
                }
                
            //}
            //else{
                
//                if(dp[i][j]==dp[i-1][j-1]+1){
//                    
//                    System.out.println("D "+u[i-1]+" - > "+v[j-1]);
//                    i--;j--;
//                }
//                else if(dp[i][j]==dp[i][j-1]){
//                    
//                    System.out.println("L "+u[i-1]+" - > "+v[j-1]);
//                j--;
//                }
//                else if(dp[i][j]==dp[i-1][j]){
//                
//                    System.out.println("U "+u[i-1]+" - > "+v[j-1]);
//                    i--;
//                }
          //  }
        }
        
        
    }
}
