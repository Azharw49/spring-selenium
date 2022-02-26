Feature: Google Search

  @regression @google
  Scenario Outline: Test Google Search
    Given I am on Google Page
    When I enter the "<search>" text
    And I click on the Search Button
    Then the number of results should be greater than <count>
  Examples:
    | search | count |
    | java   | 2     |
    | spring | 2     |
    | python | 3     |