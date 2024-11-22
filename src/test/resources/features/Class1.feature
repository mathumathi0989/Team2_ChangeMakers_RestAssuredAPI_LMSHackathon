
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






