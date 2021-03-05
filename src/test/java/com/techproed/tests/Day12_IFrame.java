package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day12_IFrame {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }



    @Test
    public void test01(){

        // https://html.com/tags/iframe/ sayfasına git
        driver.get("https://html.com/tags/iframe/");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        // sayfadaki videoyu oynat
        /*
          1.adim iFrame'e nasil gecis yapacagimiza(switch) karar veririz
          * id ile
          * IFrame index ile
          * WebElement
         */

        // 2. adim iFrame'e switchTo() ile gecis yapiyoruz

        WebElement IFrame = driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
        driver.switchTo().frame(IFrame);

        // 3. adim : iframe icinde istedigimiz WebElementinini locate edip istedigimiz islemi yapabiliriz

        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
    }


    @AfterClass
    public void tearDown(){
        //driver.close();
    }
}
