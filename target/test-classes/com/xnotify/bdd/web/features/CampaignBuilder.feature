Feature: XNotifi Campaign Builder Automation

  Background:
    Given user navigates to login page
    When user enters username
    And user enters password
    And user clicks on login button
    Then user should be redirected to dashboard page
    And dashboard page should be displayed successfully
    When user navigates to Campaign Builder module

  @WelcomeSeries_PushBasic
  Scenario: TC_001 Verify Welcome Series campaign using Push node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 1"
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

  @WelcomeSeries_Email
  Scenario: TC_002 Verify Welcome Series campaign using Email node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 2"
    And user selects campaign type as "Welcome Series"
    And user selects campaign goal as "Engagement"
    And user selects audience as "New Users"
    And user adds "Email" node in visual flow
    And user configures "Scheduled" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @WelcomeSeries_Push
  Scenario: TC_003 Verify Welcome Series campaign using Push node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 3"
    And user selects campaign type as "Welcome Series"
    And user selects campaign goal as "Conversion"
    And user selects audience as "Inactive Users"
    And user adds "Push" node in visual flow
    And user configures "Timezone Optimized" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @WelcomeSeries_Email
  Scenario: TC_004 Verify Welcome Series campaign using Email node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 4"
    And user selects campaign type as "Welcome Series"
    And user selects campaign goal as "Conversion"
    And user selects audience as "Active Users"
    And user adds "Email" node in visual flow
    And user configures "Immediate" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @WelcomeSeries_Push
  Scenario: TC_005 Verify Welcome Series campaign using Push node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 5"
    And user selects campaign type as "Welcome Series"
    And user selects campaign goal as "Retention"
    And user selects audience as "All Users"
    And user adds "Push" node in visual flow
    And user configures "Scheduled" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @WelcomeSeries_Email
  Scenario: TC_006 Verify Welcome Series campaign using Email node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 6"
    And user selects campaign type as "Welcome Series"
    And user selects campaign goal as "Retention"
    And user selects audience as "New Users"
    And user adds "Email" node in visual flow
    And user configures "Timezone Optimized" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @WelcomeSeries_Push
  Scenario: TC_007 Verify Welcome Series campaign using Push node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 7"
    And user selects campaign type as "Welcome Series"
    And user selects campaign goal as "Awareness"
    And user selects audience as "Inactive Users"
    And user adds "Push" node in visual flow
    And user configures "Immediate" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @WelcomeSeries_Email
  Scenario: TC_008 Verify Welcome Series campaign using Email node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 8"
    And user selects campaign type as "Welcome Series"
    And user selects campaign goal as "Awareness"
    And user selects audience as "Active Users"
    And user adds "Email" node in visual flow
    And user configures "Scheduled" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @Promotional_Push
  Scenario: TC_009 Verify Promotional campaign using Push node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 9"
    And user selects campaign type as "Promotional"
    And user selects campaign goal as "Engagement"
    And user selects audience as "All Users"
    And user adds "Push" node in visual flow
    And user configures "Timezone Optimized" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @Promotional_Email
  Scenario: TC_010 Verify Promotional campaign using Email node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 10"
    And user selects campaign type as "Promotional"
    And user selects campaign goal as "Engagement"
    And user selects audience as "New Users"
    And user adds "Email" node in visual flow
    And user configures "Immediate" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @Promotional_Push
  Scenario: TC_011 Verify Promotional campaign using Push node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 11"
    And user selects campaign type as "Promotional"
    And user selects campaign goal as "Conversion"
    And user selects audience as "Inactive Users"
    And user adds "Push" node in visual flow
    And user configures "Scheduled" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @Promotional_Email
  Scenario: TC_012 Verify Promotional campaign using Email node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 12"
    And user selects campaign type as "Promotional"
    And user selects campaign goal as "Conversion"
    And user selects audience as "Active Users"
    And user adds "Email" node in visual flow
    And user configures "Timezone Optimized" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @Promotional_Push
  Scenario: TC_013 Verify Promotional campaign using Push node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 13"
    And user selects campaign type as "Promotional"
    And user selects campaign goal as "Retention"
    And user selects audience as "All Users"
    And user adds "Push" node in visual flow
    And user configures "Immediate" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @Promotional_Email
  Scenario: TC_014 Verify Promotional campaign using Email node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 14"
    And user selects campaign type as "Promotional"
    And user selects campaign goal as "Retention"
    And user selects audience as "New Users"
    And user adds "Email" node in visual flow
    And user configures "Scheduled" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @Promotional_Push
  Scenario: TC_015 Verify Promotional campaign using Push node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 15"
    And user selects campaign type as "Promotional"
    And user selects campaign goal as "Awareness"
    And user selects audience as "Inactive Users"
    And user adds "Push" node in visual flow
    And user configures "Timezone Optimized" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @Promotional_Email
  Scenario: TC_016 Verify Promotional campaign using Email node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 16"
    And user selects campaign type as "Promotional"
    And user selects campaign goal as "Awareness"
    And user selects audience as "Active Users"
    And user adds "Email" node in visual flow
    And user configures "Immediate" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @Transactional_Push
  Scenario: TC_017 Verify Transactional campaign using Push node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 17"
    And user selects campaign type as "Transactional"
    And user selects campaign goal as "Engagement"
    And user selects audience as "All Users"
    And user adds "Push" node in visual flow
    And user configures "Scheduled" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @Transactional_Email
  Scenario: TC_018 Verify Transactional campaign using Email node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 18"
    And user selects campaign type as "Transactional"
    And user selects campaign goal as "Engagement"
    And user selects audience as "New Users"
    And user adds "Email" node in visual flow
    And user configures "Timezone Optimized" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @Transactional_Push
  Scenario: TC_019 Verify Transactional campaign using Push node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 19"
    And user selects campaign type as "Transactional"
    And user selects campaign goal as "Conversion"
    And user selects audience as "Inactive Users"
    And user adds "Push" node in visual flow
    And user configures "Immediate" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @Transactional_Email
  Scenario: TC_020 Verify Transactional campaign using Email node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 20"
    And user selects campaign type as "Transactional"
    And user selects campaign goal as "Conversion"
    And user selects audience as "Active Users"
    And user adds "Email" node in visual flow
    And user configures "Scheduled" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @Transactional_Push
  Scenario: TC_021 Verify Transactional campaign using Push node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 21"
    And user selects campaign type as "Transactional"
    And user selects campaign goal as "Retention"
    And user selects audience as "All Users"
    And user adds "Push" node in visual flow
    And user configures "Timezone Optimized" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @Transactional_Email
  Scenario: TC_022 Verify Transactional campaign using Email node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 22"
    And user selects campaign type as "Transactional"
    And user selects campaign goal as "Retention"
    And user selects audience as "New Users"
    And user adds "Email" node in visual flow
    And user configures "Immediate" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @Transactional_Push
  Scenario: TC_023 Verify Transactional campaign using Push node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 23"
    And user selects campaign type as "Transactional"
    And user selects campaign goal as "Awareness"
    And user selects audience as "Inactive Users"
    And user adds "Push" node in visual flow
    And user configures "Scheduled" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @Transactional_Email
  Scenario: TC_024 Verify Transactional campaign using Email node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 24"
    And user selects campaign type as "Transactional"
    And user selects campaign goal as "Awareness"
    And user selects audience as "Active Users"
    And user adds "Email" node in visual flow
    And user configures "Timezone Optimized" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @ReEngagement_Push
  Scenario: TC_025 Verify Re-Engagement campaign using Push node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 25"
    And user selects campaign type as "Re-Engagement"
    And user selects campaign goal as "Engagement"
    And user selects audience as "All Users"
    And user adds "Push" node in visual flow
    And user configures "Immediate" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @ReEngagement_Email
  Scenario: TC_026 Verify Re-Engagement campaign using Email node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 26"
    And user selects campaign type as "Re-Engagement"
    And user selects campaign goal as "Engagement"
    And user selects audience as "New Users"
    And user adds "Email" node in visual flow
    And user configures "Scheduled" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @ReEngagement_Push
  Scenario: TC_027 Verify Re-Engagement campaign using Push node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 27"
    And user selects campaign type as "Re-Engagement"
    And user selects campaign goal as "Conversion"
    And user selects audience as "Inactive Users"
    And user adds "Push" node in visual flow
    And user configures "Timezone Optimized" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @ReEngagement_Email
  Scenario: TC_028 Verify Re-Engagement campaign using Email node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 28"
    And user selects campaign type as "Re-Engagement"
    And user selects campaign goal as "Conversion"
    And user selects audience as "Active Users"
    And user adds "Email" node in visual flow
    And user configures "Immediate" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @ReEngagement_Push
  Scenario: TC_029 Verify Re-Engagement campaign using Push node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 29"
    And user selects campaign type as "Re-Engagement"
    And user selects campaign goal as "Retention"
    And user selects audience as "All Users"
    And user adds "Push" node in visual flow
    And user configures "Scheduled" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @ReEngagement_Email
  Scenario: TC_030 Verify Re-Engagement campaign using Email node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 30"
    And user selects campaign type as "Re-Engagement"
    And user selects campaign goal as "Retention"
    And user selects audience as "New Users"
    And user adds "Email" node in visual flow
    And user configures "Timezone Optimized" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @ReEngagement_Push
  Scenario: TC_031 Verify Re-Engagement campaign using Push node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 31"
    And user selects campaign type as "Re-Engagement"
    And user selects campaign goal as "Awareness"
    And user selects audience as "Inactive Users"
    And user adds "Push" node in visual flow
    And user configures "Immediate" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @ReEngagement_Email
  Scenario: TC_032 Verify Re-Engagement campaign using Email node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 32"
    And user selects campaign type as "Re-Engagement"
    And user selects campaign goal as "Awareness"
    And user selects audience as "Active Users"
    And user adds "Email" node in visual flow
    And user configures "Scheduled" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @LeadNurture_Push
  Scenario: TC_033 Verify Lead Nurture campaign using Push node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 33"
    And user selects campaign type as "Lead Nurture"
    And user selects campaign goal as "Engagement"
    And user selects audience as "All Users"
    And user adds "Push" node in visual flow
    And user configures "Timezone Optimized" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @LeadNurture_Email
  Scenario: TC_034 Verify Lead Nurture campaign using Email node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 34"
    And user selects campaign type as "Lead Nurture"
    And user selects campaign goal as "Engagement"
    And user selects audience as "New Users"
    And user adds "Email" node in visual flow
    And user configures "Immediate" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @LeadNurture_Push
  Scenario: TC_035 Verify Lead Nurture campaign using Push node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 35"
    And user selects campaign type as "Lead Nurture"
    And user selects campaign goal as "Conversion"
    And user selects audience as "Inactive Users"
    And user adds "Push" node in visual flow
    And user configures "Scheduled" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @LeadNurture_Email
  Scenario: TC_036 Verify Lead Nurture campaign using Email node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 36"
    And user selects campaign type as "Lead Nurture"
    And user selects campaign goal as "Conversion"
    And user selects audience as "Active Users"
    And user adds "Email" node in visual flow
    And user configures "Timezone Optimized" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @LeadNurture_Push
  Scenario: TC_037 Verify Lead Nurture campaign using Push node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 37"
    And user selects campaign type as "Lead Nurture"
    And user selects campaign goal as "Retention"
    And user selects audience as "All Users"
    And user adds "Push" node in visual flow
    And user configures "Immediate" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @LeadNurture_Email
  Scenario: TC_038 Verify Lead Nurture campaign using Email node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 38"
    And user selects campaign type as "Lead Nurture"
    And user selects campaign goal as "Retention"
    And user selects audience as "New Users"
    And user adds "Email" node in visual flow
    And user configures "Scheduled" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @LeadNurture_Push
  Scenario: TC_039 Verify Lead Nurture campaign using Push node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 39"
    And user selects campaign type as "Lead Nurture"
    And user selects campaign goal as "Awareness"
    And user selects audience as "Inactive Users"
    And user adds "Push" node in visual flow
    And user configures "Timezone Optimized" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @LeadNurture_Email
  Scenario: TC_040 Verify Lead Nurture campaign using Email node
    When user clicks create campaign button
    And user enters campaign name as "Automation Campaign 40"
    And user selects campaign type as "Lead Nurture"
    And user selects campaign goal as "Awareness"
    And user selects audience as "Active Users"
    And user adds "Email" node in visual flow
    And user configures "Immediate" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @validation_Push
  Scenario: TC_041 Verify validation for Push node
    When user clicks create campaign button
    And user adds "Push" node in visual flow
    And user clicks save and publish button
    Then validation message should be displayed

  @validation_Email
  Scenario: TC_042 Verify validation for Email node
    When user clicks create campaign button
    And user adds "Email" node in visual flow
    And user clicks save and publish button
    Then validation message should be displayed

  @validation_Push
  Scenario: TC_043 Verify validation for Push node
    When user clicks create campaign button
    And user adds "Push" node in visual flow
    And user clicks save and publish button
    Then validation message should be displayed

  @validation_Email
  Scenario: TC_044 Verify validation for Email node
    When user clicks create campaign button
    And user adds "Email" node in visual flow
    And user clicks save and publish button
    Then validation message should be displayed

  @validation_Push
  Scenario: TC_045 Verify validation for Push node
    When user clicks create campaign button
    And user adds "Push" node in visual flow
    And user clicks save and publish button
    Then validation message should be displayed

  @validation_Email
  Scenario: TC_046 Verify validation for Email node
    When user clicks create campaign button
    And user adds "Email" node in visual flow
    And user clicks save and publish button
    Then validation message should be displayed

  @validation_Push
  Scenario: TC_047 Verify validation for Push node
    When user clicks create campaign button
    And user adds "Push" node in visual flow
    And user clicks save and publish button
    Then validation message should be displayed

  @validation_Email
  Scenario: TC_048 Verify validation for Email node
    When user clicks create campaign button
    And user adds "Email" node in visual flow
    And user clicks save and publish button
    Then validation message should be displayed

  @validation_Push
  Scenario: TC_049 Verify validation for Push node
    When user clicks create campaign button
    And user adds "Push" node in visual flow
    And user clicks save and publish button
    Then validation message should be displayed

  @validation_Email
  Scenario: TC_050 Verify validation for Email node
    When user clicks create campaign button
    And user adds "Email" node in visual flow
    And user clicks save and publish button
    Then validation message should be displayed

  @validation_Push
  Scenario: TC_051 Verify validation for Push node
    When user clicks create campaign button
    And user adds "Push" node in visual flow
    And user clicks save and publish button
    Then validation message should be displayed

  @validation_Email
  Scenario: TC_052 Verify validation for Email node
    When user clicks create campaign button
    And user adds "Email" node in visual flow
    And user clicks save and publish button
    Then validation message should be displayed

  @validation_Push
  Scenario: TC_053 Verify validation for Push node
    When user clicks create campaign button
    And user adds "Push" node in visual flow
    And user clicks save and publish button
    Then validation message should be displayed

  @validation_Email
  Scenario: TC_054 Verify validation for Email node
    When user clicks create campaign button
    And user adds "Email" node in visual flow
    And user clicks save and publish button
    Then validation message should be displayed

  @validation_Push
  Scenario: TC_055 Verify validation for Push node
    When user clicks create campaign button
    And user adds "Push" node in visual flow
    And user clicks save and publish button
    Then validation message should be displayed

  @validation_Email
  Scenario: TC_056 Verify validation for Email node
    When user clicks create campaign button
    And user adds "Email" node in visual flow
    And user clicks save and publish button
    Then validation message should be displayed

  @validation_Push
  Scenario: TC_057 Verify validation for Push node
    When user clicks create campaign button
    And user adds "Push" node in visual flow
    And user clicks save and publish button
    Then validation message should be displayed

  @validation_Email
  Scenario: TC_058 Verify validation for Email node
    When user clicks create campaign button
    And user adds "Email" node in visual flow
    And user clicks save and publish button
    Then validation message should be displayed

  @validation_Push
  Scenario: TC_059 Verify validation for Push node
    When user clicks create campaign button
    And user adds "Push" node in visual flow
    And user clicks save and publish button
    Then validation message should be displayed

  @validation_Email
  Scenario: TC_060 Verify validation for Email node
    When user clicks create campaign button
    And user adds "Email" node in visual flow
    And user clicks save and publish button
    Then validation message should be displayed
