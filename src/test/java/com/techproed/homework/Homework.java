package com.techproed.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Homework {

    /*
    1. https://www.amazon.com/ adresine gidin
    2. softassert kullanarak amazon websitesine gittiginizi dogrulayin
    3. kategori dropdown'indan Books kategorisini secin arama kutusuna history yazdirip aratin
    4. cikan kitaplardan 2. ve 5. kitabin isminde History kelimesinin gectigini dogrulayin
    5. cikan sonuc sayisinin 50000'den buyuk oldugunu dogrulayin

     */

    WebDriver driver;

    @BeforeClass
    public void setUP(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }


    @Test
    public void test01(){
        // 1.https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // 2. softassert kullanarak amazon websitesine gittiginizi dogrulayin
        SoftAssert softAssert = new SoftAssert();
        WebElement logoAmazon =driver.findElement(By.id("nav-logo-sprites"));
        softAssert.assertTrue(logoAmazon.isDisplayed());

        // 3. kategori dropdown'indan Books kategorisini secin arama kutusuna history yazdirip aratin
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select options = new Select(dropDown);
       options.selectByVisibleText("Books");
       WebElement searcBox = driver.findElement(By.id("twotabsearchtextbox"));
       searcBox.sendKeys("history"+Keys.ENTER);

       // 4. cikan kitaplardan 2. ve 5. kitabin isminde History kelimesinin gectigini dogrulayin
        WebElement kitap2 =driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        String kitap2Yazi =kitap2.getText();
        softAssert.assertTrue(kitap2Yazi.contains("History"));

        WebElement kitap5 = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[5]"));
        String kitap5Yazi =kitap5.getText();
        softAssert.assertTrue(kitap5Yazi.contains("History"));

        // cikan sonuc sayisinin 50000'den buyuk oldugunu dogrulayin
        WebElement sonucSayisi = driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        String sonucSayisiText = sonucSayisi.getText();
        System.out.println(sonucSayisiText);  // 1-16 of over 100,000 results for

        String arr[] = sonucSayisiText.split(" ");
        System.out.println(Arrays.toString(arr)); // 1-16, of, over, 100,000, results, for]
        String sonuc = arr[3].trim().replace(",","");
        System.out.println(sonuc);  // 100.000
        int snc = Integer.parseInt(sonuc);
        System.out.println(snc);

        softAssert.assertTrue(snc>50000);
        softAssert.assertAll();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
