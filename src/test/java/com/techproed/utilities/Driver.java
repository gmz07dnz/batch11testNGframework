package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // Singleton Class: Object olusturulması kontrol altına alınan (genelde izin verilmeyen) class'lardır.
    // Bunun için baska class'lardan obje uretmenızı saglayan constructor'ı gorunur sekilde yazıp access modifier'ı prıvate yapmalıyız.

    private Driver(){

    }

    static private WebDriver driver;

    static public WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();

        if (driver == null){
           switch (ConfigReader.getProperty("browser")){
               case "chrome":
                   WebDriverManager.chromedriver().setup();
                   driver=new ChromeDriver();
                   break;
               case "firefox":
                   WebDriverManager.firefoxdriver().setup();
                   driver =new FirefoxDriver();
                   break;
               case "safari":
                   WebDriverManager.getInstance(SafariDriver.class);
                   driver = new SafariDriver();
                   break;
               case "opera":
                   WebDriverManager.operadriver().setup();
                   driver =new OperaDriver();
                   break;
           }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }



  static public void closeDriver(){
        if (driver != null){
            driver.quit();
            driver=null;
        }
    }
}
