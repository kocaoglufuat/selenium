package test.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseClass;

import java.security.SecureRandom;

import static org.testng.Assert.*;

public class C4_UploadFile extends TestBaseClass {
    /*2.https://the-internet.herokuapp.com/upload adresine gidelim
      3.chooseFile butonuna basalim
      4.Yuklemek istediginiz dosyayi secelim.
      5.Upload butonuna basalim.
      6.“File Uploaded!” textinin goruntulendigini test edelim.
*/
    @Test
    public void uploadFile() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
      //1-) dosya sec ve locate edin
        WebElement dosyaSec=driver.findElement(By.id("file-upload"));

        // 2-) yuklemek ıstedıgımız dosyanın dosya yolunu kaydedın
        String dosyaYolu= System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\FLOWER.jpg";

        //3-) Sendkeys ile dosyayı dosyasec butonuna yollayın
        dosyaSec.sendKeys(dosyaYolu);
        Thread.sleep(5000);
        //upload butonuna basalım
        driver.findElement(By.id("file-submit")).click();

        // "File Upload!" textin goruntulendıgını test edelım
        WebElement fileUploadedYazısıElementi=driver.findElement(By.tagName("h3"));
        assertTrue(fileUploadedYazısıElementi.isDisplayed());

        assertTrue(fileUploadedYazısıElementi.getText().contains("File"));
        assertFalse(fileUploadedYazısıElementi.getText().contains("Mehmet"));
        //assertEquals(fileUploadedYazısıElementi.getText(),"File Uploaded!");
        assertEquals(fileUploadedYazısıElementi.getText(),"File Uploaded!");
    }



}
