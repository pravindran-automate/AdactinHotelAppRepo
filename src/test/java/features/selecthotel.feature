
Feature: Select Hotel

Scenario: Verify Welcome Message

    Given user is in select hotel page
      | username       | password  |
      | pravindran     | Sweet@1*  |
    Then welcome message should show up
    
 
Scenario: Verify Hello username


    Given user is in select hotel page
      | username       | password  |
      | pravindran     | Sweet@1*  |
    Then hello user name message should show up 


Scenario: Verify search hotel link
    
    Given user is in select hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    And user clicks on search hotel link from select hotel page
    Then search hotel page opens up on click from select hotel



Scenario: Verify book itenerary link
    
    Given user is in select hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    And user clicks on book itenerary link from select hotel page
    Then book itenerary page opens up from select hotel page

  
Scenario: Verify change password link
    
    Given user is in select hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    And user clicks on change password link from select hotel page
    Then change password page opens up from select hotel page
 
  
Scenario: Verify logout link
    
    Given user is in select hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    And user clicks on logout link from select hotel page
    Then logout page opens up from select hotel page
    
    
Scenario: Verify Column Title
    Given user is in select hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    Then results table title shows up correctly


Scenario: Verify Title of the table
	Given user is in select hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
  Then the column titles of select hotel page shows up correctly 
  
     
Scenario: Verify selecting radio button

    Given user is in select hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    Then user should be able to select a hotel 


Scenario: Verify total price is calculated according to number of rooms
    Given user is in search hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    
    And user selects a search criterias 
    | location   | hotel           | roomtype    | noofrooms     |
    | Adelaide   | Hotel Sunshine  | Double      | 2 - Two       |
    | Sydney     | Hotel Hervey    | Double      | 3 - Three     | 
    | Brisbane   | Hotel Hervey    | Deluxe      | 4 - Four      |
    | London     | Hotel Cornice   | Super Deluxe| 5 - Five      |
    | New York   | Hotel Sunshine  | Deluxe      | 6 - Six       |
    | Los Angeles| Hotel Hervey    | Double      | 9 - Nine      |
    Then user clicks on search button and search results display according to criterias  
    Then total price is calculated according to number of rooms


Scenario: Verify total price is calculated according to number of days

     Given user is in search hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    And user selects a search criterias
    |location  | 
    |Sydney    |
    |Brisbane  |
    |Adelaide  |
    |Paris     |
    |Melbourne |  
    Then no of days are calculated correctly for different checkin and checkout dates
    And total price is calculated according to number of days
    
 
 @ignore   
Scenario: Verify continue button without selecting an option

    Given user is in select hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    And user clicks on continue button
    Then system prompts to select a hotel to continue

@ignore    
Scenario: Verify continue button by selecting a hotel

    Given user is in select hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    And user selects a hotel from select hotel page
    And user clicks on continue button
    Then system prompts to select a hotel to continue

@ignore    
Scenario: Verify cancel button

    Given user is in select hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    And user selects a hotel from select hotel page
    And user clicks on cancel button
    Then search hotel page opens up on click from select hotel
    
 Scenario: Verify column values are read only


