
Feature: Class1Module : Positive flow
  Background: 
  Given Admin sets Authorization for class1 module
  
  @GetAllClasses
  Scenario: Check if admin able to retrieve all classes  with valid Endpoint
  When Admin creates GET Request and Admin sends HTTPS Request with endpoint for class   
  Then Admin receives 200 "OK" Status with response body for class                                                                
    
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
   Then  Admin receives 405 and "Method not allowed" status visible for class
   
   @GetClassdetailswithoutAuthorization
  Scenario: Check if admin able to retrieve Class details without Authorization
  When Admin creates GET Request and Admin sends HTTPS Request with endpoint for class
  Then Admin receives 401 status with error message of Unauthorized for class
   
   @GetClassdetailswithvalidclassId
   Scenario: Check if admin able to retrieve Class details  with valid classId
   When Admin creates GET Request and Admin sends HTTPS Request with valid classId endpoint for class
   Then Admin receives 200 "OK" Status with response body with valid classId for class
  