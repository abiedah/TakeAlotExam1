package pageObjectsTakeaLot;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import frameWorkClasses.BasePage;

public class TakealotLandingPage extends BasePage {
	
	
//	Click Cookie Button
	public void clickCookieButton() {
		if (ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".button.cookies-banner-module_dismiss-button_24Z98")) != null)
				ClickElement(By.cssSelector(".button.cookies-banner-module_dismiss-button_24Z98"));
	}
	
//	**********************************  DAILY DEALS *****************************
	
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
	
	
	
//	************************************ WISH LIST *******************************
	
//	Click All Departments
	public void clickAllDepartments() {
		selectDropdown(By.name("department"), "Movies & Series");
	}
	
	
//	Click Search icon
	public void clickSearchButton() {
		ClickElement(By.xpath("//button[@class='button search-btn search-icon']"));
	}
	
	
//	Click on TV Series
	public void clickTVSeries() {
//		ClickElement(By.xpath("//div[@class='list-item sub']"));	
		ClickElement(By.xpath("//*[contains(text(), 'TV Series')]"));
	}
	
	
//	Click See More button
	public void clickSeeMore() {
		ClickElement(By.xpath("//button[.='See More']"));
	}
	
	
//	Click on Animation
	public void clickAnimation() {	
		ClickElement(By.xpath("//*[contains(text(), 'Animation')]"));
	}
	
	
//	Check Number of Results Displayed
	public String checkResultsDisplayed() {
		return getElementText(By.cssSelector(".search-count.search-count-module_search-count_1oyVQ.toolbar-module_search-count_P0ViI"));
	}
	
	
//	Click on Product
	public void clickProduct() {
		ClickElement(By.xpath("//a[contains(@class, 'product-anchor product-card-module_product-anchor_TUCBV')]"));
	}
	
	
//	Click Add to List
	public void clickAddToList() {
//		ClickElement(By.xpath("//span[@class='wishlist-split-button-module_text_E0HQC')]"));
//		ClickElement(By.xpath("//div[@class='wishlist-split-button-module_split-button_2PSmC')]"));
		ClickElement(By.xpath("//*[@class='button  expanded add-to-cart-button add-to-cart-button-module_add-to-cart-button_1a9gT')]"));  //from add to cart locator to test
	}
	
	
// Click View Wish List
	public void clickView() {
//		ClickElement(By.tagName("View"));
		ClickElement(By.xpath("//a[@class='toast-content-module_link__wfj6 toast-content-module_inline_F3XBs')]"));
	}

	
//	Click Add to Cart
	public void clickAddToCart() {
		ClickElement(By.xpath("//*[@class='button  expanded add-to-cart-button add-to-cart-button-module_add-to-cart-button_1a9gT"));
	}
	
	
//	Switch to New Window
	public void SwitchWindow() {
		Set<String> handles = driver.getWindowHandles(); 
		Iterator<String> it = handles.iterator(); 
		String parentWindowID = it.next();
		String childWindowID = it.next();
		driver.switchTo().window(childWindowID); 
	}
	
	
//	Click on Cart Icon
	public void clickCartIcon() {
		ClickElement(By.xpath("//button[@safeclass~'\\bbadge-button\\b.*\\bbadge-button-module_badge-button_3TXVp\\b.*\\bbadge-button-module_badge-icon_LvKrF\\b.*\\bbutton\\b.*\\bdark-green\\b.*\\bmini-cart-button\\b']"));
	}
	
	
//	Get Total Cart Amount
	public String GetTotalCartAmount() {
		return getElementText(By.xpath("//*[contains(text(),'Cart Summary')]/..//span[contains(@class,'currency plus currency-module_currency_29IIm')]"));
	}
	
	
//	Check Free Delivery Message
	public String checkFreeDeliveryMessage() {
		return getElementText(By.xpath("//div[@class='show-free-delivery.free-delivery-module_free-delivery-tab_3xNIm')]"));
	}
	
	
//	Select Quantity
	public void selectQuantity() {
		selectDropdown(By.id("cart-item_undefined"), "4");
	}
	
}


