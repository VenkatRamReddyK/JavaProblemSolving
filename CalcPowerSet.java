/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author venkatramreddykunta
 * Output: 
 *          Result Power Set:  [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
 */
public class CalcPowerSet {
    
    public static void main(String[] args) {
        
        
        Set<Integer> input=new HashSet<>();
        input.add(1);input.add(2);input.add(3);                
        Set<Set<Integer>> helper=new HashSet<Set<Integer>>();
        Set<Set<Integer>> result=new HashSet<Set<Integer>>();
        Set<Integer> temp;
        result.add(Collections.EMPTY_SET);
        helper.add(Collections.EMPTY_SET);
        for(int element: input){// 1,2,3            
            helper.addAll(result);            
            for(Set<Integer> helperElement:helper){
                temp=new HashSet<Integer>() ;
                temp.addAll(helperElement);                
                temp.add(element);//[],                
                result.add(temp);                                                                
            }           
        }
        System.out.println("Result Power Set:  "+result);
        
    }
    
}
