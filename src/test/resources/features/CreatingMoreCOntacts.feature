Feature: Creating more contacts

  @create_contact
  Scenario: Cretae contacts with using a map
    Given I logged into suiteCRM
    When I create a new contact:
      | first_name   | John         |
      | last_name    | Smith        |
      | office_phone | 389-566-0987 |
      | cell_phone   | 908-876-1234 |
    Then I should see contact information for "John Smith"
   # And the followong contact should be created
    # | first_name   | John         |
     # | last_name    | Smith        |
      #| office_phone | 389-566-0987 |
    
