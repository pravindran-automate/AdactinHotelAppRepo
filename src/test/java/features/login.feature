@ignore
Feature: Login functionality

Scenario: Launch using valid url

    Given user entered valid url
    Then  adactin login page opens successfully
    
Scenario: Launch using invalid url

    Given user entered invalid url
    Then  adactin login page does not open 
   

Scenario: Login with valid credentials

    Given User has navigated to login page
    When user enters valid user id
    When user enters valid password
    And user clicks on login button
    Then user should be logged in successfully
    
    
Scenario: Login with invalid credentials password

    Given User has navigated to login page
    When user enters valid user id
    When user enters invalid password
    And user clicks on login button
    Then invalid login details message show up
    
Scenario: Login with invalid credentials username

    Given User has navigated to login page
    When user enters invalid user id
    When user enters valid password
    And user clicks on login button
    Then invalid login details message show up
    
Scenario: Login with only username

    Given User has navigated to login page
    When user enters valid user id
    And user clicks on login button
    Then enter password message shows up
    
Scenario: Login with only password

    Given User has navigated to login page
    When user enters valid password
    And user clicks on login button
    Then enter userid message shows up
    
Scenario: Login without entering username or password


    Given User has navigated to login page
    And user clicks on login button
    Then enter userid message shows up
   
    