package com.office;

import com.techproed.pages.OfficeAmazon;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Question01 {

    /*
    amazon' a gidelim
    Linki Config Reader dan alalım
    Başlığın Elektronik içerip içermediğini kontrol edelim
    All Categories ' e gidelim
    "Toys & Games" ı seçelim
    Arama kelimesini config reader dan alalım
    Arama kutusuna toy story yazdıralım-- Config reader dan alalım
    İlk sayfadaki bütün fiyatları listeleyip yazdıralım en düşük ve en yüksek fiyatı bulalım
    Herhangi bir  ürünü önce tıklayıp sonra sepete ekleyelim.
    Sepete gidip seçimi yapıp yapamadığımızı assert edelim.

     */


    @Test
    public void test(){
        OfficeAmazon amazon = new OfficeAmazon();
        // amazon' a gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazon_URL"));

        //    Başlığın Elektronik içerip içermediğini kontrol edelim
        String actualTitle=Driver.getDriver().getTitle();
        String icermesiIstenen="Elektronik";
        Assert.assertFalse(actualTitle.contains(icermesiIstenen));

        //    All Categories ' e gidelim
        //    "Toys & Games" ı seçelim
        Select select =new Select(amazon.allDropDown);
        select.selectByVisibleText("Toys & Games");

        //    Arama kutusuna toy story yazdıralım-- Config reader dan alalım
        amazon.searchTextBox.sendKeys(ConfigReader.getProperty("amazon_aranan")+ Keys.ENTER);

        //    İlk sayfadaki bütün fiyatları listeleyip yazdıralım en düşük ve en yüksek fiyatı bulalım

        int urunSayisi=amazon.priceTamKisim.size();

        List<Double> fiyatList = new ArrayList<>();
        for (int i=0;i<urunSayisi;i++){
            if (!amazon.priceTamKisim.get(i).getText().isEmpty()){
                fiyatList.add(Double.parseDouble(amazon.priceTamKisim.get(i).getText()+"."+amazon.priceOndalikKisim.get(i).getText()));
            }
        }

        System.out.println("Fiyat Listesi: "+fiyatList);
        Collections.sort(fiyatList);
        System.out.println("Fiyat Listesi: "+fiyatList);
        System.out.println("En dusuk Fiyat: "+ fiyatList.get(0)+"$" );
        System.out.println("En yuksek Fiyat: "+ fiyatList.get(fiyatList.size()-1)+"$" );

        //    Herhangi bir  ürünü önce tıklayıp sonra sepete ekleyelim.
        amazon.priceTamKisim.get(5).click();


        //    Sepete gidip seçimi yapıp yapamadığımızı assert edelim.

        ReusableMethods.waitAndClick(amazon.sepeteEkle,3);
        ReusableMethods.waitAndClick(amazon.sepet,3);

        Assert.assertTrue(amazon.seciliUrun.isDisplayed());

        Driver.closeDriver();


    }
}
