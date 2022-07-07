Feature: Passing multiple parameters to the step


  @dataTable
  Scenario: User searches for multiple items
    Given User is on Google search page
    Then User should be able to search for following:
      | java         |
      | selenium     |
      | cucumber bdd |
      | data driver  |

    #option +Command + L