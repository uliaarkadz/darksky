package framework.web_pages;

import framework.BasePage;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

public class HotelLandingPage extends BasePage {

    private By destinationTextField = By.id("qf-0q-destination");
    private By chooseDestination = By.xpath("//div[@class='autosuggest-category-result']");
    private By checkInCalendar = By.xpath(".//*[@id='qf-0q-localised-check-in']");
    private By checkOutCalendar = By.xpath("//label[@id='widget-query-label-3']");
    private By selectRoom = By.xpath("//select[@id='qf-0q-compact-occupancy']");
    private By selectMoreOptions = By.xpath("//option[@data-more-options='true']");
    private By selectNumberOfRooms = By.xpath("//select[@id='qf-0q-rooms']");
    private By selectNumberOfAdults = By.xpath("//select[@id='qf-0q-room-0-adults']");
    private By selectNumberOfChildren = By.xpath("//select[@id='qf-0q-room-0-children']");
    private By childOneAge = By.xpath("//select[@id='qf-0q-room-0-child-0-age']");
    private By childTwoAge = By.xpath("//select[@id='qf-0q-room-0-child-1-age']");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By calendarLocator = By.xpath(".//*[@class='widget-datepicker-bd']/descendant::a");
    private By dealOfTheDayPrice = By.xpath("//ins");

    @Step
    public void enterDestination(String city) {
        sendText(destinationTextField, city);
    }

    public void chooseDestination(String destination) {
        autoComplete(chooseDestination, destination);
    }

    public void clickOnCheckInCalendar() {
        clickOn(checkInCalendar);
    }

    public void selectTomorrow(int noOfDays) {
        pickDate(calendarLocator, noOfDays);
    }

    public void clickOnCheckOutCalendar() {
        clickOn(checkOutCalendar);
    }

    public void selectFutureDate(int noOfDays) {
        pickDate(calendarLocator, noOfDays);
    }

    public void clickOnSelectRoom() {
        clickOn(selectRoom);
    }

    public void selectMoreOptions() {
        clickOn(selectMoreOptions);
    }

    public void selectRooms(String rooms) {
        selectingDropDown(selectNumberOfRooms, rooms);
    }

    public void selectAdults(String adults) {
        selectingDropDown(selectNumberOfAdults, adults);
    }

    public void selectChildren(String children) {
        selectingDropDown(selectNumberOfChildren, children);
    }

    public void selectChildOneAge(String ageOne) {
        selectingDropDown(childOneAge, ageOne);
    }


    public void selectChildTwoAge(String ageTwo) {
        selectingDropDown(childTwoAge, ageTwo);
    }

    public void clickOnSearchButton() {
        clickOn(searchButton);
    }

    public void verifyPriceOfTheDeal() {
        String dealPrice = getTextFromElement(dealOfTheDayPrice);
        System.out.println(dealPrice);
        //String dealPrice = "Cool";
        dealPrice = dealPrice.replace("$", "");
        System.out.println(dealPrice);
        int price = Integer.parseInt(dealPrice);
        if (price >= 200 || price <= 300) {
            System.out.println("The deal of the day is in the selected price range");
        }
    }

}