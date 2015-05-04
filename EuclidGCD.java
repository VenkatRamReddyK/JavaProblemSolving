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
public class EuclidGCD {
    public static void main(String[] args) {
        int[] list={88,84,12,4};
        System.out.println("GCD:"+gcd(list));
    }
    private static int gcd(int[] list) {     
        if(list==null || list.length==0)
            return 0;
        if(list.length==1)
            return list[0];
        
        int gcdNum=list[0];
        for (int i =1; i < list.length; i++) {            
            gcdNum=gcd(gcdNum,list[i]);
            
        }
        return gcdNum;
    }
    private static int gcd(int x, int y,int z) {     
        return gcd(x,gcd(y,z));
    }
    private static int gcd(int x, int y) {
     int gcd=1;    
        while(gcd!=0){                        
            gcd= x%y;
            x=y;
            y=gcd;                     
        }
        return x;        
    }
    
}
