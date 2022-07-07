Feature: Data Driver testing using Scenario Outline

  @google_scenario_outline
  Scenario Outline: Google capital cities search
    Given User is on Google search page
    When User searches for "<country>" capital
    Then User should see "<capital>" in the result
    Examples:
      | country   | capital       |
      | Argentina | Buenos Aires  |
      | USA       | Washington, D.C. |
      | Finland   | Helsinki      |
      | France    | Paris         |
      | Iceland   | Reykjavík     |
      | Nepal     | Kathmandu     |
      | Portugal  | Lisbon        |