package factory;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	static WebDriver driver = null;

	
	public static void initializeBrowser(String browsername) {
	
	
	
		
		if(browsername.equals("Chrome")) {
			
			
			driver = new ChromeDriver();
			
		}else if(browsername.equals("Edge")) {


			driver = new EdgeDriver();
				
	}

	
}

	
	public static WebDriver getDriver(){
		
		return driver;
	} 
	
}