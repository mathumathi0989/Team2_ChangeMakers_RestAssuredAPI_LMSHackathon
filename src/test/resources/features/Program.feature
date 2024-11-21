Feature: ProgramModule : positive flow
  
Background: Admin sets Authorization 
Given Admin provides valid authentication details


@GetAllPrograms
Scenario: Check if Admin able to retrieve all programs with valid Endpoint
    When Admin creates and executes GET all program Request for the LMS API
    Then Admin receives 200 OK Status with program response body                                                        
    
#@PostNewProgram
#Scenario: Check if Admin able to create a program with valid endpoint and request body with Authorization
    #When Admin creates and executes POST program Request for the LMS with request body
    #Then Admin receives 201 Created Status with program response body
    #
#@GetProgramByID
#Scenario: Check if Admin able to retrieve a program with valid program ID
    #When Admin creates and executes GET rogram with valid program ID Request for the LMS API
    #Then Admin receives 200 OK Status with required program response body.                                                          