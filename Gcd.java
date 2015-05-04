/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving;

import java.math.BigInteger;

/**
 *
 * @author venkatramreddykunta
 */
public class Gcd {

    public Gcd() {
    }
    
    public static void main(String[] args) {
        String x="18",y="24";
        BigInteger num1=new BigInteger(x);
        BigInteger num2=new BigInteger(y);
        System.out.println("GCD: "+num1.gcd(num2));
    }
}
