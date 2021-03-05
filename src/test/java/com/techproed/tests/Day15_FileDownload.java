package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day15_FileDownload extends TestBase {

    /*
      Iki tane metod oluşturun : isExist() ve downloadTest()
      downloadTest () metodunun icinde aşağıdaki testi yapalim:
      - https://the-internet.herokuapp.com/download adresine gidelim.
      - image1.jpg dosyasını indirelim
        Ardından isExist() methodunda dosyanın başarıyla indirilip indirilmediğini test
        edelim
     */

    @Test
    public void isExist(){
        //isExist() methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        //1.adım
        String homePath = System.getProperty("user.home");
        System.out.println(homePath);
        String filePath = homePath + "\\Downloads\\001.jpg";
        boolean dosyaVarMi = Files.exists(Paths.get(filePath));
        Assert.assertTrue(dosyaVarMi);

    }



    @Test
    public void downloadTest() throws InterruptedException {
        // - https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        // - image1.jpg dosyasını indirelim
        WebElement image1 = driver.findElement(By.linkText("001.jpg"));
        image1.click();
        Thread.sleep(5000);
    }
}
