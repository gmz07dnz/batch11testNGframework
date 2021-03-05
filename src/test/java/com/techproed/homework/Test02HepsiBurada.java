package com.techproed.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Test02HepsiBurada {

    /*
      1- "https://www.hepsiburada.com/" adresine git.
      2- Baslıgın "Türkiye'nin En Büyük Online Alışveriş Sitesi HepsiBurada.com hepsiburada.com" oldugunu doğrula.
      3- "Ev,Yaşam,Kırtasiye,Ofis" den Kırtasiye Ürünleri tıkla
      4- Resimlerden "Kalem ve Yazı Gerecleri" ni tıkla.
      5- Ilk ürünü tıkla
      6- Puanını ve degerlendiren sayiyi görüntüle
      7- Sepete ekle. Urunun eklendiğini dogrula
      8- Alışverise devam et tıkla
      9- Marka Ara "Faber-Castell" yazdır.CheckBox'ı tıkla
      10- İlk secenegi tıkla. Tıklandıgını test et
      11- Fiyat Aralıgı 25-50 tıkla
      12- İlk urunu sepete ekle
      13- Sepete git.
      14- İlk ürünü sil. Silindiğini doğrula
      15- Sepetteki ürün sayısını görüntüle
      16- Alışverişi tamamla
     */

    WebDriver driver;

    @BeforeClass
    public void setUP(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @BeforeMethod
    public void sayfayaGit(){
        // 1- "https://www.hepsiburada.com/" adresine git.
        driver.get("https://www.hepsiburada.com/");
    }

    @Test
    public void test01(){
        // 2- Baslıgın "Türkiye'nin En Büyük Online Alışveriş Sitesi HepsiBurada.com hepsiburada.com" oldugunu doğrula.
        String actualTitle = driver.getTitle();
        String expectedTitle = "Türkiye'nin En Büyük Online Alışveriş Sitesi HepsiBurada.com";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle,expectedTitle);
        softAssert.assertAll();
    }

    @Test
    public void test02(){
        // 3- "Ev,Yaşam,Kırtasiye,Ofis" den Kırtasiye Ürünleri tıkla
        driver.findElement(By.xpath("//*[(text()='Ev, Yaşam, Kırtasiye, Ofis')]")).click();
        driver.findElement(By.xpath("//span[(text()='Kırtasiye Ürünleri')]")).click();

        // 4- Resimlerden "Kalem ve Yazı Gerecleri" ni tıkla.
        driver.findElement(By.xpath("//img[@title='kalem_ve_yazi_gerecleri']")).click();

        //   5- Ilk ürünü tıkla
       driver.findElement(By.xpath("(//p[@class='hb-pl-cn'])[1]")).click();

       // 6- Puanını ve degerlendiren sayiyi görüntüle   (//span[@content='179'])[2]
        WebElement puan = driver.findElement(By.className("rating-star"));
        String puanIlkUrun = puan.getText();
        System.out.println(puanIlkUrun);

        WebElement degerlendirme = driver.findElement(By.xpath("(//span[@content='179'])[2]"));
        String degerlendirmeIlkUrun = degerlendirme.getText();
        System.out.println(degerlendirmeIlkUrun);

        // 7- Sepete ekle. Urunun eklendiğini dogrula
        driver.findElement(By.xpath("//button[@class='button big with-icon']")).click();
        WebElement urunSepette = driver.findElement(By.xpath("//*[(text()='Ürün sepetinizde')]"));
        SoftAssert softAssert = new SoftAssert();

        //  8- Alışverise devam et tıkla
        driver.findElement(By.linkText("Alışverişe devam et")).click();

        // 9- Marka Ara "Faber-Castell" yazdır. CheckBox'ı tıkla
        WebElement markaAraBox = driver.findElement(By.xpath("//input[@placeholder='Marka ara']"));
        markaAraBox.sendKeys("Faber-Castell");
       WebElement checkBox =  driver.findElement(By.xpath("//label[@for='brand-fabercastell']"));
        if(!checkBox.isSelected()){checkBox.click();}

        // 10- İlk secenegi tıkla. Tıklandıgını test et





        softAssert.assertAll();

    }
}
