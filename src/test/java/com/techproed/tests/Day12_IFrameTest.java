package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Day12_IFrameTest {

    /*
      ● https://the-internet.herokuapp.com/iframe adresine gidin.
      ● Bir metod olusturun: iframeTest
      ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda
         yazdirin.
      ○ Text Box’a “Merhaba Dunya!” yazin.
      ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur
          oldugunu dogrulayin ve konsolda yazdirin.
     */

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void iframeTest(){
        // ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsold yazdirin.
        WebElement yazi =driver.findElement(By.tagName("h3"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(yazi.isEnabled());

        // ○ Text Box’a “Merhaba Dunya!” yazin.
       driver.switchTo().frame("mce_0_ifr");

       WebElement textBox =driver.findElement(By.id("tinymce"));
       textBox.clear();
       textBox.sendKeys("Merhaba Dunya!"+ Keys.ENTER); // -> frame'den cıkmak lazım

         driver.switchTo().defaultContent();

       // ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur
        // oldugunu dogrulayin ve konsolda yazdirin.

        WebElement elementalSeleniumLink = driver.findElement(By.linkText("Elemental Selenium"));
        softAssert.assertTrue(elementalSeleniumLink.isDisplayed());
        System.out.println(elementalSeleniumLink.getText());

        softAssert.assertAll();

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }



}
