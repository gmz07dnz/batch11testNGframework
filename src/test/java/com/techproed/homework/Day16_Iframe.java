package com.techproed.homework;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Day16_Iframe extends TestBase {

    /*
     1. “http://webdriveruniversity.com/IFrame/index.html"sayfasina gidin
     2. “Our Products” butonuna basin
     3. “Cameras product”i tiklayin
     4. Popup mesajini yazdirin
     5. “close” butonuna basin
     6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
     7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
     */



    @Test
    public void test(){
        // 1. “http://webdriveruniversity.com/IFrame/index.html"sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        // 2. “Our Products” butonuna basin
        driver.switchTo().frame("frame");
       WebElement ourProducts= driver.findElement(By.partialLinkText("Our Products"));
       ourProducts.click();

        driver.switchTo().defaultContent();

        // 3. “Cameras product”i tiklayin
        driver.switchTo().frame("frame");
        driver.findElement(By.xpath("(//*[.='Cameras'])[2]")).click();

        //     4. Popup mesajini yazdirin
        WebElement popUpElement =driver.findElement(By.xpath("//div[@class='modal-body']"));
        System.out.println(popUpElement.getText());
        //     5. “close” butonuna basin
        //     6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        //     7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin

    }

}
