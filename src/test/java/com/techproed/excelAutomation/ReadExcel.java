package com.techproed.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class ReadExcel {



    /*
     Yeni bir test method olusturalim readExcel2()
        - 1.satirdaki 2.hucreye gidelim ve yazdiralim
        - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        - Satir sayisini bulalim
        - Fiziki olarak kullanilan satir sayisini bulun
        - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
     */


    @Test
    public void readExcel1() throws IOException {

        // java ile dosya okuyabilmek için FileInputStream'e ihtiyacımız var . Bunun için dosyanın path'ını bulup String
        // olarak atıyoruz

        String path = "./src/test/java/resources/ulkeler.xlsx";

        // dosyamizi javaya okutabilmek icin FileInputStream kullanip parametre olark path'i giriyoruz

        FileInputStream fileInputStream = new FileInputStream(path);

        //Excelde dataya ulasmak icin cell(hucre)'ye ulasmamiz gerekiyor
        // Bunun icin sirasiyla workbook olusturup parametre olarak fileInputStream objesini giriyoruz

        Workbook workbook =WorkbookFactory.create(fileInputStream);

        // Workbook'tan sonta ilgili sayfaya gitmek için Sheet objesi olusturuyoruz
        Sheet sheet = workbook.getSheetAt(0);  // index'e gore yazıyoruz 0 index -> 1.sayfa

        // ilgili satira gitmak icin Row objesi olusturuyoruz
        Row row = sheet.getRow(0); // 0 index -> 1.satır

        // Hucreye gitmek icin Cell objesi olusturuyoruz
        Cell cell = row.getCell(0); // 0 index -> 1. hucre ==> data type - Cell
        System.out.println(cell);

        String hucre = cell.toString(); // Data type String yaparsak uzerinde maniple yapılabilir
        System.out.println(hucre);

    }

    @Test
    public void readExcel2() throws IOException {

        String path = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fileInputStream =new FileInputStream(path);
        Workbook workbook =WorkbookFactory.create(fileInputStream);

        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        Cell satirBirHucre2 = workbook.getSheetAt(0).getRow(0).getCell(1);
        System.out.println(satirBirHucre2);

        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String satir1hücre2 = workbook.getSheetAt(0).getRow(0).getCell(1).toString();
        System.out.println(satir1hücre2);

        // - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String satir2cell4 = workbook.getSheetAt(0).getRow(1).getCell(3).toString().toLowerCase();
        System.out.println("2. Satır 4. hucre: "+satir2cell4);
        Assert.assertEquals(satir2cell4,"kabil");

        // - Satir sayisini bulalim
        int satirSayi = workbook.getSheetAt(0).getLastRowNum();
        System.out.println("Satır Sayısı: "+satirSayi);

        // - Fiziki olarak kullanilan satir sayisini bulun
       int usedrow =workbook.getSheetAt(0).getPhysicalNumberOfRows();
        System.out.println("Fiziki kullanılan satır sayısı: "+ usedrow);

        // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        HashMap<String ,String> baskentler = new HashMap<>();
        int rowNumber =workbook.getSheetAt(0).getLastRowNum();
        String ulkeAdi="";
        String baskentAdi="";

        for(int i=1; i<rowNumber;i++) {
            ulkeAdi =workbook.getSheetAt(0).getRow(i).getCell(0).toString();
            baskentAdi = workbook.getSheetAt(0).getRow(0).getCell(1).toString();
            baskentler.put(ulkeAdi,baskentAdi);
        }
        System.out.println(baskentler);
    }

}
