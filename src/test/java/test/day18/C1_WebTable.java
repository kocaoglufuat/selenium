package test.day18;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.Driver;

import java.sql.SQLOutput;

public class C1_WebTable {
    /*
    ● login() metodun oluşturun ve oturum açın.
● http://qa-environment.koalaresorthotels.com /admin/HotelRoomAdmin adresine gidin
 ○ Username : manager
 ○ Password : Manager1!
● table() metodu oluşturun
 ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
 ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
● printRows() metodu oluşturun //tr
 ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
 ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
 ○ 4.satirdaki(row) elementleri konsolda yazdırın.
 */
    @Test
    public void table(){
        KoalaResortPage koalaResortPage=new KoalaResortPage();
        koalaResortPage.koalaResortLogin();
        // ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody

        //--//tbody//tr[1]//td bu body'dekı 1.satırdakı data sayısını verıyor
        //bu locaterla bana 9 webelementi dondugu ıcın

        System.out.println("tablodakı sutun sayısı = " + koalaResortPage.birinciSatırDatalar.size());

        //System.out.println(koalaResortPage.sutunBaslıkları);
        //listemiz webelementlerden olustugu ıcın dırek yazdıramayız
        //yazdırmak ıcın for-each loop ıle her bır web elementını alıp,ustundekı texti yazdırmamız gerekır
        for (WebElement each : koalaResortPage.sutunBaslıkları
             ) {
            System.out.println(each.getText());


        }
        System.out.println(koalaResortPage.tbodyWebelement);

        //eger tum body'ı tek bır web element olarak locate eder ve yazdırırsanız
        //tum body'ı gorebılırsınız
        //ancak bu cok kullanılmaz cunku bu durumda satır,sutun veya data'ları ayırma sansımız yoktur
        //tum body tek bır element olarak yazdırılabılır ama ıslem yapmak zordur

        //Body'nın ıcınde bulunan td sayısını bulmak icin //tbody//td locatini kullanırız
        System.out.println("tablo bodys'inde bulunan cell sayıısı =" + koalaResortPage.bodydekiTumDataListesi.size());
        Driver.closeDriver();
    }

    @Test
    public void getRows(){
        /*
  ● printRows() metodu oluşturun //tr
 ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
 ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
 ○ 4.satirdaki(row) elementleri konsolda yazdırın.
 */
       KoalaResortPage koalaResortPage=new KoalaResortPage();

       koalaResortPage.koalaResortLogin();

       //    ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        //------- //tbody/tr

        System.out.println("tablodakı satır sayısı = " + koalaResortPage.satırlarListesi.size());

        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each: koalaResortPage.satırlarListesi
             ) {
            System.out.println(each.getText());
        }
   // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println(koalaResortPage.satırlarListesi.get(3).getText());

        // bır lıste olusturmadan,parametre olarak satır numarasını kabul edıp
        // girilen numaradakı satırı yazdıran bır method yazınız

        //ornek 5.satır desem locate //tbody//tr[4]

        //7.satır yazdıralım
        System.out.println("==================================================");
        koalaResortPage.istenenSatırıYazdır(7);
    }

}
