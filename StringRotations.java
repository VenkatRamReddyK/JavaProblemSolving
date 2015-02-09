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
public class StringRotations {

    private static void isARotation(StringBuffer string1, StringBuffer string2) {
        int count=0;
        boolean equals=false;
        while(count<string1.length()){              
            System.out.println("String1: "+string1+" ,string2: "+string2);
            string2=rotateMe(string2);
            System.out.println("Rotated String2: "+string2);
            if(string1.toString().equals(string2.toString())){
                equals=true;
                break;
            }count++;
            
            System.out.println("count: "+count);
        }
        if(equals)
            System.out.println("the first string is rotation of second string");          
        else            
            System.out.println("the first string is not a rotation of second string");          
        
    }

    private static StringBuffer rotateMe(StringBuffer string1) {        
        char c=string1.charAt(0);
//        System.out.println("Char at 0 of : "+string1+" is: "+c);
        string1.deleteCharAt(0).append(c);        
        return string1;
    }

    public StringRotations() {
    
    }
    public static void main(String[] args) {
        // 
        StringBuffer string1=new StringBuffer("venkat");
        StringBuffer string2=new StringBuffer("enkat");
        StringBuffer string3=new StringBuffer("tvenka");        
        isARotation(string1,string2);
    }
    
}
