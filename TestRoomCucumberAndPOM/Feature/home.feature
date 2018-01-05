Feature: reading the text and handleing the window 
         in home page
         
 Scenario: reading the text from the home page
   Given user is on the home landing page
   Then user reads the welcome text
   And also reads the description
  
  Scenario: hadndeling the new window and read the text
      Given user clicks on the terms
      When new window will open
      Then read the text from the new window