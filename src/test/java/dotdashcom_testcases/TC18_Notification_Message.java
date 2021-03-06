package dotdashcom_testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC18_Notification_Message extends BaseTest{
	
	//browser starting
	@BeforeMethod
	public void BrowserInvoking()
	{
		
		//receiving url to the browser
		driver.get("http://localhost:7080/notification_message_rendered");
	}
	
	@Test
	public void multiple_click() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a")).click();
		WebElement text_ele = driver.findElement(By.id("flash"));
		String text = text_ele.getText();
		
		System.out.println("Text present is : " +text);
		
		
	
		
		//Test clicks on the Click Here link a multiple times.

	    String text_last_window="Action unsuccesful, please try again" + 
	    		"×";
	    int i = 0;
	    //if "Action successful" is present and it click the link multiple times to get text "Action unsuccesful, please try again"
	    while (text.contains("Action successful" + 
	    		"×") ) 
	    {
	        
	        driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a")).click(); // click the Refresh Status button
	        i++;
	        //breaks from the loop after finding "Action unsuccesful, please try again"
	        if(text_last_window.contains("Action unsuccesful, please try again" + 
	        		"×"))
	        {
	        break;
	        }
	        
	    }
//printing in console the text available at last
	    System.out.println("Text present in last window is: " +text);
	   
	}
	

		
		
		
		

	    
	
	
	
	

}
