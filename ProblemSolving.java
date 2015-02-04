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
public class ProblemSolving {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] list=new int[]{4,5,10,3,7,8,1,2};
        int pivot,i,j;
        i=0;j=list.length-1;pivot=list.length/2;       
        
        while(i<j){ // i crossed j  partition is finished
            while (list[i]<list[pivot]){ // find all the elements less than pivot
                i++;                 
            }
            while (list[j]>list[pivot]){ // find all the elements less than pivot
                j--;                   
            }           
            swap(list,i,j);
        }
        if(pivot>j)
            swap(list,j,pivot);
        System.out.println("Elements lesser than "+list[pivot]+" value");
        for (int k = 0; k <= pivot; k++) {
            System.out.println(list[k]+",");
        }
        System.out.println("Elements greater than "+list[pivot]+" value");
        for (int k = pivot+1; k < list.length; k++) {
            System.out.println(list[k]+",");
        }
        
    }
    public static void swap (int list [], int index1, int index2){
        int temp;
        temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;      
    }
    
}
