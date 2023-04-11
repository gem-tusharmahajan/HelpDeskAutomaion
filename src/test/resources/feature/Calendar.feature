Feature: calendar feature functionality

  Background: Login into Helpdesk
    Given User is on login Page of helpdesk
    Then Verify user is on homepage of helpdesk
    Given Login into Helpdesk portal
    When Enter email id in input field
    When Enter password in input field
    And Click on "Yes" button
    And  Select "Employee View" view


    Scenario: Verify calendar opens.
      Given User opens the calendar
      Then User verifies calendar opens


    Scenario Outline: Select random Date on calendar
      And User opens the calendar
      Then User verifies calendar opens
      When User selects "<day>","<month>" and "<year>"
      And Click on "<clear data>" button

      Examples:
      | day   |    month     | year    | clear data |
      |  12   |  February    |  2023   | clear data |



Scenario: Verify previous and next navigation buttons for calendar

  And User opens the calendar
  Then User verifies calendar opens
  And  Get current month order
  And  Click on "next" button
  Then Verify month changes
  And Click on "previous" button
  Then Verify month changes


  Scenario: Default value(Current Date) Validation on calendar
    When User opens the calendar
    Then User verifies calendar opens
    Then Verify date is selected

Scenario: Verify month and WeekDay counts on calendar
  When User opens the calendar
  Then User verifies calendar opens
  And Count month and weekdays

  Scenario Outline: Select specific date range and verify clear data
    When User opens the calendar
    Then User verifies calendar opens
    When User selects "<day>","<month>" and "<year>"
    When User selects "<day1>","<month1>" and "<year1>"
    Then User verifies range is selected
    And Click on "<clear data>" button
    Examples:
      | day   |    month     | year    | clear data | day1 | month1 | year1 |
      |  12   |  February    |  2023   | clear data |  1    |   February     |   2023    |
