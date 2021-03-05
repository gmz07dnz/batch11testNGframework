package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.Set;

public class Day14_MouseActions01 extends TestBase {

    /*
     1- Yeni bir class olusturalim: D14_MouseActions1
     2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
     3- Cizili alan uzerinde sag click yapalim
     4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
     5- Tamam diyerek alert’I kapatalim
     6- Elemental Selenium linkine tiklayalim
     7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */


    @Test
    public void test01(){
        //  https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //  Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement ciziliAlan = driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlan).perform();

        // Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String alertYazi = driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu",alertYazi);

        // Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();

        // Elemental Selenium linkine tiklayalim
        WebElement seleniumLinki = driver.findElement(By.linkText("Elemental Selenium"));
        actions.click(seleniumLinki).perform();


        // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String ilkSayfaWindowHandle = driver.getWindowHandle();
        Set<String> tumList = driver.getWindowHandles();
        String ikinciSayfaWindowHandle = "";
        for (String w: tumList){
            if (!w.equals(ilkSayfaWindowHandle)){
                ikinciSayfaWindowHandle=w;
            }
        }

        driver.switchTo().window(ikinciSayfaWindowHandle);  // ikinci sayfadayım
        WebElement elementalSeleniumYazi = driver.findElement(By.tagName("h1"));
        String elementalSeleniumText = elementalSeleniumYazi.getText();
        Assert.assertEquals(elementalSeleniumText,"Elemental Selenium");




    }



}
