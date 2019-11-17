Feature: Filter
  As an end user
  I want to apply filters
  So that i can find my desired product range

  @regression
  Scenario: Filter By price
    Given I am on homepages
    When I search for a "cable"
    When I select any product
    Then I should be able to see filtered results