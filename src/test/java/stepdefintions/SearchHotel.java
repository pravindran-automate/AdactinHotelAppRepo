package stepdefintions;

import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Date;

import java.util.List;
import java.util.Map;

public class SearchHotel {
	
	WebDriver driver;
	WebElement locationwebelement,totalnoroomswebelement,adultsperroomwebelement, hotelwebelement, roomtypewebelement, numberofroomswebelement;
	Select locationdropdown, totalnoroomsdropdown, adultsperroomdropdown, hoteldropdown, roomtypedropdown, numberofroomsdropdown;
	String location, hotel, roomtype, noofrooms;
	List<Map<String,String>> searchCriterias;
	String searchCase;
	LocalDate today = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	String checkindate, checkoutdate, usernametocheck =null;
	public static int[] totalPriceArray = new int[100],pricePerNightArray = new int[100], noOfDaysArray = new int[100];
	public static int toCheckTotalPriceCalc = 0, toCheckTotalPriceCalcWithNoofDays = 0;
	

@Given("user is in search hotel page") 
public void user_is_in_search_hotel_page(DataTable datatable) { 
	
	List<Map<String,String>> credentials = datatable.asMaps(String.class,String.class);
	
	String username = credentials.get(0).get("username");
	String password = credentials.get(0).get("password");
	usernametocheck = username;
	driver = DriverFactory.getDriver();
	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Adactin.com - Hotel Reservation System"));
	driver.findElement(By.id("username")).clear();
	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).clear();		
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.id("login")).click();
	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Adactin.com - Search Hotel"));

}

@When("user clicks on search button")
public void user_clicks_on_search_button() {
  
	 driver.findElement(By.id("Submit")).click();
	
}

@Then("please select location message should appear")
public void please_select_location_message_should_appear() {

	Boolean mesgexists = driver.findElement(By.xpath("//span[@id='location_span']")).getText().equals("Please Select a Location");
	Assert.assertTrue(mesgexists);
}


@Given("user selects a location")
	public void user_selects_a_location() {
		
	    locationwebelement = driver.findElement(By.id("location")); // or By.name, By.xpath etc.
	    locationdropdown = new Select(locationwebelement); 
	    locationdropdown.selectByVisibleText("Brisbane");
}

@Given("user selects no input for total number of rooms")
	public void user_selects_no_input_for_total_number_of_rooms() {
 
	totalnoroomswebelement = driver.findElement(By.id("room_nos"));
	totalnoroomsdropdown = new Select(totalnoroomswebelement);
	totalnoroomsdropdown.selectByVisibleText("- Select Number of Rooms -");
	
	}

@Then("please select total rooms message should appear")
	public void please_select_total_rooms_message_should_appear() {

		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='num_room_span']")).getText().equals("Please Select Total Number of Rooms"));
	
	}

@Given("user removes the checkindate to leave it blank")
public void user_removes_the_checkindate_to_leave_it_blank() {

	driver.findElement(By.id("datepick_in")).clear();
	
}

@Then("please select checkindate message should appear")
public void please_select_checkindate_message_should_appear() {

	Assert.assertTrue(driver.findElement(By.xpath("//span[@id='checkin_span']")).getText().equals("Please Select Check-In Date"));
}

@Given("user removes the checkout to leave it blank")
public void user_removes_the_checkout_to_leave_it_blank() {

	driver.findElement(By.id("datepick_out")).clear();
}

@Then("please select checkoutdate message should appear")
public void please_select_checkoutdate_message_should_appear() {

	Assert.assertTrue(driver.findElement(By.xpath("//span[@id='checkout_span']")).getText().equals("Please Select Check-Out Date"));
	
}

@And("user selects no input for adults per room")
public void user_selects_no_input_for_adults_per_room() {
	
	adultsperroomwebelement = driver.findElement(By.id("adult_room"));
	adultsperroomdropdown = new Select(adultsperroomwebelement);
	adultsperroomdropdown.selectByVisibleText("- Select Adults per Room -");
	
}

@Then("please select adultsperroom message should appear")
public void please_select_adultsperroom_message_should_appear() {
	
	driver.findElement(By.xpath("//span[@id='adults_room_span']")).getText().equals("Please Select Adults per Room");
	
}


