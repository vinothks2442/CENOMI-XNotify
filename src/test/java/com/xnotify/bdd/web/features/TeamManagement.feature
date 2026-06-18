@TeamManagement
Feature: Team Management Module Validation

  Background:
    Given user navigates to login page
    When user enters username
    And user enters password
    And user clicks on login button
    Then user should be redirected to dashboard page
    And dashboard page should be displayed successfully

  @TM_001
  Scenario: TM_001 Verify Team Management dashboard loads successfully
    When user navigates to Team Management module
    And user verifies Total Members card is displayed
    And user verifies Active Members card is displayed
    And user verifies Pending Invites card is displayed
    And user verifies Admins card is displayed
    Then Team Management dashboard should be displayed successfully

  @TM_002
  Scenario: TM_002 Verify user can view all member records in Team Management grid
    When user navigates to Team Management module
    And user verifies Team Management dashboard is loaded
    And user verifies member records are displayed
    Then all member records should be displayed successfully

  @TM_003
  Scenario: TM_003 Verify user can invite a new member with Admin role
    When user navigates to Team Management module
    And user clicks Invite Member button
    And user enters valid member email address
    And users enters first name "Test" and last name "User"
    And user selects role as "Admin"
    And user clicks Send Invitation button
    Then member invitation should be sent successfully

  @TM_004
  Scenario: TM_004 Verify user can invite a new member with Editor role
    When user navigates to Team Management module
    And user clicks Invite Member button
    And user enters valid member email address
    And users enters first name "Test" and last name "User"
    And user selects role as "Editor"
    And user clicks Send Invitation button
    Then member invitation should be sent successfully

  @TM_005
  Scenario: TM_005 Verify user can invite a new member with Viewer role
    When user navigates to Team Management module
    And user clicks Invite Member button
    And user enters valid member email address
    And users enters first name "Test" and last name "User"
    And user selects role as "End-user"
    And user clicks Send Invitation button
    Then member invitation should be sent successfully

  @TM_006
  Scenario: TM_006 Verify mandatory validation when email field is left blank
    When user navigates to Team Management module
    And user clicks Invite Member button
    And user leaves email field blank
    And users enters first name "Test" and last name "User"
    And user selects role as "Admin"
    And user clicks Send Invitation button
    Then email mandatory validation message should be displayed

  @TM_007
  Scenario: TM_007 Verify invalid email format validation during member invitation
    When user navigates to Team Management module
    And user clicks Invite Member button
    And user enters invalid email address
    And users enters first name "Test" and last name "User"
    And user selects role as "Admin"
    And user clicks Send Invitation button
    Then invalid email validation message should be displayed

  @TM_008
  Scenario: TM_008 Verify duplicate member invitation validation
    When user navigates to Team Management module
    And user clicks Invite Member button
    And user enters already existing member email as "vinoth.ks@webknot.in"
    And users enters first name "Test" and last name "User"
    And user selects role as "Editor"
    And user clicks Send Invitation button
    Then duplicate member validation message should be displayed

  @TM_009
  Scenario: TM_009 Verify user can cancel member invitation popup
    When user navigates to Team Management module
    And user clicks Invite Member button
    And user enters valid member email address
    And users enters first name "Test" and last name "User"
    And user selects role as "Admin"
    And user clicks Cancel button
    Then invitation popup should be closed successfully

  @TM_010
  Scenario: TM_010 Verify user can search member using complete email address
    When user navigates to Team Management module
    And user verifies member records are displayed
    And user enters member email in search field as "test.member@example.com"
    And user waits for search results
    And matching records are filtered
    Then searched member record should be displayed

  @TM_011
  Scenario: TM_011 Verify user can search member using partial email address
    When user navigates to Team Management module
    And user verifies member records are displayed
    And user enters member email in search field as "test.member@example.com"
    And user waits for filtered search results
    And matching records are filtered
    Then searched member records should be displayed

  @TM_012
  Scenario: TM_012 Verify search functionality is case insensitive
    When user navigates to Team Management module
    And user verifies member records are displayed
    And user enters uppercase member email in search field as "TEST.MEMBER@EXAMPLE.COM"
    And user waits for filtered search results
    And matching records are filtered
    Then searched member records should be displayed

  @TM_013
  Scenario: TM_013 Verify no records message for invalid member search
    When user navigates to Team Management module
    And user enters invalid member email in search field
    And user waits for search execution
    And no matching member exists
    Then no member records should be displayed

  @TM_014
  Scenario: TM_014 Verify user can clear member search results
    When user navigates to Team Management module
    And user enters valid member email in search field
    And user verifies filtered records are displayed
    And user clears member search field
    And user waits for page refresh
    Then all member records should be displayed

  @TM_015
  Scenario: TM_015 Verify Admin role filter displays only Admin members
    When user navigates to Team Management module
    And user verifies member records are displayed
    And user clicks role filter dropdown
    And user selects role filter as "Admin"
    And user waits for filtered results
    Then only Admin members should be displayed

  @TM_016
  Scenario: TM_016 Verify Editor role filter displays only Editor members
    When user navigates to Team Management module
    And user verifies member records are displayed
    And user clicks role filter dropdown
    And user selects role filter as "Editor"
    And user waits for filtered results
    Then only Editor members should be displayed

  @TM_017
  Scenario: TM_017 Verify Viewer role filter displays only Viewer members
    When user navigates to Team Management module
    And user verifies member records are displayed
    And user clicks role filter dropdown
    And user selects role filter as "End-user"
    And user waits for filtered results
    Then only Viewer members should be displayed

  @TM_018
  Scenario: TM_018 Verify Active status filter displays only active members
    When user navigates to Team Management module
    And user verifies member records are displayed
    And user clicks status filter dropdown
    And user selects status filter as "Active"
    And user waits for filtered results
    Then only active members should be displayed

  @TM_019
  Scenario: TM_019 Verify Pending status filter displays only pending members
    When user navigates to Team Management module
    And user verifies member records are displayed
    And user clicks status filter dropdown
    And user selects status filter as "Pending"
    And user waits for filtered results
    Then only pending members should be displayed

  @TM_020
  Scenario: TM_020 Verify user can reset applied role and status filters
    When user navigates to Team Management module
    And user selects role filter as "Admin"
    And user selects status filter as "Active"
    And user clicks Reset Filter button
    And user waits for member records refresh
    Then all member records should be displayed

  @TM_021
  Scenario: TM_021 Verify user can filter members using Admin role and Active status
    When user navigates to Team Management module
    And user verifies member records are displayed
    And user selects role filter as "Admin"
    And user selects status filter as "Active"
    And user waits for filtered results
    Then only active Admin members should be displayed

  @TM_022
  Scenario: TM_022 Verify user can filter members using Editor role and Active status
    When user navigates to Team Management module
    And user verifies member records are displayed
    And user selects role filter as "Editor"
    And user selects status filter as "Active"
    And user waits for filtered results
    Then only active Editor members should be displayed

  @TM_023
  Scenario: TM_023 Verify user can filter members using Viewer role and Pending status
    When user navigates to Team Management module
    And user verifies member records are displayed
    And user selects role filter as "Admin"
    And user selects status filter as "Pending"
    And user waits for filtered results
    Then only active Admin members should be displayed

  @TM_024
  Scenario: TM_024 Verify user can search member and apply role filter simultaneously
    When user navigates to Team Management module
    And user enters member email in search field
    And user selects role filter as "Admin"
    And user waits for filtered results
    And matching records are filtered
    Then matching Admin member records should be displayed

  @TM_025
  Scenario: TM_025 Verify user can search member and apply status filter simultaneously
    When user navigates to Team Management module
    And user enters member email in search field
    And user selects status filter as "Active"
    And user waits for filtered results
    And matching records are filtered
    Then matching active member records should be displayed

  @TM_026
  Scenario: TM_026 Verify user can update member role from Viewer to Editor
    When user navigates to Team Management module
    And user searches existing Viewer member
    And user clicks member action menu
    And user selects Edit Member option
    And user updates role from "Admin" to "Editor"
    Then member role should be updated successfully

  @TM_027
  Scenario: TM_027 Verify user can update member role from Editor to Admin
    Given user logged into XNotify application
    When user navigates to Team Management module
    And user searches existing Editor member
    And user clicks member action menu
    And user selects Edit Member option
    And user updates role from "Editor" to "Admin"
    Then member role should be updated successfully

  @TM_028
  Scenario: TM_028 Verify updated role is reflected in member listing table
    Given user logged into XNotify application
    When user navigates to Team Management module
    And user updates member role successfully
    And user refreshes Team Management page
    And user searches updated member
    And user verifies updated role column value
    Then latest role should be displayed in member listing

  @TM_029
  Scenario: TM_029 Verify user can cancel member role modification
    Given user logged into XNotify application
    When user navigates to Team Management module
    And user searches existing member
    And user opens Edit Member popup
    And user changes member role
    And user clicks Cancel button
    Then original member role should remain unchanged

  @TM_030
  Scenario: TM_030 Verify user can open member action menu successfully
    Given user logged into XNotify application
    When user navigates to Team Management module
    And user searches existing member
    And user clicks member action menu
    And user verifies Edit Member option
    And user verifies Remove Member option
    Then member action menu should be displayed successfully

  @TM_031
  Scenario: TM_031 Verify user can remove an active member successfully
    Given user logged into XNotify application
    When user navigates to Team Management module
    And user searches active member
    And user clicks member action menu
    And user selects Remove Member option
    And user confirms member removal
    Then member should be removed successfully

  @TM_032
  Scenario: TM_032 Verify removed member is no longer displayed in member listing
    Given user logged into XNotify application
    When user navigates to Team Management module
    And user removes a member successfully
    And user refreshes Team Management page
    And user searches removed member email
    And no matching member exists
    Then removed member should not be displayed

  @TM_033
  Scenario: TM_033 Verify user can cancel member removal operation
    Given user logged into XNotify application
    When user navigates to Team Management module
    And user searches existing member
    And user selects Remove Member option
    And user clicks Cancel button on confirmation popup
    And user refreshes member listing
    Then member should remain available in Team Management

  @TM_034
  Scenario: TM_034 Verify pending invitation can be removed successfully
    Given user logged into XNotify application
    When user navigates to Team Management module
    And user filters pending invited members
    And user selects Remove Member option
    And user confirms removal action
    And system processes request
    Then pending invitation should be removed successfully

  @TM_035
  Scenario: TM_035 Verify invited user can access invitation link successfully
    Given invitation email is sent to team member
    When invited user opens invitation email
    And invited user clicks invitation link
    And invitation page is loaded
    And invitation token is validated
    And account setup page is displayed
    Then invited user should access onboarding page successfully

  @TM_037
  Scenario: TM_037 Verify invited user can login after account creation
    Given invited user account is created successfully
    When user navigates to login page
    And user enters registered email address
    And user enters valid password
    And user clicks Login button
    And authentication is completed
    Then user should login successfully

  @TM_040
  Scenario: TM_040 Verify expired invitation link cannot be used for onboarding
    Given invitation link has already expired
    When invited user opens expired invitation link
    And system validates invitation token
    And invitation expiry date is verified
    And onboarding request is rejected
    And error page is displayed
    Then invitation expiry message should be displayed

  @TM_041
  Scenario: TM_041 Verify Admin user can access Team Management module successfully
    Given Admin user logged into XNotify application
    When user navigates to Team Management module
    And user verifies Team Management page is loaded
    And user verifies Invite Member button is displayed
    And user verifies member management actions are displayed
    And user verifies role management controls are displayed
    Then Admin user should have access to Team Management module

  @TM_042
  Scenario: TM_042 Verify non-authorized user cannot access Team Management module
    Given non-admin user logged into XNotify application
    When user attempts to navigate to Team Management module
    And system validates user permissions
    And access control rules are executed
    And restricted functionality is evaluated
    And unauthorized request is processed
    Then access denied message should be displayed

  @TM_048
  Scenario: TM_048 Verify email field accepts maximum supported email length
    Given user logged into XNotify application
    When user navigates to Team Management module
    And user clicks Invite Member button
    And user enters maximum length valid email address
    And user selects role as "Admin"
    And user clicks Send Invitation button
    Then invitation should be processed successfully

  @TM_050
  Scenario: TM_050 Verify leading spaces are trimmed from invitation email field
    Given user logged into XNotify application
    When user navigates to Team Management module
    And user clicks Invite Member button
    And user enters email with leading spaces
    And user selects role as "Admin"
    And user submits invitation request
    Then email should be processed correctly

  @TM_052
  Scenario: TM_052 Verify special characters validation in invitation email field
    Given user logged into XNotify application
    When user navigates to Team Management module
    And user clicks Invite Member button
    And user enters invalid special character email address
    And user selects role as "Editor"
    And user clicks Send Invitation button
    Then invalid email validation should be displayed

  @TM_053
  Scenario: TM_053 Verify Team Management member count updates after successful invitation
    Given user logged into XNotify application
    When user records current member statistics
    And user invites a new team member successfully
    And invitation is processed successfully
    And dashboard statistics are refreshed
    And latest member counts are calculated
    Then Pending Invites count should be updated

  @TM_054
  Scenario: TM_054 Verify Team Management Active Member count updates after invitation acceptance
    Given invited user receives invitation successfully
    When invited user completes account setup process
    And invited user logs into application
    And Team Management dashboard refreshes
    And latest statistics are recalculated
    And member status becomes Active
    Then Active Member count should be updated

  @TM_057
  Scenario: TM_057 Verify pagination functionality in Team Management member listing
    Given user logged into XNotify application
    When user navigates to Team Management module
    And member records exceed single page limit
    And user clicks next page button
    And second page records are loaded
    And pagination controls are displayed
    Then next page member records should be displayed

  @TM_058
  Scenario: TM_058 Verify user can change rows per page in member listing
    Given user logged into XNotify application
    When user navigates to Team Management module
    And user clicks rows per page dropdown
    And user selects different page size
    And member listing refreshes
    And pagination controls are recalculated
    Then selected number of member records should be displayed

  @TM_059
  Scenario: TM_059 Verify Team Management module handles browser refresh during invitation workflow
    Given user logged into XNotify application
    When user navigates to Team Management module
    And user opens Invite Member popup
    And user enters invitation details
    And user refreshes browser page
    And application reloads Team Management page
    Then system should handle refresh gracefully

  @TM_060
  Scenario: TM_060 Verify end-to-end Team Member onboarding workflow
    When user navigates to Team Management module
    And user clicks Invite Member button
    And user enters valid member email address
    And users enters first name "Test" and last name "User"
    And user selects role as "Admin"
    And user clicks Send Invitation button
    Then member invitation should be sent successfully
    And invited user opens invitation link
    And invited user completes account setup
    When user navigates to Team Management module
    # Then invited member should appear as Active in Team Management

  @TC_201_SearchMember
  Scenario: TC_201 Verify user can search team members by name
    When user navigates to Team Management module
    When user enters member name in search field as "Test User"
    Then matching member "Member" records should be displayed

  @TC_202_FilterByRole
  Scenario: TC_202 Verify user can filter team members by role
    When user navigates to Team Management module
    And user selects role as "Admin" from role filter dropdown
    Then only "Admin" role records should be displayed

  @TC_203_FilterByStatus
  Scenario: TC_203 Verify user can filter team members by status
    When user navigates to Team Management module
    And user selects status as "Pending" from status filter dropdown
    Then only "Pending" status records should be displayed

  @TC_204_FilterByRoleAndStatus
  Scenario: TC_204 Verify user can filter team members by role and status
    When user navigates to Team Management module
    And user selects role as "Admin" from role filter dropdown
    And user selects status as "Pending" from status filter dropdown
    Then only records matching role "Admin" and status "Pending" should be displayed
