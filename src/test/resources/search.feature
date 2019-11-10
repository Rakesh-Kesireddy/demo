Feature: Search
  As an end user
  I want do search
  So that I can see desired products


  Scenario: Search for a product
    Given I am on homepages
    When I search for a "Laptop"
    Then I should be able to see respective products


  Scenario Outline: Search for a product
    Given I am on homepages
    When I search for a "<item>"
    Then I should be able to see respective products

    Examples:
      | item       |
      | cable      |
      | laptop     |
      | pen drive  |
      | hard disk  |
      | television |
