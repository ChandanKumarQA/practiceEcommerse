Feature: Successfully login user

  Scenario: User logs in with valid email and password

 Given the user is on the login page
    When the user enters a valid email
    And the user enters a valid password
    And the user clicks the login button
     Then the user should be successfully logged in