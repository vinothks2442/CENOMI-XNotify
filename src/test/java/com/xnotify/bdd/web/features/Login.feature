Feature: Login Functionality
  As a registered user
  I want to login into the application
  So that I can access the system features

  Background:
    Given user navigates to login page

  @Smoke @LoginPositive
  Scenario: Verify user login with valid credentials
    When user enters username
    And user enters password
    And user clicks on login button
    Then user should be redirected to dashboard page
    And dashboard page should be displayed successfully

  @Negative
  Scenario: Verify login with invalid password
    When user enters username as "testuser"
    And user enters password as "WrongPassword"
    And user clicks on login button
    Then user should see error message as "Invalid username or password"

  @Negative
  Scenario: Verify login with invalid username
    When user enters username as "wronguser"
    And user enters password as "Test@123"
    And user clicks on login button
    Then user should see error message as "Invalid username or password"

  @Negative
  Scenario: Verify login with empty username
    When user enters username as ""
    And user enters password as "Test@123"
    And user clicks on login button
    Then user should see validation message as "Username is required"

  @Negative
  Scenario: Verify login with empty password
    When user enters username as "testuser"
    And user enters password as ""
    And user clicks on login button
    Then user should see validation message as "Password is required"

  @Negative
  Scenario: Verify login with empty username and password
    When user enters username as ""
    And user enters password as ""
    And user clicks on login button
    Then user should see validation message as "Username is required"
    And user should see validation message as "Password is required"

  @UI
  Scenario: Verify password is masked
    When user enters password as "Test@123"
    Then password should be displayed in masked format

  @UI
  Scenario: Verify remember me checkbox functionality
    When user enters username as "testuser"
    And user enters password as "Test@123"
    And user selects remember me checkbox
    And user clicks on login button
    Then user should be redirected to dashboard page

  @Functional
  Scenario: Verify forgot password link navigation
    When user clicks on forgot password link
    Then user should be redirected to forgot password page

  @Session
  Scenario: Verify user logout successfully
    Given user logged into application successfully
    When user clicks on logout button
    Then user should be redirected to login page

  @Security
  Scenario: Verify login with SQL injection attempt
    When user enters username as "' OR 1=1 --"
    And user enters password as "password"
    And user clicks on login button
    Then user should see error message as "Invalid username or password"

  @Security
  Scenario: Verify login with special characters
    When user enters username as "@#$%^"
    And user enters password as "@#$%^"
    And user clicks on login button
    Then user should see error message as "Invalid username or password"
