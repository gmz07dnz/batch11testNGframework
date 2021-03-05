package com.techproed.tests;


import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;

public class Day13_WindowHandle2 extends TestBase {

    /*
      ● https://the-internet.herokuapp.com/windows adresine gidin.
      ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
      ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
      ● Click Here butonuna basın.
      ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
      ● Sayfadaki textin “New Window” olduğunu doğrulayın.
      ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
         olduğunu doğrulayın.
     */

    @Test
    public void test()  {

        // ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text = driver.findElement(By.tagName("h3"));
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertEquals(text.getText(),"Opening a new window");

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        softAssert.assertEquals(actualTitle,expectedTitle);

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        String ilkSayfaWindowHandle = driver.getWindowHandle();

        Set<String> tumList = driver.getWindowHandles();
        String ikinciSayfaWindowHandle = "";
        for (String w: tumList){
            if (!w.equals(ilkSayfaWindowHandle)){
                ikinciSayfaWindowHandle=w;
            }
        }

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciSayfaWindowHandle); //  artik 2.sayfadayim

        String actualIkinciSayfaTitle = driver.getTitle();
        String expectedIkinciSayfaTitle ="New Window";
        softAssert.assertEquals(actualIkinciSayfaTitle,expectedIkinciSayfaTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement newWindowText = driver.findElement(By.tagName("h3"));
        String textYazi = newWindowText.getText();
        softAssert.assertEquals(textYazi,"New Window");

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandle); // ilk sayfadayım
        String actualIlkPencereTitle = driver.getTitle();
        String expectedIlkPencereTitle = "The Internet";
        softAssert.assertEquals(actualIlkPencereTitle,expectedIlkPencereTitle);

        softAssert.assertAll();

    }
}