@Given("user selects a hotel")
public void user_selects_a_hotel() {

	hotelwebelement = driver.findElement(By.id("hotels"));
	hoteldropdown = new Select(hotelwebelement);
	hoteldropdown.selectByVisibleText("Hotel Sunshine");
	
	
}
@Given("user selects a roomtype")
public void user_selects_a_roomtype() {
	
	roomtypewebelement = driver.findElement(By.id("room_type"));
	roomtypedropdown = new Select(roomtypewebelement);
	roomtypedropdown.selectByVisibleText("Double");

	
}
@Given("user selects a numberofrooms")
public void user_selects_a_numberofrooms() {

	 numberofroomswebelement = driver.findElement(By.id("room_nos")); 
	 numberofroomsdropdown = new Select(numberofroomswebelement);
	 numberofroomsdropdown.selectByVisibleText("2 - Two");
	
}
@Then("select hotel page opens up")
public void select_hotel_page_opens_up() {

	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Adactin.com - Select Hotel"));

}

@And("user selects a search criterias")
public void user_selects_a_search_criterias(DataTable  data) {
	
	searchCriterias = data.asMaps(String.class,String.class);
	
}

@Then("user clicks on search button and search results display according to criterias")
public void user_clicks_on_search_button_and_search_results_display_according_to_criterias(){

	driver = DriverFactory.getDriver();
	totalPriceArray = new int[100];pricePerNightArray = new int[100]; noOfDaysArray = new int[100]; 
	
	// The loop executes for each row in searchCriterias(list of input data). Mapping the input data to 'criteria' for each row of input data. 
	
	for(Map<String, String> criteria : searchCriterias) {
	
	/* location = searchCriterias.get(i).get("location");
	hotel = searchCriterias.get(i).get("hotel");
	roomtype = searchCriterias.get(i).get("roomtype");
	noofrooms = searchCriterias.get(i).get("noofrooms"); */
		
	location = criteria.get("location");
	hotel = criteria.get("hotel");
	roomtype = criteria.get("roomtype");
	noofrooms = criteria.get("noofrooms");
	 
/*	System.out.println("location:"+location);
	System.out.println("hotel:"+hotel);
	System.out.println("roomtype:"+roomtype);
	System.out.println("noofrooms:"+noofrooms);*/ 
	
    locationwebelement = driver.findElement(By.id("location")); 
    locationdropdown = new Select(locationwebelement); 
    locationdropdown.selectByVisibleText(location);
    
 // checking hotel!=null with respect to test scenario where a hotel is not selected
    
    if(hotel!=null) {
    
	hotelwebelement = driver.findElement(By.id("hotels"));
	hoteldropdown = new Select(hotelwebelement);
	hoteldropdown.selectByVisibleText(hotel);
	
    }
	
	// checking roomtype!=null with respect to test scenario where a room type is not selected
	if(roomtype!=null) {
		
	roomtypewebelement = driver.findElement(By.id("room_type"));
	roomtypedropdown = new Select(roomtypewebelement);
	roomtypedropdown.selectByVisibleText(roomtype);
	
	}

	numberofroomswebelement = driver.findElement(By.id("room_nos")); 
    numberofroomsdropdown = new Select(numberofroomswebelement);
	numberofroomsdropdown.selectByVisibleText(noofrooms);
    driver.findElement(By.id("Submit")).click();
	Then_search_results_match_the_search_criterias();
	
	//System.out.println("i:"+i);
	
	//new java.util.Scanner(System.in).nextLine();
	
	driver.navigate().back();
	
	
	
	}
}


