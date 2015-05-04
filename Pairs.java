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


public class Pairs {
    

    static int pairs(int[] a,int k) {
      /* Complete this function */
        int pairsCount=0,pairNum=0;
        //Arrays.sort(a);
        HashMap<Integer,Integer> sumToKPairs=new HashMap<>();
        
        for(int i=0;i<a.length;i++){
            if(sumToKPairs.containsKey(a[i])){// counting duplicates
                sumToKPairs.put(a[i],sumToKPairs.get(a[i])+1);                  
            }else{// first entry of the value a[i]
                sumToKPairs.put(a[i],1);                  
            }
        }
        
        for(int i=0;i<a.length;i++){
            pairNum=(int)Math.abs(a[i]+k);

            if(sumToKPairs.containsKey(a[i]) && sumToKPairs.containsKey(pairNum)){
                pairsCount++;     
                System.out.println("Pairs: ("+a[i]+" , "+pairNum+")");
                sumToKPairs.put(pairNum,sumToKPairs.get(pairNum)-1);
                sumToKPairs.put(a[i],sumToKPairs.get(a[i])-1);
                
                if(sumToKPairs.get(pairNum)==0)
                    sumToKPairs.remove(pairNum);

                if(sumToKPairs.get(a[i])==0)
                    sumToKPairs.remove(a[i]);                
                
                
            }
              
        }
        return pairsCount;        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        
        String n = in.nextLine();
        String[] n_split = n.split(" ");
        
        int _a_size = Integer.parseInt(n_split[0]);
        int _k = Integer.parseInt(n_split[1]);
        
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");
        
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }
        
        res = pairs(_a,_k);
        System.out.println(res);
    }
}

