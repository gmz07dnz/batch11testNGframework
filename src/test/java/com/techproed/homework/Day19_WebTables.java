package com.techproed.homework;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Day19_WebTables extends TestBase {

    /*
      1. “https://demoqa.com/webtables” sayfasina gidin
      2. Headers da bulunan department isimlerini yazdirin
      3. 3.sutunun basligini yazdirin
      4. Tablodaki tum datalari yazdirin
      5. Tabloda kac cell (data) oldugunu yazdirin
      6. Tablodaki satir sayisini yazdirin
      7. Tablodaki sutun sayisini yazdirin
      8. Tablodaki 3.kolonu yazdirin
      9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
     10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
     */


    @Test
    public void test(){

        // 1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        // 2. Headers da bulunan department isimlerini yazdirin
        List<WebElement> departmentIsimleri = driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        System.out.println("Department Isimleri: ");
        for (WebElement w:departmentIsimleri) {
            System.out.println(w.getText());
        }
        System.out.println(departmentIsimleri.size());

       /*
         WebElement headers = driver.findElement(By.xpath("//div[@class='rt-thead -header']")); -> tüm satırı bir kerede tek element
         System.out.println(headers.getText());
        */

        // 3. 3.sutunun basligini yazdirin =>3. baslik 3. sütunun baslıgı olur.
        WebElement sutun3Baslik = driver.findElement(By.xpath("(//div[@class='rt-resizable-header-content'])[3]"));
        System.out.println("3. Sütunun Basliği: "+sutun3Baslik.getText()); // Age

        // 4. Tablodaki tum datalari yazdirin  //div[@class='rt-td']

        /*
        WebElement tumDatalar = driver.findElement(By.xpath("//div[@class='rt-tbody']"));// tum body tek elementte
        System.out.println("Tüm Datalar: "+tumDatalar.getText());
        */


        List<WebElement> tumDatalar = driver.findElements(By.xpath("//div[@class='rt-td']"));
        System.out.println("TümDatalar: ");
        for (WebElement w: tumDatalar) {
            System.out.println(w.getText());
        }



        //      5. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println("Data Sayisi:" +tumDatalar.size());

        //      6. Tablodaki satir sayisini yazdirin
        List<WebElement> satir = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Satir Sayisi: "+ satir.size());

        //      7. Tablodaki sutun sayisini yazdirin
        int sutunSayisi = departmentIsimleri.size();
        System.out.println("Sütun Sayisi: "+sutunSayisi);

        //      8. Tablodaki 3.kolonu yazdirin
        List<WebElement> kolon3 = driver.findElements(By.xpath("(//div[@class='rt-tr-group'])//div//div[3]"));
        System.out.println("3. Kolon: ");
        for (WebElement w:kolon3) {
            System.out.println(w.getText());
        }

        //      9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin

        int salarySutunsayisi = 0;

        for(int i =0;i<departmentIsimleri.size();i++){
            if (departmentIsimleri.get(i).getText().equals("Salary")){
                salarySutunsayisi = i;

            }
        }
        salarySutunsayisi++;
        System.out.println("Salary sütun sayisi: "+salarySutunsayisi);

        int kierraSatırSayisi =0;

        for (int i=1;i< satir.size();i++){
            String elementYolu = "((//div[@class='rt-tr-group'])["+i+"]//div//div)[1]";

            WebElement element = driver.findElement(By.xpath(elementYolu));

            if (element.getText().equals("Kierra")){
                kierraSatırSayisi=i;
            }
            }
        System.out.println("Kierra satir sayisi: "+kierraSatırSayisi);

        /*
         Her satırdaki sutunu tek tek yazmak istersen ((//div[@class='rt-tr-group'])[satirsayisi]//div//div)[sütun sayisi]
         */

        String arananXPath = "((//div[@class='rt-tr-group'])["+kierraSatırSayisi+"]//div//div)["+salarySutunsayisi+"]";
        WebElement aranan =  driver.findElement(By.xpath(arananXPath));
        System.out.println("Ismi kierra olan kisinin Salary'si : "+aranan.getText());

        //     10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin



    }


    }






