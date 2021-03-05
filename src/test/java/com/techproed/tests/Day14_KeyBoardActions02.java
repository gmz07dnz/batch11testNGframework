package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day14_KeyBoardActions02 extends TestBase {


    /*
      https://www.facebook.com sayfasina gidelim
      Kullanici adi : Mehmet , sifre : 12345 degerlerini girip login tusuna basalim
      basarili login olmadigini test edin
https://html.com/tags/iframe/
     */

    @Test
    public void test01(){

        //  https://www.facebook.com sayfasina gidelim
        driver.get("https://www.facebook.com");

        // Kullanici adi : Mehmet , sifre : 12345 degerlerini girip login tusuna basalim
      /*
        WebElement userName = driver.findElement(By.id("email"));
        userName.sendKeys("Mehmet");
        WebElement passWord = driver.findElement(By.id("pass"));
        passWord.sendKeys("12345");
        driver.findElement(By.xpath("//button[@value='1']")).click();
       */
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.id("email"));
        actions.click(userName)
                .sendKeys("Mehmet")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        // basarili login olmadigini test edin
        WebElement loginolmama = driver.findElement(By.className("_9ay7"));
        String yazi = loginolmama.getText();
        Assert.assertEquals(yazi,"The password that you've entered is incorrect. Forgotten password?");

    }
}
