/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving;

import java.util.Iterator;
   import java.util.*;
/**
 *
 * @author venkatramreddykunta
 */
public class College {
    
    public static void main(String[] args) {
 

        int[] list={-10,10,31,67,77,3,2,2,1,1};
        
        
        int current,gClosest=Integer.MAX_VALUE, gClosestI=Integer.MIN_VALUE,gClosestJ=Integer.MIN_VALUE,closestI=Integer.MIN_VALUE,closestJ=Integer.MIN_VALUE,closest=Integer.MAX_VALUE;
        for(int i=0;i<list.length;i++){
            for(int j=i+1;j<list.length;j++){
                current=list[i];
                if(Math.abs(current-list[j])<closest){
                    closestI=current;
                    closestJ=list[j];
                    closest=Math.abs(current-list[j]);
                }
            
            
//            System.out.println("Closest: i-"+closestI+"-j-"+closestJ+" ->local closest="+closest);
            }
            if(closest<gClosest){
                gClosest=closest;
                gClosestI=closestI;
                gClosestJ=closestJ;
            }
            else if(closest==gClosest){
                     System.out.println("-> "+closestI+ " ,"+closestJ);
            }
//            System.out.println(
//            System.out.println("Global Closest: i-"+gClosestI+"-j-"+gClosestJ+" ->GLobal closest="+gClosest);
            
	}
	System.out.println("Global Closest: i-"+gClosestI+"-j-"+gClosestJ+" ->GLobal closest="+gClosest);
	
}
    
}
        
    
