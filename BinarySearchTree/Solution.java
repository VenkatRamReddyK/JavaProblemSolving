/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving.BinarySearchTree;

/**
 *
 * @author venkatramreddykunta
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution { 

private static class Node {
       Node left, right;
       int data;
       Node(int newData) {
           left = right = null;
           data = newData;
       }
}

private static Node insert(Node node, int data) {
       if (node==null){            
           node = new Node(data);
       }
       else {
           if (data < node.data) {
               node.left = insert(node.left, data);
           }
           else {
               node.right = insert(node.right, data);
           }
       }
       return(node);
   }

private static Node addRandomElement(Node node, int data, int index){
       if (node==null){            
           node = new Node(data);
       }
       else {
            if (index <= 2) {
               node.left = addRandomElement(node.left, data,index);
           }
           else {
               node.right = addRandomElement(node.right, data,index);
           }
  
       }
       return(node);
   }

}

