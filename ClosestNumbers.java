import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.awt.Point;
import java.util.regex.*;

public class ClosestNumbers {
    int[] list;int N;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named ClosestNumbers. */      ClosestNumbers sol=new ClosestNumbers();
        Scanner scanner=new Scanner(System.in);
        sol.N=Integer.parseInt(scanner.nextLine());
        sol.list=new int[sol.N]; 
        for(int i=0;i<sol.N;i++){
            sol.list[i]=scanner.nextInt();
            //System.out.println(list[i]);
        }
        Arrays.sort(sol.list);
        sol.findAndDisplayMinPairs();
    }
    public void findAndDisplayMinPairs(){
        int minValue=Integer.MAX_VALUE;
        HashMap<Integer,ArrayList<Point>> minValueWithPairs=new LinkedHashMap<Integer,ArrayList<Point>>();
        Point minPair;
        ArrayList<Point> minPairList;//=new ArrayList<>();
        for(int i=0;i<N-1;i++){

            if(Math.abs(list[i+1]-list[i])<minValue){//found a new min value
                // create the an arraylist, add the new pair append the arraylist to the HashMap                     
                minValue=Math.abs(list[i+1]-list[i]);
                minPair=new Point(list[i+1],list[i]);
                minPairList=new ArrayList();
                minPairList.add(minPair);
                minValueWithPairs.put(minValue,minPairList);
               // System.out.println("- - <:  Minvalue: ["+minValue+" ], x,y: ["+list[i+1]+","+list[i]+"]");
            }
            else if(Math.abs(list[i+1]-list[i])==minValue){ 
                // get the arraylist , add the new pair, append the array list to the HashMap
                minPairList=minValueWithPairs.get(minValue);
                minPair=new Point(list[i+1],list[i]);
                minPairList.add(minPair);
                minValueWithPairs.put(minValue,minPairList);       
                //System.out.println("- - ==:  Minvalue : ["+minValue+"], x,y: ["+list[i+1]+","+list[i]+"]");
            }
        }
//        System.out.println("Output");
        System.out.println("");
        int _minValue=minValue;
      //  for(Integer _minValue : minValueWithPairs.keySet()){
          for(Point _minPoint: minValueWithPairs.get(_minValue)){
              int min=_minPoint.x<_minPoint.y?_minPoint.x:_minPoint.y;
              int max=_minPoint.x>_minPoint.y?_minPoint.x:_minPoint.y;             
              System.out.print(min+" "+max+" ");
            }
        //} 
                             
        
    }
    public  void swap(int f,int s){
        int temp=list[f];
        list[f]=list[s];
        list[s]=temp;        
    }

    public  void sort(){
        for(int i=0;i<N;i++){
            for(int j=i;j<N-1;j++){
                if(list[j]>list[j+1]){
                   swap(j,j+1);
                }
            }
                
        }    
    }
}