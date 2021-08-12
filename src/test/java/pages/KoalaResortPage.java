package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class KoalaResortPage {
    public WebElement girisYapilamadiElementi;

    public KoalaResortPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;

    @FindBy(id = "UserName")
    public WebElement kullaniciAdiTextBox;

    @FindBy(id = "Password")
    public WebElement passwordTexBox;

    @FindBy(id = "btnSubmit")
    public WebElement loginButonu;

    @FindBy(id = "MaxChildCount")
    public WebElement maxChildCount;

    @FindBy(xpath = "//*[text()='HotelRoom was inserted succesfully']")
    public WebElement roomCreatedElementi;

    @FindBy(id = "MaxAdultCount")
    public WebElement maxAdultCount;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement roomCreateSonOk;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRoomsButonu;

    @FindBy(xpath = "//*[text()='List Of Hotelrooms'])[2]")
    public WebElement hotelRoomListYaziElementi;

    @FindBy(id = "Code")
    public WebElement codeTextBox;

    @FindBy(id = "IDGroup")
    public WebElement acılırMenu;

    @FindBy(id = "btnSubmit")
    public WebElement saveButonu;

    @FindBy(xpath = "//div[text()='Hotel was inserted succesfully']")
    public WebElement sonucYazısıElementi;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRooms;

    @FindBy(xpath = "//*[text()='Add Hotelroom']")
    public WebElement addHotelRoom;

    @FindBy(id = "IDHotel")
    public WebElement idHotelDropdown;

    @FindBy(xpath = "//textarea[@dir='ltr']")
    public WebElement roomTextBox;


    @FindBy(xpath = "//tbody//tr[1]//td")
    public List<WebElement> birinciSatırDatalar;

    @FindBy(xpath = "//thead//tr[1]//th")
    public List<WebElement> sutunBaslıkları;

    @FindBy(xpath = "tbody")
    public List<WebElement> tbodyWebelement;

    @FindBy(xpath = "//tbody//td")
    public List<WebElement> bodydekiTumDataListesi;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satırlarListesi;




    public void koalaResortLogin() {
        Driver.getDriver().get(ConfigReader.getproperty("kr_url"));
        ilkLoginLinki.click();
        kullaniciAdiTextBox.sendKeys(ConfigReader.getproperty("kr_valid_username"));
        passwordTexBox.sendKeys(ConfigReader.getproperty("kr_valid_password"));
        loginButonu.click();
    }

    public void istenenSatırıYazdır(int satırNo) {
        // ===== //tbody//tr[3]

        String satırXPath = "//tbody//tr[" + (satırNo - 1) + "]";
        System.out.println(Driver.getDriver().findElement(By.xpath(satırXPath)).getText());
    }

    public String dataStringBul(int satırNo, int sutunNo) {
        String dataPath = "//tbody//tr[" + satırNo + "]//td[" + sutunNo + "]";

        return Driver.getDriver().findElement(By.xpath(dataPath)).getText();
    }



public void istenenHucreyıYazdır(int satırNo, int sutunNo){
    //ornek : 3.satır 5.sutunu yazdır
    String hucreXPath= "//tbody//tr["+satırNo +"]//td[" +sutunNo +"]";
    WebElement istenenDataElementi=Driver.getDriver().findElement(By.xpath(hucreXPath));

    System.out.println(istenenDataElementi.getText());
}


}
