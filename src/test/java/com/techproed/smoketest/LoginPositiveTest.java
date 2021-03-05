package com.techproed.smoketest;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPositiveTest extends TestBase {

    /*
      Bir test method olustur positiveLoginTest()
      http://qa-environment.crystalkeyhotels.com adresine git
      login butonuna bas
      test data username: manager ,
      test data password : Manager2!
      Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

     */

    @Test
    public void test(){
        // http://qa-environment.crystalkeyhotels.com adresine git
        driver.get("http://qa-environment.crystalkeyhotels.com");

        // login butonuna bas
        driver.findElement(By.linkText("Log in")).click();

        //   login butonuna bas
        //   test data username: manager ,
        //   test data password : Manager2!

        WebElement userNameTextBox = driver.findElement(By.id("UserName"));
        WebElement pswTextBox = driver.findElement(By.id("Password"));
        userNameTextBox.sendKeys("manager");
        pswTextBox.sendKeys("Manager2!");

         driver.findElement(By.id("btnSubmit")).click();

        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        WebElement addUserElement = driver.findElement(By.xpath("//*[.='Add User ']"));
        Assert.assertTrue(addUserElement.isDisplayed());


    }
}
