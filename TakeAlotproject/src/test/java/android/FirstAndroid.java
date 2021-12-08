package android;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FirstAndroid extends BasePageAndroid {
	

	@Test
	public void FirstTest() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Preference\"]").click();
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]").click();
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("12345");
		driver.findElementById("android:id/button1").click();
		
	}
	

}
