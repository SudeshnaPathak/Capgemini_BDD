Feature: Check login functionality

@smoke
Scenario: Test the Login Functionality
    Given user is on the login page
    When user enters valid "rmgyantra" and "rmgy@9999" and clicks on login button
    Then user is navigated to the home page

@regression  
Scenario: Test the Login Functionality
    Given user is on the login page
    When user enters valid "rmgyantra" and "rmgy@9999" and clicks on login button
    Then user is navigated to the home page