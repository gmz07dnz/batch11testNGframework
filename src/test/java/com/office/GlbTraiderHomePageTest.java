package com.office;

import com.techproed.pages.GlbTraiderPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GlbTraiderHomePageTest {

      /*
  GlbTrader sayfasına girin ve giriş yapın
  İlk sayfada kac tane link oldugunu yazdır ve calışıp calışmadıgını kontrol et
  All Categories e gidin ve rastgele bir seçeneği seçin
  Seçmiş olduğunuz kategoride kaç tane ürün olduğunu listeleyin
  Bütün ürünleri yazdıırıp sıralayarak en düşük ve en yüksek ücretli olan ürünü bulun
  Ürünlere ait tüm bilgileri yazdırın
  İlk ürüne tıklayın
  Arttırma ve azatlma linklerinin aktif olup olmadığını kontrol edin
  Ürünü 1 artırın
  Sepete giderek ürünün görünüp görünmediğini assert edin
  Ürünün 1 arttırılıp arttırılmadığını assert edin.
  Allert i accept edin.
   */



    @Test
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("glbtraider_url"));
        GlbTraiderPage glbTraiderPage =new GlbTraiderPage();

        // İlk sayfada kac tane link oldugunu yazdır ve calışıp calışmadıgını kontrol et
        int linkSayisi =glbTraiderPage.tumLink.size();
        System.out.println("Ilk sayfadaki link sayisi: "+ linkSayisi);
        for (WebElement w: glbTraiderPage.tumLink){
            Assert.assertTrue(w.isEnabled());
        }

        //All Categories e gidin ve rastgele bir seçeneği seçin
        Select select =new Select(glbTraiderPage.allCategories);
        ReusableMethods.selectRandomTextFromDropdown(select);
        glbTraiderPage.searchConfirm.click();

        //Seçmiş olduğunuz kategoride kaç tane ürün olduğunu listeleyin
        int urunSayisi= glbTraiderPage.fiyatListesi.size();
        System.out.println("Urun Sayisi: "+urunSayisi);

        //Bütün ürünleri yazdırırıp sıralayarak en düşük ve en yüksek ücretli olan ürünü bulun

        if(!glbTraiderPage.fiyatListesi.isEmpty()){
            List<Double> fiyatList = new ArrayList<>();
            for(int i=0;i<glbTraiderPage.fiyatListesi.size();i++){
                fiyatList.add(Double.parseDouble(glbTraiderPage.fiyatListesi.get(i).getText()));
            }
            System.out.println("Fiyat Listesi: "+ fiyatList);
            Collections.sort(fiyatList);
            System.out.println("En dusuk ucretli urun: "+fiyatList.get(0)+"\n"+"En Yuksek ucretli urun: "+fiyatList.get(fiyatList.size()-1));
            // Ürünlere ait tüm bilgileri yazdırın
            for(WebElement w: glbTraiderPage.urunBilgisi){
                System.out.println(w.getText());
            }
            // İlk ürüne tıklayın
            glbTraiderPage.urunBilgisi.get(0).click();
        }else {
            System.out.println("Urun Bilgisi Bulunamadi");
        }



        //Arttırma ve azatlma linklerinin aktif olup olmadığını kontrol edin
        Assert.assertTrue(glbTraiderPage.azaltma.isEnabled());
        Assert.assertTrue(glbTraiderPage.arttirma.isEnabled());

        // Ürünü 1 artırın
        glbTraiderPage.arttirma.click();

        // Sepete giderek ürünün görünüp görünmediğini assert edin
        glbTraiderPage.buyNow.click();



    }





}
