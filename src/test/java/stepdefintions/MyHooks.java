package stepdefintions;
import java.time.Duration;

import org.openqa.selenium.WebDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;

import factory.DriverFactory;

public class MyHooks {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		
			
	    DriverFactory.initializeBrowser("Chrome");
	    driver = DriverFactory.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://adactinhotelapp.com/");
		
	}
	
	
	
    @After
    public void tearDown() {
    	
    	driver.quit();
    }
    

}
