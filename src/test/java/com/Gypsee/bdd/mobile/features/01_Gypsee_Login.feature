@Gypsee_Explore @LoginPriya
Feature: Verify the functionality of the login in gypsee application

  @InValidLogin
  Scenario Outline: <TC> To check the functionality of Gypsee Login with <PhnNum> mobile number
    Given the user is on the Gypsee application
    When the user clicks on the Skip option
    Then the user should be navigated to the enter mobile number page
    When the user enters invalid "<invalid>" mobile number in the designated field
    And the user clicks on the Arrow button
    Then the user should able to see please provide ten digist number error message

    Examples: 
      | TC     | invalid    | PhnNum     |
      | TC_001 |            | empty      |
      | TC_002 |  234567912 | invalid    |
      | TC_003 | 4567893211 | four digit |

  @NonRegisterLogin
  Scenario Outline: <TC> To check the functionality of Gypsee Login with <PhnNum> mobile number
    Given the user is on the Gypsee application
    When the user clicks on the Skip option
    Then the user should be navigated to the enter mobile number page
    When the user enters non register <invalid> mobile number in the designated field
    And the user clicks on the Arrow button
    Then the user should able to see coose an account popup

    Examples: 
      | TC     | invalid    | PhnNum                                 |
      | TC_004 | 5349637891 | five series non register mobile number |
      | TC_005 | 9631258399 | nine series non register mobile number |

  #@NotAllowLocPer
  #Scenario: Tc_006 Verify functionality of the permissions with out accepting location permission
  #Given the user is on the Gypsee application
  #When the user clicks on the Skip option
  #Then the user should be navigated to the enter mobile number page
  #When the user enters their mobile number in the designated field
  #And the user clicks on the Arrow button
  #Then the user should able to see otp verification page
  #When the user enters the otp
  #Then the user should be navigated to the Allow Permissions page
  #When the user clicks on the Confirm button
  #And the user clicks on the dont allow button of the location permission
  #And the user clicks on the allow button of the physcial activity permission
  #And the user clicks on the allow button of the device position permission
  #And the user clicks on the allow button of the notification permission
  #Then the user should able to see thee permission request popup
  #
  #@NotAllowPhyActPer
  #Scenario: Tc_007 Verify functionality of the permissions with out accepting physical activity permission
  #Given the user is on the Gypsee application
  #When the user clicks on the Skip option
  #Then the user should be navigated to the enter mobile number page
  #When the user enters their mobile number in the designated field
  #And the user clicks on the Arrow button
  #Then the user should able to see otp verification page
  #When the user enters the otp
  #Then the user should be navigated to the Allow Permissions page
  #When the user clicks on the Confirm button
  #And the user clicks on the allow button of the location permission
  #And the user clicks on the dont allow button of the physcial activity permission
  #And the user clicks on the allow button of the device position permission
  #And the user clicks on the allow button of the notification permission
  #Then the user should able to see thee permission request popup
  #
  #@NotAllowPosPer
  #Scenario: Tc_008 Verify functionality of the permissions with out accepting position permission
  #Given the user is on the Gypsee application
  #When the user clicks on the Skip option
  #Then the user should be navigated to the enter mobile number page
  #When the user enters their mobile number in the designated field
  #And the user clicks on the Arrow button
  #Then the user should able to see otp verification page
  #When the user enters the otp
  #Then the user should be navigated to the Allow Permissions page
  #When the user clicks on the Confirm button
  #And the user clicks on the allow button of the location permission
  #And the user clicks on the allow button of the physcial activity permission
  #And the user clicks on the dont allow button of the device position permission
  #And the user clicks on the allow button of the notification permission
  #Then the user should able to see thee permission request popup
  #
  #@NotAllowNotiPer
  #Scenario: Tc_009 Verify functionality of the permissions with out accepting notification permission
  #Given the user is on the Gypsee application
  #When the user clicks on the Skip option
  #Then the user should be navigated to the enter mobile number page
  #When the user enters their mobile number in the designated field
  #And the user clicks on the Arrow button
  #Then the user should able to see otp verification page
  #When the user enters the otp
  #Then the user should be navigated to the Allow Permissions page
  #When the user clicks on the Confirm button
  #And the user clicks on the allow button of the location permission
  #And the user clicks on the allow button of the physcial activity permission
  #And the user clicks on the allow button of the device position permission
  #And the user clicks on the dont allow button of the notification permission
  #Then the user should able to see thee permission request popup
  #
  #
  #
  #@AllowOnlyThisTimePositiveLogin
  #Scenario: TC_010 To check the functionality of Gypsee Login with valid credentials
  #Given the user is on the Gypsee application
  #When the user clicks on the Skip option
  #Then the user should be navigated to the enter mobile number page
  #When the user enters their mobile number in the designated field
  #And the user clicks on the Arrow button
  #Then the user should able to see otp verification page
  #When the user enters the otp
  #Then the user should be navigated to the Allow Permissions page
  #When the user clicks on the Confirm button
  #And the user clicks on the only this time allow permission and clicks on options which are required
  #Then the user should be able to see the Gypsee homepage
  
  @PositiveLogin
  Scenario: TC_011 To check the functionality of Gypsee Login with valid credentials
    Given the user is on the Gypsee application
    When the user clicks on the Skip option
    Then the user should be navigated to the enter mobile number page
    When the user enters their mobile number in the designated field
    And the user clicks on the Arrow button
    Then the user should able to see otp verification page
    When the user enters the otp
    Then the user should be navigated to the Allow Permissions page
    When the user clicks on the Confirm button
    And the user clicks on the allow permission options which are required
    Then the user should be able to see the Gypsee homepage
