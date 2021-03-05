package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day10_DropDownAmazon {

    /*
    ● https://www.amazon.com/ adresine gidin.
      - Test 1
       Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
      -Test 2
       1. Kategori menusunden Books secenegini secin
       2. Arama kutusuna Java yazin ve aratin
       3. Bulunan sonuc sayisini yazdirin
       4. Sonucun Java kelimesini icerdigini test edin
     */

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void sayfayaGit(){
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void test01(){
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        List<WebElement> tumList = select.getOptions();
        int kategorisize = tumList.size()-1;
        Assert.assertEquals(kategorisize,45);

    }

    @Test
    public void javatest(){
        // Kategori menusunden Books secenegini secin
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Books");

        // Arama kutusuna Java yazin ve aratin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        String arananKelime = "Java";
        searchBox.sendKeys(arananKelime+ Keys.ENTER);

        // Bulunan sonuc sayisini yazdirin
        WebElement sonuc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucSayisi = sonuc.getText();
        System.out.println(sonucSayisi);

        // Sonucun Java kelimesini icerdigini test edin
        Assert.assertTrue(sonucSayisi.contains("Java"));

    }




}
