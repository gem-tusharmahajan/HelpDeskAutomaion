Feature: Search my tickets functionalities

  Background: Login Page
    Given User is on login Page of helpdesk
    Then Verify user is on homepage of helpdesk
    Given Login into Helpdesk portal
    When Enter email id in input field
    When Enter password in input field
    And  Click on "Yes" button
    And  Select "Employee View" view

    Scenario: Search valid keyword
    When Click on "searchBar" button
    And Enter "@@@" in searchbar
    Then Verify ticket with correct "@@@" is displayed


    Scenario: Search invalid keyword
    And Click on "searchBar" button
    And Enter "Dubai" in searchbar
    Then Verify ticket with correct "Dubai" is displayed


    Scenario Outline:Search ticket using ticket id and subject
      And Click on "<searchBar>" button
      When Enter "<Keyword>" in searchbar
      And Click on "<search>" button
      Then Verify selected ticket is displayed

      Examples:
       | search  | searchBar |  Keyword   |
       | search  | searchBar |  Android   |
       | search  | searchBar |  INC-000001106   |

Scenario: Cross icon to remove entered text
  And  Click on "searchBar" button
  And Enter "Android" in searchbar
  And  Click on "search" button
  And  Click on cross button and verify all the tickets are displayed



  Scenario: Enter invalid text in searchbar
    Then Verify user is on HomePage of Helpdesk
    When Click on "searchBar" button
    And Enter "wrong" in searchbar
    And Click on "search" button
    Then Verify selected ticket is displayed


      Scenario: Search ticket using Enter Key
        When Click on "searchBar" button
        And Enter ticket id in searchbar
        And Press enter key
        Then Verify selected ticket is displayed

  Scenario: Search ticket using subject by pressing Enter Key.
    When Click on "searchBar" button
    And Enter subject in searchbar
    And Press enter key
    Then Verify selected ticket with subject is displayed

  Scenario: Search ticket using ticket subject.
    Then Verify user is on HomePage of Helpdesk
    And Click on "searchBar" button
    And Enter subject in searchbar
    And Click on "search" button
    Then Verify selected ticket is displayed

