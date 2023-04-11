    Feature: Support view ticket creation

    Scenario: Submit Create Ticket form without filling mandatory fields [Negative scenario]
      And Click on "create new ticket" button
      Then Verify create new ticket window gets open
      And Click on "submit" button

      Scenario: Check 'Create Ticket' functionality for type 'Incident' and without attachment
        And Click on "create new ticket" button
        Then Verify create new ticket window gets open
