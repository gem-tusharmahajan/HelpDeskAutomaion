Feature: Support view functions

  Background: Login into helpdesk
    Given User is on login Page of helpdesk
    And Login into Helpdesk portal
    When Enter email id in input field
    When Enter password in input field
    And Click on "Yes" button
    Then Verify user is still on login page
    Then Verify user is on homePage of helpdesk
    And Select "Support View" view

  Scenario: Verify user is on Support view HomePage
    Then Verify support view window opens

  Scenario: Verify Count of tickets in Assigned window
    When Get "Assigned" ticket count
    Then Verify ticket count at header is same as footer

  Scenario: Verify Count of tickets in unAssigned window
    When Get "Unassigned" ticket count
    Then Verify ticket count at header is same as footer for unassigned

  Scenario: Verify Count of tickets in My Department window
    When Get "My Department" ticket count
    Then Verify ticket count at header is same as footer for unassigned

  Scenario Outline: Verify VIP button functionality
    And Click on "VIP" button
    When Select "<tab>" on dashboard in support view
    Then Verify ticket displays with vip tag for "<tab>"
    Examples:
      | tab           |
      | Assigned      |
      | Unassigned    |
      | My Department |

  Scenario: ticket assigns from dashboard
    And Click on "Unassigned" button
    And Click on "unassignedTicketId" button
    When get status of ticket
    And Click on "arrowDown" button
    And Click on "Assign" button
    When get ticket id from dashboard
    And Click on "Assign Tab" button
    And Click on "searchBar" button
    And Enter ticket id in searchField
    And Click on "search" button
    And Click on "AssignedTicketId" button
    Then Verify status of ticket changes

  Scenario Outline: Ticket status changes
#    And Click on "My Department" button
#    When check table is empty
    And Click on "AssignedTicketId" button
    When get status of ticket
    And Click on "statusArrow" button
    And Click on "arrowDown" button
    And Click on "<Status>" button
    Then Verify status of ticket changes
    Examples:
      | Status   |
      | Resolved |
      | On-Hold  |
