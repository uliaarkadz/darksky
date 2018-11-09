package stepdefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.web_pages.HotelLandingPage;

public class HotelsSearchSD {

    private HotelLandingPage landingPage = new HotelLandingPage();

    @When("^I enter destination as (.+)$")
    public void enterDestination(String city) {
        landingPage.enterDestination(city);
    }

    @When("^I select destination as (.+)$")
    public void chooseDestination(String destination) {
        landingPage.chooseDestination(destination);
    }

    @When("^I select checking date as (.+) and checkout date as (.+)$")
    public void clickOnCalendar(int checkIn, int checkOut) {
        landingPage.clickOnCheckInCalendar();
        landingPage.selectTomorrow(checkIn);
        landingPage.clickOnCheckOutCalendar();
        landingPage.selectFutureDate(checkOut);
    }

    @When("^I click on room$")
    public void clickOnRoom() {
        landingPage.clickOnSelectRoom();
    }

    @When("^I select more options$")
    public void selectMoreOptions() {
        landingPage.selectMoreOptions();
    }

    @When("^I select room as (.+)$")
    public void selectRooms(String index) {
    }

    @When("^I select adult as (.+)$")
    public void selectAdult(String index) {
        landingPage.selectAdults(index);
    }

    @When("^I select children as (.+)$")
    public void selectChildren(String index) {
        landingPage.selectChildren(index);
    }

    @When("^I select child one as (.+)$")
    public void selectChildOne(String index) {
        landingPage.selectChildOneAge(index);
    }

    @When("^I select child two as (.+)$")
    public void selectChildTwo(String index) {
        landingPage.selectChildTwoAge(index);
    }

    @When("^I click on search button$")
    public void clickOnSearchButton() {
        landingPage.clickOnSearchButton();
    }

    @Then("^I verify deal of the day hotel price is between 200 to 300$")
    public void verifyDealPrice() {
        landingPage.verifyPriceOfTheDeal();
    }
}



