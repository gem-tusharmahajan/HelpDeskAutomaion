Feature: Pagination

  Background: Login Page
    Given User is on login Page of helpdesk
    Then Verify user is on homepage of helpdesk
    And Login into Helpdesk portal
    When Enter email id in input field
    When Enter password in input field
    And Click on "Yes" button
    And Select "Employee View" view


    Scenario Outline: Pagination: Rows per Page check
      And Click on "<pageDropdown>" button
      And Select "<value>" from dropdown
      Then Verify number of ticket count on dashboard with dropdown "<value>"

    Examples:
      |   pageDropdown     |  value |
      | Page Per Dropdown  |   5    |
      | Page Per Dropdown  |   10   |
      | Page Per Dropdown  |   25   |


      Scenario: Pagination: Next button/ Previous button verification
        Then Previous page button is disabled and next page button is enabled
        And Click on next page button
        Then Verify previous page button is enabled
        And Click on previous button
        Then Verify previous page button is disabled

