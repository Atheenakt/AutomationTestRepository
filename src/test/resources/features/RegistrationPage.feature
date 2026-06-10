@smoke

Feature: Registration Page Feature

  Scenario Outline: Registration Page Title

    Given User is on the home Page of Automation labs
    When user clicks on registration button from My Account Option
    Then user validates the title of the page "<title>"
    Then validates user is the on the register account page
    When user submit with all the mandatory details "<firstName>" "<lastName>" "<Email>" "<Telephone>" "<password>"
    When user clicks on subscribe Option "<subscribeOption>"
    When user clicks on privacy policy checkbox
    When user clicks on continue button
    #Then User validates account created successfully

    Examples:
      | firstName | lastName | Email        | Telephone  | password | subscribeOption |title|
      | Anu       | Radha    | anu@test.com | 1234567890 | Test@123 | No              |Register Account|
