package test.day17;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C1_DriverIlkClass {

    @Test
    public void test01(){
        Driver.getDriver().get("https://youtube.com");

        Driver.getDriver().get("https://facebook.com");

        Driver.getDriver().get("https://amazon.com");


        Driver.closeDriver();
    }

}