@Then("search results match the search criterias")
public void Then_search_results_match_the_search_criterias() {
	
	
	WebElement resultsTable = driver.findElement(By.xpath("//td[@align='right']//table"));
	List<WebElement> reultsRows = resultsTable.findElements(By.tagName("tr"));
	WebElement inputHotelName, inputLocation, inputNoOfRooms, inputRoomType,inputPricepernight,inputTotalPrice;
	String resultHotelName, resultLocation, resultNoOfRooms, resultRoomType, resultPricepernight, resultTotalPrice;
	

	int intPricePerNight, intTotalPrice,intNumberOfRooms;
	
	//System.out.println(reultsRows.size());
	for(int i=1; i < reultsRows.size(); i++ ) {

	WebElement actualRow = reultsRows.get(i);
	List<WebElement> resultCells = actualRow.findElements(By.tagName("td"));

	inputHotelName = resultCells.get(1).findElement(By.tagName("input"));
	inputLocation = resultCells.get(2).findElement(By.tagName("input"));
	inputNoOfRooms = resultCells.get(3).findElement(By.tagName("input"));
	inputRoomType = resultCells.get(7).findElement(By.tagName("input"));
	inputPricepernight = resultCells.get(8).findElement(By.tagName("input"));
	inputTotalPrice = resultCells.get(9).findElement(By.tagName("input"));

	resultHotelName = inputHotelName.getDomAttribute("value");
	resultLocation = inputLocation.getDomAttribute("value");
	resultNoOfRooms = inputNoOfRooms.getDomAttribute("value").charAt(0)+ "";
	resultRoomType = inputRoomType.getDomAttribute("value");
	
	// Below code to use in select hotel feature
	
	resultPricepernight =  inputPricepernight.getDomAttribute("value");
	resultTotalPrice =  inputTotalPrice.getDomAttribute("value");
	
	/*System.out.println(resultHotelName); 
	System.out.println(resultLocation);
	System.out.println(resultRoomType);
	System.out.println(resultNoOfRooms);
	System.out.println(resultPricepernight.substring(6));
	System.out.println(resultTotalPrice.substring(6));*/
	
	intPricePerNight = Integer.parseInt(resultPricepernight.substring(6));
	intTotalPrice =  Integer.parseInt(resultTotalPrice.substring(6));
	intNumberOfRooms = Integer.parseInt(inputNoOfRooms.getDomAttribute("value").charAt(0)+ "");
	
	/*System.out.println("Number of Rooms:"+intNumberOfRooms);
	System.out.println("PricePerNight:"+intPricePerNight);
	System.out.println("TotalPricee:"+intTotalPrice);*/
	
	totalPriceArray[toCheckTotalPriceCalc] = (intNumberOfRooms*intPricePerNight);
    pricePerNightArray[toCheckTotalPriceCalc] = intTotalPrice;
    System.out.println("toCheckTotalPriceCalc:"+toCheckTotalPriceCalc);
	System.out.println("pricePerNightArray[toCheckTotalPriceCalc]::"+pricePerNightArray[toCheckTotalPriceCalc]);
	System.out.println("totalPriceArray[toCheckTotalPriceCalc]::"+totalPriceArray[toCheckTotalPriceCalc]);
    toCheckTotalPriceCalc++;
	
	
	// above code to use in select hotel feature

	/*System.out.println(hotel);
	System.out.println(location);
	System.out.println(roomtype);
	System.out.println(noofrooms.charAt(0));
	
	
	System.out.println(resultHotelName.equals(hotel));
	System.out.println(resultLocation.equals(location));
	System.out.println(resultRoomType.equals(roomtype));
	System.out.println(resultNoOfRooms.equals(noofrooms.charAt(0)+"")); */
	
	if(hotel!= null) {
		
		Assert.assertTrue(resultHotelName.equals(hotel));
	}
	
	Assert.assertTrue(resultLocation.equals(location));
	
	if(roomtype!=null) {
		
		Assert.assertTrue(resultRoomType.equals(roomtype));
	}
	Assert.assertTrue(resultNoOfRooms.equals(noofrooms.charAt(0)+""));
	
	
	}
}

@And("user enters previous date as checkindate")
public void user_enters_previous_date_as_checkindate() {
	
	System.out.println(today.minusDays(3));	
	driver.findElement(By.id("datepick_in")).clear();
	driver.findElement(By.id("datepick_in")).sendKeys(today.minusDays(3).format(formatter)+"");;
	
	
}

@Then("validation message for checkin date should appear")
public void validation_message_for_checkin_date_should_appear() {
	
	Assert.assertTrue(driver.getTitle().equals("Adactin.com - Search Hotel"));
	
	if(driver.getTitle().equals("Adactin.com - Search Hotel")) {
		
		String checkinvalidationmessage = driver.findElement(By.xpath("//span[@id='checkin_span']")).getText();
		
		Assert.assertTrue(checkinvalidationmessage.equals("Check-In Date shall be before than Check-Out Date")||checkinvalidationmessage.equals("Check-In Date should be either Today or Later Date"));
	
	}
	
} 


@And("user enters an invalid checkindate")
public void user_enters_an_invalid_checkindate() {
	
	driver.findElement(By.id("datepick_in")).clear();
	driver.findElement(By.id("datepick_in")).sendKeys("1");
	
}

@And("user enters a valid checkoutdate")
public void user_enters_a_valid_checkoutdate() {
	
	driver.findElement(By.id("datepick_out")).clear();
	driver.findElement(By.id("datepick_out")).sendKeys(today.plusDays(3).format(formatter)+"");
	
	
}

@And ("user enters a valid checkindate")
public void user_enters_a_valid_checkindate() {
	
	driver.findElement(By.id("datepick_in")).clear();
	driver.findElement(By.id("datepick_in")).sendKeys(today.format(formatter)+"");
	//System.out.println("value in checkin:"+driver.findElement(By.id("datepick_in")).getDomAttribute("value"));
	
}


