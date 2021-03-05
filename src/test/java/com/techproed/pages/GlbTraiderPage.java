package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GlbTraiderPage {

    public GlbTraiderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(tagName = "//a")
    public List<WebElement> tumLink;

    @FindBy(id = "header_search_category")
    public WebElement allCategories;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement searchConfirm;

    @FindBy(xpath = "//label[@class='list_price_set']")
    public List<WebElement> fiyatListesi;

    @FindBy(xpath = "//h4[@class='icon-hotproduct']")
    public List<WebElement> urunBilgisi;

    @FindBy(xpath = "//a[@class='minus']")
    public WebElement azaltma;

    @FindBy(xpath = "//a[@class='plus']")
    public WebElement arttirma;

    @FindBy(xpath = "//button[@name='buynow_submit']")
    public WebElement buyNow;

    @FindBy(id="buy_quantity")
    public WebElement arttirmaLinkCheck;

}
