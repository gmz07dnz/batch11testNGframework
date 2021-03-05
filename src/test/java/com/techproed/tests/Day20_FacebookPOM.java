package com.techproed.tests;

import com.techproed.pages.FacebookPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class Day20_FacebookPOM extends TestBase {

   @Test
    public void test(){
       driver.get("https://www.facebook.com");

       // ILk hedef locator'lardan kurtulmak
       // Bunun için pages paketi altındaki ilgili page'de ihtiyac duydugum tüm locate isimlerini yapıp burada kullanacagım

       FacebookPage facebookPage = new FacebookPage(driver); //Bu sayfasından obje olustururken driver'ımla yap diyoruz
       facebookPage.userTextBox.sendKeys("Mehmet@gmail.com");
       facebookPage.passwordTextBox.sendKeys("12345");
       facebookPage.loginBox.click();
   }

   @Test
   public void test2(){
      driver.get(ConfigReader.getProperty("facebook_URL"));
      FacebookPage facebookPage = new FacebookPage(driver);
      facebookPage.passwordTextBox.sendKeys(ConfigReader.getProperty("fb_user"));
      facebookPage.passwordTextBox.sendKeys(ConfigReader.getProperty("fb_password"));
      facebookPage.loginBox.click();
   }

}
