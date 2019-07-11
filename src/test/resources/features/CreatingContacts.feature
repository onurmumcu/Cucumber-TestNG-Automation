Feature: Creating contacts

  @rty
  Scenario: Create contact using CREATE page
    Given I logged into suiteCRM
    And I open the create contact page
    And I enter the first name "Kara" and the last name "Murat"
    And I enter the phone number "1453-1522"
    And I enter the department "hutyr"
    When I click on the save button
    Then I should see contact information for "Kara Murat"

@rty1
  Scenario Outline: Create multiple contacts
    Given I logged into suiteCRM
    And I open the create contact page
    And I enter the first name "<firstname>" and the last name "<lastname>"
    #here I created variables just like in Java
    And I enter the phone number "<phonenumber>"
    And I enter the department "<department>"

    When I click on the save button
    Then I should see contact information for "<firstname> <lastname>"
    Examples: 
      | firstname | lastname | phonenumber | department |
      | john      | travolta |    67856876 | movies     |
      | mohn      | cravolta |    87665644 | hovies     |
      #when I added second line, now it will fill the form and then close browser then it will do it again for the second line. just like a new step
      | ali       | veli     |     9088778 | hali       |
      | Bonnie    | Garcia   |      234523543 | IT         |
      | Rhiannon  | Morrison | 1-917-4613     | aa         |
      | Zeus      | Wright   | 1-328-4518     | ing        |
      | Samantha  | Maxwell  | 1-678-3953     | ss         |
      | Neil      | Sampson  | 1-826-6519     | ting       |
      | Teagan    | Larsen   | 1-247-2016     | dd         |
      | Kermit    | Goff     | 1-732-3727     | ing        |
      | Dennis    | Hoffman  | 1-602-5630     | ting       |
      | Quon      | Frank    | 1-191-8707     | sdf        |
      | Mason     | Mendez   | 1-710-5803     | sd         |
      | Herrod    | Berry    | 1-966-9204     | ing        |
      | Inez      | Slater   | 1-442-3808     | df         |
      | Todd      | Lyons    | 1-537-7100     | df         |
      | Brendan   | Meyer    | 1-1280-7814    | df         |