package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day15_FilePath extends TestBase {

    @Test
    public void test01(){

       /*
        System.out.println(System.getProperty("user.dir")); // içinde oldugumuz path'in yolunu verir
                                                           // -> C:\Users\gmzed\IdeaProjects\batch11testNGframework
        System.out.println(System.getProperty("user.home")); // kullandıgımız klasoru verir . -> C:\Users\gmzed

        */

        String anaPath = System.getProperty("user.home");
        String masaUstuPath = anaPath + "\\Desktop";
        System.out.println("Desktop yolu " + masaUstuPath);
    }


    @Test
    public void isExist(){
       // C:\Users\gmzed\Desktop\FLOWER.jpg

        // 1. adım bilgisayarimizin home path'ini alıyoruz
        String homePath = System.getProperty("user.home");

        // 2. adım home path'in devamına dosya yolunu olusturacak sekilde ek yapıyoruz
        // Önemli : dosya adından sonra mutlaka uzantısının yazılması gerekir
        String filePath = homePath + "\\Desktop\\FLOWER.jpg";
        System.out.println(filePath); // C:\Users\gmzed\Desktop\FLOWER.jpg

        // Masaustunde FLOWER.jpg dosyasının varoldugunu test edin

        // 3. adım dosyanın var oldugunu Files.exists() ile test edebiliriz.
      boolean dosyaVarMi=  Files.exists(Paths.get(filePath));
        System.out.println(dosyaVarMi);  // true

    }

}
