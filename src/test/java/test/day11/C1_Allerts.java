package test.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C1_Allerts {
    /*
● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
● Bir metod olusturun: acceptAlert
○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
“You successfully clicked an alert” oldugunu test edin.
● Bir metod olusturun: dismissAlert
○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
“successfuly” icermedigini test edin.
● Bir metod olusturun: sendKeysAlert
○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
*/
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @AfterClass
    public void tearDown(){
        //driver.close();

    }
    @Test
   //● Bir metod olusturun: acceptAlert
    public void acceptAllert(){
        /*○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
“You successfuly clicked an alert” oldugunu test edin.*/
driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

driver.switchTo().alert().accept();
        WebElement sonucyazısıWebElementi=driver.findElement(By.cssSelector("#result"));

        String expectedResultYazısı="You successfully clicked an alert";
        String actualResultYazısı=sonucyazısıWebElementi.getText();

        Assert.assertEquals(actualResultYazısı,expectedResultYazısı);

    }
@Test
    // ● Bir metod olusturun: dismissAlert
    public void dismissAllert(){
        /*○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
         “successfuly” icermedigini test edin.*/
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();

        WebElement sonucyazısıWebElementi=driver.findElement(By.cssSelector("#result"));

        String unExpected="successfully";
        String actualResultYazısı=sonucyazısıWebElementi.getText();

        Assert.assertFalse(actualResultYazısı.contains(unExpected));
    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        /*
        ● Bir metod olusturun: sendKeysAlert
            ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
            OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
         */
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(1000);
        String isim ="Mehmet";
        driver.switchTo().alert().sendKeys(isim);
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        WebElement sonucYazisiWebElementi=driver.findElement(By.cssSelector("#result"));
        String actualResultYazisi=sonucYazisiWebElementi.getText();
        Assert.assertTrue(actualResultYazisi.contains(isim));
    }
}
