package test.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C3_DropdownAmazon {
  /*
● https://www.amazon.com/ adresine gidin.
- Test 1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin
    45 oldugunu test edin
-Test 2
1. Kategori menusunden Books secenegini secin
2. Arama kutusuna Java yazin ve aratin
3. Bulunan sonuc sayisini yazdirin
4. Sonucun Java kelimesini icerdigini test edin
   */
   WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

   @AfterMethod
    public void tearnDown(){
       // driver.close();
   }

   @Test
   public void test01(){
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin  45 oldugunu test edin
        driver.get("https://amazon.com");
       WebElement acılırListe=driver.findElement(By.id("searchDropdownBox"));

       Select select= new Select(acılırListe);

       List<WebElement> tumOpsiyonlarListesi=select.getOptions();

       int expectedOpsiyonSayısı=45;
       int actualOpsiyonSayısı=tumOpsiyonlarListesi.size();

       Assert.assertEquals(actualOpsiyonSayısı,expectedOpsiyonSayısı,"beklenen sayı yanlıs");
   }

   @Test
    public void javaKitabıTesti(){
        /*  -Test 2
1. Kategori menusunden Books secenegini secin
2. Arama kutusuna Java yazin ve aratin
3. Bulunan sonuc sayisini yazdirin
4. Sonucun Java kelimesini icerdigini test edin
*/

       driver.get("https://amazon.com");
       WebElement acılırListe=driver.findElement(By.id("searchDropdownBox"));
       Select select=new Select(acılırListe);

       select.selectByVisibleText("Books");
       WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
       aramaKutusu.sendKeys("java" + Keys.ENTER);

       WebElement sonucuYazısıElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
       System.out.println(sonucuYazısıElementi.getText());

       Assert.assertTrue(sonucuYazısıElementi.getText().contains("java"));
   }
}