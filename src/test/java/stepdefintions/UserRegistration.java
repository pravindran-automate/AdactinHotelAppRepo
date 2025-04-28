package stepdefintions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import factory.DriverFactory;

import java.time.Duration;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UserRegistration {
	
	
	public static WebDriver driver;
	String message;
	String originalWindow;
		
	@Given("user is in user registration page")
	public void user_is_in_user_registration_page() {
		
		driver= DriverFactory.getDriver();
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Adactin.com - Hotel Reservation System"));
		driver.findElement(By.xpath("//a[normalize-space()='New User Register Here']")).click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Adactin.com - New User Registration"));
		
		
	}
	
	@Given("user clicks on register button")
	public void user_clicks_on_register_button() {
	   
		driver.findElement(By.id("Submit")).click();
	}
	
	@Then("mandatory field validation message should appear")
	public void mandatory_field_validation_message_should_appear() {
	  
		Assert.assertTrue(driver.findElement(By.xpath("//label[@id='username_span']")).isDisplayed());
		
	}

	
	@Given("user enters all mandatory fields except user name")
	public void user_enters_all_mandatory_fields_except_user_name() {
	
		//driver.findElement(By.id("username")).sendKeys("pravindran");
		driver.findElement(By.id("password")).sendKeys("TestingPwd*");
		driver.findElement(By.id("re_password")).sendKeys("TestingPwd*");
		driver.findElement(By.id("full_name")).sendKeys("Priyadharshini Ravindran");
		driver.findElement(By.id("email_add")).sendKeys("ravindran.priyadharshini@gmail.com");
		
     	System.out.println("⚠️ Please solve the CAPTCHA manually, then press Enter in console...");
	    new java.util.Scanner(System.in).nextLine();
		    	    
		 driver.findElement(By.id("tnc_box")).click();		    
		 user_clicks_on_register_button();   
			
	}
	
	@Then("mandatory field validation message for username should appear")
	public void mandatory_field_validation_message_for_username_should_appear() {
	   
		message = driver.findElement(By.xpath("//label[@id='username_span']")).getText();
		Assert.assertTrue(message.equals("Username is Empty"));
		
	} 												  

	
	@Given("user enters all mandatory fields except password")
	public void user_enters_all_mandatory_fields_except_password() {
		
		driver.findElement(By.id("username")).sendKeys("pravindran");
		driver.findElement(By.id("re_password")).sendKeys("TestingPwd*");
		driver.findElement(By.id("full_name")).sendKeys("Priyadharshini Ravindran");
		driver.findElement(By.id("email_add")).sendKeys("ravindran.priyadharshini@gmail.com");
		
     	System.out.println("⚠️ Please solve the CAPTCHA manually, then press Enter in console...");
	    new java.util.Scanner(System.in).nextLine();
		    	    
		 driver.findElement(By.id("tnc_box")).click();		    
		 user_clicks_on_register_button();   
	}
	
	
	@Then("mandatory field validation message for password should appear")
	public void mandatory_field_validation_message_for_password_should_appear() {
		
		message = driver.findElement(By.xpath("//label[@id='password_span']")).getText();
		Assert.assertTrue(message.equals("Password is Empty"));
		
	}
	
	
	@Given("user enters all mandatory fields except confirm password")
	public void user_enters_all_mandatory_fields_except_confirm_password() {

		driver.findElement(By.id("username")).sendKeys("pravindran");
		driver.findElement(By.id("password")).sendKeys("TestingPwd*");
		//driver.findElement(By.id("re_password")).sendKeys("TestingPwd*");
		driver.findElement(By.id("full_name")).sendKeys("Priyadharshini Ravindran");
		driver.findElement(By.id("email_add")).sendKeys("ravindran.priyadharshini@gmail.com");
		
     	System.out.println("⚠️ Please solve the CAPTCHA manually, then press Enter in console...");
	    new java.util.Scanner(System.in).nextLine();
		    	    
		 driver.findElement(By.id("tnc_box")).click();		    
		 user_clicks_on_register_button(); 	
		
	}
	
	@Then("mandatory field validation message for confirm password should appear")
	public void mandatory_field_validation_message_for_confirm_password_should_appear() {
		
		message = driver.findElement(By.xpath("//label[@id='re_password_span']")).getText();
		Assert.assertTrue(message.equals("Confirm Password is Empty"));
	}
	
	
	@Given("user enters all mandatory fields except fullname")
	public void user_enters_all_mandatory_fields_except_fullname() {

		driver.findElement(By.id("username")).sendKeys("pravindran");
		driver.findElement(By.id("password")).sendKeys("TestingPwd*");
		driver.findElement(By.id("re_password")).sendKeys("TestingPwd*");
		driver.findElement(By.id("email_add")).sendKeys("ravindran.priyadharshini@gmail.com");
		
     	System.out.println("⚠️ Please solve the CAPTCHA manually, then press Enter in console...");
	    new java.util.Scanner(System.in).nextLine();
		    	    
		 driver.findElement(By.id("tnc_box")).click();		    
		 user_clicks_on_register_button(); 	
		 
	}
	
	@Then("mandatory field validation message for fullname should appear")
	public void mandatory_field_validation_message_for_fullname_should_appear() {

		message = driver.findElement(By.xpath("//label[@id='full_name_span']")).getText();
		Assert.assertTrue(message.equals("Full Name is Empty"));
		
	}

	
	@Given("user enters all mandatory fields except emailaddress")
	public void user_enters_all_mandatory_fields_except_emailaddress() {
		
		driver.findElement(By.id("username")).sendKeys("pravindran");
		driver.findElement(By.id("password")).sendKeys("TestingPwd*");
		driver.findElement(By.id("re_password")).sendKeys("TestingPwd*");
		driver.findElement(By.id("full_name")).sendKeys("Priyadharshini Ravindran");
	
     	System.out.println("⚠️ Please solve the CAPTCHA manually, then press Enter in console...");
	    new java.util.Scanner(System.in).nextLine();
		    	    
		 driver.findElement(By.id("tnc_box")).click();		    
		 user_clicks_on_register_button(); 	
		 
	}
	
	
	@Then("mandatory field validation message for emailaddress should appear")
	public void mandatory_field_validation_message_for_emailaddress_should_appear() {

		message = driver.findElement(By.xpath("//label[@id='email_add_span']")).getText();
		Assert.assertTrue(message.equals("Email Address is Empty"));
		
	}
	
	@Given("user enters all mandatory fields except capcha")
	public void user_enters_all_mandatory_fields_except_capcha() {

		driver.findElement(By.id("username")).sendKeys("pravindran");
		driver.findElement(By.id("password")).sendKeys("TestingPwd*");
		driver.findElement(By.id("re_password")).sendKeys("TestingPwd*");
		driver.findElement(By.id("full_name")).sendKeys("Priyadharshini Ravindran");
		driver.findElement(By.id("email_add")).sendKeys("ravindran.priyadharshini@gmail.com");
		driver.findElement(By.id("tnc_box")).click();		    
		user_clicks_on_register_button(); 
		 
	}
	
	
	@Then("mandatory field validation message for capcha should appear")
	public void mandatory_field_validation_message_for_capcha_should_appear() {

		message = driver.findElement(By.xpath("//label[@id='captcha_span']")).getText();
		Assert.assertTrue(message.equals("Captcha is Empty"));
		
	}

	@Given("user enters all mandatory fields except terms")
	public void user_enters_all_mandatory_fields_except_terms() {

		driver.findElement(By.id("username")).sendKeys("pravindran");
		driver.findElement(By.id("password")).sendKeys("TestingPwd*");
		driver.findElement(By.id("re_password")).sendKeys("TestingPwd*");
		driver.findElement(By.id("full_name")).sendKeys("Priyadharshini Ravindran");
		driver.findElement(By.id("email_add")).sendKeys("ravindran.priyadharshini@gmail.com");
     	System.out.println("⚠️ Please solve the CAPTCHA manually, then press Enter in console...");
	    new java.util.Scanner(System.in).nextLine();
		user_clicks_on_register_button(); 
		
		
	}
	
	
	@Then("mandatory field validation message for terms should appear")
	public void mandatory_field_validation_message_for_terms_should_appear() {

		message = driver.findElement(By.xpath("//label[@id='tnc_span']")).getText();
		Assert.assertTrue(message.equals("You must agree to Terms and Conditions"));
		
	}
	
	@Given("user enters all mandatory fields")
	public void user_enters_all_mandatory_fields() {

		driver.findElement(By.id("username")).sendKeys("pravindran");
		driver.findElement(By.id("password")).sendKeys("TestingPwd*");
		driver.findElement(By.id("re_password")).sendKeys("TestingPwd*");
		driver.findElement(By.id("full_name")).sendKeys("Priyadharshini Ravindran");
		driver.findElement(By.id("email_add")).sendKeys("ravindran.priyadharshini@gmail.com");
     	System.out.println("⚠️ Please solve the CAPTCHA manually, then press Enter in console...");
	    new java.util.Scanner(System.in).nextLine();
		driver.findElement(By.id("tnc_box")).click();		    
		
		
	}
	
	
	@Given("user enters an existing username")
	public void user_enters_an_existing_username() {

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("pravindran");
		user_clicks_on_register_button(); 
	}
	
	@Then("mandatory message for an existing username should appear")
	public void mandatory_message_for_an_existing_username_should_appear() {
		
		System.out.println("test7");

		message = driver.findElement(By.xpath("//label[@id='username_span']")).getText();
		System.out.println(message);
		Assert.assertTrue(message.equals("This username is already available"));
		
	}
	
	
	@Given("enter a mismatch confirm password")
	public void enter_a_mismatch_confirm_password() {

		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Testing1*");
		driver.findElement(By.id("re_password")).clear();
		driver.findElement(By.id("re_password")).sendKeys("Sweet1*");
		user_clicks_on_register_button(); 
		
	}
	
	@Then("mandatory message for mismatching passwords should appear")
	public void mandatory_message_for_mismatching_passwords_should_appear() {

		message = driver.findElement(By.xpath("//label[@id='re_password_span']")).getText();
		Assert.assertTrue(message.equals("Passwords Do Not Match"));
		
	}

	@Given("enter an existing email address")
	public void enter_an_existing_email_address() {

		driver.findElement(By.id("email_add")).clear();
		driver.findElement(By.id("email_add")).sendKeys("test@gmail.com");
		user_clicks_on_register_button(); 
		
	}
	
	@Then("mandatory message for existing email address should appear")
	public void mandatory_message_for_existing_email_address_should_appear() {
		
		message = driver.findElement(By.xpath("//label[@id='email_add_span']")).getText();
		Assert.assertTrue(message.equals("Email address is already in use"));
		
	}
	
	@Given("enter an invalid email address")
	public void enter_an_invalid_email_address() {

		driver.findElement(By.id("email_add")).clear();
		driver.findElement(By.id("email_add")).sendKeys("testgmail.com*");
		driver.findElement(By.id("captcha-form")).click();
	}
	
	@Then("mandatory message for invalid email address should appear")
	public void mandatory_message_for_invalid_email_address_should_appear() {
		System.out.println("inside invalid email address method");

		message = driver.findElement(By.xpath("//label[@id='email_add_span']")).getText();
		Assert.assertTrue(message.equals("Invalid email, Please enter correct email."));
		
	}
	
	
	@Given("user clicks on term and conditions link")
	public void user_clicks_on_term_and_conditions_link() {

		originalWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[normalize-space()='Terms & Conditions']")).click();
	}
	
	@Then("terms and conditions page opens up")
	public void terms_and_conditions_page_opens_up() {
		System.out.println("3");
		System.out.println(driver.getTitle());
		
		//control needs to be moved to new window
		
		
		// Wait for the new window or tab
		new WebDriverWait(driver, Duration.ofSeconds(10))
		    .until(ExpectedConditions.numberOfWindowsToBe(2));

		// Get all window handles 
		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {
		    if (!handle.equals(originalWindow)) {
		        driver.switchTo().window(handle); // switch to new window
		        break;
		    }
		}

		Assert.assertTrue(driver.getTitle().equals("Terms and Conditions - AdactIn.com"));
		
	}

	@Given("user clicks on goback button")
	public void user_clicks_on_goback_button() {

		driver.findElement(By.xpath("//a[normalize-space()='Go back to Login page']")).click();
		
	}
	
	@Then("user login page opens up")
	public void user_login_page_opens_up() {

		Assert.assertTrue(driver.getTitle().equals("Adactin.com - Hotel Reservation System"));
	}
	
	@Given("user enters full name with space")
	public void user_enters_full_name_with_space() {
		
		driver.findElement(By.id("full_name")).clear();
		driver.findElement(By.id("full_name")).sendKeys("Iamred Newuser");
		driver.findElement(By.id("email_add")).clear();
		driver.findElement(By.id("email_add")).sendKeys("testsuccessred@gmail.com");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("pravindranred");
		user_clicks_on_register_button(); 
		

		// possibility of hardcoded email address issue
		
	}

	
	@Given("user enters full name with hypen")
	public void user_enters_full_name_with_hypen() {

		driver.findElement(By.id("full_name")).clear();
		driver.findElement(By.id("full_name")).sendKeys("Iamablue-Newuser");
		driver.findElement(By.id("email_add")).clear();
		driver.findElement(By.id("email_add")).sendKeys("testnewyahooblue@gmail.com");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("pravindranblue");
		user_clicks_on_register_button(); 
		
		// possibility of hardcoded email address issue
	}
	

	@Given("user enters full name with period")
	public void user_enters_full_name_with_period() {

		driver.findElement(By.id("full_name")).clear();
		driver.findElement(By.id("full_name")).sendKeys("Iamagreen.Newuser");
		driver.findElement(By.id("full_name")).clear();
		driver.findElement(By.id("full_name")).sendKeys("Iamagreen-Newuser");
		driver.findElement(By.id("email_add")).clear();
		driver.findElement(By.id("email_add")).sendKeys("testnewnewusergreen@gmail.com");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("automatetesting876");
		user_clicks_on_register_button(); 
		// possibility of hardcoded email address issue
	}
	
	@Then("user should be successfully registered")
	public void user_should_be_successfully_registered() {
		
		message = driver.findElement(By.xpath("//td[@class='reg_success']")).getText();
		Assert.assertTrue(message.contains("An email verification code has been sent to your email address"));
	}

	@Given("click on reset button")
	public void click_on_reset_button() {

		driver.findElement(By.id("Reset")).click();
		
	}
	
	@Then("data in all fields should reset to default")
	public void data_in_all_fields_should_reset_to_default() {
		
		Assert.assertTrue(driver.findElement(By.id("username")).getText().isBlank());
		Assert.assertTrue(driver.findElement(By.id("password")).getText().isBlank());
		Assert.assertTrue(driver.findElement(By.id("re_password")).getText().isBlank());
		Assert.assertTrue(driver.findElement(By.id("full_name")).getText().isBlank());
		Assert.assertTrue(driver.findElement(By.id("email_add")).getText().isBlank());
		Assert.assertTrue(driver.findElement(By.id("captcha-form")).getText().isBlank());
		Assert.assertTrue(driver.findElement(By.id("tnc_box")).isEnabled());
		
	}
	

	


}
