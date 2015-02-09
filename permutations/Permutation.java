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
public class Permutation {

    static int[] list={4,4,2,5};
    static int N,i,j,k,value,index;
    public static void main(String[] args) {
        N=list.length;
        int[][] perm=new int[(int)Math.pow(N,N)][N];
        for(j=0;j<N;j++){                
                for(i=0;i<(int)Math.pow(N,N-j);i++){                    
                    for(k=0;k<(int)Math.pow(N,j);k++){                        
                        value=i/(int)Math.pow(N,N-j-1);
                        index=k*(int)Math.pow(N,N-j)+i;
                        perm[index][j]=list[value];                        
                    }                         
                }
        }                            
        System.out.println("All possible combination of input");       
        for(i=0;i<(int)Math.pow(N,N);i++){
            for(j=0;j<N;j++){
                System.out.print(" "+perm[i][j]);
            }   
            System.out.println();
        }       
    }
    
}
    

