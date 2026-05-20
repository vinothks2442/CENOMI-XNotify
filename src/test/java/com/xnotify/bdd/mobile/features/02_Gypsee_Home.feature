@Gypsee_Explore @Gypsee_Explore_MY
Feature: Validating the functionality of Gypsee Application

  @HomePage_AddDevice
  Scenario: TC_Home_001 Validating the functionality of AddDevice prsent in Gypsee App Homepage
    #Given the user is on the Gypsee application
    #When the user clicks on the Skip option
    #Then the user should be navigated to the enter mobile number page
    #When the user enters their mobile number in the designated field
    #And the user clicks on the Arrow button
    #Then the user should able to see otp verification page
    #When the user enters the otp
    #Then the user should be navigated to the Allow Permissions page
    #When the user clicks on the Confirm button
    #And the user clicks on the allow permission options which are required
    #Then the user should be able to see the Gypsee homepage
    When User clicks on Add Device present in the home page
    Then User should able to see the list of avialable devices
    When User clicks on add device plus icon present in Mydevices Page
    Then User should able to see the Add device page which contains information like chrager,ODB and etc
    When user clicks on smart chrger present in Add Device page
    And User clicks on smart car chrger
    Then User should able to see information regarding connecting charger
    And User clicks on Next button present in Add device page
    And user clicks on one of the paired device
       And User clicks on ODB device and clicks on ODB2 BLE
    And clicks on Next button present in Add device
    And user clicks on one of the paired device
      And User clicks on sterio device type and clicks on car sterio
    And User clicks on Next button present in Add device page
    And user clicks on one of the paired device
       And User clicks on Next button present in Add device page
    And user clicks on one of the paired device
       And User clicks on backbutton of Add device
    And User clicks on backbutton of Add device
    Then the user should be able to see the Gypsee homepage

  @Navigation
  Scenario: TC_002 validating the navigation functionality of deffernt menu items present in Gypsee Application
    Given the user should be able to see the Gypsee homepage
    When User clicks on shareoption prsent in GypseeAppp home page
    Then user should able to see the Gypsee Road safety promise page
    When user clicks on copy button present in the share page
    And User clicks on Backbutton present in share page
    Then User should able to see the details of the home page
    When User clicks on dashboard menu item present in home page
    Then User should able to navigate to dashboard page
    When User clicks on Trips menu item present in the homepage
    Then User should able to the all trips information
    When User clicks on car health score prsent in homepage
    Then user should able to navigate to the carhealth score page
    And User clicks on backbutton prsent in the carhealth score page
    When User clicks on homemenu item present in GypseeApp homepage
    And User clicks on carscan prsent in the homepage
    Then user should able to navigate to the scancar page
    And User clicks on back button present in the car scan page
    Then User should able to see the details of the home page
    When User clicks on ScannerLiveDemo present in homepage
    Then User should able to navigate to scannerLiveDemo page
    When User clicks on Exitdemo present in the page
    Then User should able to see the details of the home page
    When user clicks on RTO vehicle information
    Then User should able to see the registration details of the vehicle

  @Trips_Functionality
  Scenario: TC_003 validating the functionality of Trip menu items present in Gypsee Application
    Given User is in GypseeApplication homepage
    When User clicks on Trips menu item present in the homepage
    Then User should able to the all trips information
    When User clicks on first drive and clicks on share feedback
    Then User should able to see the sharefeedback page with cancel and submit buttons
    When User clicks on cancel button of share feedback page and clicks on back button
    When User clicks on Second drive and clicks on share feedback
    Then User should able to see the sharefeedback page with cancel and submit buttons
    When User clicks on cancel button of share feedback page and clicks on back button
    When User clicks on third drive and clicks on share feedback
    Then User should able to see the sharefeedback page with cancel and submit buttons
    When User clicks on cancel button of share feedback page and clicks on back button
    Then the user should be able to see the Gypsee homepage

  @Vehicle_MaintanaceRemainder
  Scenario: TC_004 validating the functionality of Trip menu items present in Gypsee Application
    #Given the user is on the Gypsee application
    #When the user clicks on the Skip option
    #Then the user should be navigated to the enter mobile number page
    #When the user enters their mobile number in the designated field
    #And the user clicks on the Arrow button
    #Then the user should able to see otp verification page
    #When the user enters the otp
    #Then the user should be navigated to the Allow Permissions page
    #When the user clicks on the Confirm button
    #And the user clicks on the allow permission options which are required
    #Then the user should be able to see the Gypsee homepage
    Given User is in GypseeApplication homepage
    When User clicks on vehicle maintainance remainder present in the homepage
    And clicks on plus symbol to add device
    And User enters the valid vehicle register number and clicks on submit
    Then User should able to see error message
    When User clicks on cancel button

  #And clicks on plus symbol to add device
  #And User enters the invalid vehicle number and clicks on submit
  #Then User should able to see error message
  #When User clicks on cancel button
  #And clicks on plus symbol to add device
  #And User enters empty value and clicks on submit button
  #Then Uset should able to see the message Enter registration number with red color
  #When User clicks on cancel button  and clicks on back button
  #Then the user should be able to see the Gypsee homepage
  @HomePage_AllValidations_Positive
  Scenario: TC_005 validating the functionality of all items present in Gypsee Application homepage
    Given User is in GypseeApplication homepage
    And User clicks on carscan prsent in the homepage
    And User clicks on scan your car health now
    Then User should able to see the confirmed,pending code description
    And User clicks on backbutton of Add device
    Then the user should be able to see the Gypsee homepage
    When user clicks on RTO vehicle information
    And User clicks on scrolldown the page
    And User clicks Service reminder present in RTO information
    And User clicks on Next Serice due date present in RTO Information
    And User clicks on odometer reading present in RTO Information page
    #And User clicks on Update button present in the RTO Information page
    #Then the user should be able to see the Gypsee homepage
