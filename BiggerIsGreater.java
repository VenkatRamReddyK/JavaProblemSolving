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

public class BiggerIsGreater {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner stdin=new Scanner(System.in);
        int tests=stdin.nextInt();
        stdin.nextLine();
        StringBuffer currentString;
        
        for(int i=0;i<tests;i++){            
            currentString=new StringBuffer(stdin.nextLine());
//            
            processInput(currentString);
        }        
        
    }
    
    static void processInput(StringBuffer currentString) {       
        String postMatchString;
        StringBuffer preMatchString;
        int misMatchIndex=findDecreasedMisMatchIndex(currentString);    

        if(misMatchIndex>=0){
            preMatchString=new StringBuffer(currentString.substring(0,misMatchIndex));
            postMatchString=currentString.substring(misMatchIndex);            
            
            preMatchString.append(getNextString(postMatchString));
            System.out.println(preMatchString);            
//            writeToFile(preMatchString.toString());
        }else{  //misMatchIndex =-1
            System.out.println("no answer");            
        }

    }
    static void writeToFile(String input) throws IOException{
        BufferedWriter out = new BufferedWriter(new FileWriter("output.txt", true));
        out.append(input);
    }
   static String getNextString(String input){//fg
         StringBuffer outputBuffer=new StringBuffer();   
         char[] sortedChars=new char[input.length()];
         char nextFirstChar,firstChar;         
         sortedChars=input.toCharArray();
         Arrays.sort(sortedChars);
         firstChar=input.charAt(0);

         nextFirstChar=getFirstChar(sortedChars,firstChar);
         outputBuffer.append(nextFirstChar);

         // populating the next characters 
         for(int i=0;i<sortedChars.length;i++){   
            if(sortedChars[i]!=nextFirstChar){
                 outputBuffer.append(sortedChars[i]);                
            }   
         }
        return outputBuffer.toString();
    }
    // returns the next char of the first match of firstChar
    static char getFirstChar(char[] sortedChars,char firstChar){
        for(int i=0;i<sortedChars.length-1;i++){
            if(firstChar==sortedChars[i])
                return sortedChars[i+1];
        }
        return ' ';
    }
    // finds the index where there is a decreased character value (i.e. from end)
    static int findDecreasedMisMatchIndex(StringBuffer input){
        int len=input.length()-1;
        for(int i=len;i>0;i--){
            if((input.charAt(i)-input.charAt(i-1))>0)
                return i-1;
        }    
        return -1;
    }
}