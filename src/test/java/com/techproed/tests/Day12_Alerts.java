package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Day12_Alerts {

    /*
    ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    ● Bir metod olusturun: acceptAlert
    ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
       “You successfuly clicked an alert” oldugunu test edin.
    ● Bir metod olusturun: dismissAlert
    ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
    ● Bir metod olusturun: sendKeysAlert
    ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve
    result mesajında isminizin görüntülendiğini doğrulayın.
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
    public  void acceptAlert() throws InterruptedException {

        //  ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        // “You successfuly clicked an alert” oldugunu test edin.

        Thread.sleep(3000); // ne yaptıgını takip etmek için bu sekilde yaptık
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        WebElement resultMesaj = driver.findElement(By.id("result"));

        Thread.sleep(3000);
        String resultMesajText = resultMesaj.getText();
        String expectedresultMesajText = "You successfuly clicked an alert";

        Assert.assertEquals(expectedresultMesajText,resultMesajText);

        /*
        String sonucYazisi=driver.findElement(By.id("result")).getText();
        Assert.assertEquals(sonucYazisi,"You successfuly clicked an alert");
        */
    }

    @Test
    public void dismiss(){

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve
        // result mesajının “successfuly” icermedigini test edin.

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        String resultText = driver.findElement(By.id("result")).getText();
        String istenmeyenKelime = "successfuly";
        Assert.assertFalse(resultText.contains(istenmeyenKelime));

    }

    @Test
    public void sendKeysAlert(){

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve
        // result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Gamze");
        driver.switchTo().alert().accept();

        String resultText = driver.findElement(By.id("result")).getText();
        String aranan = "Gamze";
        Assert.assertTrue(resultText.contains(aranan));

    }

    @AfterClass
    public void tearDown(){
      driver.close();
    }
}
