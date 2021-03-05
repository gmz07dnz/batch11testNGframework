package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OfficeAmazon {

    public OfficeAmazon(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(id = "searchDropdownBox")
    public WebElement allDropDown;

    @FindBy(id="twotabsearchtextbox")
    public WebElement searchTextBox;

    @FindBy(xpath = "//span[@class='a-price-whole']")
    public List<WebElement> priceTamKisim;

    @FindBy(xpath = "//span[@class='a-price-fraction']")
    public List<WebElement> priceOndalikKisim;

    @FindBy(id = "add-to-cart-button")
    public WebElement sepeteEkle;

    @FindBy(id = "nav-cart-count")
    public WebElement sepet;

    @FindBy(xpath = "//img[@class='sc-product-image']")
    public WebElement seciliUrun;

}
