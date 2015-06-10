///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package problemsolving;
//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
///**
// *
// * @author venkatramreddykunta
// */
//public class Pangrams {
//    
//    public static void main(String[] args) {
//    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//    
//                Scanner input=new Scanner(System.in);
////                String textInput=Character.parseChar(input.nextLine().split(" "));
//                char alphabet; 
//               int count=0;
//                 HashSet<Character> alphabetSet=new HashSet<>();
//                for(int i=0;i<textInput.length();i++){
//                            alphabet=textInput.charAt(i);
//                      //System.out.println(alphabet);  
//                    if(!alphabetSet.contains(textInput.charAt(i)) && ((alphabet>='a' && alphabet <='z') || (alphabet>='A' && alphabet <='Z') )){
//                        // not in set and an alphabet           
//                          alphabetSet.add(alphabet);
//                           count++;     
//                    }
//                }
//                if(count==26)
//                            System.out.println("pangram");
//                
//                else
//                            System.out.println("not pangram");
//                
//    }
//}
//
