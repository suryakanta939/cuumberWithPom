Feature: in adoption check the availability of the animals 
          by selecting the dates.After finding any availabilty 
          enter the details of the user.
          
Background: user will be on the adoptionpage
    Given user is on the landing page
    When user clicks on the adoption
    Then will confirm that user is on adoption page
   
 Scenario: read all the animal name and its type
    Then user can see the adoption page and the animals
    And  user will note the available animals
    
 Scenario: checking the availabilty of lion
     Given user will select the date
     When user will click on the check
     Then user has to note the availabity
     
 Scenario: checking the availabilty of turtle
     Given user will select the date
     When user will click on the check for turtle
     Then user has to note the availabity
     Then user will enter "suriya" and "Cuttack"
     And then will enter "754031" and "surya.east09@gmail.com"
     Then will click on the check button