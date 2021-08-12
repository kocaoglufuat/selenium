package test.day15;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C1_Senkronizasyon extends TestBase {

    @Test
    public void test01(){
        driver.get("https://youtube.com");
        driver.findElement(By.xpath("//yt-formatted-string[text()='Müzik']")).click();

    }
}
