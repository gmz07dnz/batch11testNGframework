package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day11_SoftAssert2 {

    /*
    1. “http://zero.webappsecurity.com/” Adresine gidin
    2. Sign in butonuna basin
    3. Login kutusuna “username” yazin
    4. Password kutusuna “password” yazin
    5. Sign in tusuna basin
    6. Pay Bills sayfasina gidin
    7. “Purchase Foreign Currency” tusuna basin
    8. “Currency” drop down menusunden Eurozone’u secin
    9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
    10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select
        One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark
        (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan
        (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore
        (dollar)","Thailand (baht)"
     */


    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test01(){
        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();


        // 3. Login kutusuna “username” yazin
        WebElement loginBox = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginBox.sendKeys("username");

        //  4. Password kutusuna “password” yazin
        WebElement passwordBox = driver.findElement(By.id("user_password"));
        passwordBox.sendKeys("password");


        //  5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // 6. Pay Bills sayfasina gidin
        driver.findElement(By.linkText("Pay Bills")).click();

        // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();

        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currencyDropDown = driver.findElement(By.id("pc_currency"));
        Select select = new Select(currencyDropDown);
        select.selectByVisibleText("Eurozone (euro)");

        //  9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        String expectedResult = "Eurozone (Euro)";
        String actualResult = select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualResult,expectedResult,"Eurozone secimi yanlis");

        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select
        //        One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark
        //        (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan
        //        (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore
        //        (dollar)","Thailand (baht)"

        List<WebElement> dropDownList = select.getOptions();

        List<String > tumList = new ArrayList<String>();
        for (WebElement w: dropDownList){
            tumList.add(w.getText());
        }

       // System.out.println(tumList);

        List<String> expectedOptionalList = Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
                "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
                "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)");

        System.out.println(expectedOptionalList);

        softAssert.assertEquals(tumList,expectedOptionalList,"options listesi actual ile uyusmuor");

     softAssert.assertAll();
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
