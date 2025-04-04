package pages;

import managers.WaitManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    WebDriver driver;
    WaitManager wm;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wm = new WaitManager(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"fadein\"]/main/div[1]/div[2]/div[1]/h4/strong")
    WebElement txt_banner;

    /** SEARCHING FLIGHT **/
    @FindBy(xpath = "//input[@name='from']" )
    WebElement txt_origin;
    @FindBy(xpath = "//input[@name='to']")
    WebElement txt_destination;
    @FindBy(xpath = "//*[@id=\"flights-search\"]/div[1]/div/div/div[1]/select")
    WebElement drd_flightType;
    @FindBy(id = "flight_type")
    WebElement drd_flightClass;
    @FindBy(id = "departure")
    WebElement txt_depart_date;
    @FindBy(id = "return_date")
    WebElement txt_returnDate;
    @FindBy(xpath = "//div[@class='col-lg-2']//a[@role='button']")
    WebElement drd_travellers;
    @FindBy(id = "fadults")
    WebElement txt_numOfAdults;
    @FindBy(id = "fchilds")
    WebElement txt_numOfChildren;
    @FindBy(id = "finfant")
    WebElement txt_numOfInfants;


    @FindBy(css = "body > main:nth-child(5) > section:nth-child(4) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > strong:nth-child(1) > small:nth-child(1)")
    WebElement txt_getFlightResultText;


    /*COMMON COMPONENTS*/
    @FindBy(xpath = "//*[@id=\"tab\"]/li[1]/button")
    WebElement tab_flight;
    @FindBy(id = "flights-search")
    WebElement btn_Search_btn;

    // Verify HomePage Banner
    public String getBannerText(){
        return txt_banner.getText();
    }

    //Select the flight tab
    public void selectFlightTab(){
        //tab_flight.click();
        wm.waitTillClickable(tab_flight).click();
    }

    //Select the Travel Type: One Way or Return
    public void selectFlightType(String flightType){
        Select select = new Select(drd_flightType);
        select.selectByVisibleText(flightType);
    }

    //Select the Flight Class: Economy, Economy Premium, Business, First
    public void selectFlightClass(String flightClassName){
        Select select = new Select(drd_flightClass);
        select.selectByVisibleText(flightClassName);
    }

    //Enter Origin
    public void enterOrigin(String flyingFrom){
        txt_origin.sendKeys(flyingFrom);
    }

    //Enter Destination
    public void enterDestination(String destinationTo){
        txt_destination.sendKeys(destinationTo);
    }

    //Enter Depart Date
    public void enterDepartDate(String departDate){
        txt_depart_date.clear();
        txt_depart_date.sendKeys(departDate);
    }

    //Enter Return Date
    public void enterReturnDate(String returnDate){
        txt_returnDate.sendKeys(returnDate);
    }

    //Enter Depart Date and Return Date
    public void enterDepartAndReturnDates(String departDate, String returnDate){
        txt_origin.sendKeys(departDate);
        txt_returnDate.sendKeys(returnDate);
    }

    //Select number of passengers
    public void clickOnTravellersDropdown(){
        //drd_travellers.click();
        wm.waitTillClickable(drd_travellers).click();
    }
    public void enterAdults(String numberOfAdults){
        //Need to optimize that only accept integer
        txt_numOfAdults.clear();
        txt_numOfAdults.sendKeys(numberOfAdults);
    }
    public void enterChildren(String numberOfChildren){
        //Need to optimize that only accept integer
        txt_numOfChildren.clear();
        txt_numOfChildren.sendKeys(numberOfChildren);
    }
    public void enterInfants(String numberOfInfants){
        //Need to optimize that only accept integer
        txt_numOfInfants.clear();
        txt_numOfInfants.sendKeys(numberOfInfants);
    }
    public void enterTravellers(String numberOfAdults, String numberOfChildren, String numberOfInfants){
        drd_travellers.click();
        wm.waitTillClickable(drd_travellers).click();
        txt_numOfAdults.clear();
        txt_numOfAdults.sendKeys(numberOfAdults);
        txt_numOfChildren.clear();
        txt_numOfChildren.sendKeys(numberOfChildren);
        txt_numOfInfants.clear();
        txt_numOfInfants.sendKeys(numberOfInfants);
    }

    public void clickSearchButton(){
//        btn_Search_btn.click();
        wm.waitTillClickable(btn_Search_btn).click();
    }
    public boolean verifyModifySearchButtonDisplay(){
        //System.out.println(txt_getFlightResultText.getText());
        return txt_getFlightResultText.isDisplayed();
    }


}
