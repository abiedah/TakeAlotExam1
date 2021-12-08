package takealotproject;

import org.testng.annotations.Test;

import pageObjectsTakeaLot.TakealotLandingPage;

public class WishList {
	
	TakealotLandingPage lp = new TakealotLandingPage();
	
	@Test
	public void Given_Select_Department_AND_Category_WHEN_Results_Displayed_THEN_Assert_Number_Of_Results() {
		lp.clickCookieButton();
		lp.clickAllDepartments();
		lp.clickSearchButton();
		lp.clickTVSeries();
		lp.clickAnimation();
		lp.checkResultsDisplayed();
		
		String results = lp.checkResultsDisplayed();
		String Results = results.substring(0,2);
		int items = Integer.valueOf(Results);
		
		if(items >= 1) {
			System.out.println("More than 1 items is displayed");
		}
		
		lp.clickProduct();
		lp.SwitchWindow();
		lp.clickAddToList();
		lp.clickView();
		lp.clickAddToCart();
		lp.clickCartIcon();
		lp.checkFreeDeliveryMessage();
		
		String amount = lp.GetTotalCartAmount();
		String cart = amount.substring(2);
		int cartAmount = Integer.valueOf(cart);
		
		if(cartAmount < 450) {
			System.out.println("Spend more for free delivery " + lp.checkFreeDeliveryMessage());
		}
		
		lp.selectQuantity();
		lp.GetTotalCartAmount();
		
		if(cartAmount >= 450) {
			System.out.println("Free Delivery");
		}
	}

}
