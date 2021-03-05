package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day14_MouseActions03 extends TestBase {


    @Test
    public void test01(){
        // Amazon'a gidelim
        driver.get("https://www.amazon.com");
        WebElement element = driver.findElement(By.xpath("(//span[@class='nav-line-1'])[3]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        WebElement createList = driver.findElement(By.xpath("(//span[@class='nav-text'])[1]"));  // linkText ile olur
        actions.click(createList).perform();

        // yaziyi test et
        WebElement yaziElementi = driver.findElement(By.xpath("//div[@role='heading']"));
        String text = yaziElementi.getText();
        Assert.assertEquals(text,"Your Lists");
    }
}
