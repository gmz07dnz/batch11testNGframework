package com.techproed.homework;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day16_ExplicitWait extends TestBase {

    /*
     1. " https://demoqa.com/dynamic-properties” sayfasina gidin
     2. “Visible After 5 Seconds” butonunun gorunun oldugunu test edin
     */

    @Test
    public void test(){
        //  1. " https://demoqa.com/dynamic-properties” sayfasina gidin
        driver.get("https://demoqa.com/dynamic-properties");

        //  2. “Visible After 5 Seconds” butonunun gorunun oldugunu test edin
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement visibleAfter5SecondsButon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        Assert.assertTrue(visibleAfter5SecondsButon.isDisplayed());

    }



}
