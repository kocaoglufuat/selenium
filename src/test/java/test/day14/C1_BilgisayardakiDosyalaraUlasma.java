package test.day14;

import org.testng.annotations.Test;

import java.awt.*;

public class C1_BilgisayardakiDosyalaraUlasma {
    @Test
    public void test01(){
        //system.getproperty("user.dir") icinde oldugumuz projenın bılgısayardakı yolunu verır
        System.out.println(System.getProperty("user.dir"));
        //System.getProperty("user home") kullandıgımız bılgısayarın Maın path'ini verir
        //ana yol
        System.out.println(System.getProperty("user.home"));

        //bır dosyaya dınamık olarak ulasabılmek ıcın
        //masaustune ulasmak ıstıyorsam

        String masaUstuDosyaYolu= System.getProperty("user.home") + "\\Desktop";
        System.out.println(masaUstuDosyaYolu);
    }
}
