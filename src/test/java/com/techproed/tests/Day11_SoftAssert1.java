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

public class Day11_SoftAssert1 {

    /*
    1. “http://www.amazon.com” Adresine gidin
    2. Basliginin "Sahibinden Satılık, Kiralık, Emlak, Oto, Alışveriş Ürünleri" oldugunu dogrulayin
    3. search kutusuna araba yazip arattirin
    4. bulunan sonuc sayisini yazdirin
    5. sonuc yazisinin "araba" icerdigini dogrulayin
    6. Tumunu temizle linkini tiklayin
    7. Bulunan sonucu yazdirin
    8. Sonuc yazisinin “araba” kelimesi icermedigini dogrulayin
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
        // “http://www.sahibinden.com” Adresine gidin
        driver.get("http://www.sahibinden.com");
        SoftAssert softAssert = new SoftAssert();

        // Basliginin "Sahibinden Satılık, Kiralık, Emlak, Oto, Alışveriş Ürünleri" oldugunu dogrulayin
        String actualTitle = driver.getTitle();
        String expectedTitle ="Sahibinden Satılık, Kiralık, Emlak, Oto, Alışveriş Ürünleri";
        softAssert.assertEquals(actualTitle,expectedTitle);

        //  search kutusuna araba yazip arattirin
        WebElement searchBox = driver.findElement(By.id("searchText"));
        searchBox.sendKeys("araba"+ Keys.ENTER);

        // sonuc yazisinin "araba" icerdigini dogrulayin
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='result-text estimated-result-text']"));
        String actualSonucYazisi = sonucYazisi.getText();
        String arananIcerik = "araba";
        softAssert.assertTrue(actualSonucYazisi.contains(arananIcerik));

        // Tumunu temizle linkini tiklayin
        driver.findElement(By.linkText("Tümünü Temizle")).click();

        // Bulunan sonucu yazdirin
        WebElement sonucYazisi2 = driver.findElement(By.className("result-text"));
        System.out.println(sonucYazisi2.getText());

        // Sonuc yazisinin “araba” kelimesi icermedigini dogrulayin
        String istenmeyenKelime = "araba";
        softAssert.assertFalse(sonucYazisi2.getText().contains(istenmeyenKelime));

        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown(){
       driver.close();
    }
}
