@mycampaign
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

  @WelcomeSeries_Email
  Scenario: TC_002 Verify Welcome Series campaign using Email node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Welcome Series"
    And user selects campaign goal as "Engagement"
    And user selects audience as "Segment" and target audience as "All Users"
    And user clicks visual flow buildert tab
    And user adds "Email" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @WelcomeSeries_Push
  Scenario: TC_003 Verify Welcome Series campaign using Push node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Welcome Series"
    And user selects campaign goal as "Conversion"
    And user selects audience as "Segment" and target audience as "Inactive Users"
    And user clicks visual flow buildert tab
    And user adds "Push" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @WelcomeSeries_Inapp
  Scenario: TC_003 Verify Welcome Series campaign using Push node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Welcome Series"
    And user selects campaign goal as "Conversion"
    And user selects audience as "Segment" and target audience as "All Users"
    And user clicks visual flow buildert tab
    And user adds "In-App" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @WelcomeSeries_Email
  Scenario: TC_004 Verify Welcome Series campaign using Email node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Welcome Series"
    And user selects campaign goal as "Conversion"
    And user selects audience as "Segment" and target audience as "Active Users"
    And user clicks visual flow buildert tab
    And user adds "Email" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @WelcomeSeries_Push
  Scenario: TC_005 Verify Welcome Series campaign using Push node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Welcome Series"
    And user selects campaign goal as "Retention"
    And user selects audience as "Segment" and target audience as "All Users"
    And user clicks visual flow buildert tab
    And user adds "Push" node in visual flow
    And user clicks schedule tab
    And user configures "Scheduled" schedule type
    And user selects desired date and time as "10-10-2026" and "10:10"
    And user clicks save and publish button
    Then campaign should be created successfully

  @WelcomeSeries_Email
  Scenario: TC_006 Verify Welcome Series campaign using Email node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Welcome Series"
    And user selects campaign goal as "Retention"
    And user selects audience as "Segment" and target audience as "All Users"
    And user clicks visual flow buildert tab
    And user adds "Email" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @WelcomeSeries_Push
  Scenario: TC_007 Verify Welcome Series campaign using Push node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Welcome Series"
    And user selects campaign goal as "Awareness"
    And user selects audience as "Segment" and target audience as "Inactive Users"
    And user clicks visual flow buildert tab
    And user adds "Push" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @WelcomeSeries_Email
  Scenario: TC_008 Verify Welcome Series campaign using Email node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Welcome Series"
    And user selects campaign goal as "Awareness"
    And user selects audience as "Segment" and target audience as "Active Users"
    And user clicks visual flow buildert tab
    And user adds "Email" node in visual flow
    And user clicks schedule tab
    And user configures "Scheduled" schedule type
    And user selects desired date and time as "10-10-2026" and "10:10"
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_009_Promotional_Push
  Scenario: TC_009 Verify Promotional campaign using Push node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Promotional"
    And user selects campaign goal as "Engagement"
    And user selects audience as "Segment" and target audience as "All Users"
    And user clicks visual flow buildert tab
    And user adds "Push" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_010_Promotional_Email
  Scenario: TC_010 Verify Promotional campaign using Email node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Promotional"
    And user selects campaign goal as "Engagement"
    And user selects audience as "Segment" and target audience as "New Users"
    And user clicks visual flow buildert tab
    And user adds "Email" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_011_Promotional_Push
  Scenario: TC_011 Verify Promotional campaign using Push node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Promotional"
    And user selects campaign goal as "Conversion"
    And user selects audience as "Segment" and target audience as "Inactive Users"
    And user clicks visual flow buildert tab
    And user adds "Push" node in visual flow
    And user clicks schedule tab
    And user configures "Scheduled" schedule type
    And user selects desired date and time as "10-10-2026" and "10:10"
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_012_Promotional_Email
  Scenario: TC_012 Verify Promotional campaign using Email node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Promotional"
    And user selects campaign goal as "Conversion"
    And user selects audience as "Segment" and target audience as "Active Users"
    And user clicks visual flow buildert tab
    And user adds "Email" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_013_Promotional_Push
  Scenario: TC_013 Verify Promotional campaign using Push node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Promotional"
    And user selects campaign goal as "Retention"
    And user selects audience as "Segment" and target audience as "All Users"
    And user clicks visual flow buildert tab
    And user adds "Push" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_014_Promotional_Email
  Scenario: TC_014 Verify Promotional campaign using Email node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Promotional"
    And user selects campaign goal as "Retention"
    And user selects audience as "Segment" and target audience as "New Users"
    And user clicks visual flow buildert tab
    And user adds "Email" node in visual flow
    And user clicks schedule tab
    And user configures "Scheduled" schedule type
    And user selects desired date and time as "10-10-2026" and "10:10"
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_015_Promotional_Push
  Scenario: TC_015 Verify Promotional campaign using Push node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Promotional"
    And user selects campaign goal as "Awareness"
    And user selects audience as "Segment" and target audience as "Inactive Users"
    And user clicks visual flow buildert tab
    And user adds "Push" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_016_Promotional_Email
  Scenario: TC_016 Verify Promotional campaign using Email node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Promotional"
    And user selects campaign goal as "Awareness"
    And user selects audience as "Segment" and target audience as "Active Users"
    And user clicks visual flow buildert tab
    And user adds "Email" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_017_Transactional_Push
  Scenario: TC_017 Verify Transactional campaign using Push node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Transactional"
    And user selects campaign goal as "Engagement"
    And user selects audience as "Segment" and target audience as "All Users"
    And user clicks visual flow buildert tab
    And user adds "Push" node in visual flow
    And user clicks schedule tab
    And user configures "Scheduled" schedule type
    And user selects desired date and time as "10-10-2026" and "10:10"
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_018_Transactional_Email
  Scenario: TC_018 Verify Transactional campaign using Email node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Transactional"
    And user selects campaign goal as "Engagement"
    And user selects audience as "Segment" and target audience as "New Users"
    And user clicks visual flow buildert tab
    And user adds "Email" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_019_Transactional_Push
  Scenario: TC_019 Verify Transactional campaign using Push node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Transactional"
    And user selects campaign goal as "Conversion"
    And user selects audience as "Segment" and target audience as "Inactive Users"
    And user clicks visual flow buildert tab
    And user adds "Push" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_020_Transactional_Email
  Scenario: TC_020 Verify Transactional campaign using Email node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Transactional"
    And user selects campaign goal as "Conversion"
    And user selects audience as "Segment" and target audience as "Active Users"
    And user clicks visual flow buildert tab
    And user adds "Email" node in visual flow
    And user clicks schedule tab
    And user configures "Scheduled" schedule type
    And user selects desired date and time as "10-10-2026" and "10:10"
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_021_Transactional_Push
  Scenario: TC_021 Verify Transactional campaign using Push node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Transactional"
    And user selects campaign goal as "Retention"
    And user selects audience as "Segment" and target audience as "All Users"
    And user clicks visual flow buildert tab
    And user adds "Push" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_022_Transactional_Email
  Scenario: TC_022 Verify Transactional campaign using Email node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Transactional"
    And user selects campaign goal as "Retention"
    And user selects audience as "Segment" and target audience as "New Users"
    And user clicks visual flow buildert tab
    And user adds "Email" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_023_Transactional_Push
  Scenario: TC_023 Verify Transactional campaign using Push node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Transactional"
    And user selects campaign goal as "Awareness"
    And user selects audience as "Segment" and target audience as "Inactive Users"
    And user clicks visual flow buildert tab
    And user adds "Push" node in visual flow
    And user clicks schedule tab
    And user configures "Scheduled" schedule type
    And user selects desired date and time as "10-10-2026" and "10:10"
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_024_Transactional_Email
  Scenario: TC_024 Verify Transactional campaign using Email node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Transactional"
    And user selects campaign goal as "Awareness"
    And user selects audience as "Segment" and target audience as "Active Users"
    And user clicks visual flow buildert tab
    And user adds "Email" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_025_ReEngagement_Push
  Scenario: TC_025 Verify Re-Engagement campaign using Push node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Re-engagement"
    And user selects campaign goal as "Engagement"
    And user selects audience as "Segment" and target audience as "All Users"
    And user clicks visual flow buildert tab
    And user adds "Push" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_026_ReEngagement_Email
  Scenario: TC_026 Verify Re-Engagement campaign using Email node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Re-engagement"
    And user selects campaign goal as "Engagement"
    And user selects audience as "Segment" and target audience as "New Users"
    And user clicks visual flow buildert tab
    And user adds "Email" node in visual flow
    And user clicks schedule tab
    And user configures "Scheduled" schedule type
    And user selects desired date and time as "10-10-2026" and "10:10"
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_027_ReEngagement_Push
  Scenario: TC_027 Verify Re-Engagement campaign using Push node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Re-engagement"
    And user selects campaign goal as "Conversion"
    And user selects audience as "Segment" and target audience as "Inactive Users"
    And user clicks visual flow buildert tab
    And user adds "Push" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_028_ReEngagement_Email
  Scenario: TC_028 Verify Re-Engagement campaign using Email node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Re-engagement"
    And user selects campaign goal as "Conversion"
    And user selects audience as "Segment" and target audience as "Active Users"
    And user clicks visual flow buildert tab
    And user adds "Email" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_029_ReEngagement_Push
  Scenario: TC_029 Verify Re-Engagement campaign using Push node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Re-engagement"
    And user selects campaign goal as "Retention"
    And user selects audience as "Segment" and target audience as "All Users"
    And user clicks visual flow buildert tab
    And user adds "Push" node in visual flow
    And user clicks schedule tab
    And user configures "Scheduled" schedule type
    And user selects desired date and time as "10-10-2026" and "10:10"
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_030_ReEngagement_Email
  Scenario: TC_030 Verify Re-Engagement campaign using Email node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Re-engagement"
    And user selects campaign goal as "Retention"
    And user selects audience as "Segment" and target audience as "New Users"
    And user clicks visual flow buildert tab
    And user adds "Email" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_031_ReEngagement_Push
  Scenario: TC_031 Verify Re-Engagement campaign using Push node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Re-engagement"
    And user selects campaign goal as "Awareness"
    And user selects audience as "Segment" and target audience as "Inactive Users"
    And user clicks visual flow buildert tab
    And user adds "Push" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_032_ReEngagement_Email
  Scenario: TC_032 Verify Re-Engagement campaign using Email node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Re-engagement"
    And user selects campaign goal as "Awareness"
    And user selects audience as "Segment" and target audience as "Active Users"
    And user clicks visual flow buildert tab
    And user adds "Email" node in visual flow
    And user clicks schedule tab
    And user configures "Scheduled" schedule type
    And user selects desired date and time as "10-10-2026" and "10:10"
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_033_LeadNurture_Push
  Scenario: TC_033 Verify Lead Nurture campaign using Push node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Lead Nurture"
    And user selects campaign goal as "Engagement"
    And user selects audience as "Segment" and target audience as "All Users"
    And user clicks visual flow buildert tab
    And user adds "Push" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_034_LeadNurture_Email
  Scenario: TC_034 Verify Lead Nurture campaign using Email node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Lead Nurture"
    And user selects campaign goal as "Engagement"
    And user selects audience as "Segment" and target audience as "New Users"
    And user clicks visual flow buildert tab
    And user adds "Email" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_035_LeadNurture_Push
  Scenario: TC_035 Verify Lead Nurture campaign using Push node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Lead Nurture"
    And user selects campaign goal as "Conversion"
    And user selects audience as "Segment" and target audience as "Inactive Users"
    And user clicks visual flow buildert tab
    And user adds "Push" node in visual flow
    And user clicks schedule tab
    And user configures "Scheduled" schedule type
    And user selects desired date and time as "10-10-2026" and "10:10"
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_036_LeadNurture_Email
  Scenario: TC_036 Verify Lead Nurture campaign using Email node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Lead Nurture"
    And user selects campaign goal as "Conversion"
    And user selects audience as "Segment" and target audience as "Active Users"
    And user clicks visual flow buildert tab
    And user adds "Email" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_037_LeadNurture_Push
  Scenario: TC_037 Verify Lead Nurture campaign using Push node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Lead Nurture"
    And user selects campaign goal as "Retention"
    And user selects audience as "Segment" and target audience as "All Users"
    And user clicks visual flow buildert tab
    And user adds "Push" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_038_LeadNurture_Email
  Scenario: TC_038 Verify Lead Nurture campaign using Email node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Lead Nurture"
    And user selects campaign goal as "Retention"
    And user selects audience as "Segment" and target audience as "New Users"
    And user clicks visual flow buildert tab
    And user adds "Email" node in visual flow
    And user clicks schedule tab
    And user configures "Scheduled" schedule type
    And user selects desired date and time as "10-10-2026" and "10:10"
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_039_LeadNurture_Push
  Scenario: TC_039 Verify Lead Nurture campaign using Push node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Lead Nurture"
    And user selects campaign goal as "Awareness"
    And user selects audience as "Segment" and target audience as "Inactive Users"
    And user clicks visual flow buildert tab
    And user adds "Push" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully

  @TC_040_LeadNurture_Email
  Scenario: TC_040 Verify Lead Nurture campaign using Email node
    When user clicks create campaign button
    And user enters campaign name
    And user enters campaign description as "This is a test campaign created using automation"
    And user selects campaign type as "Lead Nurture"
    And user selects campaign goal as "Awareness"
    And user selects audience as "Segment" and target audience as "Active Users"
    And user clicks visual flow buildert tab
    And user adds "Email" node in visual flow
    And user clicks schedule tab
    And user configures "Send Immediately" schedule type
    And user clicks save and publish button
    Then campaign should be created successfully
  # @validation_Push
  # Scenario: TC_041 Verify validation for Push node
  #   When user clicks create campaign button
  #   And user adds "Push" node in visual flow
  #   And user clicks save and publish button
  #   Then validation message should be displayed
  # @validation_Email
  # Scenario: TC_042 Verify validation for Email node
  #   When user clicks create campaign button
  #   And user adds "Email" node in visual flow
  #   And user clicks save and publish button
  #   Then validation message should be displayed
  # @validation_Push
  # Scenario: TC_043 Verify validation for Push node
  #   When user clicks create campaign button
  #   And user adds "Push" node in visual flow
  #   And user clicks save and publish button
  #   Then validation message should be displayed
  # @validation_Email
  # Scenario: TC_044 Verify validation for Email node
  #   When user clicks create campaign button
  #   And user adds "Email" node in visual flow
  #   And user clicks save and publish button
  #   Then validation message should be displayed
  # @validation_Push
  # Scenario: TC_045 Verify validation for Push node
  #   When user clicks create campaign button
  #   And user adds "Push" node in visual flow
  #   And user clicks save and publish button
  #   Then validation message should be displayed
  # @validation_Email
  # Scenario: TC_046 Verify validation for Email node
  #   When user clicks create campaign button
  #   And user adds "Email" node in visual flow
  #   And user clicks save and publish button
  #   Then validation message should be displayed
  # @validation_Push
  # Scenario: TC_047 Verify validation for Push node
  #   When user clicks create campaign button
  #   And user adds "Push" node in visual flow
  #   And user clicks save and publish button
  #   Then validation message should be displayed
  # @validation_Email
  # Scenario: TC_048 Verify validation for Email node
  #   When user clicks create campaign button
  #   And user adds "Email" node in visual flow
  #   And user clicks save and publish button
  #   Then validation message should be displayed
  # @validation_Push
  # Scenario: TC_049 Verify validation for Push node
  #   When user clicks create campaign button
  #   And user adds "Push" node in visual flow
  #   And user clicks save and publish button
  #   Then validation message should be displayed
  # @validation_Email
  # Scenario: TC_050 Verify validation for Email node
  #   When user clicks create campaign button
  #   And user adds "Email" node in visual flow
  #   And user clicks save and publish button
  #   Then validation message should be displayed
  # @validation_Push
  # Scenario: TC_051 Verify validation for Push node
  #   When user clicks create campaign button
  #   And user adds "Push" node in visual flow
  #   And user clicks save and publish button
  #   Then validation message should be displayed
  # @validation_Email
  # Scenario: TC_052 Verify validation for Email node
  #   When user clicks create campaign button
  #   And user adds "Email" node in visual flow
  #   And user clicks save and publish button
  #   Then validation message should be displayed
  # @validation_Push
  # Scenario: TC_053 Verify validation for Push node
  #   When user clicks create campaign button
  #   And user adds "Push" node in visual flow
  #   And user clicks save and publish button
  #   Then validation message should be displayed
  # @validation_Email
  # Scenario: TC_054 Verify validation for Email node
  #   When user clicks create campaign button
  #   And user adds "Email" node in visual flow
  #   And user clicks save and publish button
  #   Then validation message should be displayed
  # @validation_Push
  # Scenario: TC_055 Verify validation for Push node
  #   When user clicks create campaign button
  #   And user adds "Push" node in visual flow
  #   And user clicks save and publish button
  #   Then validation message should be displayed
  # @validation_Email
  # Scenario: TC_056 Verify validation for Email node
  #   When user clicks create campaign button
  #   And user adds "Email" node in visual flow
  #   And user clicks save and publish button
  #   Then validation message should be displayed
  # @validation_Push
  # Scenario: TC_057 Verify validation for Push node
  #   When user clicks create campaign button
  #   And user adds "Push" node in visual flow
  #   And user clicks save and publish button
  #   Then validation message should be displayed
  # @validation_Email
  # Scenario: TC_058 Verify validation for Email node
  #   When user clicks create campaign button
  #   And user adds "Email" node in visual flow
  #   And user clicks save and publish button
  #   Then validation message should be displayed
  # @validation_Push
  # Scenario: TC_059 Verify validation for Push node
  #   When user clicks create campaign button
  #   And user adds "Push" node in visual flow
  #   And user clicks save and publish button
  #   Then validation message should be displayed
  # @validation_Email
  # Scenario: TC_060 Verify validation for Email node
  #   When user clicks create campaign button
  #   And user adds "Email" node in visual flow
  #   And user clicks save and publish button
  #   Then validation message should be displayed

  @TC_101_SearchCampaignByName @vinothhh
  Scenario: TC_101 Verify user can search campaign using campaign name filter
    When user enters campaign name in search field as "Test009393"
    Then matching campaign records should be displayed

  @TC_102_SearchCampaignByPartialName @vinothhh
  Scenario: TC_102 Verify campaign search supports partial text match
    When user enters campaign name in search field as "Test"
    Then matching campaign records should be displayed

  @TC_103_SearchCampaignWithNoMatchingData @vinothhh
  Scenario: TC_103 Verify no records displayed for invalid campaign search
    When user enters campaign name in search field as "InvalidCampaign123"
    Then no campaign records should be displayed

  @TC_104_SearchCampaignWithSpecialCharacters @vinothhh
  Scenario: TC_104 Verify campaign search behavior with special characters
    When user enters campaign name in search field as "@@@###"
    Then no campaign records should be displayed

  @TC_105_SearchCampaignWithEmptyValue @vinothhh
  Scenario: TC_105 Verify campaign search with empty input
    When user clears campaign search field
    Then all campaign records should be displayed

  @TC_106_FilterByStatus @vinothhh
  Scenario: TC_106 Verify user can filter campaigns by status
    When user selects campaign status as "Sent"
    Then filtered campaigns with status "Sent" should be displayed

  @TC_107_FilterByChannel @vinothhh
  Scenario: TC_107 Verify user can filter campaigns by channel
    When user selects campaign channel as "Push"
    Then filtered campaigns with channel "Push" should be displayed

  @TC_108_FilterByCreator @vinothhh
  Scenario: TC_108 Verify user can filter campaigns by creator
    When user enters creator name as "Test User"
    Then filtered campaigns created by "Test User" should be displayed

  @TC_109_FilterByCreatedDate @vinothhh
  Scenario: TC_109 Verify user can filter campaigns using created date
    When user selects created date as "28-05-2026"
    Then campaigns created on selected date should be displayed

  @TC_110_FilterBySearchAndStatus @vinothhh
  Scenario: TC_110 Verify campaign filtering using campaign name and status
    When user enters campaign name in search field as "Test"
    And user selects campaign status as "Sent"
    Then matching filtered campaign records should be displayed

  @TC_111_FilterBySearchAndChannel @vinothhh
  Scenario: TC_111 Verify campaign filtering using campaign name and channel
    When user enters campaign name in search field as "Test"
    And user selects campaign channel as "Push"
    Then matching filtered campaign records should be displayed

  @TC_112_FilterByStatusAndChannel @vinothhh
  Scenario: TC_112 Verify campaign filtering using status and channel
    When user selects campaign status as "Sent"
    And user selects campaign channel as "Push"
    Then matching filtered campaign records should be displayed

  @TC_113_FilterByCreatorAndStatus @vinothhh
  Scenario: TC_113 Verify campaign filtering using creator and status
    When user enters creator name as "Test User"
    And user selects campaign status as "Sent"
    Then matching filtered campaign records should be displayed

  @TC_114_FilterByAllFilters @vinothhh
  Scenario: TC_114 Verify campaign filtering using all available filters
    When user enters campaign name in search field as "Test009393"
    And user selects campaign status as "Sent"
    And user selects campaign channel as "Push"
    And user enters creator name as "Test User"
    And user selects created date as "28-05-2026"
    Then matching filtered campaign records should be displayed

  @TC_115_FilterResetValidation @vinothhh
  Scenario: TC_115 Verify all filters reset correctly
    When user enters campaign name in search field as "Test"
    And user selects campaign status as "Sent"
    And user clicks reset filter button
    Then all campaign records should be displayed

  @TC_116_FilterByFutureDate @vinothhh
  Scenario: TC_116 Verify filtering using future date
    When user selects created date as "10-10-2035"
    Then no campaign records should be displayed

  @TC_117_FilterWithWhitespace @vinothhh
  Scenario: TC_117 Verify campaign search with leading and trailing spaces
    When user enters campaign name in search field as "   Test009393   "
    Then matching campaign records should be displayed

  @TC_118_FilterCreatorSingleCharacter @vinothhh
  Scenario: TC_118 Verify creator filter supports continuous typing
    When user enters creator name as "T"
    Then creator input field should retain focus

  @TC_119_FilterCombinationNoData @vinothhh
  Scenario: TC_119 Verify filter combination with no matching records
    When user enters campaign name in search field as "Invalid"
    And user selects campaign status as "Failed"
    And user selects campaign channel as "SMS"
    Then no campaign records should be displayed

  @TC_120_FilterPaginationValidation @vinothhh
  Scenario: TC_120 Verify filters work correctly after changing rows per page
    When user selects rows per page as "50"
    And user selects campaign status as "Sent"
    Then filtered campaigns with status "Sent" should be displayed
