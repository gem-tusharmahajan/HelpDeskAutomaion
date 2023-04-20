Feature: Ticket creation

  Background: Login Page

    Given User is on login Page of helpdesk
    Then Verify user is on homePage of helpdesk
    And Login into Helpdesk portal
    When Enter email id in input field
    When Enter password in input field
    When Click on "Yes" button
    Then Verify user is still on login page
    Then Verify user is on homePage of helpdesk
    And Select "Employee View" view

  Scenario Outline: Verify if ticket cancels from action button

    And Click on "create new ticket" button
    Then Verify create new ticket tab opens
    And Enter data in "<subject>" field
    And Click on "<Type>" button
    And Select "<select>" from options
    When Enter description in ticket window
    And Select "<Department>" in ticket window
    When Get all the required validation data
    And Click on submit button
    Then Verify ticket is created
    And Click on "continue" button
    And Click on "<deleteIcon>" button
    And Click on cancel button
    And Enter cancel ticket reason
    And Click on cancel ticket
    Then Verify ticket status is cancelled
    Examples:
      | subject | Type | select   | Department | deleteIcon |
      | Android | IT   | Incident | IT         | option     |
      | Android | IT   | Incident | Accounts   | option     |
      | Android | IT   | Incident | HR         | option     |
      | Android | IT   | Incident | Admin      | option     |


  Scenario Outline: Verify if ticket cancels from ticket details page

    And Click on "create new ticket" button
    Then Verify create new ticket tab opens
    And Enter data in "<subject>" field
    And Click on "<Type>" button
    And Select "<select>" from options
    And Enter description in ticket window
    And Select "<Department>" in ticket window
    When Get all the required validation data
    And Click on submit button
    Then Verify ticket is created
    And Click on "continue" button
    And Click on ticket id
    And Click on cancel ticket button
    And Enter cancel ticket reason
    And Click on cancel ticket

    Examples:
      | subject | Type     | select   | Department |
      | Android | IT       | Incident | IT         |
      | Android | Accounts | Incident | IT         |
      | Android | HR       | Incident | IT         |
      | Android | Admin    | Incident | IT         |
      | Android | Admin    | Incident | IT         |


  Scenario Outline: Verify if ticket cancels without cancel reason

    When Click on "create new ticket" button
    Then Verify create new ticket tab opens
    And Enter data in "<subject>" field
    And Click on "<Type>" button
    And Select "<select>" from options
    And Enter description in ticket window
    And Select "<Department>" in ticket window
    When Get all the required validation data
    And Click on submit button
    Then Verify ticket is created
    And Click on "continue" button
    And Click on ticket id
    And Click on cancel ticket button
    And Click on cancel ticket
    Then Verify ticket cancels

    Examples:
      | subject | Type     | select   | Department |
      | Android | IT       | Incident | IT         |
      | Android | Accounts | Incident | IT         |
      | Android | HR       | Incident | IT         |
      | Android | Admin    | Incident | IT         |


  Scenario Outline: Verify ticket details and timeline from ticket details page

    When Click on "create new ticket" button
    Then Verify create new ticket tab opens
    And Enter data in "<subject>" field
    And Click on "<Type>" button
    And Select "<select>" from options
    And Enter description in ticket window
    And Select "<Department>" in ticket window
    And Upload file
    When Get all the required validation data
    And Click on submit button
    Then Verify ticket is created
    And Click on "continue" button
    And Click on ticket id
    Then Verify ticket data with displayed data
    And Click on "timeline" button
    When Get timeline state
    And Click on cancel ticket button
    And Enter cancel ticket reason
    And Click on cancel ticket
    Then Verify ticket cancels
    And Click on ticket id
    And Click on "timeline" button
    Then Verify ticket timeline status is cancelled
    Examples:
      | subject | Type     | select   | Department |
      | Android | IT       | Incident | IT         |
      | Android | Accounts | Incident | IT         |
      | Android | HR       | Incident | IT         |
      | Android | Admin    | Incident | IT         |
