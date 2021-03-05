package com.techproed.homework;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Day16_ActionsClass extends TestBase {

    /*
     1."http://webdriveruniversity.com/Actions" sayfasina gidin
     2."Hover over Me First" kutusunun ustune gelin
     3."Link 1" e tiklayin
     4.Popup mesajini yazdirin
     5.Popup'i tamam diyerek kapatin
     6."Click and hold" kutusuna basili tutun
     7. "Click and hold" kutusunda cikan yaziyi yazdirin
     8. "Double click me" butonunu cift tiklayin
     */


    @Test
    public void test() throws InterruptedException {
        //  1."http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2."Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverMeFirstKutusu = driver.findElement(By.xpath("//*[.='Hover Over Me First!']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverMeFirstKutusu).perform();
        // 3."Link 1" e tiklayin
        driver.findElement(By.linkText("Link 1")).click();

        // 4.Popup mesajini yazdirin
       String popupMesaj= driver.switchTo().alert().getText();
       System.out.println(popupMesaj);

        // 5.Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        // 6."Click and hold" kutusuna basili
        WebElement clickAndHold = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();

        // 7. "Click and hold" kutusunda cikan yaziyi yazdirin
        String clickAndHoldYazi = clickAndHold.getText();
        System.out.println(clickAndHoldYazi);

        // 8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickMe = driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClickMe).perform();
    }
}
