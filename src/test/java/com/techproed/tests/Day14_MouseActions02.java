package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day14_MouseActions02 extends TestBase {

    /*
     1- http://uitestpractice.com/Students/Actions adresine gidelim
     2- Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini
        gorelim
     3- Click Me butonuna click yapalim ve cikan alertteki mesajin
        "Clicked !!" oldugunu dogrulayalim
     4- Double Click Me! butonuna tiklayalim ve cikan mesajin "Double
        Clicked !!" oldugunu dogrulayalim
     5- Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef
        kutuda "Dropped!" yazildigini dogrulayin
     */

    @Test
    public void test01() throws InterruptedException {
        // 1- http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get("http://uitestpractice.com/Students/Actions");

        // Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim

        WebElement maviKutu = driver.findElement(By.id("div2"));
        Actions actions = new Actions(driver);
        actions.moveToElement(maviKutu).perform();
        Thread.sleep(5000);

        // 3- Click Me butonuna click yapalim ve cikan alertteki mesajin "Clicked !!" oldugunu dogrulayalim
        WebElement clickMe = driver.findElement(By.xpath("//button[@name='click']"));
        actions.click(clickMe).perform();
        String alertYazi = driver.switchTo().alert().getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(alertYazi,"Clicked !!");
        driver.switchTo().alert().accept();
        // 4- Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
        WebElement doubleClickButton = driver.findElement(By.name("dblClick"));
        actions.doubleClick(doubleClickButton).perform();
        String doubleClickalertYazi = driver.switchTo().alert().getText();
        softAssert.assertEquals(doubleClickalertYazi,"Double Clicked !!");
        driver.switchTo().alert().accept();
        // 5- Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef kutuda "Dropped!" yazildigini dogrulayin
        WebElement tasinacakElement=driver.findElement(By.id("draggable"));
        WebElement tasimaHedefElementi = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(tasinacakElement,tasimaHedefElementi).perform();
        Thread.sleep(5000);
        String tasimaHedefElementiText = tasimaHedefElementi.getText();
        softAssert.assertEquals(tasimaHedefElementiText,"Dropped!");


        softAssert.assertAll();


    }

}
