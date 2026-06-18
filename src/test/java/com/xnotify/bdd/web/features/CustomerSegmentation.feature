@CustomerSegmentation
Feature: Customer Segmentation Module Validation

  Background:
    Given user navigates to login page
    When user enters username
    And user enters password
    And user clicks on login button
    Then user should be redirected to dashboard page
    And dashboard page should be displayed successfully

  @TextAttributesWithOrConditions
  Scenario Outline: Verify segmentation using text attributes
    Given user navigates to Customer Segmentation page
    When user clicks Create Segment button
    And user enters segment name
    And users enters segment description as "This is a test segment"
    And user selects segment type as "Dynamic"
    And user selects OR condition
    And user clicks Add Condition button
    And user selects attribute "<Attribute>"
    And user selects operator "<Operator>"
    And user enters condition value "<Value>"
    And user clicks Save Segment button
    Then segment should be created successfully

    Examples:
      | Attribute       | Operator | Value      |
      | User Identifier | =        | User001    |
      | Location        | =        | Riyadh     |
      | App Version     | =        |      1.0.0 |
      | OS Version      | =        | Android 14 |
      | Device Type     | =        | Mobile     |

  @DateAttributes
  Scenario Outline: Verify segmentation using date attributes
    Given user navigates to Customer Segmentation page
    When user clicks Create Segment button
    And user enters segment name
    And users enters segment description as "This is a test segment"
    And user selects segment type as "Dynamic"
    And user selects OR condition
    And user clicks Add Condition button
    And user selects attribute "<Attribute>"
    And user selects operator "<Operator>"
    And user selects date value as "<Value>"
    And user clicks Save Segment button
    Then segment should be created successfully

    Examples:
      | Attribute   | Operator | Value      |
      | Signup Date | after    | 2025-01-01 |
      | Last Active | before   | 2026-01-01 |

  @DropdownAttributes
  Scenario Outline: Verify segmentation using dropdown attributes
    Given user navigates to Customer Segmentation page
    When user clicks Create Segment button
    And user enters segment name
    And users enters segment description as "This is a test segment"
    And user selects segment type as "Dynamic"
    And user clicks Add Condition button
    And user selects attribute "<Attribute>"
    And user selects operator "<Operator>"
    And user enters condition value as "<Value>"
    And user clicks Save Segment button
    Then segment should be created successfully

    Examples:
      | Attribute    | Operator | Value          |
      | Platform     | =        | Android        |
      | Push Enabled | =        | True (Enabled) |

  @DropdownAttributes
  Scenario Outline: Verify segmentation using dropdown attributes
    Given user navigates to Customer Segmentation page
    When user clicks Create Segment button
    And user enters segment name
    And users enters segment description as "This is a test segment"
    And user selects segment type as "Dynamic"
    And user clicks Add Condition button
    And user selects attribute "<Attribute>"
    And user selects operator "<Operator>"
    And user enters condition value as "<Value>"
    And user clicks Save Segment button
    Then segment should be created successfully

    Examples:
      | Attribute    | Operator | Value          |
      | Platform     | =        | Android        |
      | Push Enabled | =        | True (Enabled) |

  @TextAttributesWithAndConditions
  Scenario Outline: Verify segmentation using text attributes
    Given user navigates to Customer Segmentation page
    When user clicks Create Segment button
    And user enters segment name
    And users enters segment description as "This is a test segment"
    And user selects segment type as "Dynamic"
    And user selects AND condition
    And user clicks Add Condition button
    And user selects attribute "<Attribute>"
    And user selects operator "<Operator>"
    And user enters condition value "<Value>"
    And user clicks Save Segment button
    Then segment should be created successfully

    Examples:
      | Attribute       | Operator | Value      |
      | User Identifier | =        | User001    |
      | Location        | =        | Riyadh     |
      | App Version     | =        |      1.0.0 |
      | OS Version      | =        | Android 14 |
      | Device Type     | =        | Mobile     |

  @MultiCondition_AND_Text
  Scenario: Verify customer segment creation with User Identifier and Location using AND condition
    Given user navigates to Customer Segmentation page
    When user clicks Create Segment button
    And user enters segment name
    And users enters segment description as "AND segment with text attributes"
    And user selects segment type as "Dynamic"
    And user selects AND condition
    And user clicks Add Condition button
    And user selects attribute "User Identifier"
    And user selects operator "="
    And user enters condition value "User001"
    And user clicks Add Condition button
    And user selects attribute "Location"
    And user selects operator "="
    And user enters condition value "Riyadh"
    And user clicks Save Segment button
    Then segment should be created successfully

  @MultiCondition_AND_Text_Dropdown
  Scenario: Verify customer segment creation with Location and Platform using AND condition
    Given user navigates to Customer Segmentation page
    When user clicks Create Segment button
    And user enters segment name
    And users enters segment description as "AND segment with text and dropdown"
    And user selects segment type as "Dynamic"
    And user selects AND condition
    And user clicks Add Condition button
    And user selects attribute "Location"
    And user selects operator "="
    And user enters condition value "Riyadh"
    And user clicks Add Condition button
    And user selects attribute "Platform"
    And user selects operator "="
    And user enters condition value as "Android"
    And user clicks Save Segment button
    Then segment should be created successfully

  @MultiCondition_AND_Date_Dropdown
  Scenario: Verify customer segment creation with Signup Date and Push Enabled using AND condition
    Given user navigates to Customer Segmentation page
    When user clicks Create Segment button
    And user enters segment name
    And users enters segment description as "AND segment with date and dropdown"
    And user selects segment type as "Dynamic"
    And user selects AND condition
    And user clicks Add Condition button
    And user selects attribute "Signup Date"
    And user selects operator "after"
    And user selects date value as "2025-01-01"
    And user clicks Add Condition button
    And user selects attribute "Push Enabled"
    And user selects operator "="
    And user enters condition value as "True (Enabled)"
    And user clicks Save Segment button
    Then segment should be created successfully

  @MultiCondition_AND_ThreeAttributes
  Scenario: Verify customer segment creation with Location, Platform and Push Enabled using AND condition
    Given user navigates to Customer Segmentation page
    When user clicks Create Segment button
    And user enters segment name
    And users enters segment description as "Three condition AND segment"
    And user selects segment type as "Dynamic"
    And user selects AND condition
    And user clicks Add Condition button
    And user selects attribute "Location"
    And user selects operator "="
    And user enters condition value "Riyadh"
    And user clicks Add Condition button
    And user selects attribute "Platform"
    And user selects operator "="
    And user enters condition value as "Android"
    And user clicks Add Condition button
    And user selects attribute "Push Enabled"
    And user selects operator "="
    And user enters condition value as "True (Enabled)"
    And user clicks Save Segment button
    Then segment should be created successfully
  # =====================================================
  # MULTIPLE CONDITIONS - OR
  # =====================================================

  @MultiCondition_OR_Text @Multi
  Scenario: Verify customer segment creation with User Identifier and Location using OR condition
    Given user navigates to Customer Segmentation page
    When user clicks Create Segment button
    And user enters segment name
    And users enters segment description as "OR segment with text attributes"
    And user selects segment type as "Dynamic"
    And user selects OR condition
    And user clicks Add Condition button
    And user selects attribute "User Identifier"
    And user selects operator "="
    And user enters condition value "User001"
    And user clicks Add Condition button
    And user selects attribute "Location"
    And user selects operator "="
    And user enters condition value "Riyadh"
    And user clicks Save Segment button
    Then segment should be created successfully

  @MultiCondition_OR_Text_Dropdown @Multi
  Scenario: Verify customer segment creation with Location and Platform using OR condition
    Given user navigates to Customer Segmentation page
    When user clicks Create Segment button
    And user enters segment name
    And users enters segment description as "OR segment with text and dropdown"
    And user selects segment type as "Dynamic"
    And user selects OR condition
    And user clicks Add Condition button
    And user selects attribute "Location"
    And user selects operator "="
    And user enters condition value "Riyadh"
    And user clicks Add Condition button
    And user selects attribute "Platform"
    And user selects operator "="
    And user enters condition value as "Android"
    And user clicks Save Segment button
    Then segment should be created successfully

  @MultiCondition_OR_Date @Multi
  Scenario: Verify customer segment creation with Signup Date and Last Active using OR condition
    Given user navigates to Customer Segmentation page
    When user clicks Create Segment button
    And user enters segment name
    And users enters segment description as "OR segment with date attributes"
    And user selects segment type as "Dynamic"
    And user selects OR condition
    And user clicks Add Condition button
    And user selects attribute "Signup Date"
    And user selects operator "after"
    And user selects date value as "2025-01-01"
    And user clicks Add Condition button
    And user selects attribute "Last Active"
    And user selects operator "before"
    And user selects date value as "2026-01-01"
    And user clicks Save Segment button
    Then segment should be created successfully

  @MultiCondition_OR_ThreeAttributes @Multi
  Scenario: Verify customer segment creation with Platform, Push Enabled and OS Version using OR condition
    Given user navigates to Customer Segmentation page
    When user clicks Create Segment button
    And user enters segment name
    And users enters segment description as "Three condition OR segment"
    And user selects segment type as "Dynamic"
    And user selects OR condition
    And user clicks Add Condition button
    And user selects attribute "Platform"
    And user selects operator "="
    And user enters condition value as "Android"
    And user clicks Add Condition button
    And user selects attribute "Push Enabled"
    And user selects operator "="
    And user enters condition value as "True (Enabled)"
    And user clicks Add Condition button
    And user selects attribute "OS Version"
    And user selects operator "="
    And user enters condition value "Android 14"
    And user clicks Save Segment button
    Then segment should be created successfully

  @ActionOnExistingSegment
  Scenario: Verify editing an existing segment
    Given user navigates to Customer Segmentation page
    When user clicks on the created segment action based on "Device Segment" segment name
    And user selects action as "Edit" from segment action dropdown
    And user updates segment description as "Updated description for the segment"
    And user clicks Save Segment button
    Then segment should be updated successfully

  @TC_101_SearchSegmentByName @vinothhhSegement
  Scenario: TC_101 Verify user can search segments using segment name filter
    Given user navigates to Customer Segmentation page
    When user enters segment name in search field as "Segment"
    Then matching "Segment" records should be displayed in the search results

  @TC_106_FilterBySegmentType @vinothhhSegement
  Scenario: TC_106 Verify user can filter segments by type
    Given user navigates to Customer Segmentation page
    When user selects segment type as "Dynamic" option from segment type filter dropdown
    Then filtered segments with type "Dynamic" should be displayed
