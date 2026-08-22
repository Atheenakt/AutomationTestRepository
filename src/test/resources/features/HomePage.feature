@smoke1

Feature: Home Page Feature

  Background:
    Given User is on the home Page of Automation labs

  Scenario: Home Page Header Validation
    Then user validates options displayed in top right of the page
    When user click on MyAccountOption
    Then user validate options displayed for MyAccount

  Scenario Outline: Home page Currency validation and selection

    Then user validates Currency option
    When user click on currency and selects "<currencyType>"
    Then user validates product price is updated with "<currencyType>"
    Examples:
      | currencyType |
      |              |

  Scenario Outline: Product Selection and validation in Home Page

    When user clicks on LOB and Choose "<productClassification>"
    When user choose product "<product>"
    Then user validates the title of the page "<title>"
    Then user validates user navigated to product listing page

    Examples:
      | productClassification | product  | title    |
      | Components            | Monitors | Monitors |

  Scenario : Validation of Featured option in Home Page

    Then user validates featured option is available in the bottom of the page
    And user validates products are displayed under featured option
    And user Validates available buttons for featured products

