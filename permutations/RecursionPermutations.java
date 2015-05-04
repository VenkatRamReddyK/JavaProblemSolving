/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving.permutations;

/**
 *
 * @author venkatramreddykunta
 */
public class RecursionPermutations {
    public static void main(String[] args) {
        StringBuffer input=new StringBuffer("abcdefghijklmnop");
        permutations(input,0);
//        System.out.println(" "+input);
    }

    private static void permutations(StringBuffer input,int index) {
        if(index==input.length()){
            System.out.println(" "+input);
            
        }
        for (int i = index; i < input.length(); i++) {            
            swap(input,index,i);
            permutations(input,index+1);
            swap(input,index,i);
        }
        
    }

    private static void swap(StringBuffer input, int index, int i) {
        char temp=input.charAt(index);
        input.setCharAt(index,input.charAt(i));
        input.setCharAt(i,temp);
    }

    
}
