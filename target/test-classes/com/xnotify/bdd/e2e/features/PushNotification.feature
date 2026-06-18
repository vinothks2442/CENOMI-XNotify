@e2e @push
Feature: Push Notification Validation

  Background:
    Given user navigates to login page
    When user enters username
    And user enters password
    And user clicks on login button
    Then user should be redirected to dashboard page
    And dashboard page should be displayed successfully
    When user navigates to Campaign Builder module

@pushTests01
  Scenario: Validate push notification received in mobile
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Welcome Series"
    And user selects campaign goal as "Engagement"
    And user selects audience as "Segment" and target audience as "All Users"
    And user clicks visual flow buildert tab
    And user adds "Push" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully
    Then user validates notification in mobile
