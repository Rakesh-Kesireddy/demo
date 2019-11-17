@search
Feature: Search
  As an end user
  I want do search
  So that I can see desired products

  Background: ulkjcvlkdjbldfjgldif
    Given I am on homepages

  Scenario: Search for a product
    When I search for a "Laptop"
    Then I should be able to see respective products

  @smoke
  Scenario Outline: Search for a product
    When I search for a "<item>"
    Then I should be able to see respective products

    Examples:
      | item       |
      | cable      |
