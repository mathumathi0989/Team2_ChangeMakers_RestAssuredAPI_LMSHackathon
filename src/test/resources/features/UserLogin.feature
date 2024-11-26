
 Feature: User login : positive flow
 
 Background: Admin sets Authorization 
Given Admin provides valid authentication details
 
 
      Scenario:  Admin creates request with valid credentials login
                 When Admin calls Post Https method  with valid endpoint login 
                 Then Admin receives 200 OK Status with program response body                                                  
    
          
 Scenario: Check if Admin able to generate token with invalid endpoint login
            When Admin calls Post Https method with invalid endpoint login 
            Then Admin receives 401 unauthorized status login
            
            Scenario: Check if Admin able to generate token with invalid credentials login1
            When Admin calls Post Https method with valid endpoint login1
            Then Admin receives 400 Bad request login
  
  
          
          
        

 