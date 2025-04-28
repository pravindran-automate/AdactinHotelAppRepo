package stepdefintions;

import org.junit.Assert;


import org.openqa.selenium.*;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	
	// website launching
	
	WebDriver driver = DriverFactory.getDriver();
	
	@Given("user entered valid url")
	public void user_entered_valid_url() {
		
		
		
		
		
		}
	
	@Then("adactin login page opens successfully")
	public void adactin_login_page_opens_successfully() {
		
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Adactin.com - Hotel Reservation System")); 
	}
	
	
	@Given("user entered invalid url")
	public void user_entered_invalid_url() throws WebDriverException{
		
	try {
			
			System.out.println("Inside try");
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get("https://adactinhotlapp.com/index.php");
		}catch(WebDriverException e) {
			
			System.out.println("Inside catch");
			Assert.assertTrue(true);
		
		}
		
		
	}
	
	
	@Then("adactin login page does not open")
	public void adactin_login_page_does_not_open() {
		
		Assert.assertTrue(!driver.getTitle().equalsIgnoreCase("Adactin.com - Hotel Reservation System"));
	}
	
	
	// User Login
	
	@Given("User has navigated to login page")
	public void User_has_navigated_to_login_page() {
		
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Adactin.com - Hotel Reservation System"));
		
	}

	
	@When("user enters valid user id")
	public void user_enters_valid_user_id() {
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("pravindran");
		
	}
	
	@When("user enters invalid user id")
	public void user_enters_invalid_user_id() {
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("pravindra");
		
	}
    
	@When("user enters valid password")
	public void user_enters_valid_password() {
		
		driver.findElement(By.id("password")).clear();		
		driver.findElement(By.id("password")).sendKeys("Sweet@1*");
	}
	
	@When("user enters invalid password")
	public void When_user_enters_invalid_password(){
		
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Sw***t@1*");
	}
	
		
    @And("user clicks on login button")
    public void user_click_on_login_button() {
    	
    	driver.findElement(By.id("login")).click();
    	
    }
	
    @Then("user should be logged in successfully")
  public void user_should_be_logged_in_successfully() {
    	
    	    	
    	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Adactin.com - Search Hotel"));
    	
    	
    	
    }
    
    @Then("enter password message shows up")
    public void enter_password_message_shows_up() {
    	
    	System.out.println(driver.findElement(By.xpath("//span[@id='password_span']")).getText());
    	
    	Assert.assertTrue(driver.findElement(By.xpath("//span[@id='password_span']")).getText().equalsIgnoreCase("Enter Password"));
    }
    
    @Then("enter userid message shows up")
    public void enter_userid_message_shows_up() {
    	
        System.out.println(driver.findElement(By.xpath("//span[@id='username_span']")).getText());
    	
    	Assert.assertTrue(driver.findElement(By.xpath("//span[@id='username_span']")).getText().equalsIgnoreCase("Enter Username"));
    }
    
    @Then("invalid login details message show up")
    public void invalid_login_details_message_show_up() {
    	
    	Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(),'Invalid Login details or Your Password might have ')]")).isDisplayed());
    	
    }
    
  
}
