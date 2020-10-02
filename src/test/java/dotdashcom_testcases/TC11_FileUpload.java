package dotdashcom_testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC11_FileUpload {

	public static WebDriver driver;

	// browser starting method with browser config
	@BeforeMethod
	public void BrowserInvoking() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32_v85//chromedriver.exe");
		driver = new ChromeDriver();

		// receiving url to the browser
		driver.get("http://localhost:7080/upload");

		// maximizing window
		driver.manage().window().maximize();
	}

	@Test
	public void file_upload() {
		// element of upload button stored in webelement
		WebElement upload_button_ele = driver.findElement(By.id("file-upload"));

		// Test uses Upload Button to upload a file.
		upload_button_ele.sendKeys("C:\\Users\\samsung\\eclipse-workspace\\dotdashcom\\File_upload_doc.txt");
		driver.findElement(By.id("file-submit")).click();

		// getting and printing file uploaded text after successful upload of file
		WebElement file_uploaded_txt_ele = driver.findElement(By.tagName("h3"));
		String file_uploaded_txt = file_uploaded_txt_ele.getText();
		System.out.println("Text shows file uploaded is :" + file_uploaded_txt);

		// printing the name of file which is uploaded
		WebElement uploaded_file_ele = driver.findElement(By.id("uploaded-files"));
		String uploaded_file_name = uploaded_file_ele.getText();

		System.out.println("Name of the file uploaded is: " + uploaded_file_name);

		// Test asserts that the file is uploaded.
		Assert.assertEquals(file_uploaded_txt, "File Uploaded!");
		System.out.println("File Uploaded Successfully and Assertion is Passed");

	}

	@AfterMethod
	public void teardown() {
		// browser closer
		driver.close();
	}

}
