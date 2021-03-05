package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day09_Priority {

      /*
    1) Bir class oluşturun: YoutubeAssertions
    2) https://www.youtube.com adresine gidin
    3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
       ○ titleTest => Sayfa başlığını “YouTube” oldugunu test edin
       ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
       ○ searchBoxTest => Search Box'ın erişebilir oldugunu test edin
       ○ wrongTitleTest=> Sayfa basliginin “youtube” olmadigini dogrulayin
     */


    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test (priority = 1)
    public void titleTest(){
        //https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com/");

        // Sayfa başlığını “YouTube” oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Test (priority = 3)
    public void imageTest(){
        driver.get("https://www.youtube.com/");
        // YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement youtubeImage = driver.findElement(By.xpath("(//div[@class='yt-icon-container style-scope ytd-topbar-logo-renderer'])[1]"));
        Assert.assertTrue(youtubeImage.isDisplayed());
    }


    @Test (priority = 4)
    public void searchBoxTest(){
        driver.get("https://www.youtube.com/");
        // Search Box'ın erişebilir oldugunu test edin
        WebElement searchBox = driver.findElement(By.xpath("//input[@autocapitalize='none']"));
        Assert.assertTrue(searchBox.isEnabled());

    }

    @Test (priority = 2)
    public void wrongTitleTest(){
        driver.get("https://www.youtube.com/");
        // Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle = driver.getTitle();
        String expectedTitle = "youtube";
        Assert.assertFalse(actualTitle.equals(expectedTitle));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
