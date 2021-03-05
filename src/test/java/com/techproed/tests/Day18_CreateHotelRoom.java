package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day18_CreateHotelRoom extends TestBase {

    /*
     1. Tests packagenin altına class olusturun: HotelRoomCreation
     2. Bir metod olusturun: RoomCreateTest()
     3. qa-environment.crystalkeyhotels.com adresine gidin.
     4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
        a. Username : manager b. Password : Manager2!
    5. Login butonuna tıklayın.
    6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
    7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
    8. Save butonuna basin.
    9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
    10. OK butonuna tıklayın.
    11. Hotel rooms linkine tıklayın.
    12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın..
     */

    @Test
    public void roomCreateTest() throws InterruptedException {
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

        // Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        driver.findElement(By.xpath("//*[.='Hotel Management']")).click();
        driver.findElement(By.partialLinkText("Hotel Rooms")).click();
        driver.findElement(By.xpath("//*[.='Add Hotelroom ']")).click();

        //    7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        WebElement idHoteldropDown = driver.findElement(By.id("IDHotel"));
        Select select = new Select(idHoteldropDown);
        select.selectByVisibleText("HAPPY HOTEL ");
        Actions actions =new Actions(driver);

        actions.sendKeys(Keys.TAB)
                .sendKeys("06100")
                .sendKeys(Keys.TAB)
                .sendKeys("Double with Child Room")
                .sendKeys(Keys.TAB)
                .sendKeys("Italy")
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys("cok guzel oda")
                .perform();

        WebElement text500 = driver.findElement(By.partialLinkText("500"));
        WebElement price = driver.findElement(By.id("Price"));
        actions.dragAndDrop(text500,price)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        WebElement roomType = driver.findElement(By.id("IDGroupRoomType"));
        Select select1 = new Select(roomType);
        select1.selectByValue("7");

        actions.sendKeys(Keys.TAB)
                .sendKeys("2")
                .sendKeys(Keys.TAB)
                .sendKeys("0")
                .perform();

        /*
         driver.findElement(By.id("MaxAdultCount")).sendKeys("2");
         driver.findElement(By.id("MaxChildCount")).sendKeys("2");
         */

        //    8. Save butonuna basin.
        driver.findElement(By.id("btnSubmit")).click();
        Thread.sleep(10000);

        //    9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//*[text()='HotelRoom was inserted successfully']"));
        Assert.assertTrue(sonucYaziElementi.isDisplayed());

        //10. OK butonuna tıklayın.
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        //    11. Hotel rooms linkine tıklayın.
        actions.sendKeys(Keys.HOME).perform();  // 2 defa pagedown yapıp syf basına cıkmaktansa home yapılabilir.
        driver.findElement(By.partialLinkText("Hotel Rooms")).click();

        //    12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın..
        WebElement hotelRoomListYaziElementi=driver.findElement(By.xpath("(//*[text()='List Of Hotelrooms'])[2]"));
        Assert.assertTrue(hotelRoomListYaziElementi.isDisplayed());






    }


}
