Feature: BatchModule : positive flow

  Background: Admin sets Authorization to Bearer Token for Batch Module
    Given Admin provides valid UserName and PassWord

  @GetAllBatches-(Positive1)
  Scenario: Check if Admin able to retrieve all batches with valid Endpoint
    When Admin creates and executes GET all batches Request for the LMS API
    Then Admin receives 200 OK Status for getALLBatches

  @GetAllBatches-(Positive2)
  Scenario: Check if admin able to retrieve all batches with search string
    When Admin creates and executes GET all batches Request with search string for the LMS API
    Then Admin receives 200 OK Status for getALLBatches2

  @GetBatchByBatchID-(Positive3)
  Scenario: Check if admin able to retrieve a batch with valid batch ID
    When Admin creates and executes GET batch with valid batch ID Request for the LMS API
    Then Admin receives 200 OK Status for getBatchByBatchID

  @GetBatchByBatchID-(Positive4)
  Scenario: Check if admin able to retrieve a batch after deleting the batch
    When Admin creates GET Request with valid Batch ID
    Then Admin receives 200 OK Status with  batchStatus field "OK" in the response body

  @GetBatchByBatchName-(Positive5)
  Scenario: Check if Admin able to retrieve a batch with valid batch Name
    When Admin creates and executes GET batch with valid batch Name Request for the LMS API
    Then Admin receives 200 OK Status for getBatchByBatchName

  @GetBatchByBatchName-(Positive6)
  Scenario: Check if admin able to retrieve a deleted batch using batch name
    When Admin creates GET Request with batch Name
    Then Admin receives 200 OK Status for Get Batch By Batch Name

  @GetBatchByProgramID-(Positive7)
  Scenario: Check if Admin able to retrieve a batch with valid Program ID
    When Admin creates and executes GET batch with valid program ID
    Then Admin receives 200 OK Status with response body for GetBatchByProgramId

  @PostNewBatch-(Positive8)
  Scenario: Check if Admin able to create a batch with valid endpoint and request body (non-existing values)
    When Admin creates POST Request  with valid data in request body
    Then Admin receives Created Status for post new batch with status code 201 and response message "Created"

  @PostNewBatch-(Positive9)
  Scenario: Check if admin able to create a batch with missing additional fields
    When Admin creates POST Request with missing additional fields
    Then Admin receives Created Status for post2 new batch with status code 201 and response message "Created"

  @Put(UpdateBatchByBatchID)-(Positive10)
  Scenario: Check if admin able to update a Batch with valid batchID and mandatory fields in request body
    When Admin creates PUT Request with valid BatchId and Data
    Then Admin receives updated Status for put with status code 200 and response message "OK"

  @Put(UpdateBatchByBatchID)-(Positive11)
  Scenario: Check if admin able to update a Batch with a deleted batchID in the endpoint
    When Admin creates PUT Request with deleted batch Id
    Then Admin receives updated Status for put2 with status code 200 and response message "OK"

  @DeleteBatchByBatchID-(Positive12)
  Scenario: Check if Admin able to delete a batch with valid Batch ID
    When Admin creates DELETE request with valid batch ID
    Then Admin receives 200 OK Status with message for DeleteBatchByBatchID

  @GetAllBatches-(Negative1)
  Scenario: Check if admin able to retrieve all batches with invalid Endpoint
    When Admin creates GET Request (Negative1)
    Then Admin receives 404 status with error message Not Found

  @GetAllBatches-(Negative2)
  Scenario: Check if admin able to retrieve all batches without Authorization
    When Admin creates GET Request (Negative2)
    Then Admin receives 401 status with error message Unauthorized

  @GetBatchByBatchID-(Negative3)
  Scenario: Check if admin able to retrieve a batch with batch ID without authorization
    When Admin creates GET Request with valid Batch ID (Negative3)
    Then Admin receives 401 Status with error message unauthorized for GetAllBatches

  @GetBatchByBatchID-(Negative4)
  Scenario: Check if admin able to retrieve a batch with invalid BATCH ID
    When Admin creates GET Request with invalid Batch ID (Negative4)
    Then Admin receives 404 Not Found Status with message and boolean success details

  @GetBatchByBatchID-(Negative5)
  Scenario: Check if admin able to retrieve a batch with invalid endpoint
    When Admin creates GET Request with valid Batch ID (Negative5)
    Then Admin receives 404 not found Status

  @GetBatchByBatchName-(Negative6)
  Scenario: Check if admin able to retrieve a batch without authorization
    When  Admin creates GET Request with batch Name(Negative6)
    Then Admin receives 401  Status with error message unauthorized

  @GetBatchByBatchName-(Negative7)
  Scenario: Check if admin able to retrieve a batch with invalid BATCH NAME
    When  Admin creates GET Request with invalid Batch Name(Negative7)
    Then Admin receives 404 Not Found Status with message and boolean success details1

  @GetBatchByBatchName-(Negative8)
  Scenario: Check if admin able to retrieve a batch with invalid endpoint1
    When  Admin creates GET Request with valid Batch Name(Negative8)
    Then Admin receives 404 Not found

  @GetBatchByProgramID-(Negative9)
  Scenario: Check if admin able to retrieve a batch with program ID without authorization
    When Admin creates GET Request with program id(Negative9)
    Then Admin receives 401  Status with error message unauthorized for GetBatchByProgramId

  @GetBatchByProgramID-(Negative10)
  Scenario: Check if admin able to retrieve a batch with invalid Program Id
    When Admin creates GET Request with invalid Program Id
    Then Admin receives 404 Not Found Status with message and boolean success details for GetBatchByProgramId

  @GetBatchByProgramID-(Negative10)
  Scenario: Check if admin able to retrieve a batch with invalid endpoint
    When Admin creates GET Request with invalid endpoint(Negative10)
    Then Admin receives 404  Status with  error message Not Found for GetBatchByProgramId

  @GetBatchByProgramID-(Negative11)
  Scenario: Check if admin able to retrieve a batch after the programID is deleted
    When Admin creates GET Request with program id(Negative11)
    Then Admin receives 404 Not Found Status with message and boolean success details for batch

  @PostNewBatch-(Negative12)
  Scenario: Check if admin able to create a Batch with valid endpoint and request body without authorization
    When Admin creates POST Request  with valid data in request body(Negative12)
    Then Admin receives 401 Unauthorized for post new batch

  @PostNewBatch-(Negative13)
  Scenario: Check if admin able to create a Batch with valid endpoint and request body (existing value in Batch Name)
    When Admin creates POST Request  with existing value in request body(Negative13)
    Then Admin receives 400 Bad Request Status with message and boolean success details

  @PostNewBatch-(Negative14)
  Scenario: Check if admin able to create a Batch missing mandatory fields in request body
    When Admin creates POST Request with invalid data in request body(Negative14)
    Then Admin receives 400 Bad Request Status with message and boolean success details(Negative14)

  @PostNewBatch-(Negative15)
  Scenario: Check if admin able to create a batch with invalid endpoint
    When Admin creates POST Request body(Negative15)
    Then Admin receives 404 not found  Status(Negative15)

  @PostNewBatch-(Negative16)
  Scenario: Check if admin able to create a batch with invalid data in request body
    When Admin creates POST Request with invalid data in request body(Negative16)
    Then Admin receives 400 Bad Request Status with message and boolean success details(Negative16)

  @PostNewBatch-(Negative17)
  Scenario: Check if admin able to create a batch  with inactive program ID
    When Admin creates POST Request with inactive program id(Negative17)
    Then Admin receives 400 Bad Request Status with message and boolean success details(Negative17)

  @Put(UpdateBatchByBatchID)-(Negative18)
  Scenario: Check if admin able to update a Batch with valid batchID and mandatory fields in request body without authorization
    When Admin creates PUT Request with valid BatchId and Data(Negative18)
    Then Admin receives 401 unauthorized status for UpdateBatchByBatchID

  @Put(UpdateBatchByBatchID)-(Negative19)
  Scenario: Check if admin able to update a Batch with invalid batchID and mandatory fields in request body without authorization
    When Admin creates PUT Request with invalid BatchId and valid Data(Negative19)
    Then Admin receives 404 Not Found Status with message and boolean success details for UpdateBatchByBatchID

  @Put(UpdateBatchByBatchID)-(Negative20)
  Scenario: Check if admin able to update a Batch with valid batchID and missing mandatory fields request body
    When Admin creates PUT Request with valid batch Id and missing mandatory fields(Negative20)
    Then  Admin receives 400 Bad Request Status with message and boolean success details for UpdateBatchByBatchID

  @Put(UpdateBatchByBatchID)-(Negative21)
  Scenario: Check if admin able to update a batch with invalid data
    When Admin creates PUT Request with invalid data(Negative21)
    Then  Admin receives 400 Bad Request Status with message and boolean success details for UpdateBatchByBatchID1

  @Put(UpdateBatchByBatchID)-(Negative22)
  Scenario: Check if admin able to update a Batch with invalid endpoint
    When Admin creates PUT Request with Valid batch Id(Negative22)
    Then  Admin receives 404 not found for UpdateBatchByBatchID

  @Put(UpdateBatchByBatchID)-(Negative23)
  Scenario: Check if admin able to update a Batch with a valid batchID and deleted programID field in the request body with other mandatory fields
    When Admin creates PUT Request with Valid batch Id(Negative23)
    Then  Admin receives 400 Bad Request Status with message and boolean success details for UpdateBatchByBatchID2

  @DeleteBatchByBatchID-(Negative24)
  Scenario: Check if admin able to delete a Batch with invalid endpoint
    When Admin creates DELETE Request with valid BatchId(Negative24)
    Then Admin receives 404 not found for DeleteBatchByBatchID

  @DeleteBatchByBatchID-(Negative26)
  Scenario: Check if admin able to delete a Batch without authorization
    When Admin creates DELETE Request with valid BatchId(Negative26)
    Then Admin receives 401 Unauthorized Status for DeleteBatchByBatchID