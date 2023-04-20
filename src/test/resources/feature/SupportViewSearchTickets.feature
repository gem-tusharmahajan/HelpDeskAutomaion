Feature: Search my tickets functionalities for support view

  Background: Login into helpdesk
    Given User is on login Page of helpdesk
    Given Login into Helpdesk portal
    When Enter email id in input field
    When Enter password in input field
    And  Click on "Yes" button
    Then Verify user is still on login page
    Then Verify user is on homePage of helpdesk
    And  Select "Support View" view

  Scenario: Search valid keyword
    When Click on "searchBar" button
    And Enter "Leave Request" in searchbar
    Then Verify ticket with correct "Leave Request" is displayed

  Scenario: Search invalid keyword
    And Click on "searchBar" button
    And Enter "Dubai" in searchbar
    Then Verify ticket with correct "Dubai" is displayed

  Scenario Outline:Search ticket using ticket id and subject
    And Click on "searchBar" button
    When Enter "<Keyword>" in searchbar
    And Click on "search" button
    Then Verify selected ticket is displayed

    Examples:
      | Keyword       |
      | Leave Request |
      | INC-000004621 |

  Scenario: Cross icon to remove entered text
    And  Click on "searchBar" button
    And Enter "Leave Request" in searchbar
    And  Click on "search" button
    And  Click on cross button and verify all the tickets are displayed


  Scenario: Enter invalid text in searchbar
    Then Verify user is on homePage of helpdesk
    When Click on "searchBar" button
    And Enter "wrong" in searchbar
    And Click on "search" button
    Then Verify selected ticket is displayed

  Scenario: Search ticket using Enter Key
    When Click on "searchBar" button
    And Enter ticket id in searchbar
    And Press enter key
    Then Verify selected ticket is displayed

#  Scenario: Search ticket using subject by pressing Enter Key.
#    When Click on "searchBar" button
#    And Enter subject in searchbar
#    And Press enter key
#    Then Verify selected ticket with subject is displayed
#
#  Scenario: Search ticket using ticket subject.
#    Then Verify user is on homePage of helpdesk
#    And Click on "searchBar" button
#    And Enter subject in searchbar
#    And Click on "search" button
#    Then Verify selected ticket is displayed