package com.techproed.smoketest;

import com.techproed.pages.CrystalHotelPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class NegativeTestWithPage extends TestBase {

     /*
      - yanlisSifre
     test data dogru username: manager , dogru password : Manager2!
    * http://qa-environment.crystalkeyhotels.com adresine git
    * Login butonuna bas
    */


    @Test
    public void test(){
        driver.get("http://qa-environment.crystalkeyhotels.com");
        CrystalHotelPage crystalHotelPage =new CrystalHotelPage(driver);
        crystalHotelPage.anaSayfalogin.click();
        crystalHotelPage.userNameTextBox.sendKeys("manager");
        crystalHotelPage.passwordTextBox.sendKeys("manager");
        crystalHotelPage.ikinciLogin.click();
    }
}
