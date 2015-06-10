/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 *
 * @author venkatramreddykunta
 */
public class Test {
    public static void main(String[] args) {
        
       // int index=findDecreasedMisMatchIndex("yxw");
//        System.out.println("MisMatchIndex:"+index);
        System.out.println(""+getNextString("dkhc"));// fdg
 
    }
    static int findDecreasedMisMatchIndex(String input){
        int len=input.length()-1;
        for(int i=len;i>0;i--){
            if((input.charAt(i)-input.charAt(i-1))>0)
                return i-1;
        }    
        return -1;
    }
    static String getNextString(String input){//fg
         StringBuffer outputBuffer=new StringBuffer();   
         char[] sortedChars=new char[input.length()];
         char nextFirstChar,firstChar;
         int nextIndex=-1;

         sortedChars=input.toCharArray();
         Arrays.sort(sortedChars);
         firstChar=input.charAt(0);

         nextFirstChar=getIndexOfFirstChar(sortedChars,firstChar);
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
    static char getIndexOfFirstChar(char[] sortedChars,char firstChar){
        for(int i=0;i<sortedChars.length-1;i++){
            if(firstChar==sortedChars[i])
                return sortedChars[i+1];
        }
        return ' ';
    }
}
