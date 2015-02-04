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
public class FactRecursion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int n=5;
        int p=fact(5);
        
        
        
        
    }

    private static int fact(int n) {
      int p;
        if (n==1) return 1;
      else{
          System.out.println(n);
          p=n*fact(n-1);
          
          return p;  
      }
          
    }
    
    
}
