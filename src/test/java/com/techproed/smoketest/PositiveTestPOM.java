package com.techproed.smoketest;

import com.techproed.pages.CrystalHotelPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTestPOM extends TestBase {

    @Test
    public void test(){
        //    login butonuna bas
        driver.get(ConfigReader.getProperty("cURl"));

        //test data username: manager ,
        CrystalHotelPage crystalHotelPage=new CrystalHotelPage(driver);
        crystalHotelPage.anaSayfalogin.click();
        crystalHotelPage.userNameTextBox.sendKeys(ConfigReader.getProperty("valid_user"));

        //test data password : Manager2!
        crystalHotelPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        crystalHotelPage.ikinciLogin.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(crystalHotelPage.systemManagement.isDisplayed());

    }
}
