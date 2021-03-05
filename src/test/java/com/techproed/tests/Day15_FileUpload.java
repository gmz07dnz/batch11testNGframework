package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day15_FileUpload extends TestBase {

    /*
     1. Tests packagenin altina bir class oluşturun : D14_UploadFile
     2. https://the-internet.herokuapp.com/upload adresine gidelim
     3. chooseFile butonuna basalim
     4. Yuklemek istediginiz dosyayi secelim.
     5. Upload butonuna basalim.
     6. “File Uploaded!” textinin goruntulendigini test edelim.
     */


    @Test
    public void isExist(){

    }



    @Test
    public void test() throws InterruptedException {
        // - https://the-internet.herokuapp.com/upload adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/upload");

        // Dosya sec butonunu locate edin
        WebElement dosyaSecButon = driver.findElement(By.id("file-upload"));

        // Flower yolunu yazınız
        String homePath = System.getProperty("user.home");
        String filePathFlower = homePath + "\\Desktop\\FLOWER.jpg";

        dosyaSecButon.sendKeys(filePathFlower);
        Thread.sleep(5000);

        // upload tıkla
        driver.findElement(By.id("file-submit")).click();

        //  “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement sonucYaziElementi=driver.findElement(By.tagName("h3"));
        Assert.assertEquals(sonucYaziElementi.getText(),"File Uploaded!");

    }
}
