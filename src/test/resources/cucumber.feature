Feature: Image tab contains images
  As a user
  I want to test Image tab
  So that I can be sure that images are displayed correctly

  Scenario Outline: Check Google image tab contains images
    Given User makes search by '<keyword>'
    When User clicks on image tab
    Then User checks Image tab visibility
    Examples:
      | keyword |
      | images  |
