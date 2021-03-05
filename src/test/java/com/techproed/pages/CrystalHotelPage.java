package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrystalHotelPage {

    WebDriver driver;

    public CrystalHotelPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Log in")
   public WebElement anaSayfalogin;


    @FindBy(id = "UserName")
   public WebElement userNameTextBox;


    @FindBy(id = "Password")
 public WebElement passwordTextBox;

    @FindBy(id = "btnSubmit")
   public WebElement ikinciLogin;

    @FindBy(xpath = "//*[.='System Management']")
   public WebElement systemManagement;



}
