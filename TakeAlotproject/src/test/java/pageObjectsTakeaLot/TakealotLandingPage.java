package pageObjectsTakeaLot;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import frameWorkClasses.BasePage;

public class TakealotLandingPage extends BasePage {
	
	
//	Click Cookie Button
	public void clickCookieButton() {
		if (ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".button.cookies-banner-module_dismiss-button_24Z98")) != null)
				ClickElement(By.cssSelector(".button.cookies-banner-module_dismiss-button_24Z98"));
	}
	
	
//	Click Daily Deals Button
	public void clickDailyDeals() {
		ClickElement(By.xpath("//a[contains(@href, 'https://www.takealot.com/deals?sort=Relevance')]"));
	}
	
	
//	Search by Brand in Daily Deals
	public void enterBrand(String SearchbyBrand) {
		EnterText(By.cssSelector("input#_undefined"), SearchbyBrand);
	}
	
	
//	String message if no results found in Daily Deals
	public String checkmessage() {
		return getElementText(By.cssSelector(".filter-search-module_no-results_3zVd7"));
	}
	
	
//	Clear the filter icon in Daily Deals
	public void clickClear() {
		ClickElement(By.cssSelector(".filter-clear-icon.filter-search-module_clear-icon_3Plm_"));
	}
	
	
	
	
}
