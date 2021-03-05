package com.techproed.homework;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day16_EnableTest extends TestBase {

    /*
     1. Bir class olusturun : EnableTest
     2. Bir metod olusturun : isEnabled()
     3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
     4. Textbox’in etkin olmadigini(enabled) dogrulayın
     5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
     6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
     7. Textbox’in etkin oldugunu(enabled) dogrulayın.
     */


    @Test
    public void isEnabled(){
        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());

        // Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement enableButon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[2]")));
        enableButon.click();

        // “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement mesajWebElement = driver.findElement(By.id("message"));
        Assert.assertTrue(mesajWebElement.isDisplayed());

        // Textbox’in etkin oldugunu(enabled) dogrulayın.
        WebElement textBox1 = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(textBox1.isEnabled());
    }
}
