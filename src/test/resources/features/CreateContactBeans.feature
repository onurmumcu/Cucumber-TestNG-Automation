Feature: Creating more contacts with bean

  @create_contacta
  Scenario: Create contacts with using beans
    Given I logged into suiteCRM
    When I save a new contact:
      | firstName | lastName | department | officePhone | cellPhone | email        |
      | ali       | veli     | IT         |  987654321| 123456789 | ali@veli.org |
    
    Then I should see contact information for "ali veli"
