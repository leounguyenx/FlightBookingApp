package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.HomePage;

import java.time.Duration;

public class SearchFlightsTest {
    WebDriver driver;
    HomePage homepage;


    @Given("User on the flight Search Page")
    public void user_on_the_flight_search_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.phptravels.net/");
    }
    @When("User searches a flight from {string} to {string}")
    public void user_searches_a_flight_from_to(String from, String to) {
        homepage = new HomePage(driver);
        homepage.enterOrigin(from);
        homepage.enterDestination(to);
    }
    @And("selects the flight type {string}")
    public void selects_the_flight_type(String flightType) {
        homepage.selectFlightType(flightType);
    }
    @And("selects the depart date {string}")
    public void selects_the_depart_date(String departDate) {
        homepage.enterDepartDate(departDate);
    }
    @And("selects the number of passengers {string} {string} {string}")
    public void selects_the_number_of_passengers(String adults, String children, String infants) {
        homepage.clickOnTravellersDropdown();
        homepage.enterAdults(adults);
        homepage.enterChildren(children);
        homepage.enterInfants(infants);
    }
    @And("User clicks on Search button")
    public void user_clicks_on_search_button() {
        homepage.clickSearchButton();
        System.out.println("Clicked Search");
        homepage.clickSearchButton();
        System.out.println("Clicked Search");
    }
    @Then("The search results should display flights matching the criteria")
    public void the_search_results_should_display_flights_matching_the_criteria() {
        System.out.println("Under construction");
        //Assert.assertTrue(homepage.verifyModifySearchButtonDisplay());
        //homepage.verifyModifySearchButtonDisplay();
    }
}
