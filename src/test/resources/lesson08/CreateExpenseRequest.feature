Feature: create expense request

  Background:
    Given  I am authorized

  Scenario Outline:
    Given I am at expense page
    When I fill '<name>' field
    And I select business unit
    And I select expenditure
    And I select currency
    And I fill sum plan
    And I select date plan
    And I click save and close button
    Then Success message is visible
    Examples:
      | name   |
      | testFirst |
      | testNameForTest  |