@And("user enters an invalid checkoutdate")
public void user_enters_an_invalid_checkoutdate() {
	
	driver.findElement(By.id("datepick_out")).clear();
	driver.findElement(By.id("datepick_out")).sendKeys("**()");
	System.out.println("value in checkout2:"+driver.findElement(By.id("datepick_out")).getDomAttribute("value"));
		
}


@Then("validation message for checkout date should appear") 
public void validation_message_for_checkout_date_should_appear () {
	
	Assert.assertTrue(driver.getTitle().equals("Adactin.com - Search Hotel"));
	
	if(driver.getTitle().equals("Adactin.com - Search Hotel")) {
		
		String checkoutvalidationmessage = driver.findElement(By.xpath("//span[@id='checkout_span']")).getText();
		Assert.assertTrue(checkoutvalidationmessage.equals("Check-Out Date shall be after than Check-In Date"));
	
	}
	
}

@When("user selects a search criterias for invalid checkin date")
public void user_selects_a_search_criteria_for_invalid_checkin_date() {
	
		
		driver.findElement(By.id("datepick_in")).clear();
		driver.findElement(By.id("datepick_in")).sendKeys("**()");
		driver.findElement(By.id("datepick_out")).clear();
		driver.findElement(By.id("datepick_out")).sendKeys(today.plusDays(3).format(formatter)+"");
		
	}


@When ("user selects a search criterias with numbers in checkin and checkout date")
public void user_selects_a_search_criterias_with_numbers_in_checkin_and_checkout_date() {
	
	

	driver.findElement(By.id("datepick_in")).clear();
	driver.findElement(By.id("datepick_in")).sendKeys(today.plusDays(1).getDayOfMonth()+"");
	driver.findElement(By.id("datepick_out")).clear();
	driver.findElement(By.id("datepick_out")).sendKeys(today.plusDays(3).getDayOfMonth()+"");
	
	
	
}


@When("user clicks on reset button")
public void user_clicks_on_reset_button() {
	
	driver.findElement(By.id("Reset")).click();	
	
}

@Then("all data entered should change to default value")
public void all_data_entered_should_change_to_default_value() {
	
	String actualLocationValue,actualHotelValue, actualRoomtypeValue, actualTotalNoRoomsValue, actualCheckInDate,actualCheckoutDate, actualadultperroomValue;
	 
	
	locationwebelement= driver.findElement(By.id("location"));
	locationdropdown = new Select(locationwebelement);
	actualLocationValue = locationdropdown.getFirstSelectedOption().getText();
	
	hotelwebelement= driver.findElement(By.id("hotels"));
	hoteldropdown = new Select(hotelwebelement);
	actualHotelValue = hoteldropdown.getFirstSelectedOption().getText();
	
	roomtypewebelement= driver.findElement(By.id("room_type"));
	roomtypedropdown = new Select(roomtypewebelement);
	actualRoomtypeValue = roomtypedropdown.getFirstSelectedOption().getText();
	
	totalnoroomswebelement= driver.findElement(By.id("room_nos"));
	totalnoroomsdropdown = new Select(totalnoroomswebelement);
	actualTotalNoRoomsValue = totalnoroomsdropdown.getFirstSelectedOption().getText();
	
	actualCheckInDate = driver.findElement(By.id("datepick_in")).getDomAttribute("value");
	actualCheckoutDate = driver.findElement(By.id("datepick_out")).getDomAttribute("value");
	
	adultsperroomwebelement= driver.findElement(By.id("adult_room"));
	adultsperroomdropdown = new Select(adultsperroomwebelement);
	actualadultperroomValue = adultsperroomdropdown.getFirstSelectedOption().getText();

	
	Assert.assertTrue(actualLocationValue.equals("- Select Location -"));
	Assert.assertTrue(actualHotelValue.equals("- Select Hotel -"));
	Assert.assertTrue(actualRoomtypeValue.equals("- Select Room Type -"));
	Assert.assertTrue(actualTotalNoRoomsValue.equals("1 - One"));
	Assert.assertTrue(actualCheckInDate.equals(today.format(formatter)+""));
	Assert.assertTrue(actualCheckoutDate.equals(today.plusDays(1).format(formatter)+""));
	Assert.assertTrue(actualadultperroomValue.equals("1 - One"));
	
	
	
}


@And("user clicks on search hotel link")
public void user_clicks_on_search_hotel_link() {
	
	driver.findElement(By.xpath("//a[normalize-space()='Search Hotel']")).click();
	
								
}


