Feature: Note on Dashboard


Background: Given I logged into suiteCRM
#When I use background it runs before every Scenario there is no crash between this and our hook class
  Scenario: Post a note on Dashboard
   
    When I post "Hello Everyone"
    Then Post should be displayed
    Then I logout from application


	@smoke
  Scenario: Post another note on Dashboard
#    Given I logged into suiteCRM
#I commented the above method because I used background method.
    When I post "Hello Everyone"
    Then Post should be displayed
    Then I logout from application