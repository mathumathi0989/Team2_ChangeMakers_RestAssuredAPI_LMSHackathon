#Author: Bhagyashri
Feature: ProgramModule

  Background: Admin sets Authorization
    Given Admin provides valid authentication details

  @GetAllPrograms
  Scenario: Check if Admin able to retrieve all programs with valid Endpoint
    When Admin creates and executes GET all program Request for the LMS API
    Then Admin receives 200 OK Status with program response body

  @GetAllProgramsWithAdmins
  Scenario: Check if Admin able to retrieve all programs with Admins and valid Endpoint
    Given Admin creates GET Request to retrieve all programs with Admins for the LMS API
    When Admin executes HTTPS GET program request with valid endpoint
    Then Admin receives 200 OK Status with response body

  @PostNewProgram
  Scenario Outline: Check if Admin able to create a program with valid endpoint and request body with Authorization
    When Admin creates and executes POST program Request for the LMS with "<ValidRequestBody>"
    Then Admin receives 201 Created Status with program response body containing "<UniqueProgramIds>"

    Examples: 
      | ValidRequestBody                                   | UniqueProgramIds   |
      | ValidProgramWithAllValidFieldsPresentInRequestBody | UniqueProgramIdOne |
      | ValidProgramWithMissingOptionalFieldInRequestBody  | UniqueProgramIdTwo |

  @GetProgramByID
  Scenario: Check if Admin able to retrieve a program with valid program ID
    When Admin creates and executes GET rogram with valid program ID Request for the LMS API
    Then Admin receives 200 OK Status with required program response body

  @PutByProgramID
  Scenario: Check if Admin able to update a program with valid programID endpoint and valid request body
    Given Admin creates PUT Request for the LMS Program API endpoint to "UpdateProgramWithAllValidFieldsPresentInRequestBody"
    When Admin sends HTTPS PUT Request with valid endpoint to update program
    Then Admin receives 200 OK Status with updated value in program response body

  @MethodNotAllowed
  Scenario: Check if Admin able to create a program with invalid method
    Given Admin creates POST Program Request for the LMS with request body
    When Admin sends HTTPS GET Program Request and request Body with endpoint
    Then Admin receives 405 Method Not Allowed

  @MethodNotAllowed
  Scenario: Check if Admin able to retrieve all programs with invalid Method
    Given Admin creates GET all programs Request for the LMS API
    When Admin sends HTTPS POST Program Request with endpoint
    Then Admin receives 405 Method Not Allowed

  @MethodNotAllowed
  Scenario: Check if Admin able to retrieve all programs with admins with invalid Method
    Given Admin creates GET all programs with admins Request for the LMS with request body
    When Admin sends HTTPS POST Program Request and request Body with endpoint
    Then Admin receives 405 Method Not Allowed

  @MethodNotAllowed
  Scenario: Check if Admin able to update a program with invalid method
    Given Admin creates PUT program Request for the LMS API
    When Admin sends HTTPS GET Program Request with endpoint
    Then Admin receives 405 Method Not Allowed

  @NoAuth
  Scenario: Check if Admin able to create a program with valid endpoint and request body without Authorization
    Given Admin creates POST Request for the LMS with request body and with no auth
    When Admin sends HTTPS POST Program Request with valid request Body and endpoint
    Then Admin receives 401 Unauthorized

  @NoAuth
  Scenario: Check if Admin able to retrieve all programs without Authorization
    Given Admin creates GET Program Request for the LMS with no auth
    When Admin sends HTTPS GET Program Request with valid endpoint
    Then Admin receives 401 Unauthorized

  @NoAuth
  Scenario: Check if Admin able to retrieve all programs with Admins without Authorization
    Given Admin creates GET Program with admins Request for the LMS with no auth
    When Admin sends HTTPS GET Program with admins Request with valid endpoint
    Then Admin receives 401 Unauthorized

  @NoAuth
  Scenario: Check if Admin able to retrieve a program by programID without Authorization
    Given Admin creates GET Program by programID Request for the LMS with no auth
    When Admin sends HTTPS GET Program by programID Request with valid endpoint
    Then Admin receives 401 Unauthorized

  @NoAuth
  Scenario: Check if Admin able to update a program by programID without Authorization
    Given Admin creates PUT Request with no auth for the LMS API endpoint with request Body with mandatory, additional fields
    When Admin sends HTTPS PUT Program by programID Request with valid endpoint
    Then Admin receives 401 Unauthorized

  @NoAuth
  Scenario: Check if Admin able to update a program by programName without Authorization
    Given Admin creates PUT Request with programName and no auth for the LMS API endpoint with request Body with mandatory, additional fields
    When Admin sends HTTPS PUT Program by programName Request with valid endpoint
    Then Admin receives 401 Unauthorized

  @NoAuth
  Scenario: Check if Admin able to delete a program by programID without Authorization
    Given Admin creates DELETE by programID Request with no auth for the LMS API endpoint
    When Admin creates DELETE Request with no auth for the LMS API endpoint  and  valid programName
    Then Admin receives 401 Unauthorized

  @NoAuth
  Scenario: Check if Admin able to delete a program by programName without Authorization
    Given Admin creates DELETE by programName Request with no auth for the LMS API endpoint
    When Admin sends HTTPS DELETE Program by programID with noauth Request and valid endpoint
    Then Admin receives 401 Unauthorized

  @PostNewProgram
  Scenario Outline: Check if Admin able to create a program with invalid request body
    Given Admin creates POST Request for the LMS with "<invalidData>" in request body
    When Admin sends HTTPS POST Request and invalid program request Body with endpoint
    Then Admin receives 400 Bad Request Status

    Examples: 
      | invalidData                               |
      | ExistingProgramName                       |
      | MissingMandatoryDetails                   |
      | SpecialCharactersInProgramMandatoryFields |
      | OnlyNumbersInProgramMandatoryFields       |
      | VeryLongProgramName                       |

  @PutByProgramID
  Scenario Outline: Check if Admin able to update a program with invalid request body
    Given Admin creates PUT by programID Request for the LMS with "<invalidDataToUpdate>" in request body
    When Admin sends HTTPS PUT Request and invalid program request Body with endpoint
    Then Admin receives 400 Bad Request Status with message for invalid request body and boolean success details

    Examples: 
      | invalidDataToUpdate                                      |
      | ExistingProgramNameToUpdate                              |
      | MissingMandatoryDetailsToUpdateProgram                   |
      | SpecialCharactersInProgramMandatoryFieldsToUpdateProgram |
      | OnlyNumbersInProgramMandatoryFieldsToUpdateProgram       |
      | VeryLongProgramNameToUpdateProgram                       |

  @PutByProgramName
  Scenario Outline: Check if Admin able to update a program with invalid request body
    Given Admin creates PUT by programName Request for the LMS with "<invalidDataToUpdate>" in request body
    When Admin sends HTTPS PUT by programName Request and invalid program request Body with endpoint
    Then Admin receives 400 Bad Request Status with error message for invalid request body and boolean success details

    Examples: 
      | invalidDataToUpdate                                      |
      | ExistingProgramNameToUpdate                              |
      | MissingMandatoryDetailsToUpdateProgram                   |
      | SpecialCharactersInProgramMandatoryFieldsToUpdateProgram |
      | OnlyNumbersInProgramMandatoryFieldsToUpdateProgram       |

  @PutByProgramName
  Scenario: Check if Admin able to update a program with valid programName endpoint and valid request body
    Given Admin creates PUT by programName Request for the LMS Program API endpoint to "UpdateProgramWithAllValidFieldsPresentInRequestBody"
    When Admin sends HTTPS PUT Request with valid programName endpoint to update program
    Then Admin receives 200 OK Status with updated value in program response body

  @PutByProgramName
  Scenario: Check if Admin able to update a program status
    Given Admin creates PUT Request for the LMS API endpoint and Valid program Name and "programStatus"
    When Admin sends HTTPS PUT by programName Request with valid programName endpoint to update program status
    Then Admin receives 200 OK Status with updated status in response body

  @PutByProgramName
  Scenario: Check if Admin able to update a program by programName with  invalid program Description
    Given Admin creates PUT Request for the LMS API endpoint and invalid "programDescription"
    When Admin sends HTTPS PUT by programName Request with valid programName endpoint to update program
    Then Admin receives 400 Bad Request Status with invalid programName error message and boolean success details

  @DeleteProgramByProgramID
  Scenario: Check if Admin able to delete a program with valid program ID
    Given Admin creates DELETE Request for the LMS Program API endpoint and valid program ID
    When Admin sends HTTPS DELETE program by programId Request with valid endpoint
    Then Admin receives 200 Ok status with successful program deletion message

  @DeleteProgramByProgramName
  Scenario: Check if Admin able to delete a program with valid programName
    Given Admin creates DELETE Request for the LMS API endpoint and valid programName
    When Admin sends HTTPS DELETE program by programName Request with endpoint
    Then Admin receives 200 Ok status with message

 
  @invalidEndPoint
  Scenario: Check if Admin able to create a program with invalid endpoint
    Given Admin creates POST Request with invalid endpoint for the LMS with request body
    When Admin sends HTTPS POST Request with valid request Body and invalid endpoint
    Then Admin receives 404 not found  Status with message and boolean success details

  @invalidEndPoint
  Scenario: Check if Admin able to retrieve all programs with invalid Endpoint
    Given Admin creates GET Request for the LMS with valid baseURI
    When Admin sends GET Request to the LMS API along with invalid endpoind
    Then Admin receives 404 not found Status with error message

  @invalidEndPoint
  Scenario: Check if Admin able to retrieve a program by programID with invalid Endpoint
    Given Admin creates GET Request to retrieve a program by programID for the LMS API
    When Admin sends HTTPS GET Request with invalid endpoint
    Then Admin receives 404 Not Found Status with error message and boolean success details

  @invalidEndPoint
  Scenario: Check if Admin able to retrieve all programs with admins and with invalid Endpoint
    Given Admin creates GET request to fetch all programs with admins for the LMS API
    When Admin sends HTTPS Get all programs along with admins Request with invalid endpoint
    Then Admin receives 404 not found Status with correct error message

  @invalidEndPoint
  Scenario: Check if Admin able to update a program with invalid programID endpoint  and valid request body
    Given Admin creates PUT Request for the LMS API endpoint along with valid request Body with mandatory, additional  fields
    When Admin sends HTTPS Request with invalid programId endpoint
    Then Admin receives 404 Not Found Status with message and boolean success flag details

  @invalidEndPoint
  Scenario: Check if Admin able to update a program with  invalid program Name and request body
    Given Admin creates PUT Request for the LMS API endpoint with valid request Body with mandatory, additional  fields
    When Admin sends HTTPS Request with invalid programName endpoint
    Then Admin receives 404 Not Found Status with error message and boolean success flag details

  @invalidEndPoint
  Scenario: Check if Admin able to delete a program with valid LMS API,invalid programName
    Given Admin creates DELETE Request for the LMS API endpoint  and  invalid programName
    When Admin sends HTTPS Delete by invalid programName Request with endpoint
    Then Admin receives 404 Not Found Status along with error message and boolean success details

  @invalidEndPoint
  Scenario: Check if Admin able to delete a program with valid LMS API,invalid program ID
    Given Admin creates DELETE Request for the LMS API endpoint  and  invalid program ID
    When Admin sends HTTPS DELETE by invalid programID Request with endpoint
    Then Admin receives 404 Not Found Status along with message and boolean success flag details

