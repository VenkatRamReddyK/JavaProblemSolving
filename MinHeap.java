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
public class MinHeap {
    int[] mylist={3,2,5,4,1,0,7,9,8};
    int[] heap={};
    public static void main(String[] args) {
       MinHeap minHeap=new MinHeap();
       minHeap.process();
       

                
    }
    public void process(){
        if (mylist.length>0)
            this.heap[0]=mylist[0];
        
         for(int i = 1; i < this.mylist.length; i++) {
            this.insert(i,mylist[i]);        
         }
        
    }
    public void insert(int index,int value){        
        int root=this.mylist[0];
        // insert at the end and re-heapify
        
    }
    
         
}
