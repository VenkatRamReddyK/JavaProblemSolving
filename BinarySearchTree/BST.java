/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving.BinarySearchTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author venkatramreddykunta
 */

public class BST {
    Node root;
    int glb;    // to keep track of Greatest Lower Bound
    int shb;    // to keep track of Smallest Higher Bound
    int maxDiameter;
    int kthLargest=0;
//    HashMap<Integer, Integer> diameterMap;
    int treesize=0;
    boolean balanced=true;
    BST(){        
        glb=Integer.MIN_VALUE;
        shb=Integer.MAX_VALUE;
        maxDiameter=Integer.MIN_VALUE;                
    }
    public void findKthLargest(Node current,int K){
        if(K>treesize){
            System.err.println(K+"th Largest Value does not exist in the tree");
            return;
        }
        if(current.right!=null)
            findKthLargest(current.right,K);

        kthLargest++; //counting the current largest value
        if(kthLargest==K){
            System.err.println("Kth Largest Value: "+current.key);
            return;
        }
        if(current.left!=null)
            findKthLargest(current.left,K);            
    }
    public void insert(int key,Node _parent){
        Node current=new Node(key);
        //Node parent=new Node();
        if(this.root==null){
            root=current;
            treesize++;            
//            System.out.println("Adding an element at the root with value : [ "+current.key+" ]");
            return;
        }
        else{
            
                if(key<=_parent.key){//key is in left subtree
                    if(_parent.left==null){//left subtree is empty
                        _parent.left=current;
                        treesize++;
//                            System.out.println("Adding an element [ "+current.key+" ] to the left side of [ "+_parent.key+" ]");
                        return;
                    }else{// left sub tree is not empty
//                            System.out.println("Traversing to the right side of [ "+_parent.key+" ]");
                        this.insert(key, _parent.left);
                    }
                }
                else { //if(key>root.key) key is in right subtree
                    if(_parent.right==null){ //right subtree is empty
                        _parent.right=current;
                        treesize++;
//                        System.out.println("Adding an element [ "+current.key+" ] to the right side of [ "+_parent.key+" ]");
                        return;
                    }else{ // right sub tree is not empty
//                      System.out.println("Traversing to the left side of [ "+_parent.key+" ]");
                        this.insert(key, _parent.right);
                    }                
                }
                //else{
//                    System.out.println("Duplicate found");
                 //   return;
                //}
                
                        
        }
    }
    
    public boolean search(int key, Node current){
        
        //Node current=new Node(key);
        if(current==null){
            return false;
        }
        else{         
            if(current.key==key){
                return true;
            }
            else if(key<current.key){
               return  search(key,current.left);
            }
            else{
                return search(key,current.right);
            }            
       }         
    } 
    
    public static void main(String[] args) {
        int[] list={7,5,3,6,9,8,10};//{2,5,3,1,4,7,8,1,2,4,3};
        
        BST bstree=new BST();
        System.out.println("Insertion order: ");
        for(int key:list){
            System.out.print(" "+key);
            bstree.insert(key,bstree.root);
        }        
        System.out.println("\n In order Traversal:");
        
        bstree.inOrder(bstree.root);
        System.out.println("Tree Size: "+bstree.treesize);
        bstree.findKthLargest(bstree.root,8);
        bstree.balanced_BST_Height(bstree.root);
        System.out.println(bstree.balanced?"BALANCED":"Not Balanced");
        bstree.calcDiameter(bstree.root);
        System.out.println("Maximum Diameter: "+bstree.maxDiameter);    
        System.out.println("Complete BST: "+bstree.isCompleteBST(bstree.root));
        
//        System.out.println("\n Pre - order Traversal:");
//        bstree.preOrder(bstree.root);
//        System.out.println("\n Post - order Traversal:");
//        bstree.postOrder(bstree.root);
        
//        for(int key:list){
//            System.out.println("Search Key : "
//                    + "[ "+key+" ]"+bstree.search(key, bstree.root));
//        }
//            System.out.println("Search Key : "
//                    + "[ "+121+" ]"+bstree.search(121, bstree.root));
//            System.out.println("Search Key : "
//                    + "[ "+(-121)+" ]"+bstree.search(-121, bstree.root));
//        
//       for(int key:list){     
//        
//                               
//          System.out.println("GLB OF "+key+": "+bstree.GLB(key,bstree.root));    
//          System.out.println("SHB OF "+key+": "+bstree.SHB(key,bstree.root));    
//          System.out.println("NEAREST OF "+key+": "+bstree.nearestOf(key,bstree.root));
//       }
//       System.out.println("GLB OF 121 : "+bstree.GLB(121,bstree.root));    
//       System.out.println("SHB OF 121 : "+bstree.SHB(121,bstree.root));    
//       System.out.println("NEAREST OF 121 "+bstree.nearestOf(121,bstree.root));
//       
//       System.out.println("GLB OF -121 : "+bstree.GLB(-121,bstree.root));       
//       System.out.println("SHB OF -121 : "+bstree.SHB(-121,bstree.root));    
//       System.out.println("NEAREST OF -121 : "+bstree.nearestOf(-121,bstree.root));
//    
//       System.out.println("Binary Search Tree: "+bstree.is_binary_search_tree(bstree.root));
//    
//       System.out.println("Height of the Tree: "+bstree.height(bstree.root));
//       
//        System.out.println("Max Diameter: "+bstree.maxDiameter(bstree.root));
//        
    }
    
