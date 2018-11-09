package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by mohammadmuntakim on 6/9/17.
 */
public class BasePage {

	public void clickOn(By locator) {
		try {
			SharedSD.getDriver().findElement(locator).click();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public void sendText(By locator, String text) {
		try {
			SharedSD.getDriver().findElement(locator).sendKeys(text);
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public String getTextFromElement(By locator) {
		String text = null;
		try {
			text = SharedSD.getDriver().findElement(locator).getText();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}

		return text;
	}

	public void clickOnBrowserBackArrow() {
		SharedSD.getDriver().navigate().back();
	}

	public void clickOnBrowserForwardArrow() {
		SharedSD.getDriver().navigate().forward();
	}

	public void refreshBrowser() {
		SharedSD.getDriver().navigate().refresh();
	}

	public void autoComplete(By locator, String destination){
		//       setValue(locator, destination);
//        getDriver().findElement(By.xpath(".//*[@id='tab-flight-tab-hp']")).click();
//        getDriver().findElement(By.xpath(".//*[@id='flight-origin-hp-flight']")).sendKeys("New York");
		List<WebElement> list = SharedSD.getDriver().findElements(locator);
		for (WebElement ele : list) {
			if (ele.getText().contains(destination)) {
				ele.click();
				break;
			}
		}
	}

	public static void pickDate(By locator, int noOfDays) {

		SimpleDateFormat sdf = new SimpleDateFormat("d");
		Calendar cl = Calendar.getInstance();
		cl.setTime(new Date());
		cl.add(Calendar.DATE,noOfDays);
		String futureDate = sdf.format(cl.getTime());

		List<WebElement> days = SharedSD.getDriver().findElements(locator);

		for (WebElement day : days) {
			String expectedDay = day.getText();
			if (expectedDay.equals(futureDate)) {
				day.click();
				break;
			}
		}
	}

	public static void selectingDropDown (By locator, String value) {
		WebElement dropDown = SharedSD.getDriver().findElement(locator);
		Select s = new Select(dropDown);
		s.selectByValue(value);

	}



}
