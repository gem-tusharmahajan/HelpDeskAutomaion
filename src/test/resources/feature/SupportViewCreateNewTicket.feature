    Feature: Support view ticket creation

      Background: Login into Helpdesk
        Given User is on login Page of helpdesk
        Then Verify user is on homepage of helpdesk
        Given Login into Helpdesk portal
        When Enter email id in input field
        When Enter password in input field
        And Click on "Yes" button
        Then Verify user is still on login page
        And  Select "Support View" view



    Scenario: Submit Create Ticket form without filling mandatory fields [Negative scenario]
      And Click on "create new ticket" button
      Then Verify create new ticket window gets open
      And Click on "submit" button

      Scenario: Check 'Create Ticket' functionality for type 'Incident' and without attachment for yourself
        And Click on "create new ticket" button
        Then Verify create new ticket window gets open
        And Enter caller name
        And Select channel
