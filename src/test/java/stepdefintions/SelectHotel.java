package stepdefintions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class SelectHotel {
	
	WebDriver driver;
	WebElement locationwebelement;
	Select locationdropdown;
	String username,password;

	
	@Given("user is in select hotel page") 
	public void user_is_in_select_hotel_page(DataTable datatable) { 
		
		
		List<Map<String,String>> credentials = datatable.asMaps(String.class,String.class);
		
		username = credentials.get(0).get("username");
		password = credentials.get(0).get("password");
		
		driver = DriverFactory.getDriver();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Adactin.com - Hotel Reservation System"));
		driver.findElement(By.id("username")).clear();
		
		driver.findElement(By.id("username")).sendKeys(username);
		
		driver.findElement(By.id("password")).clear();		
		
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.id("login")).click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Adactin.com - Search Hotel"));
		
	    locationwebelement = driver.findElement(By.id("location")); // or By.name, By.xpath etc.
	    locationdropdown = new Select(locationwebelement); 
	    locationdropdown.selectByVisibleText("Brisbane");
	    
	    driver.findElement(By.id("Submit")).click();
	    
	    Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Adactin.com - Select Hotel"));	
	    
	}
	
	@Given("user is in select hotel page with more than one number of rooms")
	public void user_is_in_select_hotel_page_with_more_than_one_number_of_rooms(DataTable datatable) { 
		
		
List<Map<String,String>> credentials = datatable.asMaps(String.class,String.class);
		
		username = credentials.get(0).get("username");
		password = credentials.get(0).get("password");
		
		driver = DriverFactory.getDriver();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Adactin.com - Hotel Reservation System"));
		driver.findElement(By.id("username")).clear();
		
		driver.findElement(By.id("username")).sendKeys(username);
		
		driver.findElement(By.id("password")).clear();		
		
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.id("login")).click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Adactin.com - Search Hotel"));
		
	    locationwebelement = driver.findElement(By.id("location")); // or By.name, By.xpath etc.
	    locationdropdown = new Select(locationwebelement); 
	    locationdropdown.selectByVisibleText("Brisbane");
	    
	    
	    
	    
	    driver.findElement(By.id("Submit")).click();
	    
	    Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Adactin.com - Select Hotel"));
		
	}

	
	@Then("welcome message should show up")
	public void welcome_message_should_show_up() {
		
		Assert.assertTrue(driver.findElement(By.className("welcome_menu")).getText().contains("Welcome to Adactin Group"));
		
		
	}
	
	@Then("hello user name message should show up")
	public void user_name_should_show_up_correctly() {
		
		String rightWelcomeMenu = driver.findElement(By.cssSelector(".welcome_menu[align='right']")).getText();
		Assert.assertTrue(rightWelcomeMenu.contains(username+""));
		
	
	}
	
	
	@And("user clicks on search hotel link from select hotel page")
	public void user_clicks_on_search_hotel_link_from_select_hotel_page() {
		
		driver = GenericElements.user_clicks_on_search_hotel_link(driver);
		
								
	}
	
	@Then("search hotel page opens up on click from select hotel")
	public void search_hotel_page_opens_up_from_select_hotel(){
		
		System.out.println("inside search hotel page");
		driver = GenericElements.search_hotel_page_opens_up(driver);
		
		
	}
	
	@And("user clicks on book itenerary link from select hotel page")
	public void user_clicks_on_book_itenerary_link_from_select_hotel_page() {
		
		driver.findElement(By.xpath("//a[normalize-space()='Booked Itinerary']")).click();
		
	}


	@Then("book itenerary page opens up from select hotel page")
	public void book_itenerary_page_opens_up_from_select_hotel() {
		
		Assert.assertTrue(driver.findElement(By.className("login_title")).getText().equals("Booked Itinerary"));
		
	}
	

@Given("user clicks on change password link from select hotel page")
public void user_clicks_on_change_password_link_from_select_hotel_page() {
	
	driver.findElement(By.xpath("//a[normalize-space()='Change Password']")).click();
	
}

@Then("change password page opens up from select hotel page")
public void change_password_page_opens_up_from_select_hotel_page() {

	Assert.assertTrue(driver.findElement(By.xpath("//strong[normalize-space()='Change Password']")).getText().equals("Change Password"));
}

