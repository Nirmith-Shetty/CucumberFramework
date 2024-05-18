Feature: validate user is able to add a new customer

  Background:
  Given User is logged in and on home page

  @Sanity
  Scenario: Add customer feature
    When user clicks on customers option on left menu
    And clicks on customers option
    Then customer page should open
    And user clicks on Add new
    And user fills all the details
    And clicks on save