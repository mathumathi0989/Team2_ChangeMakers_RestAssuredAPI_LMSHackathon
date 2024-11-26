
Feature: Class1Module : Positive flow
  Background: 
  Given Admin sets Authorization for class1 module
  
  
  
  @GetAllClasses
  Scenario: Check if admin able to retrieve all classes  with valid Endpoint
  When Admin creates GET Request and Admin sends HTTPS Request with endpoint for class   
  Then Admin receives 200 "OK" Status with response body for class                                                                
  
   
  @createClass
  Scenario: Check if admin is able to create class with all valid details
  When Admin creates POST Request with request body for create class
  Then Admin receive 201 "Created" Status for createClass
  
  @createclasswithonlymandatory
  Scenario: Check if admin is able to create class with only mandatory 
  When Admin creates POST Request with request body for mandatory createClass
  Then Admin receive 201 status for createClass
  
 
  @createclasswithonlyadditionalfieldvalues
  Scenario: Check if admin is able to create class with only additional field values
  When  Admin creates POST Request for only addditional field values createClass
  Then  Admin receive 400 status for createClass
  
  
  @GetAllClasseswithinvalidendpoint
  Scenario: Check if admin able to retrieve all  classes with invalid Endpoint
  When Admin creates GET Request and Admin sends HTTPS Request with invalid endpoint for class 
  Then Admin receives 404 status with error message Not Found for class
  
  @Getallclasseswithinvalidmethod
  Scenario: Check if admin able to retrieve all  classes with invalid method
  When Admin creates GET Request and Admin sends HTTPS Request with invalid method endpoint for class
  Then Admin receives 405 Method not allowed status visible for class

  @Getallclasseswithoutauthorization
  Scenario: Check if admin able to retrieve all classes without Authorization
  When  Admin creates GET Request and admin sends HTTPS Request  without Authorization for class
  Then  Admin receives 401 status with error message Unauthorized for class

  @GetClassdetailswithvalidclasstopic
   Scenario: Check if admin able to retrieve Class details  with valid classtopic 
   When  Admin creates GET Request and Admin sends HTTPS Request with endpoint for a class  
   Then  Admin receives 200 OK Status with response body for class             
  
  @Getalclasseswithinvalidclasstopic
   Scenario: Check if admin able to retrieve all classes with invalid classtopic
   When  Admin creates GET Request and Admin sends HTTPS Request with invalid classtopic endpoint for class 
   Then  Admin receives 404 Not Found Status with message visible for class
   
  @GetallclasseswithinvalidEndpoint
   Scenario: Check if admin able to retrieve all  classes with invalid Endpoint
   When  Admin creates GET Request and Admin sends HTTPS Request with invalid endpoint 
   Then  Admin receives 404 "Not Found" Status with message visible
   
   @Getallclasseswithinvalidmethod
   Scenario: Check if admin able to retrieve all  classes with invalid method
   When  Admin creates GET Request and Admin sends HTTPS Request with not valid  method endpoint for class 
   Then  Admin receives 405 and "Method Not Allowed" status visible for class
   
   @GetClassdetailswithoutAuthorization
  Scenario: Check if admin able to retrieve Class details without Authorization
  When Admin creates GET Request and Admin sends HTTPS Request without Authorization for classtopic
  Then Admin receives 401 status with error message of "Unauthorized" for class
   
   @GetClassdetailswithvalidclassId
   Scenario: Check if admin able to retrieve Class details  with valid classId
   When Admin creates GET Request and Admin sends HTTPS Request with valid classId endpoint for class
   Then Admin receives 200 "OK" Status with response body with valid classId for class
   
  @GetClassdetailswithinvalidclassId
  Scenario: Check if admin able to retrieve Class details with invalid classId 
  When Admin creates GET Request  and Admin sends HTTPS Request with invalid classid endpoint for class  
  Then Admin receives 404 "Not Found" Status with message visible for class
  
  @GetClassdetailswithinvalidEndpoint
  Scenario: Check if admin able to retrieve Class details with invalid Endpoint
  When Admin creates GET Request for invalid endpoint and Admin sends HTTPS Request with invalid endpoint  for class
  Then Admin receives 404 "Not Found" Status with message for invalid endpoint  visible for class
  
  
  @GetClassdetailswithinvalidmethod
  Scenario: Check if admin able to retrieve Class details with invalid method
  When Admin creates GET Request for invalid method and Admin sends HTTPS Request with endpoint for class
  Then Admin receives 405 and "Method Not Allowed" status visible of invalid method for class 
 
  @GetClassdetailswithclassidwithoutAuthorization
  Scenario: Check if admin able to retrieve Class details without Authorization
  When Admin creates GET Request and Admin sends HTTPS Request without Authorizationwith endpoint for class
  Then Admin receives 401 status with error message of "Unauthorized" for class
  
  @DeleteaclasswithvalidclassID
  Scenario: Check if admin able to delete a class with valid class ID
  When Admin creates DELETE Request with valid classId and Admin sends HTTPS Request  with endpoint for class
  Then Admin receives 200 Ok status with message for class
 
  
  @Deleteaclasswithinvalidendpoint
  Scenario: Check if admin able to delete a class with invalid endpoint
  When Admin creates DELETE Request with valid classId and Admin sends HTTPS Request  with invalid endpoint for class
  Then Admin receives 404 not found for class

  
  @DeleteaclasswithinvalidclassID
  Scenario: Check if admin able to delete a class with invalid class ID
  When Admin creates DELETE Request with invalid classId and Admin sends HTTPS Request  with endpoint for class
  Then Admin receives 404 Not Found Status with message and boolean success details for class
  

  
  
  @deleteaclasswithoutauthorization
  Scenario: Check if admin able to delete a class without authorization
  When Admin creates DELETE Request without authorization with valid classId and Admin sends HTTPS Request  with endpoint for class
  Then Admin receives 401 Unauthorized Status  for class
  
  

 
  #@createclasswithinvaliddata
  #Scenario: Check if admin is able to create class with invalid data
  #When Admin creates POST Request for the LMS with invalid data and Admin calls "POST " request with endpoint for class
  #Then Admin receive 400 with error message for class
  #
  #
  #@createclasswithexistingclasstopic
  #Scenario: Check if admin is able to create class with existing class topic
  #When  Admin creates POST request for the LMS with existing class topic and Admin calls "POST " request with endpoint for class
  #Then  Admin receive 400 with error message for class
  #
  #@createclasswithoutrequestbody
  #Scenario: Check if admin is able to create class without request body
  #When Admin create POST request for the LMS without request body and Admin calls "POST " request with endpoint for class
  #Then Admin receive 400 / 415 status code for class
  #
  #
  #@createclasswithinvalidendpoint
  #Scenario: Check if admin is able to create class with invalid endpoint
  #When  Admin create POST request for the LMS with valid request and Admin calls "POST " request with invalid endpoint for class
  #Then  Admin receive 404 Not found for class
  #
  #@createclasswithinvalidbaseURL
  #Scenario: Check if admin is able to create class with invalid baseURL
  #When Admin create POST request for the LMS with invalid baseURL and Admin calls "POST " request with endpoint for class
  #Then Admin receive 404 Not found  for class  
  #
  #@createclasswithoutauth
  #Scenario: Check if admin is able to create class without auth
  #When Admin creates POST Request for the LMS with request body and Admin calls "POST" request with endpoint  for class
  #Then Admin receives 401 unauthorized for class
 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  