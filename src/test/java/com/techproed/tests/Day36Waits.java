package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Day36Waits extends TestBase {

    @Test
    public void test() {
        // https://demoga.com/browser-windows adresine gidin
        driver.get("https://demoga.com/browser-windows");

        // Alerts'e tıkla
        //on button click,alert will appear 5seconds karsisindaki click me butonuna basin

       driver.switchTo().alert().accept();

       WebDriverWait wait = new WebDriverWait(driver,20);
     //  wait.until(ExpectedConditions.elementToBeClickable())
    }
    }
