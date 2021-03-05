package com.techproed.smoketest;

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginNegativeTest extends TestBase {

    /*
     3 Farkli test Methodunda 3 senaryoyu test et
      - yanlisSifre
      - yanlisKulllanici
      - yanlisSifreKullanici
     test data dogru username: manager , dogru password : Manager2!
    * http://qa-environment.crystalkeyhotels.com adresine git
    * Login butonuna bas
    * Verilen senaryolar ile giris yapilamadigini test et
    */


    Faker faker =new Faker();
    public void giris(){
        // http://qa-environment.crystalkeyhotels.com adresine git
        driver.get("http://qa-environment.crystalkeyhotels.com");

        // login butonuna bas
        driver.findElement(By.linkText("Log in")).click();
    }

    @Test
    public void yanlisKulllaniciTesti(){
        giris();

        // yanlis userName, dogru sifre
        WebElement userNameTextBox = driver.findElement(By.id("UserName"));
        WebElement pswTextBox = driver.findElement(By.id("Password"));
        userNameTextBox.sendKeys(faker.name().firstName());
        pswTextBox.sendKeys("Manager2!");

    }

    @Test
    public void yanlisSifreTesti(){
        giris();

        // Dogru username, yanlisSifre
        WebElement userNameTextBox = driver.findElement(By.id("UserName"));
        WebElement pswTextBox = driver.findElement(By.id("Password"));
        userNameTextBox.sendKeys("manager");
        pswTextBox.sendKeys(faker.internet().password());

    }


    @Test
    public void yanlisSifreyanlisUserNameTesti(){
        giris();

        // Dogru username, yanlisSifre
        WebElement userNameTextBox = driver.findElement(By.id("UserName"));
        WebElement pswTextBox = driver.findElement(By.id("Password"));
        userNameTextBox.sendKeys(faker.name().firstName());
        pswTextBox.sendKeys(faker.internet().password());

    }

    @AfterMethod
    public void methodSonrası(){
        //* Login butonuna bas
        driver.findElement(By.id("btnSubmit")).click();

        //* Verilen senaryolar ile giris yapilamadigini test et
        WebElement yanlısGirisElementText = driver.findElement(By.xpath("//*[.='Try again please']"));
        Assert.assertEquals(yanlısGirisElementText.getText(),"Try again please");

    }





}
