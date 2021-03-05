package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day17_CreateHotel extends TestBase {


    /*
      1. Tests packagenin altına class olusturun: D17_CreateHotel
      2. Bir metod olusturun: createHotel
      3. http://qa-environment.crystalkeyhotels.com adresine git.
      4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri
         girin.
      a. Username : manager
      b. Password : Manager2!
      5. Login butonuna tıklayın.
      6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
      7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
      8. Save butonuna tıklayın.
      9. “Hotel was inserted successfully” textinin göründüğünü test edin.
      10. OK butonuna tıklayın.
     */


    @Test
    public void createHotel() throws InterruptedException {
        // http://qa-environment.crystalkeyhotels.com adresine git
        driver.get("http://qa-environment.crystalkeyhotels.com");

        // Username textbox ve password metin kutularını locate edin ve asagidaki verileri girin.
        //      a. Username : manager
        //      b. Password : Manager2!
        // Login butonuna tıklayın.

        driver.findElement(By.linkText("Log in")).click();

        WebElement userNameTextBox = driver.findElement(By.id("UserName"));
        WebElement pswTextBox = driver.findElement(By.id("Password"));
        userNameTextBox.sendKeys("manager");
        pswTextBox.sendKeys("Manager2!");

        driver.findElement(By.id("btnSubmit")).click();

        // Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        driver.findElement(By.xpath("//*[.='Hotel Management']")).click();
        driver.findElement(By.partialLinkText("Hotel List")).click();
        driver.findElement(By.xpath("//*[.='Add Hotel ']")).click();

        // Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        WebElement codeTextBox = driver.findElement(By.id("Code"));
        Actions actions = new Actions(driver);

        actions.click(codeTextBox)
                .sendKeys("123")
                .sendKeys(Keys.TAB)
                .sendKeys("Name")
                .sendKeys(Keys.TAB)
                .sendKeys("Istanbul")
                .sendKeys(Keys.TAB)
                .sendKeys("5521234567")
                .sendKeys(Keys.TAB)
                .sendKeys("abc@gmail.com")
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        WebElement idGroupDropDown = driver.findElement(By.id("IDGroup"));
        Select select = new Select(idGroupDropDown);
        select.selectByVisibleText("Hotel Type2");

        //      8. Save butonuna tıklayın.
        Thread.sleep(2000);
        driver.findElement(By.id("btnSubmit")).click();
        //      9. “Hotel was inserted successfully”
        Thread.sleep(2000);
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[text()='Hotel was inserted successfully']"));
        String otelOlusturulduYazisi=sonucYaziElementi.getText();
        Thread.sleep(2000);
        Assert.assertEquals(otelOlusturulduYazisi,"Hotel was inserted successfully");


        //      10. OK butonuna tıklayın.
        driver.findElement(By.xpath("//*[.='OK']")).click();

    }






}
