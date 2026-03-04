#@SmokeScenario
Feature: feature to test login functionality

  #@SmokeTest
  Scenario Outline: Check login is successful with valid credentials
    Given browser is launched
    And user is on login page
    When user enters "<username>" and "<password>" and clicks on login button
    Then user is navigated to home page

#Data driven testing using parameterization    
 Examples:
| username | password |
| rmgyantra | rmgy@9999|

