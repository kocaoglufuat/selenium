package test.day09;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class C1_Priority {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("before method calıstı");
    }
    @AfterMethod
    public void teardown(){
        driver.close();
        System.out.println("after method calıstı");
    }

    @Test(priority = 10)
    public void test01(){
        System.out.println("test01 calıstı");
    }

    @Test(priority = 5)
    public void ıkıncıtest(){
        System.out.println("ıkıncı test calıstı");
    }
    @Test(priority = 2)
    public void yazdım(){
        System.out.println("yazdım");
    }

}
