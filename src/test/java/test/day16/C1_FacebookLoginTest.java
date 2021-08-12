package test.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.FacebookLoginPage;
import utilities.TestBase;

public class C1_FacebookLoginTest extends TestBase {
    public void gelenekselTest(){
        driver.get("https://facebook.com");
        WebElement emailTextBox=driver.findElement(By.id("email"));
        emailTextBox.sendKeys("fuat@gmail.com");

        WebElement passwordKutusu=driver.findElement(By.id("pass"));
        passwordKutusu.sendKeys("12345");

        driver.findElement(By.xpath("//button[@name='login']")).click();


        }

        public void pageIleTest(){
            FacebookLoginPage facebookLoginPage=new FacebookLoginPage(driver);
        }
    }


