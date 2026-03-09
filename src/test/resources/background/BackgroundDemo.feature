Feature: Check Home Page functionality

  Background: user is logged in
    Given login page is displayed
    When user enters username and password and clicks on the login button
    Then user navigates to home page

  Scenario: Check whether logout link is active
    When user clicks on profile link
    Then logout link is diplayed

  Scenario: Verify User profile is displayed
    When user clicks on MyInfo link
    Then user profile is displayed
