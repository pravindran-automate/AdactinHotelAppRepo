package stepdefintions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GenericElements {
	
	
	public static WebDriver user_clicks_on_search_hotel_link(WebDriver driver) {
		
		System.out.println("inside Generic elements");
		driver.findElement(By.xpath("//a[normalize-space()='Search Hotel']")).click();
		System.out.println("after clicking search hotel");
		return driver;
								
	}

	public static WebDriver search_hotel_page_opens_up(WebDriver driver) {
		
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Adactin.com - Search Hotel"));
	    return driver;
	}
}
