@Post_GetOtp @GypseeAPI
Feature: validation of get otp Functionality

  @GetOtp_Positive @smoke
  Scenario: TC_001 Post request for get otp positive scenario
    Given I set up request specification
      | HeaderName      | HeaderValue       |
      | Content-Type    | application/json  |
      | Accept          | */*               |
      | Accept-Encoding | gzip, deflate, br |
      | Connection      | keep-alive        |
    When I post the request with "GetOtp" payload
    And I store the response as "GetOtpResponse" name
    #Then I validate the response scheama is as expected against "GetOtpSchema" file
    And I should see the response code as "200"
    And contentType as "application/json"
    And verify response time is less than "4000" milliseconds
    And verify response headers
      | HeaderName             | HeaderValue      |
      | Content-Type           | application/json |
      | X-Content-Type-Options | nosniff          |
    And the fields in response should match with expected values
      | JPath          | Value                      |
      | $.status       |                        200 |
      | $.message      | "OTP sent Successfully"    |
      | $.totalRecords |                          0 |
      | $.requestId    | "306545727a49353337353235" |
      | $.otp          | "234466"                   |
      | $.userExists   | true                       |

  @GetOtp_InvalidUri
  Scenario: TC_002 Post request for get otp negative scenario invalid URI
    Given I set up request specification
      | HeaderName      | HeaderValue       |
      | Content-Type    | application/json  |
      | Accept          | */*               |
      | Accept-Encoding | gzip, deflate, br |
      | Connection      | keep-alive        |
    When I post the request with "GetOtpInvalidUri" payload
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
      | $.path    | "/gypsee/mobile/send"  |

  @GetOtp_WithouPayLoad
  Scenario: TC_003 Post request for get otp negative scenario without payload
    Given I set up request specification
      | HeaderName      | HeaderValue       |
      | Content-Type    | application/json  |
      | Accept          | */*               |
      | Accept-Encoding | gzip, deflate, br |
      | Connection      | keep-alive        |
    When I post the request with "GetOtp" without payload
    And I store the response as "GetOtpWithoutPayloadResponse" name
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

  @GetOtp @Invalid_CountryCode
  Scenario Outline: <TC_Num> Verify Post request for get otp invalid Country code <Description>
    Given I set up request specification
      | HeaderName      | HeaderValue       |
      | Content-Type    | application/json  |
      | Accept          | */*               |
      | Accept-Encoding | gzip, deflate, br |
      | Connection      | keep-alive        |
    When I modify the field values in "GetOtpInvalidCountryCode" payload
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
      | TC_09  |       1.333 | - Double                         |
      | TC_010 | a1          | - Alphanumeric                   |

  @GetOtp @Invalid_PhoneNumber
  Scenario Outline: <TC_Num> Verify Post request for get otp invalid Phonenumber <Description>
    Given I set up request specification
      | HeaderName      | HeaderValue       |
      | Content-Type    | application/json  |
      | Accept          | */*               |
      | Accept-Encoding | gzip, deflate, br |
      | Connection      | keep-alive        |
    When I modify the field values in "GetOtpInvalidPhoneNumber" payload
      | JPath             | Value             |
      | $.userPhoneNumber | <userPhoneNumber> |
    And I post the request to endpoint
    Then I should see the response code as "400"
    And verify response time is less than "3000" milliseconds
    And contentType as "application/json"
    And verify response headers
      | HeaderName             | HeaderValue                    |
      | Content-Type           | application/json |
      | X-Content-Type-Options | nosniff                        |
    And the fields in response should match with expected values
      | JPath          | Value          |
      | $.status       |            400 |
      | $.message      | "Invalid Phone Number - Length Mismatch(Expected: 10)" |
      | $.totalRecords |              0 |
       | $.userExists |              false |

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
