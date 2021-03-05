package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class Day18_WebTables extends TestBase {

    /*
     ● login() metodun oluşturun ve oturum açın.
     ● http://qa-environment.crystalkeyhotels.com/admin/HotelRoomAdmin adresine gidin
       ○ Username : manager
       ○ Password : Manager2!

    ● table() metodu oluşturun
     ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
     ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.

     ● printRows() metodu oluşturun //tr
     ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
     ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
     ○ 4.satirdaki(row) elementleri konsolda yazdırın.

     printCells() metodu oluşturun //td
    ○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
    ○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.

    printColumns() metodu oluşturun
   ○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
   ○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
   ○ 5.column daki elementleri konsolda yazdırın.

     */


    public void login() {
        //● http://qa-environment.crystalkeyhotels.com/admin/HotelRoomAdmin adresine gidin
        // ○ Username : manager
        // ○ Password : Manager2!
        driver.get("http://qa-environment.crystalkeyhotels.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager");
        driver.findElement(By.id("Password")).sendKeys("Manager2!" + Keys.ENTER);


    }

    @Test
    public void table() throws InterruptedException {
        login();
        Thread.sleep(5000);

        // ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement tumbody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumbody.getText());


        /*
         NOT: Table Body'si tek bir WebElement olarak locate edilebilir ve getText() ile yazdırıldıgında body'de bulunan tum data'ları yazdırır.
         Fakat bu data'lar uzerinde manipulation yapamayız.
         */

        // ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody

        /*
         NOT: Sütun sayısını bulmak için sayfadaki thead içindeki headers(başlıkları) saymamız yeterli. Bunun için bir list olusturup
         bu list'e xpath olarak //teaders//th yazıp baslıkları aldık.
         */

        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//thead//th"));
        System.out.println("Tablodaki sütun sayisi: " + basliklarListesi.size());


        // headers yazdıralım => WebElement oldugu için direk yazdıramayız, getTExt() kullanmalıyız

        for (WebElement w : basliklarListesi) {
            System.out.println(w.getText());
        }
    }

    @Test
    public void printRows() {
        login();

        // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satir = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Body'deki satır sayısı: " + satir.size());

        // ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement w : satir) {
            System.out.println(w.getText());
        }

        // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println(satir.get(3).getText());

        // listeden elemani almadan locate ederek 4.satiri yazdirin
        WebElement satir4 = driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println(satir4.getText());
    }

    @Test
    public void printCells() {
        login();
        //○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        List<WebElement> toplamHücre = driver.findElements(By.xpath("//tbody//td"));
        System.out.println("Toplam Hucre Sayisi: " + toplamHücre.size());

//○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.

        for (WebElement w : toplamHücre) {
            System.out.println(w.getText());
        }
    }

    @Test
    public void printColumns() {
        login();
        // ○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
        List<WebElement> toplamSütun = driver.findElements(By.xpath("//thead//th"));
        System.out.println("Toplam Sütun Sayisi: " + toplamSütun.size());
        int sütunSayisi = toplamSütun.size();

        //   ○ 5.column daki elementleri konsolda yazdırın.
        List<WebElement> column5 = driver.findElements(By.xpath("//tbody//td[5]"));
        for (WebElement w : column5) {
            System.out.println(" " + w.getText());
        }

        // ○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.Her sütun basında sütun numarası yazsın

        for (int i = 1; i <= sütunSayisi; i++) {
            List<WebElement> allSütun = driver.findElements(By.xpath("//tbody//td[" + i + "]"));
            WebElement sütunBasligi = driver.findElement(By.xpath("//thead//th[" + i + "]"));
            System.out.println(i + ". sütun");
            System.out.println(sütunBasligi.getText());

            for (WebElement w : allSütun) {
                System.out.print(w.getText());
            }
            System.out.println();
        }
    }

   /*
    1. Bir metod oluşturun : printData(int row, int column);
       a. Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu hücredeki(cell) veriyi yazdırmalıdır.
    2. Baska bir Test metodu oluşturun: printDataTest();
       a. Ve bu metodu printData() methodunu cagirmak icin kullanin.
       b. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
       c. yazdirilan datanin olmasi gereken dataya esit oldugunu test edin
    */


    public String printData(int row, int column)  {
        WebElement yazdirilacakData = driver.findElement(By.xpath("//tbody//tr["+row+"]//td["+column+"]"));

        System.out.println(yazdirilacakData.getText());
        String yazdırılanData = yazdirilacakData.getText();
        return yazdırılanData;


    }

    @Test
    public void printDataTest() {
        login();
       String yazdirilanData = printData(3,5);
       // yazdirilan datanin olmasi gereken dataya esit oldugunu test edin

        Assert.assertEquals(yazdirilanData,"NewYork");
        }
    }


