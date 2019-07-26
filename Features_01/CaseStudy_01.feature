Feature: Registration for TestMe application

  Scenario Outline: Registration process
    Given Launch the testme application
    Then I click on signup button
    Then I enter the  username "<uname>"
    And I enter the  firstname "<fname>"
    And I enter the  lastname "<lname>"
    And I enter the  password "<pswd>"
    And I enter the  confirmpassword "<pswd>"
    And I select the  gender "<gender>"
    And I enter the  email id "<email>"
    And I enter the  mobile number "<mobile>"
    And I enter the  dob "<dob>"
    And I enter the address "<address>"
    And I enter the security question "<security>"
    And I enter the answer "<answer>"
    When I click on register button and verify registration

    Examples: 
      | uname    | fname    | lname   | pswd    | gender | email              | mobile     | dob        | address            | security                   | answer |
      | fgmnkIzx | fvjcgBdv | dfbghdh | mnbvcxz | Male   | fgmnkizx@gmail.com | 9876543210 | 06/05/1998 | asdfghjkloiyuwetyu | What is your favour color? | black  |