@invalidPathParameter
Scenario Outline: Check if Admin able to delete a program with valid LMS API,invalid pathParameter ProgramID
Given Admin creates DELETE Request for the LMS API endpoint  and  "<invalidPathParameterprogramID>"
    When Admin sends HTTPS DELETE by invalid programID Request with endpoint
    Then Admin receives 404 Not Found Status along with message and boolean success flag details
Examples: 
| invalidPathParameterprogramID |
| zero 													|
| negativeID 										|
| overFlowInteger								|

Scenario Outline: Check if Admin able to read a program with valid LMS API,invalid pathParameter ProgramID
Given Admin creates GET Request for the LMS API endpoint  and  "<invalidPathParameterprogramID>"
    When Admin sends HTTPS GET by invalid programID Request with endpoint
    Then Admin receives 404 Not Found Status along with message and boolean success flag details
Examples: 
| invalidPathParameterprogramID |
| zero 													|
| negativeID 										|
| overFlowInteger								|

 
  @invalidBaseURI
  Scenario: Check if Admin able to retrieve a program by programID with invalid baseURI
    Given Admin creates GET Request to retrieve a program by programID for the LMS API with invalid baseURI
    When Admin sends HTTPS GET Request along with valid endpoint and invalid baseURI
    Then Admin receives 404 Not Found Status with resp error message and boolean success details

  @invalidBaseURI
  Scenario: Check if Admin able to update a program with invalid baseURI and valid programId
    Given Admin creates PUT Request for the LMS API endpoint along with valid request Body with invalid baseURI
    When Admin sends HTTPS Request with valid programId endpoint and invalid baseURI
    Then Admin receives 404 Not Found Status with appropriate error message and boolean success flag details
