package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class GlbSignUpPage {

    /*
      Kullanici https://www.glbtrader.com/register.html adresine gitsin.
      1. pages paketinin altina bir page class olusturun : GlbSignUpPage ve Page
         objelerini(webelement) locate edin.
      2. smoketest paketinin altina bir test classi olusturun : GlbSignUpTest
         Kullanici kimlik bilgileri ile kayit oldugunda “Success!” mesajini gordugunu
         test edin
     */

    GlbSignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
