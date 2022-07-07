Feature: User should be able to login with correct credentials

  Background:
    Given user is in web table login page

  @webAppLogin
  Scenario: Web table login scenario
    When user enters username "Test"
    And user enters password "Tester"
    Then user should see url contains orders

  @wip
  Scenario: positive login scenario
    When user enters username "Test" , password "Tester" and login
    Then user should see url contains orders

  @wip
  Scenario: map data yable practice
    When user enters below credentials
    | username | Test |
    | password | Tester |
