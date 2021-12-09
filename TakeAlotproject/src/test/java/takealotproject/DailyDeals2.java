package takealotproject;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectsTakeaLot.TakealotLandingPage;

public class DailyDeals2 {
	
	TakealotLandingPage lp = new TakealotLandingPage();
	
	@BeforeTest
	public void Cookies() {
		lp.clickCookieButton();
	}
	
	@Test
	public void GIVEN_SelectBrandFromDailyDeals_WHEN_NoItemsFound_THEN_SkipTheTestCase() {
		
//		GIVEN_SelectBrandFromDailyDeals
		lp.clickDailyDeals();
		lp.enterBrand("Aerolatte");
		lp.clickClear();
		lp.enterBrand("Marvel");
		lp.clickClear();
		lp.enterBrand("Acer");
		
//		WHEN_NoItemsFound
		String actualmessage = lp.checkmessage();
		String expectedmessage = "No results found for ";
		
//		THEN_SkipTheTestCase
		if (!(actualmessage.equals(expectedmessage))) {
			System.out.println("Skip this test case, brands not available via Daily Deals");
			throw new SkipException("Skip this test case");
		}
	}
	

	@AfterSuite
	public void cleanup() {
		lp.cleanUp();
	}
}
