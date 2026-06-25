@smoke

Feature: Login Page Feature

Background:
  Given User is on the home Page of Automation labs
  When user clicks on login button from My Account Option
  Then user validates the title of the page "Account Login"
  Then validates user is the on the login page

  Scenario Outline: Invalid Login

    When user enters email and password "<email>" "<password>"
    When user clicks on login button
    When user validates error message "<errorMsg>"
    ##When user signs out

    Examples:
      | email     | password | errorMsg        |
      | Anu       | Radha    | No match for E-Mail Address and/or Password   |


  Scenario: Login Page Options

    Then user validates register Account and Continue button displayed
    And user validates forgot password link is displayed
    And user validates the different options in right side of the page
    |Login  |
    |Register|
    |Forgotten Password|
    |My Account|
    |Address Book|
    |Wish List   |
    |Order History|
    |Downloads    |
    |Recurring payments|
    |Reward Points     |
    |Returns           |
    |Transactions      |
    |Newsletter        |
