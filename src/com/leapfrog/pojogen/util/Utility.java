/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.pojogen.util;

import com.sun.xml.internal.bind.v2.schemagen.Util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Utility {

    private static HashMap<String, String> dummy = new HashMap<>();

    public StringBuilder getMap(HashMap<String, String> map) throws IOException {

        Map<String, String> mapp = map;

        StringBuilder builder = new StringBuilder();
        for (String key : mapp.keySet()) {

            if (key.contains("String") || key.contains("string")) {
                String result = getStringTemplate(key, map.get(key));
                builder.append(result);
            } else {
                String result = getIntegerTemplate(key, map.get(key));
                builder.append(result);
            }
        }

        return builder;
    }

    private String getStringTemplate(String key, String value) throws IOException {
        StringBuilder builder = new StringBuilder();
        try {

            BufferedReader reader = new BufferedReader(new FileReader("E:/JavaPrograms/IO Files/Pojo/getStringTemplate.txt"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                String change = line.replace("*", value).replace("#", (key.substring(0, 1).toUpperCase() + key.substring(1))).replace("-", (value.substring(0, 1).toUpperCase() + value.substring(1)));
                System.out.println(change);
                builder.append(change);

                 if (change != null) {
                    //FileWriter writer = new FileWriter("E:/test.txt", true);
                    BufferedWriter writer =new BufferedWriter( new FileWriter("E:/test.txt", true));
                    writer.write(change);
                    writer.close();
                }

            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return builder.toString();
    }

    private String getIntegerTemplate(String key, String value) throws IOException {
        StringBuilder builder = new StringBuilder();
        try {

            BufferedReader reader = new BufferedReader(new FileReader("E:/JavaPrograms/IO Files/Pojo/getIntegerTemplate.txt"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                String change = line.replace("*", value).replace("#", key).replace("-", (value.substring(0, 1).toUpperCase() + value.substring(1)));
                System.out.println(change);
                builder.append(change);
                if (change != null) {
                    //FileWriter writer = new FileWriter("E:/test.txt", true);
                    BufferedWriter writer =new BufferedWriter( new FileWriter("E:/test.txt", true));
                    writer.write(change);
                    writer.close();
                }

            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return builder.toString();
    }

    public void setClass(String className) {

    }
}
