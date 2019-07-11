Feature: sugarCrm menu options

Scenario: Verify collaboration menu options are visible
Given I logged into suiteCRM
When I hover over the Collaboration menu
Then following menu options should be visible for Collaboration:
|Home|
|Emails|
|Documents|
|Projects|
#I am doing above line with all these following scenarios
#Then "home" menu option should be visible for collaboration:
#Then "Emails" menu option should be visible for collaboration:
#Then "Documents" menu option should be visible for collaboration:
#Then "Projects" menu option should be visible for collaboration:


  @f&f
  Scenario: Verify Support menu options
    Given I logged into suiteCRM
    When I hover over the Support menu
    Then following menu options should be visible for Support:
      | Home     |
      | Accounts |
      | Contacts |
      | Cases    |
       
   @f&f
  Scenario: Verify Sales menu options
    Given I logged into suiteCRM
    When I hover over the Sales menu
    Then following menu options should be visible for Sales:
      | Home     |
      | Accounts |
      | Contacts |
      | Cases    | 