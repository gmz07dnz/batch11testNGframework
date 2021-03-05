package com.techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {    // configuration properties'i okumak için
    // ilk yapacağımız sey properties objesi olusturmak
    // bu objeyi static blok içinde kullanacagımdan static yapmama gerekir
    //bu objeyi sadece bu class'ta kullanacagım için private yapıyorum

   static private Properties properties ;

    static{

        String path = "configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties=new Properties();
            properties.load(fileInputStream);

            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  public static String getProperty(String key){
        return properties.getProperty(key);
  }
}
