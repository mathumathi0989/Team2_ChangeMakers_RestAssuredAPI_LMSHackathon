Feature: ProgramModule

  Background: Admin sets Authorization
    Given Admin provides valid authentication details

  @Program_S1_GetAllPrograms
  Scenario: Check if Admin able to retrieve all programs with valid Endpoint
    When Admin creates and executes GET all program Request for the LMS API
    Then Admin receives 200 OK Status with program response body

  @Program_S2_GetAllProgramsWithAdmins
  Scenario: Check if Admin able to retrieve all programs with Admins and valid Endpoint
    Given Admin creates GET Request to retrieve all programs with Admins for the LMS API
    When Admin executes HTTPS GET program request with valid endpoint
    Then Admin receives 200 OK Status with response body

  @Program_S3_PostNewProgram
  Scenario Outline: Check if Admin able to create a program with valid endpoint and request body with Authorization
    When Admin creates and executes POST program Request for the LMS with "<ValidRequestBody>"
    Then Admin receives 201 Created Status with program response body containing "<UniqueProgramIds>"

    Examples: 
      | ValidRequestBody                                   | UniqueProgramIds   |
      | ValidProgramWithAllValidFieldsPresentInRequestBody | UniqueProgramIdOne |
      | ValidProgramWithMissingOptionalFieldInRequestBody  | UniqueProgramIdTwo |

  @Program_S4_GetProgramByID
  Scenario: Check if Admin able to retrieve a program with valid program ID
    When Admin creates and executes GET rogram with valid program ID Request for the LMS API
    Then Admin receives 200 OK Status with required program response body
    
  @Program_S5_PutByProgramID
  Scenario: Check if Admin able to update a program with valid programID endpoint and valid request body
	Given Admin creates PUT Request for the LMS Program API endpoint to "UpdateProgramWithAllValidFieldsPresentInRequestBody"
	When Admin sends HTTPS PUT Request with valid endpoint to update program 
	Then Admin receives 200 OK Status with updated value in program response body                                           

  @Program_S6_DeleteProgramByID
  Scenario: Check if Admin able to delete a program with valid program ID
    Given Admin creates DELETE Request for the LMS Program API endpoint and valid program ID
    When Admin sends HTTPS DELETE program by programId Request with valid endpoint
    Then Admin receives 200 Ok status with successful program deletion message
    
 @Program_S7_DeleteProgramByName
Scenario: Check if Admin able to delete a program with valid programName
Given Admin creates DELETE Request for the LMS API endpoint and valid programName
When Admin sends HTTPS DELETE program by programName Request with endpoint
Then Admin receives 200 Ok status with message
