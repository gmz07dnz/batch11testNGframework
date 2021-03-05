package com.techproed.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Test01HepsiBurada {

    /*
      1- "https://www.hepsiburada.com/" adresine git.
      2- URL'nin "hepsiburada" içerdiğini dogrula.
      3- Sepetim'i tıkla. Bos oldugunu kontrol et.
      4- "https://www.hepsiburada.com/" adresine tekrar git.
      5- Elektronik tıkla.
      6- Bilgisayar/tablet'e git
      7- Tablet, Samsung git
      8- Fiyat Aralıgına en az butonuna "1000" en cok butonuna "2000" yaz ,tıkla
      9- Renk siyah sec
      10- Filtrelerin yazılı oldugu yerde "ekran boyutu 10.4 inç" goruntulendiğini test et.
      11- Renk seceneginde siyah olmadıgını test et.
      12- Renk filtre kısmında "gümüş" secenegini tıkla
      13- Ilk urunu tıkla.Urun adını kaydet. Fiyatının 2000den az oldugunu dogrula
      14- Urun markasının "Samsung" kelimesini içerdiğini dogrula
      15- Fiyat 2000den az ve "Samsung" içeriyorsa adeti "2" yap ve sepete ekle
      16- "Urun Sepete Eklendi" yazsının görüntelendiğini test et.
      17- Sepetime git.Atla secenegini tıkla.Urunun eklendiğini test et.
     */


    WebDriver driver;

    @BeforeClass
    public void setUP() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test01() {
        // 1- "https://www.hepsiburada.com/" adresine git.
        driver.get("https://www.hepsiburada.com/");
        // 2- URL'nin "hepsiburada" içerdiğini dogrula.
        String actualURL = driver.getCurrentUrl();
        String icerenKelime = "hepsiburada";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualURL.contains(icerenKelime));
        // 3- Sepetim'i tıkla. Bos oldugunu kontrol et.
        driver.findElement(By.id("cartItemCount")).click();
        WebElement sepetBosYazi = driver.findElement(By.xpath("//*[.='Sepetin şu an boş']"));
        softAssert.assertTrue(sepetBosYazi.isDisplayed());

        softAssert.assertAll();

    }

    @Test
    public  void test02(){

        // 4- "https://www.hepsiburada.com/" adresine tekrar git.
        driver.get("https://www.hepsiburada.com/");

        // 5- Elektronik tıkla.
        driver.findElement(By.xpath("(//span[@class='sf-MenuItems-5_2RN'])[1]")).click();

        // 6- Bilgisayar/tablet'e git
        driver.findElement(By.xpath("(//*[.='Elektronik'])[1]")).click();

        //  7- Tablet, Samsung git
        Actions actions = new Actions(driver);
        WebElement bilgisayarTablet = driver.findElement(By.linkText("Bilgisayar/Tablet"));
        actions.moveToElement(bilgisayarTablet).perform();
        WebElement samsung = driver.findElement(By.xpath("(//span[.='Samsung'])[1]"));
        actions.doubleClick(samsung).perform();


        //  8- Fiyat Aralıgına en az butonuna "1000" en cok butonuna "2000" yaz ,tıkla
        //  9- Renk siyah sec

        // 10- Filtrelerin yazılı oldugu yerde "ekran boyutu 10.4 inç" goruntulendiğini test et.
        // 11- Renk seceneginde siyah olmadıgını test et.
        // 12- Renk filtre kısmında "gümüş" secenegini tıkla
        // 13- Ilk urunu tıkla.Urun adını kaydet. Fiyatının 2000den az oldugunu dogrula
        // 14- Urun markasının "Samsung" kelimesini içerdiğini dogrula
        // 15- Fiyat 2000den az ve "Samsung" içeriyorsa adeti "2" yap ve sepete ekle
        // 16- "Urun Sepete Eklendi" yazsının görüntelendiğini test et.
        // 17- Sepetime git.Atla secenegini tıkla.Urunun eklendiğini test et.

    }


    @AfterMethod
    public void tearDown(){
      driver.close();
    }

}