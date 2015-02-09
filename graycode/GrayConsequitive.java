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
public class GrayConsequitive {
    public static void main(String[] args) {
        byte[] gray7={0,0,0,0,0,1,1,1};//7
        byte[] gray6={0,0,0,0,0,1,1,0};//6
        byte[] gray0={0,0,0,0,0,0,0,0};//7
        byte[] gray2={0,0,0,0,0,0,1,0};//6
        byte[] bin2={0,0,0,0,0,0,1,0};//6
        byte[] bin_to_gray2=binToGray(bin2);
//        System.out.println(" - - >  "+Byte.parseByte("5",2));
//        byte b3=12;//0b00000111;
//        byte b2=0b00000010;
//        System.out.println("7: "+b3);
        
//        byte g3=grayCodeOfByte(b3);
//        byte g2=grayCodeOfByte(b2);
//        System.out.println("gray of [ "+b2+" ] is : "+g2);
//        System.out.println("gray of [ "+b3+" ] b3 is : "+g3);
//        
        
        
        System.out.println(" Consequitive: "+isConsequitive(259,263));
        
//        System.out.println("\n Consequitive: 7,6 "+isConsequitive(gray7,gray6));
//        System.out.println("Consequitive: 0,2 "+isConsequitive(gray0,gray2));
        
        
//        int i =132;
//        byte b =(byte)i;
//        System.out.println("-> "+b);


//        System.out.println("  gray of 2 :  ");
//        
//        for (int i = 0; i < bin_to_gray2.length; i++) {
//            System.out.print(""+bin_to_gray2[i]);
//        }
        
        
    }
//    private static boolean isConsequitive(byte b3, byte b2) {
//        
//        
//    }
    
    
    private static int grayToBinary(int num){
         for (int mask = num >> 1; mask != 0; mask = mask >> 1)
           num = num ^ mask;
            return num;
    }
    
    
    private static boolean isConsequitive(int gray1, int gray2) {           
        if(Math.abs(grayToBinary(gray1)-grayToBinary(gray2))==1)
            return true;
        return false;        
    }   
    
//    System.out.println("gray to bin of [ "+gray1+" ] is : "+first);
//        System.out.println("gray to bin of [ "+gray2+" ] is : "+second);
    
    private static byte[] grayToBinary(byte[] gray1) {
        byte[] bin=new byte[gray1.length];      
        int j=0;
        bin[0]=gray1[0];
        for (int i = 1; i < gray1.length; i++) {
            bin[i]=(byte) (gray1[i]^bin[j++]);            
        }
       return bin;
    }
    
    
    // overwriting the previous method
    private static boolean isConsequitive(byte[] gray1, byte[] gray2) {
        byte[] bin1=grayToBinary(gray1);
        byte[] bin2=grayToBinary(gray2); 

        int first=binToInt(bin1);
        
        int second=binToInt(bin2);        
        if(Math.abs(first-second)==1){
            return true;
        }
        else
            return false;
    }
    private static byte grayCodeOfByte(byte b3) {
        return (byte)(b3^(b3>>1));
        }
    
    private static int binToInt(byte[] bin2) {
        int intVal=0;
        for(int i=bin2.length-1;i>=0;i--)                    
            intVal+=(int)bin2[i]*Math.pow(2, bin2.length-1-i);        
        return intVal;
    }

    private static byte[] binToGray(byte[] bin2) {
        byte[] gray=new byte[bin2.length];
//        byte[] rshift=new byte[bin2.length];
        gray[0]=bin2[0];
        for (int i = 0; i < bin2.length-1; i++) {
            gray[i+1]=(byte)(bin2[i]^bin2[i+1]);
        }
        return gray;
    }

    

    
    

}

//    private static byte[] xor(byte[] x, byte[] y) {
//        byte[] z=new byte[x.length];    
//        int i = 0;
//        for (byte b : x)
//            z[i] = (byte) (b ^ y[i++]);
//        return z;
//    }

//        System.out.println("Length of gray1: "+gray1.length);
//        System.out.println(" Pow of 3,2"+Math.pow(3, 2));
//        System.out.println("Int Value of Gray1: "+binToInt(gray1));
//        
//        System.out.println("Int Value of Gray2: "+binToInt(gray2));
//        byte[] z, x={1,0,1},y={1,1,1};
//        z=xor(x,y);
//        System.out.println("Xor : ");
//        for (int i = 0; i < z.length; i++) {
//            System.out.print(" "+z[i]);
//        }

//        byte[] bin2=grayToBinary(gray1);
//        System.out.println("Gray: ");
//        for (int i = 0; i < bin2.length; i++) {
//            System.out.print(" "+bin2[i]);
//        }