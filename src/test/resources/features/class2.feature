#Author: Mathumathi

Feature: Class 2 module

Background:  
Given Admin sets Authorization for class module


@GetAllRecordings
Scenario: Check if admin able to retrieve all class recording  
When Admin creates GET Request and sends HTTPS Request with endpoint for getAllRecordings
Then Admin receives 200 "OK" Status for getAllRecordings

@GetAllRecordings                                                             
Scenario: Check if admin able to retrieve all class recording with invalid Endpoint
When Admin creates GET Request and sends HTTPS Request with invalid endpoint for getAllRecordings
Then Admin receives 404 "Not Found" Status for getAllRecordings

@GetAllRecordings
Scenario: Check if admin able to retrieve all class recording with invalid method
When Admin creates Other Request and sends HTTPS Request with valid endpoint for getAllRecordings
Then Admin receives 405 "Method not allowed" Status for getAllRecordings

@GetAllRecordings
Scenario: Check if admin able to retrieve all class recording without Authorization
When Admin creates GET Request and sends HTTPS Request with valid endpoint but without Auth for getAllRecordings
Then Admin receives 401 "Unauthorized" Status for getAllRecordings


@GetClassRecordingsbyBatchId 
Scenario: Check if admin able to retrieve class recording  with valid Batchid
When Admin creates GET Request and sends HTTPS Request with endpoint for getClassRecordingsByBatchID
Then Admin receives 200 "OK" Status for getClassRecordingsByBatchID

@GetClassRecordingsbyBatchId 
Scenario: Check if admin able to retrieve  class recording with invalid Batchid
When Admin creates GET Request and sends HTTPS Request with invalid batchID for getClassRecordingsByBatchID
Then Admin receives 404 "Not Found" Status for getClassRecordingsByBatchID

@GetClassRecordingsbyBatchId 
Scenario: Check if admin able to retrieve class recording with invalid Endpoint
When Admin creates GET Request and sends HTTPS Request with invalid endpoint for getClassRecordingsByBatchID
Then Admin receives 404 "Not Found" Status for getClassRecordingsByBatchID

@GetClassRecordingsbyBatchId 
Scenario: Check if admin able to retrieve class recording with invalid method
When Admin creates Other Request and sends HTTPS Request with valid endpoint for getClassRecordingsByBatchID
Then Admin receives 405 "Method not allowed" Status for getClassRecordingsByBatchID

@GetClassRecordingsbyBatchId 
Scenario: Check if admin able to retrieve  class recording without Authorization
When Admin creates GET Request and sends HTTPS Request with valid endpoint but without Auth for getClassRecordingsByBatchID
Then Admin receives 401 "Unauthorized" Status for getClassRecordingsByBatchID


@GetClassRecordingsbyClassId
Scenario: Check if admin able to retrieve class recording  with valid ClassID
When Admin creates GET Request and sends HTTPS Request with endpoint for getClassRecordingsByClassID
Then Admin receives 200 "OK" Status for getClassRecordingsByClassID

@GetClassRecordingsbyClassId
Scenario: Check if admin able to retrieve  class recording with invalid ClassID
When Admin creates GET Request and sends HTTPS Request with invalid batchID for getClassRecordingsByClassID
Then Admin receives 404 "Not Found" Status for getClassRecordingsByClassID

@GetClassRecordingsbyClassId
Scenario: Check if admin able to retrieve class recording with invalid Endpoint
When Admin creates GET Request and sends HTTPS Request with invalid endpoint for getClassRecordingsByClassID
Then Admin receives 404 "Not Found" Status for getClassRecordingsByClassID

@GetClassRecordingsbyClassId
Scenario: Check if admin able to retrieve class recording with invalid method
When Admin creates Other Request and sends HTTPS Request with valid endpoint for getClassRecordingsByClassID
Then Admin receives 405 "Method not allowed" Status for getClassRecordingsByClassID

@GetClassRecordingsbyClassId
Scenario: Check if admin able to retrieve  class recording without Authorization
When Admin creates GET Request and sends HTTPS Request with valid endpoint but without Auth for getClassRecordingsByClassID
Then Admin receives 401 "Unauthorized" Status for getClassRecordingsByClassID


@GetClassRecordingsbyClassId2
Scenario: Check if admin able to retrieve class recording  with valid ClassID
When Admin creates GET Request and sends HTTPS Request with endpoint for getClassRecordingsByClassID2
Then Admin receives 200 "OK" Status for getClassRecordingsByClassID2

@GetClassRecordingsbyClassId2
Scenario: Check if admin able to retrieve  class recording with invalid ClassID
When Admin creates GET Request and sends HTTPS Request with invalid batchID for getClassRecordingsByClassID2
Then Admin receives 404 "Not Found" Status for getClassRecordingsByClassID2

@GetClassRecordingsbyClassId2
Scenario: Check if admin able to retrieve class recording with invalid Endpoint
When Admin creates GET Request and sends HTTPS Request with invalid endpoint for getClassRecordingsByClassID2
Then Admin receives 404 "Not Found" Status for getClassRecordingsByClassID2

@GetClassRecordingsbyClassId2
Scenario: Check if admin able to retrieve class recording with invalid method
When Admin creates Other Request and sends HTTPS Request with valid endpoint for getClassRecordingsByClassID2
Then Admin receives 405 "Method not allowed" Status for getClassRecordingsByClassID2

@GetClassRecordingsbyClassId2
Scenario: Check if admin able to retrieve  class recording without Authorization
When Admin creates GET Request and sends HTTPS Request with valid endpoint but without Auth for getClassRecordingsByClassID2
Then Admin receives 401 "Unauthorized" Status for getClassRecordingsByClassID2


@GetUpcomingClasses
Scenario: Check if admin able to retrieve upcoming classes with valid studentID
When Admin creates GET Request and sends HTTPS Request with endpoint for getUpcomingClasses
Then Admin receives 200 "OK" Status for getUpcomingClasses

@GetUpcomingClasses
Scenario: Check if admin able to retrieve upcoming classes with invalid studentID
When Admin creates GET Request and sends HTTPS Request with invalid studentID for getUpcomingClasses
Then Admin receives 404 "Not Found" Status for getUpcomingClasses

@GetUpcomingClasses
Scenario: Check if admin able to retrieve upcoming classes with invalid Endpoint
When Admin creates GET Request and sends HTTPS Request with invalid endpoint for getUpcomingClasses
Then Admin receives 404 "Not Found" Status for getUpcomingClasses

@GetUpcomingClasses
Scenario: Check if admin able to retrieve upcoming classes with invalid method
When Admin creates Other Request and sends HTTPS Request with valid endpoint for getUpcomingClasses
Then Admin receives 405 "Method not allowed" Status for getUpcomingClasses

@GetUpcomingClasses
Scenario: Check if admin able to retrieve upcoming classes without Authorization
When Admin creates GET Request and sends HTTPS Request with valid endpoint but without Auth for getUpcomingClasses
Then Admin receives 401 "Unauthorized" Status for getUpcomingClasses




