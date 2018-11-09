package framework.mobile_pages;

import framework.MobileBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LandingPage extends MobileBasePage {

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='SKIP ']")
    @iOSFindBy(accessibility = "yesButton")
    private MobileElement yesButton;

    @AndroidFindBy(xpath= "//android.webkit.WebView/android.view.View/android.widget.Button[1]")
    private MobileElement mainMenu;

    @AndroidFindBy(xpath= "//android.view.View[@content-desc='Menu']")
    private MobileElement sidebarHeader;

    @AndroidFindBy(xpath = "//android.widget.ToggleButton[@content-desc='FAVORITES ']")
    private MobileElement favoritesButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='No Sessions Found']")
    private MobileElement sessionText;


    public void tapOnSkipButton() {
        tapOn(yesButton);
    }

    public void tapOnMainMenuButton() {
        tapOn(mainMenu);
    }

    public boolean isMenuPresent(){
        return isElementPresent(sidebarHeader);
    }

//    public boolean isSideMenuBarDisplayed() {
//        return isElementDisplayed(sidebarHeader);
//    }

    public void clickOnFavorits(){
        tapOn(favoritesButton);
    }
    public boolean verifyText(){
        return isElementDisplayed(sessionText);
    }
}
