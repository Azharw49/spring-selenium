Feature: Window Feature

  @regression @window
  Scenario Outline: Open Multiple windows
    Given the user open "https://vins-udemy.s3.amazonaws.com/ds/window/main.html"
    When the user click all links
    And the user switch to "<page>"
    Then the title of the page should be "<pageTitle>"
    Examples:
      | page  | pageTitle |
      | Page A| Page A    |
      | Page B| Page B    |
      | Page C| Page C    |




