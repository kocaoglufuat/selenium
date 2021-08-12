package test.day14;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C2_IsExist {
    @Test
    public void test01() throws InterruptedException {
        //masaustunuzde flower dosyasının oludugunu test edın

        //1-)maın path'ını Strıng olarak kaydedelım
        String mainPath=System.getProperty("user.home");
Thread.sleep(5000);
        //2-)dosya yolunu strıng olarak kaydedelım

        String dosyaYolu=mainPath+"\\OneDrive\\Masaüstü\\FLOWER.jpg";
        System.out.println(dosyaYolu);

        //3 Assertion yapalım bu kod calısmıyo
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));




    }

}
