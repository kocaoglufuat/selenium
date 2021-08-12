package test.day19;

import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C1_WebTableTekrar1 {

    //a. satır(row) ve sutun(column) numarasını gırdıgınızde,
    //printdata metodu bu hucredekı(cell) verıyı yazdırmalıdır
    //2. baska bır test metodu olusturun: prıntDataTest();
    //a. ve bu metodu prıntData()methodunu cagırmak ıcın kullanın
    //b. ornek: printdata (3,5); =>3.satır, 5.sutundakı verıyı yazdırmalıdır
    //c. yazdırılan datanın olması gereken dataya esıt oldugunu test edın
    @Test
    public void test01(){
        KoalaResortPage koalaResortPage=new KoalaResortPage();

        koalaResortPage.koalaResortLogin();

        koalaResortPage.istenenHucreyıYazdır(3,6);



    }
}
