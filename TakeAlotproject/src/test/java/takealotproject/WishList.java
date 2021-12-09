package takealotproject;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectsTakeaLot.TakealotLandingPage;

public class WishList {
	
	TakealotLandingPage lp = new TakealotLandingPage();
	
	@BeforeTest
	public void Cookie() {
		lp.clickCookieButton();
	}
	
	
	@Test
	public void GIVEN_Select_Department_AND_Category_WHEN_Results_Displayed_THEN_Assert_Number_Of_Results() {
		
//		GIVEN
		lp.clickAllDepartments();
		lp.clickSearchButton();
		
//		AND
		lp.clickTVSeries();
		lp.clickAnimation();
		lp.checkResultsDisplayed();
		
//		WHEN
		String items = lp.checkResultsDisplayed();
		String Results = items.substring(0,2);
		int itemResults = Integer.valueOf(Results);
		
//		THEN
		if(itemResults >= 1) {
			System.out.println("More than 1 item is displayed");
		}

	}
		
		
		@Test
		public void GIVEN_Select_Product_AND_Add_To_WishList_WHEN_Cart_Value_Is_Less_Than_R450_THEN_Assert_Message_Spend_More() {
		
//		GIVEN
		lp.clickAllDepartments();
		lp.clickSearchButton();
		lp.clickTVSeries();
		lp.clickAnimation();
		lp.clickProduct();
		lp.SwitchWindow();
		
//		AND
		lp.clickAddToList();
		lp.clickView();
		lp.clickAddToCart();
		lp.clickCartIcon();
		lp.checkFreeDeliveryMessage();
		
//		WHEN
		String amount = lp.GetTotalCartAmount();
		String cart = amount.substring(2);
		int cartAmount = Integer.valueOf(cart);
		
		String free = lp.checkFreeDeliveryMessage();
		String value = free.substring(7,9);   		//450
		int freeValue = Integer.valueOf(value);
		
		
//		THEN
		if(cartAmount < freeValue) {
			System.out.println("No free delivery " + lp.checkFreeDeliveryMessage());
		}
	}
		
		
		@Test
		public void GIVEN_Select_Product_WHEN_Cart_Amount_Is_More_Than_R450_THEN_Get_Free_Delivery() {
			
//		GIVEN
		lp.clickAllDepartments();
		lp.clickSearchButton();
		lp.clickTVSeries();
		lp.clickAnimation();
		lp.clickProduct();
		lp.SwitchWindow();	
		lp.clickAddToList();
		lp.clickView();
		lp.clickAddToCart();
		lp.clickCartIcon();
		lp.checkFreeDeliveryMessage();
		
		lp.selectQuantity();
		lp.GetTotalCartAmount();
		
//		WHEN
		String amount = lp.GetTotalCartAmount();
		String cart = amount.substring(2);
		int cartAmount = Integer.valueOf(cart);
		
		String free = lp.checkFreeDeliveryMessage();
		String value = free.substring(7,9);  		//450
		int freeValue = Integer.valueOf(value);
		
//		THEN
		if(cartAmount >= freeValue) {
			System.out.println("Free Delivery");
		}
	}
		
		@AfterSuite
		public void cleanUp() {
			lp.cleanUp();
		}

}
