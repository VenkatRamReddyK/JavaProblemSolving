/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockANdWatson {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner=new Scanner(System.in);
        int newVal;
        System.out.println("Enter the # of Test Cases:");
        int tests=Integer.parseInt(scanner.nextLine());                
        System.out.println("Test Cases:"+tests);
        for(int i=0;i<tests;i++){
            
            System.out.println("Enter the length of array:");
            int len=Integer.parseInt(scanner.nextLine());           
            System.out.println("Length:"+len);
            System.out.println("Enter the Elements of array by space delimited:");
         
            for(int j=0;j<len;i++){           
                newVal=scanner.nextInt();
                System.out.print(newVal+" ");
              
            }
     
        }
    }    
    
}
