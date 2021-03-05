package com.techproed.smoketest;

import com.techproed.pages.CrystalHotelPage;
import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTestWithPage extends TestBase {

    //1) com.techproed altinda bir package olustur : smoketest
    //2) Bir Class olustur : PositiveTest
    //3) Bir test method olustur positiveLoginTest()
    //  http://qa-environment.crystalkeyhotels.com adresine git
    //    login butonuna bas
    //test data username: manager ,
    //test data password : Manager2!
    //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

    @Test
    public void test(){
        //  http://qa-environment.crystalkeyhotels.com adresine git
        driver.get("http://qa-environment.crystalkeyhotels.com");
        CrystalHotelPage crystalHotelPage = new CrystalHotelPage(driver);


        //    login butonuna bas
        crystalHotelPage.anaSayfalogin.click();

        //test data username: manager
        crystalHotelPage.userNameTextBox.sendKeys("manager");

        //test data password : Manager2!
        crystalHotelPage.passwordTextBox.sendKeys("Manager2!");
        crystalHotelPage.ikinciLogin.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(crystalHotelPage.systemManagement.isDisplayed());



    }

}
