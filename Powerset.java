/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;



import java.util.*;

public class Powerset {

    protected static <T> Set<T> removeMe(Set<T> s, T e) {
        Set<T> result = new HashSet(s);
        result.remove(e);
        return result;
    }

    protected static <T> Set<T> addMe(Set<T> s, T e) {
        Set<T> result = new HashSet(s);
        result.add(e);
        return result;
    }

    public static <T> Set<Set<T>> powerset(Set<T> s) {
        Set<Set<T>> result = new HashSet<Set<T>>();
        if(s.isEmpty()) {
            result.add(Collections.EMPTY_SET);
        } else {
            for (T e : s) {
                Set<T> t = removeMe(s, e);
                Set<Set<T>> ps = powerset(t);
                result.addAll(ps);
                //System.out.println("e: "+e+"- ps- "+ps+"- result-"+result);
                for (Set<T> ts : ps) {
                    result.add(addMe(ts, e));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        
        Set<String> s = new HashSet<String>();        
        Set<Set<String>> sets=new HashSet<Set<String>>();
        //System.out.println(powerset(s));
        s.add("a");
        //System.out.println(powerset(s));
        s.add("b");
        //System.out.println(powerset(s));
        s.add("c");
        sets=powerset(s);
        System.out.println(sets);
        StringBuffer[] bufferList=new StringBuffer[1];
        bufferList=convertToStrings(sets);
        System.out.println(sets.size());
        System.out.println("Smallest is: ");
        
//        for(StringBuffer string1:bufferList){
//            System.out.println(string1);
//        }
        System.out.println("lowest:"+lowerBetweenString(bufferList));
        
    }    
    static StringBuffer lowerBetweenString1(StringBuffer string1,StringBuffer string2){
            if(string1.toString().compareTo(string2.toString())>0){
                return string1;
            }
                return string2;
        }
static StringBuffer lowerBetweenString(StringBuffer[] strings){
    StringBuffer minString=new StringBuffer(strings[1]);
    //System.out.println(strings[1]);
    for(int i=2;i<strings.length;i++){
            if(strings[i].toString().compareTo(minString.toString())<0){
                minString= strings[i];
                
            }   
         //   System.out.println(strings[i]);
        }
    return minString;
    }    
    static StringBuffer[] convertToStrings(Set<Set<String>> sets){
        StringBuffer[] bufferList=new StringBuffer[sets.size()];
        StringBuffer temp; 
        int i=0;
        for (Set<String> set:sets){
            System.out.println(set);
            temp=new StringBuffer();
            for(String element:set){
                if(!element.equals("")){
                    temp.append(element);
                }
            }
            bufferList[i++]=temp;
        }
        
        return bufferList;
    }
}