package android;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.internal.TouchAction;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

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
	
	@Test
	public void SecondTest() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Views\"]").click();
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]").click();
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]").click();
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void Gestures() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		
		TouchAction t = new TouchAction(driver);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		WebElement expandList = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
		t.tap(tapOptions().withElement(element(expandList))).perform();
		driver.findElementByAndroidUIAutomator("text(\"1. Custom Adaptor\")").click();
		
	}
	
	@Test
	public void Scroll() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		
		TouchAction t = new TouchAction(driver);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Radio Group\"));");
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
	}
	

	@Test
	public void DragAndDrop() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		
		TouchAction t = new TouchAction(driver);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();
		WebElement firstElement = driver.findElementById("io.appium.android.apis:id/drag_dot_1");
		WebElement secondElement = driver.findElementById("io.appium.android.apis:id/drag_dot_2");
		t.longPress(longPressOptions().withElement(element(firstElement))).moveTo(element(secondElement)).release().perform();
		
	}
}
