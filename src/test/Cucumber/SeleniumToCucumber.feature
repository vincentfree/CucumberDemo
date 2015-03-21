Feature: Find the cheese

  Scenario: Finding some cheese
    Given I am on the Google search page
    When I search for "apple"
    Then the page title should start with "cheese"