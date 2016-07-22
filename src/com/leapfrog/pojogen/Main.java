/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.pojogen;

import com.leapfrog.pojogen.util.Utility;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            Scanner input = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            HashMap<String,String> map = new HashMap<>();
            
            System.out.println("Enter POJO Class: ");
            String pojoclass = input.next();
            
            String line = "";
            System.out.println("Enter dependencies (datatype space variableName) : ");
            
            while(!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                
                String [] tokens = line.split(" ");
                map.put(tokens[0],tokens[1]);
               // System.out.println(map);
                
                
            }
            Utility u = new Utility();
            u.setClass(pojoclass);
            StringBuilder from = u.getMap(map);
            //
            
//            if(from!=null){
//                FileWriter writer = new FileWriter(new File("E:/test.txt"));
//                writer.write(from.toString());
//                writer.close();
//            }
            
            
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
