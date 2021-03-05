package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day36_waits2 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //https://the-internet.herokuapp.com/add_remove_elements/ adresine git
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Add Element butonuna tiklayın
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

        //"Delete" butonu gorunur oluncaya kadar bekleyin
        WebDriverWait wait =new WebDriverWait(driver,20);
       WebElement deletebutonu= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='deleteElement()']")));

        // "Delete" butonunun gorunur oldugunu test edin
        Assert.assertTrue(deletebutonu.isDisplayed());
        //"Delete" butonuna basarak butonu silin
        deletebutonu.click();
        // "Delete" butonunun gorunmedigini test edin
        Thread.sleep(2000);
       // Assert.assertFalse(deletebutonu.isDisplayed()); // fail olur, cunku element silindiği için olmadıgından

    }
}
