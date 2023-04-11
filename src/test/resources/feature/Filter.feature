Feature: Filter page functionalities


  Background: Login Page
    Given User is on login Page of helpdesk
    Then Verify user is on homepage of helpdesk
    Given Login into Helpdesk portal
    When Enter email id in input field
    When Enter password in input field
    And Click on "Yes" button
    And Select "Employee View" view


  Scenario: Hide cancelled, closed and resolved tickets
    Then  Verify user is on HomePage of Helpdesk
    When Count number of tickets
    And Click on "filter" button
    Then Verify filter tab is opened
    And Click on "toggle" button
    And Click on "filter" button
    And Count number of filtered tickets


  Scenario Outline: Clear all filters
    And Click on "<filter>" button
    Then Verify filter tab is opened
    And Select "<department>" and select "<status>" in filter tab
    And Click on "<filter>" button
    When Count number of tickets
    And Click on "<filter>" button
    And Click on "<clear all>" button
    And Click on "<filter>" button
    When Count number of tickets again
    Examples:
      | filter | department | status     | clear all |
      | filter | IT         | Open       | clear All |
      | filter | IT         | Unassigned | clear All |
      | filter | IT         | Assigned   | clear All |
      | filter | IT         | On Hold    | clear All |
      | filter | IT         | Resolved   | clear All |
      | filter | IT         | Cancelled  | clear All |
      | filter | IT         | Closed     | clear All |
      | filter | IT         | Re-opened  | clear All |
      | filter | IT         | Rejected   | clear All |
      | filter | HR         | Open       | clear All |
      | filter | HR         | Unassigned | clear All |
      | filter | HR         | Assigned   | clear All |
      | filter | HR         | On Hold    | clear All |
      | filter | HR         | Resolved   | clear All |
      | filter | HR         | Cancelled  | clear All |
      | filter | HR         | Closed     | clear All |
      | filter | HR         | Re-opened  | clear All |
      | filter | HR         | Rejected   | clear All |
      | filter | Accounts   | Open       | clear All |
      | filter | Accounts   | Unassigned | clear All |
      | filter | Accounts   | Assigned   | clear All |
      | filter | Accounts   | On Hold    | clear All |
      | filter | Accounts   | Resolved   | clear All |
      | filter | Accounts   | Cancelled  | clear All |
      | filter | Accounts   | Closed     | clear All |
      | filter | Accounts   | Re-opened  | clear All |
      | filter | Accounts   | Rejected   | clear All |
      | filter | Admin      | Open       | clear All |
      | filter | Admin      | Unassigned | clear All |
      | filter | Admin      | Assigned   | clear All |
      | filter | Admin      | On Hold    | clear All |
      | filter | Admin      | Resolved   | clear All |
      | filter | Admin      | Cancelled  | clear All |
      | filter | Admin      | Closed     | clear All |
      | filter | Admin      | Re-opened  | clear All |
      | filter | Admin      | Rejected   | clear All |
      | filter | test dept  | Open       | clear All |
      | filter | test dept  | Unassigned | clear All |
      | filter | test dept  | Assigned   | clear All |
      | filter | test dept  | On Hold    | clear All |
      | filter | test dept  | Resolved   | clear All |
      | filter | test dept  | Cancelled  | clear All |
      | filter | test dept  | Closed     | clear All |
      | filter | test dept  | Re-opened  | clear All |
      | filter | test dept  | Rejected   | clear All |


  Scenario: Department filter
    And Click on "filter" button
    Then Verify filter tab is opened
    And Select the "IT"
    And Select the "Accounts"
    And Select the "HR"
    And Select the "Admin"
    And Select the "test dept"
    Then Verify filtered data is displayed in department column.


  Scenario: Status filter
    And Click on "filter" button
    Then Verify filter tab is opened
    And Select the "Open"
    And Select the "Unassigned"
    And Select the "Assigned"
    And Select the "On Hold"
    And Select the "Resolved"
    And Select the "Cancelled"
    And Select the "Closed"
    And Select the "Re-opened"
    And Select the "Rejected"
    And Click on "filter" button
    Then Verify filtered data is displayed in status column.


  Scenario Outline: Both filters (Department and Status)

    Then  Verify user is on HomePage of Helpdesk
    And Click on row per page dropDown
    When Count number of tickets
    When Click on "<filter>" button
    Then Verify filter tab is opened
    And Select "<department>" and select "<status>" in filter tab
    And Click on "<filter>" button
    And Count number of filtered tickets with "<department>" and "<status>"

    Examples:
      | filter | department | status     |
      | filter | IT         | Open       |
      | filter | IT         | Unassigned |
      | filter | IT         | Assigned   |
      | filter | IT         | On Hold    |
      | filter | IT         | Resolved   |
      | filter | IT         | Cancelled  |
      | filter | IT         | Closed     |
      | filter | IT         | Re-opened  |
      | filter | IT         | Rejected   |
      | filter | HR         | Open       |
      | filter | HR         | Unassigned |
      | filter | HR         | Assigned   |
      | filter | HR         | On Hold    |
      | filter | HR         | Resolved   |
      | filter | HR         | Cancelled  |
      | filter | HR         | Closed     |
      | filter | HR         | Re-opened  |
      | filter | HR         | Rejected   |
      | filter | Accounts   | Open       |
      | filter | Accounts   | Unassigned |
      | filter | Accounts   | Assigned   |
      | filter | Accounts   | On Hold    |
      | filter | Accounts   | Resolved   |
      | filter | Accounts   | Cancelled  |
      | filter | Accounts   | Closed     |
      | filter | Accounts   | Re-opened  |
      | filter | Accounts   | Rejected   |
      | filter | Admin      | Open       |
      | filter | Admin      | Unassigned |
      | filter | Admin      | Assigned   |
      | filter | Admin      | On Hold    |
      | filter | Admin      | Resolved   |
      | filter | Admin      | Cancelled  |
      | filter | Admin      | Closed     |
      | filter | Admin      | Re-opened  |
      | filter | Admin      | Rejected   |
      | filter | test dept  | Open       |
      | filter | test dept  | Unassigned |
      | filter | test dept  | Assigned   |
      | filter | test dept  | On Hold    |
      | filter | test dept  | Resolved   |
      | filter | test dept  | Cancelled  |
      | filter | test dept  | Closed     |
      | filter | test dept  | Re-opened  |
      | filter | test dept  | Rejected   |


  Scenario: Close filter button
    And Click on "filter" button
    Then Verify filter tab is opened
    And Click on "cross" button
    Then Verify filter tab is closed

      