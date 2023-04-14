Feature: Ticket creation

  Background: Login Page

    Given User is on login Page of helpdesk
    Then Verify user is on homepage of helpdesk
    And Login into Helpdesk portal
    When Enter email id in input field
    When Enter password in input field
    When Click on "Yes" button
    Then Verify user is still on login page
    And Select "Employee View" view

  Scenario Outline: Verify if ticket cancels from action button

    And Click on "<create new ticket>" button
    Then Verify create new ticket tab opens
    And Enter data in "<subject>" field
    And Click on "<Type>" button
    And Select "<select>" from options
    When Enter description in ticket window
    And Select "<Department>" in ticket window
    When Get all the required validation data
    And Click on submit button
    Then Verify ticket is created
    And Click on "<continue>" button
    And Click on "<deleteIcon>" button
    And Click on cancel button
    And Enter cancel ticket reason
    And Click on cancel ticket
    Then Verify ticket status is cancelled
    Examples:
      | create new ticket | subject | Type | select   | Department | continue | deleteIcon       |
      | create new ticket | Android | IT   | Incident | IT         | continue | option |
      | create new ticket | Android | IT   | Incident | Accounts         | continue | option |
      | create new ticket | Android | IT   | Incident | HR         | continue | option |
      | create new ticket | Android | IT   | Incident | Admin         | continue | option |



  Scenario Outline: Verify if ticket cancels from ticket details page

    And Click on "<create new ticket>" button
    Then Verify create new ticket tab opens
    And Enter data in "<subject>" field
    And Click on "<Type>" button
    And Select "<select>" from options
    And Enter description in ticket window
    And Select "<Department>" in ticket window
    When Get all the required validation data
    And Click on submit button
    Then Verify ticket is created
    And Click on "<continue>" button
    And Click on ticket id
    And Click on cancel ticket button
    And Enter cancel ticket reason
    And Click on cancel ticket

    Examples:
      | create new ticket | subject | Type | select   | Department | continue |
      | create new ticket | Android | IT   | Incident | IT         | continue |
      | create new ticket | Android | Accounts   | Incident | IT         | continue |
      | create new ticket | Android | HR   | Incident | IT         | continue |
      | create new ticket | Android | Admin   | Incident | IT         | continue |
      | create new ticket | Android |   Admin    | Incident |     IT     | continue |



  Scenario Outline: Verify if ticket cancels without cancel reason

    When Click on "<create new ticket>" button
    Then Verify create new ticket tab opens
    And Enter data in "<subject>" field
    And Click on "<Type>" button
    And Select "<select>" from options
    And Enter description in ticket window
    And Select "<Department>" in ticket window
    When Get all the required validation data
    And Click on submit button
    Then Verify ticket is created
    And Click on "<continue>" button
    And Click on ticket id
   And Click on cancel ticket button
    And Click on cancel ticket
    Then Verify ticket cancels

    Examples:
      | create new ticket | subject | Type | select   | Department | continue |
      | create new ticket | Android | IT   | Incident | IT         | continue |
      | create new ticket | Android | Accounts   | Incident | IT         | continue |
      | create new ticket | Android | HR   | Incident | IT         | continue |
      | create new ticket | Android |   Admin    | Incident |     IT     | continue |




  Scenario Outline: Verify ticket details and timeline from ticket details page

    When Click on "<create new ticket>" button
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
    And Click on "<continue>" button
    And Click on ticket id
    Then Verify ticket data with displayed data
    And Click on "<timeline>" button
    When Get timeline state
    And Click on cancel ticket button
    And Enter cancel ticket reason
    And Click on cancel ticket
    Then Verify ticket cancels
    And Click on ticket id
    And Click on "<timeline>" button
    Then Verify ticket timeline status is cancelled
    Examples:
      | create new ticket | subject |   Type  | select   | Department | continue | timeline |
      | create new ticket | Android |    IT   | Incident |     IT     | continue | timeline |
      | create new ticket | Android | Accounts| Incident |     IT     | continue | timeline |
      | create new ticket | Android |   HR    | Incident |     IT     | continue | timeline |
      | create new ticket | Android |   Admin    | Incident |     IT     | continue | timeline |
