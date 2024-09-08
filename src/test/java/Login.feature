@Regression
Feature: User Login

  Scenario Outline: Unsuccessful login with incorrect credentials
    Given the user is on the login page
    When the user enters "<username>" as the username
    And enters "<password>" as the password
    And clicks the login button
    Then an error message "Invalid username or password" should be displayed

    Examples:
      | username                | password     |
      | raman.kumar@idsil.com   | password@123 |

  Scenario Outline: Successful login with correct credentials
    Given the user is on the login page
    When the user enters "<username>" as the username
    And enters "<password>" as the password
    And clicks the login button
    Then the user should be redirected to the dashboard

    Examples:
      | username               | password     |
      | rahul.jawa@idsil.com  | password@123 |
