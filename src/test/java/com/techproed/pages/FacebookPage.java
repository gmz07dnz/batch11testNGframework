
package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {

    WebDriver driver;

    // Pages sayfası olustururken ilk iş parametreli  bir const uretmek

   public FacebookPage(WebDriver driver){
       //  driver'ı bu sayfada kontrol edebilmek için bu sayfada bir driver olusturmalıyım
       // olusturacagım driver'ı instance olarak olusturuyorum ki class'ın heryerinden ulasabilelim
       this.driver=driver;
       PageFactory.initElements(driver,this);
    }

    @FindBy(id="email")   // driver.findElement
   public WebElement userTextBox;

   @FindBy(id="pass")
   public WebElement passwordTextBox;

   @FindBy(id="u_0_b")
   public WebElement loginBox;








}
