package test.day16;

import org.testng.annotations.Test;
import pages.KoalaResortLoginPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C4_ConfigKullanmaTesti extends TestBase {
     /*
    1 ) Bir Class olustur : PositiveTest
    2) Bir test method olustur positiveLoginTest()
            http://qa-environment.koalaresorthotels.com adresine git
            login butonuna bas
        test data username: manager ,
        test data password : Manager1!
        Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */

    @Test
    public void test01(){
    // Kodumu tamamen dinamik yapmak icin 3 dataya ihtiyacim var
    // 1- locate  ==> Bunlari Page Class'indan obje ureterek alabilirim
    // 2- Test datalari ==> Bunlar icin obje olusturmama gerek yok,
    //    ConfigReader Class'inda hersey static oldugu icin
    //    sadece Class ismi ile herseye ulasabilirim
    driver.get(ConfigReader.getproperty("kr_url"));
    KoalaResortLoginPage koalaResortLoginPage=new KoalaResortLoginPage(driver);
    koalaResortLoginPage.ilkLoginLinki.click();
    koalaResortLoginPage.kullaniciAdiTextBox.sendKeys(ConfigReader.getproperty("kr_valid_username"));
    koalaResortLoginPage.passwordTexBox.sendKeys(ConfigReader.getproperty("kr_valid_password"));
    koalaResortLoginPage.loginButonu.click();

}
}
