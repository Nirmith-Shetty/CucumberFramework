Feature: validate user is able to add a new customer

  Background:
    Given User is logged in and on home page

  @Sanity
  Scenario Outline: Add customer feature
    When user clicks on customers option on left menu
    And clicks on customers option
    Then customer page should open
    And user clicks on Add new
    And user fills all the details according the excel data for below mentioned "<testCaseIds>" and "<sheetName>" Sheet
    And clicks on save
    Examples:
      | testCaseIds |  | sheetName |
      | 4           |  | Sample    |
