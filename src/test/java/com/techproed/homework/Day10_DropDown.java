package com.techproed.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day10_DropDown {

    /*
    1. “http://zero.webappsecurity.com/” Adresine gidin
    2. Sign in butonuna basin
    3. Login kutusuna “username” yazin
    4. Password kutusuna “password.” yazin
    5. Sign in tusuna basin
    6. Pay Bills sayfasina gidin
    7. “Purchase Foreign Currency” tusuna basin
    8. “Currency” drop down menusunden Eurozone’u secin
    9. “amount” kutusuna bir sayi girin
    10. “US Dollars” in secilmedigini test edin
    11. “Selected currency” butonunu secin
    12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini control edin.

     */

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test01(){

        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //  2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();

        // 3. Login kutusuna “username” yazin
        WebElement loginBox = driver.findElement(By.id("user_login"));
        loginBox.sendKeys("username");

        // 4. Password kutusuna “password.” yazin
        WebElement passwordBox =driver.findElement(By.id("user_password"));
        passwordBox.sendKeys("password");

        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //    6. Pay Bills sayfasina gidin
        driver.findElement(By.linkText("Pay Bills")).click();

        //    7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();

        //    8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currencyDropDown = driver.findElement(By.id("pc_currency"));
        Select select = new Select(currencyDropDown);
        select.selectByVisibleText("Eurozone (euro)");

        //  9. “amount” kutusuna bir sayi girin
        WebElement amountBox = driver.findElement(By.id("pc_amount"));
        amountBox.sendKeys("3000");
        //    10. “US Dollars” in secilmedigini test edin
        WebElement radioUSDollars = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(radioUSDollars.isSelected());

        //    11. “Selected currency” butonunu secin
        WebElement selectedCurrencyRadioButton = driver.findElement(By.id("pc_inDollars_false"));
        selectedCurrencyRadioButton.isSelected();
        if(!selectedCurrencyRadioButton.isSelected()){
            selectedCurrencyRadioButton.click();
        }

        //    12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();

        //    13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini control edin.
        WebElement yaziControl = driver.findElement(By.id("alert_content"));
        String actualyazi = yaziControl.getText();
        String expectedyazi = "Foreign currency cash was successfully purchased.";
        Assert.assertEquals(actualyazi,expectedyazi);

    }











    @AfterClass
    public void tearDown(){
      //  driver.close();
    }
}
