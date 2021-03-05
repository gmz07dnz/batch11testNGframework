package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day16_SeleniumWaits extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.youtube.com");
     //   WebElement olmayanElement = driver.findElement(By.id("olamyan"));

        WebElement logo = driver.findElement(By.xpath("(//div[@id='logo-icon-container'])[1]"));

        /*
          => implicitlyWait();
          Olmayan bir element oldugunda ne kadar belirlenmişse o kdr bekler bulmak için
          Element varsa bulunca belirlene sure kadar beklemez
          TestBase'e koydugumuzda bunu her element için yapar.
       */

        /*
         => explicitlyWait();
         Nadiren kullanılır.
         Bazı elementler hemen gorulmez. Yuklenmesi uzun surebilir.Bu durumlarda kullanılır.
         Sadece bir element için gecerli olur.
         */
    }

    /*
     1. Bir class olusturun : WaitTest
     2. Iki tane metod olusturun : implicitWait() , explicitWait()
        Iki metod icin de asagidaki adimlari test edin.
    3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    4. Remove butonuna basin.
    5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    6. Add buttonuna basin
    7. It’s back mesajinin gorundugunu test edin
     */


    @Test
    public void implicitWaitTest(){
        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Remove butonuna basin.
        driver.findElement(By.xpath("(//button[@autocomplete='off'])[1]")).click();

        // “It’s gone!” mesajinin goruntulendigini test edin.
        WebElement mesajElementi1 = driver.findElement(By.id("message"));
       Assert.assertTrue(mesajElementi1.isDisplayed());
        //<p id="message">It's gone!</p>


        // Add buttonuna basin
        driver.findElement(By.xpath("(//button[@autocomplete='off'])[1]")).click();

        //  It’s back mesajinin gorundugunu test edin
        WebElement mesajElementi2 = driver.findElement(By.id("message"));
        //<p id="message">It's back!</p>
        Assert.assertTrue(mesajElementi2.isDisplayed());
    }

    @Test
    public void ExplicitlyWait(){
        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Remove butonuna basin.
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement removeButonu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@autocomplete='off'])[1]")));
        removeButonu.click();

        // “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneYazisielementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(itsGoneYazisielementi.isDisplayed());

        // Add buttonuna basin
        removeButonu.click();

        // It’s back mesajinin gorundugunu test edin
        WebElement itsBackYazisielementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(itsBackYazisielementi.isDisplayed());









    }


}
