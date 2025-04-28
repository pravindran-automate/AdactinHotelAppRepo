@ignore
Feature: UserRegistration

Scenario: Try registering by only clicking on Register button

Given user is in user registration page
And user clicks on register button
Then mandatory field validation message should appear

Scenario: Try registering by not entering user name

Given user is in user registration page
And user enters all mandatory fields except user name
Then mandatory field validation message for username should appear


    
Scenario: Try registering by not entering password

Given user is in user registration page
And user enters all mandatory fields except password
Then mandatory field validation message for password should appear 

Scenario: Try registering by not entering confirm password

Given user is in user registration page
And user enters all mandatory fields except confirm password
Then mandatory field validation message for confirm password should appear

Scenario: Try registering by not entering fullname

Given user is in user registration page
And user enters all mandatory fields except fullname
Then mandatory field validation message for fullname should appear

Scenario: Try registering by not entering emailaddress

Given user is in user registration page
And user enters all mandatory fields except emailaddress
Then mandatory field validation message for emailaddress should appear


Scenario: Try registering by not entering capcha

Given user is in user registration page
And user enters all mandatory fields except capcha
Then mandatory field validation message for capcha should appear

Scenario: Try registering by not selecting terms

Given user is in user registration page
And user enters all mandatory fields except terms
Then mandatory field validation message for terms should appear


Scenario: Try registering by using existing username

Given user is in user registration page
And user enters all mandatory fields
And user enters an existing username
Then mandatory message for an existing username should appear

Scenario: Try registering by entering mismatching passwords

Given user is in user registration page
And user enters all mandatory fields
And enter a mismatch confirm password
Then mandatory message for mismatching passwords should appear

Scenario: Try registering by entering existing email

Given user is in user registration page
And user enters all mandatory fields
And enter an existing email address
Then mandatory message for existing email address should appear

Scenario: Try registering by entering invalid email address

Given user is in user registration page
And enter an invalid email address
Then mandatory message for invalid email address should appear 

Scenario: verify terms and conditions link

Given user is in user registration page
And user clicks on term and conditions link
Then terms and conditions page opens up 

Scenario: verify goback button

Given user is in user registration page
And user clicks on goback button
Then user login page opens up


Scenario: verify entering full name with space

Given user is in user registration page
And user enters all mandatory fields
And user enters full name with space
Then user should be successfully registered

Scenario: verify entering full name with hyphen

Given user is in user registration page
And user enters all mandatory fields
And user enters full name with hypen
Then user should be successfully registered

Scenario: verify entering full name with period

Given user is in user registration page
And user enters all mandatory fields
And user enters full name with period
Then user should be successfully registered












Scenario: verify reset button

Given user is in user registration page
And user enters all mandatory fields
And click on reset button
Then data in all fields should reset to default








