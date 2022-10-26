Feature: Search field tests
  Background: Open Amazon Home Page
    Given User is on Home Page

  Scenario: When user enters valid data in the search field, the input should be displayed in the number of results found
    When User enters a valid input in search field

    Then User gets the searched items

    And The inserted data is present within the text showing the number of results found

  Scenario: When user enters invalid data in the search field, should be displayed an error message
    When User enters an invalid input in search field

    Then User gets an error message

    And The searched items are not returned

  Scenario: When user enters valid data in the search field, the keyword should be present in the description from the found items
    When User enters a valid input in search field

    Then User gets a list of items by the search input

    And At least one item should contain the search input
