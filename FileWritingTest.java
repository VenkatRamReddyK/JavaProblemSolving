/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author venkatramreddykunta
 */
public class FileWritingTest {
    public static void main(String[] args) throws IOException  {        
            writeToFile("venkat");
    }
    
static void writeToFile(String input) throws IOException{
    PrintWriter out = new PrintWriter("output1.txt");
    out.println(input);
    out.close();
    }
}

