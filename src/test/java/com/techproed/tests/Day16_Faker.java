package com.techproed.tests;

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day16_Faker extends TestBase {

    Faker faker = new Faker();

    @Test
    public void test(){
        String isimFaker = faker.name().firstName();
        System.out.println(isimFaker);
    }

    @Test
    public void facebookUserTest(){
        //1. "https://www.facebook.com" Adresine gidin
        driver.get("https://www.facebook.com");

        //2. “create new account” butonuna basin
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        //3. “firstName” giris kutusuna bir isim yazin
        //4. “surname” giris kutusuna bir soyisim yazin
        //5. “email” giris kutusuna bir email yazin
        //6. “email” onay kutusuna emaili tekrar yazin
        //7. Bir sifre girin

        WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions = new Actions(driver);
        String email = faker.internet().emailAddress();
        actions.click(firstNameTextBox)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .perform();

        //8.Tarih icin gun secin
        WebElement dayDropdown = driver.findElement(By.id("day"));
        Select select = new Select(dayDropdown);
        select.selectByVisibleText("13");

        //9.Tarih icin ay secin
        WebElement monthDropdown = driver.findElement(By.id("month"));
        Select select1 = new Select(monthDropdown);
        select1.selectByVisibleText("Jan");

        //10.Tarih icin yil secin
        WebElement yearDropdown = driver.findElement(By.id("year"));
        Select select2= new Select(yearDropdown);
        select2.selectByVisibleText("1987");

        //11.Cinsiyeti secin
        WebElement femaleRadiobutton = driver.findElement(By.xpath("(//input[@type ='radio'])[1]"));
        femaleRadiobutton.click();
        //12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Assert.assertTrue(femaleRadiobutton.isSelected());

        WebElement maleRadiobutton =driver.findElement(By.xpath("//input[@value='2']"));
        Assert.assertFalse(maleRadiobutton.isSelected());

        WebElement customRadiobutton =driver.findElement(By.xpath("//input[@value='-1']"));
        Assert.assertFalse(customRadiobutton.isSelected());

        
    }

}
