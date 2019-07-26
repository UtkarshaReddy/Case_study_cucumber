Feature: Test Me parameterization

  Scenario Outline: Test Me login for multiple users
    Given I am launching the testme application in firefox
    And I click on SignIn link
    Then I provide username "<uname>"
    And I provide password "<pswrd>"
    Then I click on login and verify the login status

    Examples: 
      | uname  | pswrd   |
      | fgmnzxc | mnbvcxz |
      | fgmnzxc | mnbvcxz |
