@hotel-regression @hotel-search
Feature: Hotel Search Feature

  Background:
    Given I am on hotel website homepage

  @hotel-search-1
  Scenario: Verify deal of the day price amount
    When I enter destination as New
    And I select destination as New York, New York, United
    And I select checking date as 1 and checkout date as 8
    And I click on room
    And I select more options
    And I select room as 1
    And I select adult as 2
    And I select children as 2
    And I select child one as 2
    And I select child two as 3
    And I click on search button
    Then I verify deal of the day hotel price is between 200 to 300