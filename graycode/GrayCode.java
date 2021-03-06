/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving.graycode;

/**
 *
 * @author venkatramreddykunta
 */
public class GrayCode {
    static StringBuffer buffer;
    static int N=9; // gray code of size N
//    static int[] window={0,0,1,0,1,1,0};    
    static int[] windowLeft={0,0,1,0,1,1,0};    
    static int[] windowRight={1,1,0,0,1,1,0};    
    private static void traverse(int index,boolean isFirstHalf) {
        int leftIndex,rightIndex;        
            if(isFirstHalf)
                 buffer.append(windowLeft[index]); 
            else 
                buffer.append(windowRight[index]); 
        if(buffer.length()==N){ // Buffer is full
            System.out.println(buffer);
        }else{
            leftIndex=2*index+1;
            rightIndex=2*index+2;
            leftIndex = updateIndex(leftIndex);
            rightIndex = updateIndex(rightIndex);
          //  if(isFirstHalf){
                traverse(leftIndex,isFirstHalf);
                traverse(rightIndex,isFirstHalf);            
          
        }
        buffer.deleteCharAt(buffer.length()-1);
        // if Left child is traverses Traverse right child 
    }

    public static int updateIndex(int leftIndex) {
        if(leftIndex>=4){            
            leftIndex%=4;            
            if(leftIndex!=3)
                leftIndex+=4;            
        }
        return leftIndex;
    }

    public static void main(String[] args) {
       int grayCode=4;
       buffer=new StringBuffer(N);
       traverse(0,true);
       traverse(0,false);            
       indexOfGrayCode(grayCode);
    }

    private static void indexOfGrayCode(int grayCode) {
        
    }
  
}
