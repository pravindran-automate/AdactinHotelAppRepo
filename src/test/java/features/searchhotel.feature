  
Feature: Search Hotel

@ignore
Scenario: Verify if location is a mandatory field

    Given user is in select hotel page
      | username       | password  |
      | pravindran     | Sweet@1*  |
    When user clicks on search button
    Then please select location message should appear
          
@ignore
Scenario: Verify if total number of rooms is a mandatory field

    Given user is in search hotel page
      | username       | password  |
      | pravindran     | Sweet@1*  |
    And user selects a location
    And user selects no input for total number of rooms
    When user clicks on search button
    Then please select total rooms message should appear

@ignore
Scenario: Verify if checkin is a mandatory field

    Given user is in search hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    And user selects a location
    And user removes the checkindate to leave it blank 
    When user clicks on search button 
    Then please select checkindate message should appear
    
@ignore  
Scenario: Verify if checkout is a mandatory field

    Given user is in search hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    And user selects a location
    And user removes the checkout to leave it blank
    When user clicks on search button
    Then please select checkoutdate message should appear 

@ignore
Scenario: Verify if adultsperroom is a mandatory field

    Given user is in search hotel page 
    | username       | password  |
    | pravindran     | Sweet@1*  |
    And user selects a location
    And user selects no input for adults per room
    When user clicks on search button
    Then please select adultsperroom message should appear

 @ignore   
Scenario: Verify search results as per search criterias

    Given user is in search hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    And user selects a search criterias 
    | location   | hotel           | roomtype    | noofrooms     |
    | Adelaide   | Hotel Sunshine  | Double      | 2 - Two       |
    | Sydney     | Hotel Hervey    | Double      | 3 - Three     | 
    | Sydney     | Hotel Creek     | Standard    | 1 - One       |
    | Melbourne  | Hotel Sunshine  | Double      | 2 - Two       |
    | Brisbane   | Hotel Hervey    | Deluxe      | 4 - Four      |
    | London     | Hotel Cornice   | Super Deluxe| 5 - Five      |
    | New York   | Hotel Sunshine  | Deluxe      | 6 - Six       |
    | Los Angeles| Hotel Hervey    | Double      | 10 - Ten      |
   
    Then user clicks on search button and search results display according to criterias   

    
    
@ignore
Scenario: Verify search results by not selecting any roomtype

    Given user is in search hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    
    And user selects a search criterias
    | location   | hotel           |noofrooms      |
    | Adelaide   | Hotel Sunshine  | 2 - Two       |
    
   Then user clicks on search button and search results display according to criterias 
    
  
  @ignore 
Scenario: Verify search results by not selecting any hotel

    Given user is in search hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  | 
    
    And user selects a search criterias 
    | location   | roomtype    | noofrooms     |
    | Sydney     | Double      | 3 - Three     | 
    
    Then user clicks on search button and search results display according to criterias 
    
   @ignore 
Scenario: Verify search results by not selecting hotel or roomtype ---  This is failed case,as the data does not return all of them, they return all standard room types only, need to look into this later 

    Given user is in search hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    
    And user selects a search criterias 
    | location   |  noofrooms     |
    | Sydney     |  1 - One       |
    
    Then user clicks on search button and search results display according to criterias 
    
@ignore
Scenario: Verify past date checkin 

    Given user is in search hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    
    And user selects a location
    And user enters previous date as checkindate
    When user clicks on search button
    Then validation message for checkin date should appear 
 @ignore
   
Scenario: Verify invalid checkin date

    Given user is in search hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    
    And user selects a location    
    And user selects a search criterias for invalid checkin date
    When user clicks on search button
    Then validation message for checkin date should appear 
     
     @ignore
Scenario: Verify numbers in checkin and checkout date

    Given user is in search hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    
    And user selects a location    
    And user selects a search criterias with numbers in checkin and checkout date
    When user clicks on search button
    Then validation message for checkin date should appear 
    
   @ignore 
Scenario: Verify invalid checkout date
 
    Given user is in search hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    And user selects a location
    And user enters a valid checkindate
    And user enters an invalid checkoutdate
    When user clicks on search button
    Then validation message for checkout date should appear 
              
 @ignore 
Scenario: Verify different checkin and checkout dates
    
    Given user is in search hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    And user selects a location
    And user enters a valid checkindate 
    And user enters a valid checkoutdate 
    When user clicks on search button
    Then select hotel page opens up 

@ignore    
Scenario: Verify number of days calculation
    
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
    
@ignore
Scenario: Verify reset button

    Given user is in search hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    And user selects a location
    And user selects a hotel
    And user selects a roomtype
    And user selects a numberofrooms
    And user enters a valid checkindate
    And user enters a valid checkoutdate
    When user clicks on reset button
    Then all data entered should change to default value

   @ignore
Scenario: Verify search hotel link
    
    Given user is in search hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    And user selects a location
    And user selects a hotel
    And user selects a roomtype
    And user selects a numberofrooms
    And user enters a valid checkindate
    And user enters a valid checkoutdate
    And user clicks on search hotel link
    Then search hotel page opens up
    Then all data entered should change to default value
    
    
    

 @ignore
Scenario: Verify book itenerary link
    
    Given user is in search hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    And user clicks on book itenerary link
    Then book itenerary page opens up

 @ignore  
Scenario: Verify change password link
    
    Given user is in search hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    And user clicks on change password link
    Then change password page opens up
    
  @ignore
Scenario: Verify logout link
    
    Given user is in search hotel page
    | username       | password  |
    | pravindran     | Sweet@1*  |
    And user clicks on logout link
    Then logout page opens up

    
