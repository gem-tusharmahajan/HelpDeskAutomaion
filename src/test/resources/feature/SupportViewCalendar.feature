Feature: calendar feature functionality

  Background: Login into Helpdesk
    Given User is on login Page of helpdesk
    Then Verify user is on homePage of helpdesk
    Given Login into Helpdesk portal
    When Enter email id in input field
    When Enter password in input field
    And Click on "Yes" button
    Then Verify user is still on login page
    Then Verify user is on homePage of helpdesk
    And  Select "Support View" view

  Scenario: Verify calendar opens.
    Given User opens the calendar
    Then User verifies calendar opens


  Scenario Outline: Select random Date on calendar
    When Select "<tab>" on dashboard in support view
    And User opens the calendar
    Then User verifies calendar opens
    When User selects "12","April" and "2023"
    And Click on "clear data" button
    Examples:
      | tab           |
      | Assigned      |
      | Unassigned    |
      | My Department |

  Scenario Outline: Verify previous and next navigation buttons for calendar
    When Select "<tab>" on dashboard in support view
    And User opens the calendar
    Then User verifies calendar opens
    And  Get current month order
    And  Click on "next" button
    Then Verify month changes
    And Click on "previous" button
    Then Verify month changes
    Examples:
      | tab           |
      | Assigned      |
      | Unassigned    |
      | My Department |

  Scenario Outline: Default value(Current Date) Validation on calendar
    When Select "<tab>" on dashboard in support view
    When User opens the calendar
    Then User verifies calendar opens
    Then Verify date is selected
    Examples:
      | tab           |
      | Assigned      |
      | Unassigned    |
      | My Department |


  Scenario: Verify month and WeekDay counts on calendar
    When User opens the calendar
    Then User verifies calendar opens
    And Count month and weekdays

  Scenario Outline: Select specific date range and verify clear data
    When Select "<tab>" on dashboard in support view
    When User opens the calendar
    Then User verifies calendar opens
    When User selects "12","February" and "2023"
    When User selects "1","February" and "2023"
    Then User verifies range is selected
    And Click on "clear data" button
    Examples:
      | tab           |
      | Assigned      |
      | Unassigned    |
      | My Department |