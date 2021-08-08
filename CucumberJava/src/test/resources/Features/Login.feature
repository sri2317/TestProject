@smokeFeature
Feature: feature to test login functionlaity

  @smoketest
  Scenario Outline: Check login is successful with valid credentials
    Given user is on login page
    When user enters<username>and<password>
    And clicks on login button
    Then user is successfully logged in!

    Examples: 
      | username| password  |
      | test@qa-experience.com  | Password1 |
      | test1@qa-experience.com | Password2 |
      