Feature: Login Functionality

  @Test
  Scenario: Login with valid credentials
    When user enters email as "admin@yourstore.com" and password as "admin"
    And clicks on login
    Then Page Title should be "Dashboard / nopCommerce administration"

  @Sanity
  Scenario Outline: Login with invalid email
    When user enters email as "<username>" and password as "admin"
    And clicks on login
    Then error message should be displayed as "<errorMessage>"
    Examples:
      | username             | errorMessage                        |
      | admin@yourstore.com1 | Wrong email                         |
      | admin@yourstorecom   | Wrong email                         |
      | 112839               | Please enter a valid email address. |

  @Sanity
  Scenario: Login with invalid password
    When user enters email as "admin@yourstore.com" and password as "admin1"
    And clicks on login
    Then incorrect password error message should be displayed as "Login was unsuccessful. Please correct the errors and try again." and "The credentials provided are incorrect"

