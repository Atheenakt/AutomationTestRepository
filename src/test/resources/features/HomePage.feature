

Feature: Home Page Feature

  Background:
    Given User is on the home Page of Automation labs

  Scenario: Home Page Header Validation
    Then user validates options displayed in top right of the page
    When user click on MyAccountOption
    Then user validate options displayed for MyAccount

  @smokeTest1
  Scenario Outline: Home page Currency validation and selection

    When user click on currency and selects "<currencyType>"
    Then user validates product price is updated with "<currencyType>"

    Examples:
      | currencyType |
      | € Euro |
      | £ Pound Sterling|
      | $ US Dollar|

  Scenario Outline: Product Selection and validation in Home Page

    When user clicks on LOB product "<productClassification>"
    When user choose product "<product>"
    Then user validates the title of the page "<title>"
    Then user validates user navigated to product listing page

    Examples:
      | productClassification | product  | title    |
      | Components            | Monitors | Monitors |


  Scenario: Validation of Featured option and advertisements in Home Page

    Then user validates featured area present and products are displayed
    Then user Validates available buttons for featured products
    Then user validates advertisements of home page


