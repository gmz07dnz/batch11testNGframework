package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day09_Dropdown {

    /*
    ● https://the-internet.herokuapp.com/dropdown adresine gidin.
      1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
      2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
      3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
      4.Tüm dropdown değerleri(value) yazdırın
      5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın
     */

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }


    @Test
    public void dropdownTesti(){


        // 1. adım dropdown Web elementini locate edelim.
        WebElement dropdown = driver.findElement(By.id("dropdown"));

        //2. adım select objesi olusturalım ve locate ettiğimiz WebElementi parametre olarak objeye ekledik
        Select select = new Select(dropdown);

        // 3. adim varolan 3 yontemden herhangi biri ile istedigimiz kategoriyi secelim
        select.selectByIndex(1);
        String ilksecilenoption = select.getFirstSelectedOption().getText();

        // Sectiğimiz option'in "Opsiyon1" oldugunu test edin

        Assert.assertEquals(ilksecilenoption,"Option 1");

    }

    @Test
    public void test02(){

        // Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        WebElement dropDown=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropDown);
        select.selectByValue("2");
        String  ikinciSecilenOption = select.getFirstSelectedOption().getText();

        // Sectiğimiz option'in "Option 2" oldugunu test edin
        Assert.assertEquals(ikinciSecilenOption,"Option 2");

    }

    @Test
    public void tumListe(){
        WebElement dropDown=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropDown);
        List<WebElement> tumList = select.getOptions();

        for(WebElement w: tumList){
            System.out.println(w.getText());
        }

        // Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın

        int listBoyut = tumList.size();
        if (listBoyut==4){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
