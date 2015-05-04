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
public class StringTest
{
  public static void main(String[] args)
  {
    String s = "yo-dude: like, ... []{}this is a string";
    s = s.replaceAll("[^a-z A-Z0-9]", "");
    System.out.println(s);
  }

}