    private int height(Node current){
        if(this.root==null)
            return 0;
        else if(current.left==null && current.right==null )
            return 1;
        else if(current.left==null )
            return height(current.right)+1;
        else if(current.right==null )
            return height(current.left)+1;
        else
            return Math.max(
                            height(current.left), 
                            height(current.right)
                           )    +   1;
        
    }
    
    private int maxDiameter(Node current){
        int d=diameter(current);
        return maxDiameter;
    }
    private int diameter(Node current){      
        // update maxDiameter if new Max Diameter is found
        // else apply recursive algorithm for finding height
        
        int currentDiameter=Integer.MIN_VALUE;
        if(this.root==null)
            return 0; // Indication no elements are present

        else if(current.left==null && current.right==null )
            return 1;
        else if (current.left == null) {
            currentDiameter=diameter(current.right) +   1;
            if(currentDiameter>maxDiameter){
                maxDiameter=currentDiameter;    
            }  
            return height(current.right)+1;
        }
        else if(current.right==null ){
            currentDiameter=diameter(current.left) +   1;
            if(currentDiameter>maxDiameter){
                maxDiameter=currentDiameter;    
            }                        
            return height(current.left)+1;
        }
        else{
            
            currentDiameter=diameter(current.left) + diameter(current.right)  +   1;
            if(currentDiameter>maxDiameter){
              maxDiameter=currentDiameter;    
            }
            return   Math.max(
                            height(current.left), 
                            height(current.right)
                           )    +   1;
        }   
    }
    
    private void inOrder(Node current){
        if(current==null){
            return;
        }else{
            inOrder(current.left);
            System.out.print(" "+current.key);
            inOrder(current.right);
        }
        
    }
    
    private void postOrder(Node current) {
          if(current==null){
            return;
        }else{
            postOrder(current.left);
            postOrder(current.right);
            System.out.print(" "+current.key);
        }
    }

    private void preOrder(Node current) {
          if(current==null){
            return;
        }else{
            System.out.print(" "+current.key);
            preOrder(current.left);            
            preOrder(current.right);            
        }
    }

    // GREATEST LOWER BOUND
    private int GLB(int key,Node current){
        
        if(this.root==null) // No Elements in the Tree
            return -1;
        if(current==null){
            return -1;
        }
        else{             
            if(key < current.key)
                return GLB(key,current.left);
            
            else if(key > current.key){
                    glb=current.key;
               return  GLB(key,current.right);
            }
            else{ // found the key
                
                if(current.left==null){
//                    System.out.println("GlB before finding current.key: "+current.key+" is "+glb);
                    return glb==Integer.MIN_VALUE?-1:glb; // if glb is not assigned a value then return -1
                }
                else{
                    return GLBHelper(current.left);
                }
                
            }                        
        }

    }
  
    private int GLBHelper(Node current){
        glb=current.key;
        if(current.right==null)            
            return glb;
        else   
            return GLBHelper(current.right);        
    }
 
    //SMALLEST HIGHER BOUND
    private int SHB(int key,Node current){
        if(this.root==null)
            return -1;
        
        if(current==null){
            return -1;
        }
        else{             
            if(key < current.key){
                shb=current.key;
                return SHB(key,current.left);
            }
            else if(key > current.key){
               return  SHB(key,current.right);
            }
            else{ // found the key
                
                if(current.right==null){
//                    System.out.println("SHB before finding current.key: "+current.key+" is "+shb);
                    return shb==Integer.MAX_VALUE?-1:shb; 
                    
                }
                else{
                    return SHBHelper(current.right);
                }
                
            }                        
        }

    }

    private int SHBHelper(Node current){
        shb=current.key;
        if(current.left==null)
            return current.key;
        else            
            return SHBHelper(current.left);        
    }

    private int nearestOf(int key,Node current){
        
        int glb=GLB(key,current);
        int shb=SHB(key,current);
        if(glb==-1)
            return shb;
        else if(shb==-1)
            return glb;
        else
            return Math.abs(key-glb)<Math.abs(key-shb)  ?   glb :   shb;        
            // return nearest of glb and shb
    }