@Then("search hotel page opens up")
public void search_hotel_page_opens_up(){
	
	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Adactin.com - Search Hotel"));
	
}

@And("user clicks on book itenerary link")
public void user_clicks_on_book_itenerary_link() {
	
	driver.findElement(By.xpath("//a[normalize-space()='Booked Itinerary']")).click();
	
}


@Then("book itenerary page opens up")
public void book_itenerary_page_opens_up() {
	
	Assert.assertTrue(driver.findElement(By.className("login_title")).getText().equals("Booked Itinerary"));
	
}

@And("user clicks on change password link")
public void user_clicks_on_change_password_link() {
	
	
	driver.findElement(By.xpath("//a[normalize-space()='Change Password']")).click();
	
}

@Then("change password page opens up")
public void change_password_page_opens_up() {
	
	Assert.assertTrue(driver.findElement(By.xpath("//strong[normalize-space()='Change Password']")).getText().equals("Change Password"));
	
}

@And("user clicks on logout link")
public void user_clicks_on_logout_link() {
	
	driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
	
}

@Then("logout page opens up")
public void logout_page_opens_up() {
	
	Assert.assertTrue(driver.findElement(By.xpath("//td[@class='reg_success']")).getText().contains("You have successfully logged out."));
	
}

@Then("no of days are calculated correctly for different checkin and checkout dates")
public void no_of_days_are_calculated_correctly_for_different_checkin_and_checkout_dates() {
	
	int i = 4;
	totalPriceArray = new int[100];pricePerNightArray = new int[100]; noOfDaysArray = new int[100];
	for(Map<String,String> criteria : searchCriterias) {
		
		System.out.println("Case:"+(i-3));
		
		location = criteria.get("location");
		locationwebelement = driver.findElement(By.id("location"));
		locationdropdown = new Select(locationwebelement);
		locationdropdown.selectByValue(location);

		driver.findElement(By.id("datepick_in")).clear();
		driver.findElement(By.id("datepick_in")).sendKeys(today.format(formatter)+"");
    	driver.findElement(By.id("datepick_out")).clear();
		driver.findElement(By.id("datepick_out")).sendKeys(today.plusDays(i).format(formatter)+"");
		driver.findElement(By.id("Submit")).click();
		
		WebElement resultsTable = driver.findElement(By.xpath("//td[@align='right']//table"));
		List<WebElement> reultsRows = resultsTable.findElements(By.tagName("tr"));
		WebElement noOfDays;
		String stringNoofDays;
		
		

		for(int j = 1 ;j< reultsRows.size();j++) {
			
			WebElement actualRow = reultsRows.get(j);
			List<WebElement> resultCells = actualRow.findElements(By.tagName("td"));
			noOfDays = resultCells.get(6).findElement(By.tagName("input"));
			stringNoofDays = noOfDays.getDomAttribute("value");
			
			// Checking if the number of days are calculated correctly
			
			Assert.assertTrue((stringNoofDays.replaceAll("\\D+", "")).equals(""+i));
			
			// below code to check if total price is calculated according to number of days - from select hotel page
			noOfDaysArray[toCheckTotalPriceCalcWithNoofDays] = Integer.parseInt(stringNoofDays.replaceAll("\\D+", ""));
			pricePerNightArray[toCheckTotalPriceCalcWithNoofDays] = Integer.parseInt(resultCells.get(8).findElement(By.tagName("input")).getDomAttribute("value").substring(6));
			totalPriceArray[toCheckTotalPriceCalcWithNoofDays] = Integer.parseInt(resultCells.get(9).findElement(By.tagName("input")).getDomAttribute("value").substring(6));
			toCheckTotalPriceCalcWithNoofDays++;
			
			/*System.out.println("noOfDaysArray[toCheckTotalPriceCalcWithNoofDays]:"+noOfDaysArray[toCheckTotalPriceCalcWithNoofDays]);
			System.out.println("pricePerNightArray[toCheckTotalPriceCalcWithNoofDays]"+pricePerNightArray[toCheckTotalPriceCalcWithNoofDays]);
			System.out.println("totalPriceArray[toCheckTotalPriceCalcWithNoofDays]"+totalPriceArray[toCheckTotalPriceCalcWithNoofDays]);*/


			// above code to check if total price is calculated according to number of days - from select hotel page ends
			
			
			
			
		}
		
		driver.navigate().back();		
		i++;
		
		
	}
	
}




//https://www.youtube.com/watch?v=sQuIRGY0enQ  // Maven cucumber reporting 



}