@Given("user clicks on logout link from select hotel page")
public void user_clicks_on_logout_link_from_select_hotel_page() {
	
	driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
}

@Then("logout page opens up from select hotel page")
public void logout_page_opens_up_from_select_hotel_page() {
	
	Assert.assertTrue(driver.findElement(By.xpath("//td[@class='reg_success']")).getText().contains("You have successfully logged out."));

}

@Then("the column titles of select hotel page shows up correctly")
public void the_column_titles_of_select_hotel_page_shows_up_correctly  () {

	WebElement resultsTable = driver.findElement(By.xpath("//td[@align='right']//table"));
	WebElement firstRow = resultsTable.findElements(By.tagName("tr")).get(0);  
	List<WebElement> firstColumnTitle = firstRow.findElements(By.tagName("td"));
	String[] expectedColumnTitles = {"Select", "Hotel Name", "Location", "Rooms", 
			                         "Arrival Date", "Departure Date", "No. of Days", 
			                         "Rooms Type", "Price per Night",  "Total Price (excl. GST)" };
	String actualColumnTitle= null;
	
	for(int i=0; i< firstColumnTitle.size();i++) {
	
		actualColumnTitle = firstColumnTitle.get(i).findElement(By.tagName("strong")).getText();
        Assert.assertTrue(actualColumnTitle.equals(expectedColumnTitles[i]));
	}
	
}

@Then("results table title shows up correctly")
public void results_table_title_shows_up_correctly() {

	String tableTitle = driver.findElement(By.xpath("//td[@class='login_title']")).getText();
	System.out.println(tableTitle);
	Assert.assertTrue(tableTitle.equals("Select Hotel"));
	
}

@Then("user should be able to select a hotel")
public void user_should_be_able_to_select_a_hotel() {
	
	WebElement resultsTable = driver.findElement(By.xpath("//td[@align='right']//table"));
	List<WebElement> resultRows = resultsTable.findElements(By.tagName("tr"));  
	 
	
	for(int i=1; i < resultRows.size(); i++) {
		
		List<WebElement> resultColumns = resultRows.get(i).findElements(By.tagName("td"));
		
	
			WebElement radioButton = resultColumns.get(0).findElement(By.tagName("input"));
			radioButton.click();
			Assert.assertTrue(radioButton.isSelected());
			
		
		
	}
	
	
	
}

@Then("columns are readonly")
public void columns_are_readonly() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}


@Then("total price is calculated according to number of rooms")
public void total_price_is_calculated_according_to_number_of_rooms() {
	
	//System.out.println("toCheckTotalPriceCalcin select hotel:"+SearchHotel.toCheckTotalPriceCalc); 
	for(int i=0;i< SearchHotel.toCheckTotalPriceCalc;i++) {
		
		System.out.println( "totalPriceArray[i]:"+SearchHotel.totalPriceArray[i]);
		System.out.println( "pricePerNightArray[i]:"+SearchHotel.pricePerNightArray[i]);
	
	    Assert.assertTrue(SearchHotel.totalPriceArray[i]==SearchHotel.pricePerNightArray[i]);	
	}

	
	
	
}

@Then("total price is calculated according to number of days")
public void total_price_is_calculated_according_to_number_of_days() {
  

	//System.out.println("toCheckTotalPriceCalcin select hotel:"+SearchHotel.toCheckTotalPriceCalcWithNoofDays); 
	for(int i=0;i< SearchHotel.toCheckTotalPriceCalcWithNoofDays;i++) {
		
		/*System.out.println( "noOfDaysArray[i]::"+SearchHotel.noOfDaysArray[i]);
		System.out.println( "totalPriceArray[i]:"+SearchHotel.totalPriceArray[i]);
		System.out.println( "pricePerNightArray[i]:"+SearchHotel.pricePerNightArray[i]);*/
	
	    Assert.assertTrue(SearchHotel.totalPriceArray[i]==(SearchHotel.noOfDaysArray[i]*SearchHotel.pricePerNightArray[i]));	
	}
	
	
}

@Given("user clicks on continue button")
public void user_clicks_on_continue_button() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
@Then("system prompts to select a hotel to continue")
public void system_prompts_to_select_a_hotel_to_continue() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("user selects a hotel from select hotel page")
public void user_selects_a_hotel_from_select_hotel_page() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}



@Given("user clicks on cancel button")
public void user_clicks_on_cancel_button() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}



	
}