    private boolean is_binary_search_tree_new(Node current){
        if(this.root==null)
            return false;
        if(current.left==null && current.right==null){
            return true;
        }
        else if(current.left==null){
            if(is_binary_search_tree(current.right))
                return current.key<current.right.key;   
        }
        else if(current.right==null){
            if(is_binary_search_tree(current.left))
                    return current.left.key<=current.key;   
        }
        else{// left and right child exist                        
            if(is_binary_search_tree(current.left) && is_binary_search_tree(current.right))
                return current.left.key<=current.key && current.key<current.right.key ;                       
        }
       return false; // if any of the above case is not true then return false;
    }
    
    private boolean is_binary_search_tree(Node current){
        if(this.root==null)
            return false;
        if(current.left==null && current.right==null){
            return true;
        }
        else if(current.right==null){
            if(current.left.key<=current.key){
                return is_binary_search_tree(current.left);
            }
        }
        else if(current.left==null){
            if(current.key<current.right.key){
                return  is_binary_search_tree(current.right);
            }
        }
        else{// left and right child exist            
            if(current.left.key<=current.key && current.key<current.right.key){            
                return is_binary_search_tree(current.left) && is_binary_search_tree(current.right);
            }            
        }
       return false; // if any of the above case is not true then return false;
    }
    
    private int balanced_BST_Height(Node current){
        int leftHeight=0,rightHeight=0;        
        if(current==null)
            return 0;
        else{
            leftHeight=balanced_BST_Height(current.left);
            rightHeight= balanced_BST_Height(current.right);
            if(balanced){                
                if(Math.abs(leftHeight-rightHeight)>1) // imbalance
                    balanced=false;                
                return Math.max(leftHeight,rightHeight)+1;
            }
            else
                return Math.max(leftHeight,rightHeight)+1;
            
        }        
    }
    
    private int calcDiameter(Node current){
        int leftHeight=0,rightHeight=0;        
        int _maxDiameter=0;
        if(current==null)
            return 0;
        else{
            leftHeight=calcDiameter(current.left);
            rightHeight= calcDiameter(current.right);            
            // calculating the diameter of the current node
            _maxDiameter=leftHeight+rightHeight+1;            
            // updating the max diameter of the BSTree
            if(maxDiameter<_maxDiameter)
                maxDiameter=_maxDiameter;            
            // return the maximum height of the subtree to calculate the diameter of the parent node
            return Math.max(leftHeight,rightHeight)+1;                        
            
        }        
    }
    private boolean isCompleteBST(Node root){
        Queue<Node> nodes=new LinkedList<>();
//        int level=0;
        if(root==null)
            return true;
        nodes.add(root);
        Node current;
        boolean breakPointFound=false; 
        
        while(!nodes.isEmpty()){
           current=nodes.remove(); // 1
           if(breakPointFound && (current.left!=null))
               return false;
               
           if(current.left!=null) nodes.add(current.left);
           else breakPointFound=true;
           
           if(breakPointFound && current.right!=null)
               return false;
           if(current.right!=null) nodes.add(current.right);
           else breakPointFound=true;                  
        }        
            return true;
    }  
    private boolean isFullBST(Node root){
        return true;
    }
}













  /*    This code solve all the test cases
    private int GLB(int key,Node current,Node parent){
        
        if(current==null){
            return -1;
        }
        else{             
            if(key < current.key){
                if(glb<=current.key)
                    glb=current.key;
                
                return GLB(key,current.left,current);
            }
            else if(key > current.key){
               return  GLB(key,current.right,current);
            }
            else{ // found the key
                
                if(current.left==null){
                    System.out.println("Current.key:"+current.key+",Parent.key"+parent.key);
                    return parent.key;
                }
                else{
                    return GLBHelper(current.left);
                }
                
            }                        
        }

    }
  
    private int GLBHelper(Node current){
        if(current.right==null)
            return current.key;
        else            
            return GLBHelper(current.right);        
    }
 
    //SMALLEST HIGHER BOUND
    private int SHB(int key,Node current,Node parent){
        
        if(current==null){
            return -1;
        }
        else{             
            if(key < current.key){
                return SHB(key,current.left,current);
            }
            else if(key > current.key){
               return  SHB(key,current.right,current);
            }
            else{ // found the key
                
                if(current.right==null){
                    return -1;
                }
                else{
                    return SHBHelper(current.right);
                }
                
            }                        
        }

    }

    private int SHBHelper(Node current){
        if(current.left==null)
            return current.key;
        else            
            return SHBHelper(current.left);        
    }
*/

