package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    // we created the properties object

    private  static Properties properties = new Properties();

    static {
        try{
            // we got the path and pass it into FileInputStream, to open the file
            FileInputStream file = new FileInputStream("configuration.properties");
            // we load the opened file into properties object

            properties.load(file);
            // close the file
            file.close();

        } catch (IOException e){
            System.out.println("Properties file not found");
        }
    }
    // we read from file
    public static String getProperty(String Keyword){
        return properties.getProperty(Keyword);
    }
}
