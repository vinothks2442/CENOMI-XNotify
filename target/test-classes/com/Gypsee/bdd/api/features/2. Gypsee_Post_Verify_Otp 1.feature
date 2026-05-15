@Post_VerifyOtp @GypseeAPI
Feature: validation of verify otp Functionality

  @VerifyOtp_Positive
  Scenario: TC_001 Post request for verify otp positive scenario
    Given I set up request specification
      | HeaderName      | HeaderValue       |
      | Content-Type    | application/json  |
      | Accept          | */*               |
      | Accept-Encoding | gzip, deflate, br |
      | Connection      | keep-alive        |
    When I post the request with "VerifyOtp" payload
    And I store the response as "VerifyOtpResponse" name
    #Then I validate the response scheama is as expected against "VerifyOtpSchema" file
    And I should see the response code as "200"
    And contentType as "application/json"
    And verify response time is less than "4000" milliseconds
    And verify response headers
      | HeaderName             | HeaderValue      |
      | Content-Type           | application/json |
      | X-Content-Type-Options | nosniff          |
    And verifies the field is present in the response
      | JPath                  |
      | $.user.userAccessToken |
      | $.user.fcmToken        |
    And the fields in response should match with expected values
      | JPath                                | Value                                  |
      | $.status                             |                                    200 |
      | $.message                            | "OTP verified Successfully"            |
      | $.totalRecords                       |                                      0 |
      | $.user.userId                        | "10bb8e55-597a-443d-a3f0-1ef1db2b6a84" |
      | $.user.userName                      | "kasasowjanya13@gmail.com"         |
      | $.user.userFullName                  | "Sowjanya Kasa"                      |
      | $.user.userEmail                     | "kasasowjanya13@gmail.com"         |
      | $.user.userPhoneNumber               | "6303429063"                           |
      | $.user.userVehicles[0].userVehicleId | "7b092956-4baa-4007-ae41-06df40c2d24f" |

  @VerifyOtp_InvalidUri
  Scenario: TC_002 Post request for verify otp negative scenario invalid URI
    Given I set up request specification
      | HeaderName      | HeaderValue       |
      | Content-Type    | application/json  |
      | Accept          | */*               |
      | Accept-Encoding | gzip, deflate, br |
      | Connection      | keep-alive        |
    When I post the request with "VerifyOtpInvalidUri" payload
    Then I should see the response code as "404"
    And verify response time is less than "4000" milliseconds
    And verify response headers
      | HeaderName             | HeaderValue      |
      | Content-Type           | application/json |
      | X-Content-Type-Options | nosniff          |
    And verifies the field is present in the response
      | JPath       |
      | $.timestamp |
    And the fields in response should match with expected values
      | JPath     | Value                  |
      | $.status  |                    404 |
      | $.message | "No message available" |
      | $.error   | "Not Found"            |
      | $.path    | "/gypsee/mobile/otp"   |

  @VerifyOtp_WithouPayLoad
  Scenario: TC_003 Post request for verify otp negative scenario without payload
    Given I set up request specification
      | HeaderName      | HeaderValue       |
      | Content-Type    | application/json  |
      | Accept          | */*               |
      | Accept-Encoding | gzip, deflate, br |
      | Connection      | keep-alive        |
    When I post the request with "VerifyOtp" without payload
    And I store the response as "VerifyOtpWithoutPayloadResponse" name
    Then I should see the response code as "400"
    And contentType as "application/json"
    And verify response time is less than "4000" milliseconds
    And verifies the field is present in the response
      | JPath       |
      | $.timestamp |
      | $.message   |
    And the fields in response should match with expected values
      | JPath    | Value |
      | $.status |   400 |

  @VerifyOtp @Invalid_CountryCode_Verify
  Scenario Outline: <TC_Num> Verify Post request for verify otp invalid Country code <Description>
    Given I set up request specification
      | HeaderName      | HeaderValue       |
      | Content-Type    | application/json  |
      | Accept          | */*               |
      | Accept-Encoding | gzip, deflate, br |
      | Connection      | keep-alive        |
    When I modify the field values in "VerifyOtpInvalidCountryCode" payload
      | JPath         | Value         |
      | $.countryCode | <countryCode> |
    And I post the request to endpoint
    Then I should see the response code as "400"
    And verify response time is less than "3000" milliseconds
    And contentType as "application/json"
    And verify response headers
      | HeaderName             | HeaderValue      |
      | Content-Type           | application/json |
      | X-Content-Type-Options | nosniff          |
    And verifies the field is present in the response
      | JPath       |
      | $.timestamp |
      | $.message   |
    And the fields in response should match with expected values
      | JPath    | Value |
      | $.status |   400 |

    Examples: 
      | TC_Num | countryCode | Description                      |
      | TC_04  | $$          | - Special characters             |
      | TC_05  | 1^          | - integer with special character |
      | TC_06  | a$          | - String with special character  |
      | TC_07  | a           | - Char                           |
      | TC_08  | asdfg       | - String                         |
      | TC_19  |       1.333 | - Double                         |
      | TC_010 | a1          | - Alphanumeric                   |

  @VerifyOtp @Invalid_PhoneNumber_Verify
  Scenario Outline: <TC_Num> Verify Post request for verify otp invalid Phonenumber <Description>
    Given I set up request specification
      | HeaderName      | HeaderValue       |
      | Content-Type    | application/json  |
      | Accept          | */*               |
      | Accept-Encoding | gzip, deflate, br |
      | Connection      | keep-alive        |
    When I modify the field values in "VerifyOtpInvalidPhoneNumber" payload
      | JPath             | Value             |
      | $.userPhoneNumber | <userPhoneNumber> |
    And I post the request to endpoint
    Then I should see the response code as "400"
    And verify response time is less than "3000" milliseconds
    And contentType as "application/json"
    And verify response headers
      | HeaderName             | HeaderValue      |
      | Content-Type           | application/json |
      | X-Content-Type-Options | nosniff          |
    And verifies the field is present in the response
      | JPath     |
      | $.message |
    And the fields in response should match with expected values
      | JPath          | Value |
      | $.status       |   400 |
      | $.totalRecords |     0 |
      | $.userExists   | false |

    Examples: 
      | TC_Num | userPhoneNumber | Description                      |
      | TC_11  | $$              | - Special characters             |
      | TC_12  | 1^              | - integer with special character |
      | TC_13  | a$              | - String with special character  |
      | TC_14  | a               | - Char                           |
      | TC_15  | asdfg           | - String                         |
      | TC_16  | null            | - Null                           |
      | TC_17  |           1.333 | - Double                         |
      | TC_18  | a1              | - Alphanumeric                   |

  @VerifyOtp @Invalid_Otp_Verify
  Scenario Outline: <TC_Num> Verify Post request for verify otp invalid Otp <Description>
    Given I set up request specification
      | HeaderName      | HeaderValue       |
      | Content-Type    | application/json  |
      | Accept          | */*               |
      | Accept-Encoding | gzip, deflate, br |
      | Connection      | keep-alive        |
    When I modify the field values in "VerifyOtp" payload
      | JPath | Value |
      | $.otp | <otp> |
    And I post the request to endpoint
    Then I should see the response code as "400"
    And verify response time is less than "3000" milliseconds
    And contentType as "application/json"
    And verify response headers
      | HeaderName             | HeaderValue      |
      | Content-Type           | application/json |
      | X-Content-Type-Options | nosniff          |
       And verifies the field is present in the response
      | JPath       |
      | $.message   |
    And the fields in response should match with expected values
      | JPath          | Value                     |
      | $.status       |                       400 |
      | $.totalRecords |                         0 |
      | $.userExists   | false                     |

    Examples: 
      | TC_Num | otp   | Description                      |
      | TC_19  | $$    | - Special characters             |
      | TC_20  | 1^    | - integer with special character |
      | TC_21  | a$    | - String with special character  |
      | TC_22  | a     | - Char                           |
      | TC_23  | asdfg | - String                         |
      | TC_24  | null  | - Null                           |
      | TC_25  | 1.333 | - Double                         |
      | TC_26  | a1    | - Alphanumeric                   |

  @VerifyOtp @Invalid_LoginUser
  Scenario Outline: <TC_Num> Verify Post request for verify otp invalid login user <Description>
    Given I set up request specification
      | HeaderName      | HeaderValue       |
      | Content-Type    | application/json  |
      | Accept          | */*               |
      | Accept-Encoding | gzip, deflate, br |
      | Connection      | keep-alive        |
    When I modify the field values in "VerifyOtp" payload
      | JPath       | Value       |
      | $.loginUser | <loginUser> |
    And I post the request to endpoint
    Then I should see the response code as "400"
    And verify response time is less than "3000" milliseconds
    And contentType as "application/json"
    And verify response headers
      | HeaderName             | HeaderValue      |
      | Content-Type           | application/json |
      | X-Content-Type-Options | nosniff          |
    And verifies the field is present in the response
      | JPath       |
      | $.timestamp |
      | $.message   |
    And the fields in response should match with expected values
      | JPath    | Value |
      | $.status |   400 |

    Examples: 
      | TC_Num | loginUser | Description                      |
      | TC_27  | $$        | - Special characters             |
      | TC_28  | 1^        | - integer with special character |
      | TC_29  | a$        | - String with special character  |
      | TC_30  | a         | - Char                           |
      | TC_31  | asdfg     | - String                         |
      | TC_32  |     1.333 | - Double                         |
      | TC_33  | a1        | - Alphanumeric                   |
