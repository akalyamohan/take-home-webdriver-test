package dotdashcom_testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC13_IFrame extends BaseTest{

	// browser staring method
	@BeforeMethod
	public void BrowserInvoking() {

		// receiving url to the browser
		driver.get("http://localhost:7080/iframe");
	}

	@Test
	public void iframe() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// count of total frames avaiable in the page and printing in console
		int frame_count = driver.findElements(By.tagName("iframe")).size();
		System.out.println(frame_count);

		// switing to frame from page content
		driver.switchTo().frame("mce_0_ifr");

		// clearing the text available inside the frame body
		driver.findElement(By.xpath("/html/body")).clear();

		// sending some text to frame body
		driver.findElement(By.xpath("/html/body")).sendKeys("Please be safe");

		// receiving text to the console and asserting for sent text available or not
		String text_in_frame = driver.findElement(By.xpath("/html/body")).getText();
		System.out.println("Text inside frame is : " + text_in_frame);
		Assert.assertEquals(text_in_frame, "Please be safe");

	}

}
